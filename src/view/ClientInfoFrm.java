package view;

import dao.RentedReceiptDAO;
import dao.ReturnedReceiptDAO;
import model.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class ClientInfoFrm extends BaseFrm {
    private final User u;
    private final Client client;
    private final List<RentedCostume>  listRenting   = new ArrayList<>();
    private final List<ReturnedCostume> listReturned = new ArrayList<>();
    private final List<RentedDeposit>  listDeposits  = new ArrayList<>();
    private DefaultTableModel rentingModel;

    public ClientInfoFrm(User user, Client client) {
        super("Client Information - Return Costume");
        this.u = user;
        this.client = client;
        loadData();
        initComponents();
        setSize(1100, 820);
        centerWindow();
    }

    private void loadData() {
        for (RentedReceipt rr : new RentedReceiptDAO().searchByClient(client)) {
            if (rr.getListRentedCostume() != null)  listRenting.addAll(rr.getListRentedCostume());
            if (rr.getListRentedDeposit() != null)  listDeposits.addAll(rr.getListRentedDeposit());
        }
        for (ReturnedReceipt ret : new ReturnedReceiptDAO().searchByClient(client)) {
            if (ret.getListReturnedCostume() != null) listReturned.addAll(ret.getListReturnedCostume());
        }
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Title
        JLabel lblTitle = new JLabel("Client\u2019s Infomation", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblTitle.setBorder(new EmptyBorder(25, 0, 10, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // Scrollable centre
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(5, 20, 10, 20));

        content.add(buildClientTable());
        content.add(Box.createVerticalStrut(10));
        content.add(buildSection("Renting costumes",  buildRentingModel(),  false));
        content.add(Box.createVerticalStrut(10));
        content.add(buildSection("Returned costumes", buildReturnedModel(), false));
        content.add(Box.createVerticalStrut(10));
        content.add(buildSection("Deposits",          buildDepositModel(),  false));

        mainPanel.add(new JScrollPane(content), BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnNext   = styledBtn("Next",   new Color(149, 182, 214));
        JButton btnCancel = styledBtn("Cancel", new Color(228, 234, 240));
        footer.add(btnNext);
        footer.add(btnCancel);
        mainPanel.add(footer, BorderLayout.SOUTH);

        btnNext.addActionListener(e -> handleNext());
        btnCancel.addActionListener(e -> { new SearchClientFrm(u).setVisible(true); dispose(); });

        add(mainPanel);
    }

    // ── Client info table (1 row) ─────────────────────────────────────────
    private JPanel buildClientTable() {
        String[] cols = {"ID", "Fullname", "Address", "Tel", "Email", "Note"};
        DefaultTableModel m = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        m.addRow(new Object[]{client.getId(), client.getFullname(),
            client.getAddress(), client.getTel(), client.getEmail(), client.getNote()});
        return buildSection(null, m, false);
    }

    // ── Renting costumes ──────────────────────────────────────────────────
    private DefaultTableModel buildRentingModel() {
        String[] cols = {"ID", "Name", "Rented Date", "Deposit", "Rental Fee",
                         "Rented Quantity", "Returning Quantity"};
        rentingModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return c == 6; }
        };
        for (RentedCostume rc : listRenting) {
            rentingModel.addRow(new Object[]{
                rc.getCostume().getBarcode(),
                rc.getCostume().getName(),
                fmtDate(rc.getRentedAt()),
                rc.getCostume().getPrice(),
                rc.getPrice(),
                rc.calculateRemainedQuantity(),
                ""
            });
        }
        return rentingModel;
    }

    // ── Returned costumes ─────────────────────────────────────────────────
    private DefaultTableModel buildReturnedModel() {
        String[] cols = {"ID", "Name", "Rented Date", "Returned Date",
                         "Returned Quantity", "Total Rentel Fee", "Total Fine Fee"};
        DefaultTableModel m = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (ReturnedCostume rc : listReturned) {
            m.addRow(new Object[]{
                rc.getRentedCostume().getCostume().getBarcode(),
                rc.getRentedCostume().getCostume().getName(),
                fmtDate(rc.getRentedCostume().getRentedAt()),
                fmtDate(rc.getReturnedAt()),
                rc.getQuantity(),
                rc.getRentedFee(),
                rc.getFineFee()
            });
        }
        return m;
    }

    // ── Deposits ──────────────────────────────────────────────────────────
    private DefaultTableModel buildDepositModel() {
        String[] cols = {"ID", "Name", "Deposit Date", "Quantity", "Value", "Note"};
        DefaultTableModel m = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (RentedDeposit rd : listDeposits) {
            m.addRow(new Object[]{
                rd.getId(),
                rd.getDepositItem().getName(),
                fmtDate(rd.getRentedAt()),
                rd.getQuantity(),
                rd.getDepositItem().getValue(),
                rd.getNote()
            });
        }
        return m;
    }

    // ── handleNext ────────────────────────────────────────────────────────
    private void handleNext() {
        List<ReturnedCostume> toReturn = new ArrayList<>();
        for (int i = 0; i < rentingModel.getRowCount(); i++) {
            String raw = String.valueOf(rentingModel.getValueAt(i, 6)).trim();
            if (raw.isEmpty()) continue;
            int qty;
            try { qty = Integer.parseInt(raw); } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "So luong tra khong hop le o hang " + (i+1));
                return;
            }
            int remained = listRenting.get(i).calculateRemainedQuantity();
            if (qty < 1 || qty > remained) {
                JOptionPane.showMessageDialog(this, "So luong tra khong hop le o hang " + (i+1));
                return;
            }
            ReturnedCostume rc = new ReturnedCostume();
            rc.setRentedCostume(listRenting.get(i));
            rc.setQuantity(qty);
            rc.setReturnedAt(new Date());
            rc.setListReturnedDamage(new ArrayList<>());
            toReturn.add(rc);
        }
        if (toReturn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long dien so luong tra.");
            return;
        }
        new ReturnProcessingFrm(u, client, toReturn).setVisible(true);
        dispose();
    }

    // ── Helpers ───────────────────────────────────────────────────────────
    private JPanel buildSection(String title, DefaultTableModel m, boolean editable) {
        JTable table = new JTable(m);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.getTableHeader().setBackground(Color.WHITE);
        table.setFont(LABEL_FONT);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(new LineBorder(new Color(180, 195, 210), 1));
        int rows = Math.min(m.getRowCount() + 1, 5);
        scroll.setPreferredSize(new Dimension(Integer.MAX_VALUE, rows * 31 + 25));

        JPanel panel = new JPanel(new BorderLayout(0, 4));
        panel.setBackground(BACKGROUND_COLOR);
        if (title != null) {
            JLabel lbl = new JLabel(title);
            lbl.setFont(LABEL_FONT);
            panel.add(lbl, BorderLayout.NORTH);
        }
        panel.add(scroll, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height + 80));
        return panel;
    }

    private JButton styledBtn(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btn.setBackground(bg);
        btn.setForeground(TEXT_COLOR);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 200, 220), 1),
            BorderFactory.createEmptyBorder(10, 40, 10, 40)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private String fmtDate(Date d) {
        return d == null ? "" : new SimpleDateFormat("dd/MM/yyyy").format(d);
    }
}
