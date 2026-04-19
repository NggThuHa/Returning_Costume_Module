package view;

import dao.RentedReceiptDAO;
import dao.ReturnedReceiptDAO;
import model.Client;
import model.RentedCostume;
import model.RentedDeposit;
import model.RentedReceipt;
import model.ReturnedCostume;
import model.ReturnedReceipt;
import model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientInfoFrm extends BaseFrm {
    private final User u;
    private final Client client;
    private final List<RentedReceipt> listRentedReceipt;
    private final List<RentedCostume> listRentedCostume;
    private final List<RentedDepositView> listRentedDeposit;
    private final List<ReturnedCostume> listReturnedHistory;

    private JTable tblRentedCostume;

    public ClientInfoFrm(User user, Client client) {
        super("Thong tin khach hang - Tra trang phuc");
        this.u = user;
        this.client = client;

        listRentedReceipt = new RentedReceiptDAO().searchByClient(client);
        listRentedCostume = new ArrayList<>();
        listRentedDeposit = new ArrayList<>();
        listReturnedHistory = new ArrayList<>();

        for (RentedReceipt rentedReceipt : listRentedReceipt) {
            if (rentedReceipt.getListRentedCostume() != null) {
                listRentedCostume.addAll(rentedReceipt.getListRentedCostume());
            }
            if (rentedReceipt.getListRentedDeposit() != null) {
                for (RentedDeposit rentedDeposit : rentedReceipt.getListRentedDeposit()) {
                    listRentedDeposit.add(new RentedDepositView(rentedDeposit, rentedReceipt.getRentedAt()));
                }
            }
        }

        List<ReturnedReceipt> returnedReceipts = new ReturnedReceiptDAO().searchByClient(client);
        for (ReturnedReceipt returnedReceipt : returnedReceipts) {
            if (returnedReceipt.getListReturnedCostume() != null) {
                listReturnedHistory.addAll(returnedReceipt.getListReturnedCostume());
            }
        }

        initComponents();
        setSize(1200, 820);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Thong tin khach hang");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel content = new JPanel(new GridLayout(4, 1, 10, 10));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));

        content.add(buildClientInfoPanel());
        content.add(buildRentedCostumePanel());
        content.add(buildReturnedHistoryPanel());
        content.add(buildDepositPanel());

        mainPanel.add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnNext = createPrimaryButton("Tiep");
        JButton btnCancel = createSecondaryButton("Huy");

        btnNext.addActionListener(e -> handleNext());
        btnCancel.addActionListener(e -> {
            new SearchClientFrm(u).setVisible(true);
            this.dispose();
        });

        footer.add(btnCancel);
        footer.add(btnNext);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel buildClientInfoPanel() {
        String[] columns = {"Ma", "Ho ten", "Dia chi", "So dien thoai", "Email", "Ghi chu"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addRow(new Object[]{
                client.getId(),
                client.getFullname(),
                client.getAddress(),
                client.getTel(),
                client.getEmail(),
                client.getNote()
        });

        JTable table = new JTable(model);
        table.setRowHeight(28);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Thong tin khach hang"), BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildRentedCostumePanel() {
        String[] columns = {"Ma", "Ten trang phuc", "Ngay muon", "Gia coc", "Gia muon", "So luong muon", "So luong tra"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };

        for (RentedCostume rentedCostume : listRentedCostume) {
            model.addRow(new Object[]{
                    rentedCostume.getCostume().getBarcode(),
                    rentedCostume.getCostume().getName(),
                    formatDate(rentedCostume.getRentedAt()),
                    formatAmount(rentedCostume.getCostume().getPrice()),
                    formatAmount(rentedCostume.getPrice()),
                    rentedCostume.calculateRemainedQuantity(),
                    ""
            });
        }

        tblRentedCostume = new JTable(model);
        tblRentedCostume.setRowHeight(28);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Danh sach trang phuc dang muon"), BorderLayout.NORTH);
        panel.add(new JScrollPane(tblRentedCostume), BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildReturnedHistoryPanel() {
        String[] columns = {"Ma", "Ten trang phuc", "Ngay muon", "Ngay tra", "So luong", "Tien thue", "Tien phat"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (ReturnedCostume returnedCostume : listReturnedHistory) {
            model.addRow(new Object[]{
                    returnedCostume.getRentedCostume().getCostume().getBarcode(),
                    returnedCostume.getRentedCostume().getCostume().getName(),
                    formatDate(returnedCostume.getRentedCostume().getRentedAt()),
                    formatDate(returnedCostume.getReturnedAt()),
                    returnedCostume.getQuantity(),
                    formatAmount(returnedCostume.getRentedFee()),
                    formatAmount(returnedCostume.getFineFee())
            });
        }

        JTable table = new JTable(model);
        table.setRowHeight(28);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Danh sach trang phuc da tra"), BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildDepositPanel() {
        String[] columns = {"Ma", "Ten coc", "Ngay coc", "So luong coc", "So tien", "Ghi chu"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (RentedDepositView rentedDepositView : listRentedDeposit) {
            model.addRow(new Object[]{
                    rentedDepositView.rentedDeposit.getId(),
                    rentedDepositView.rentedDeposit.getDepositItem().getName(),
                    formatDate(rentedDepositView.rentedAt),
                    rentedDepositView.rentedDeposit.getQuantity(),
                    formatAmount(rentedDepositView.rentedDeposit.getDepositAmount()),
                    rentedDepositView.rentedDeposit.getNote()
            });
        }

        JTable table = new JTable(model);
        table.setRowHeight(28);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Danh sach do dang coc"), BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private void handleNext() {
        List<ReturnedCostume> toReturn = new ArrayList<>();

        for (int i = 0; i < tblRentedCostume.getRowCount(); i++) {
            int returnQty = 0;
            String rawValue = String.valueOf(tblRentedCostume.getValueAt(i, 6)).trim();
            if (rawValue.isEmpty()) {
                continue;
            }

            try {
                returnQty = Integer.parseInt(rawValue);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "So luong tra khong hop le.");
                return;
            }

            if (returnQty < 1) {
                JOptionPane.showMessageDialog(this, "So luong toi thieu la 1");
                return;
            }

            if (returnQty > 0) {
                int remained = listRentedCostume.get(i).calculateRemainedQuantity();
                if (returnQty > remained) {
                    JOptionPane.showMessageDialog(this, "So luong tra khong hop le.");
                    return;
                }
                ReturnedCostume returnedCostume = new ReturnedCostume();
                returnedCostume.setRentedCostume(listRentedCostume.get(i));
                returnedCostume.setQuantity(returnQty);
                returnedCostume.setReturnedAt(new Date());
                toReturn.add(returnedCostume);
            }
        }

        if (toReturn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long dien so luong tra");
            return;
        }

        new ReturnProcessingFrm(u, client, toReturn).setVisible(true);
        this.dispose();
    }

    private String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    private String formatAmount(float value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.format("%.2f", value);
    }

    private static class RentedDepositView {
        private final RentedDeposit rentedDeposit;
        private final Date rentedAt;

        private RentedDepositView(RentedDeposit rentedDeposit, Date rentedAt) {
            this.rentedDeposit = rentedDeposit;
            this.rentedAt = rentedAt;
        }
    }
}
