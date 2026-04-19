package view;

import dao.*;
import model.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ConfirmFrm extends BaseFrm {
    private final User u;
    private final ReturnedReceipt returnedReceipt;
    private List<RentedDeposit> depositsToRefund;

    public ConfirmFrm(User user, ReturnedReceipt receipt) {
        super("Confirmation - Return Costume");
        this.u = user;
        this.returnedReceipt = receipt;

        // Collect unreturned deposits for this client
        depositsToRefund = new ArrayList<>();
        for (RentedReceipt rr : new RentedReceiptDAO().searchByClient(receipt.getClient())) {
            if (rr.getListRentedDeposit() != null) {
                for (RentedDeposit rd : rr.getListRentedDeposit()) {
                    if (!rd.isReturned()) depositsToRefund.add(rd);
                }
            }
        }
        returnedReceipt.setTotalRefundDeposit(
            depositsToRefund.stream()
                .mapToDouble(rd -> rd.getDepositItem().getValue() * rd.getQuantity())
                .reduce(0, Double::sum)
        );

        initComponents();
        setSize(1100, 870);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // ── Title ──────────────────────────────────────────────────────────
        JLabel lblTitle = new JLabel("Confirmation", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblTitle.setBorder(new EmptyBorder(25, 0, 10, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // ── Scrollable content ─────────────────────────────────────────────
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(5, 20, 10, 20));

        // Meta labels
        JPanel metaPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        metaPanel.setBackground(BACKGROUND_COLOR);
        metaPanel.setBorder(new EmptyBorder(0, 5, 10, 5));
        metaPanel.add(metaLabel("Returned Date: " + fmtDate(returnedReceipt.getReturnedAt())));
        metaPanel.add(metaLabel("Staff Fullname: " + returnedReceipt.getUser().getFullname()));
        metaPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        content.add(metaPanel);

        // Client information label
        content.add(sectionLabel("Client information:"));
        content.add(buildClientTable());
        content.add(Box.createVerticalStrut(12));

        // Returned costumes
        content.add(sectionLabel("Returned costumes"));
        content.add(buildSection(buildReturnedCostumeModel()));
        content.add(Box.createVerticalStrut(12));

        // Returned Damage
        content.add(sectionLabel("Returned Damage"));
        content.add(buildSection(buildDamageModel()));
        content.add(Box.createVerticalStrut(12));

        // Returned Deposit
        content.add(sectionLabel("Returned Deposit"));
        content.add(buildSection(buildDepositModel()));

        mainPanel.add(new JScrollPane(content), BorderLayout.CENTER);

        // ── Footer ─────────────────────────────────────────────────────────
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnConfirm = styledBtn("Confirm", new Color(149, 182, 214));
        JButton btnCancel  = styledBtn("Cancel",  new Color(228, 234, 240));
        footer.add(btnConfirm);
        footer.add(btnCancel);
        mainPanel.add(footer, BorderLayout.SOUTH);

        btnConfirm.addActionListener(e -> handleConfirm());
        btnCancel.addActionListener(e -> {
            new ReturnProcessingFrm(u, returnedReceipt.getClient(),
                returnedReceipt.getListReturnedCostume()).setVisible(true);
            dispose();
        });

        add(mainPanel);
    }

    // ── Table builders ─────────────────────────────────────────────────────

    private JPanel buildClientTable() {
        Client c = returnedReceipt.getClient();
        DefaultTableModel m = new DefaultTableModel(
            new String[]{"ID","Fullname","Address","Tel","Email","Note"}, 0) {
            public boolean isCellEditable(int r, int col) { return false; }
        };
        m.addRow(new Object[]{c.getId(), c.getFullname(), c.getAddress(),
            c.getTel(), c.getEmail(), c.getNote()});
        return buildSection(m);
    }

    private DefaultTableModel buildReturnedCostumeModel() {
        DefaultTableModel m = new DefaultTableModel(
            new String[]{"ID","Name","Rented Date","Rented Quantity","Returning Quantity","Total Rented Fee"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (ReturnedCostume rc : returnedReceipt.getListReturnedCostume()) {
            m.addRow(new Object[]{
                rc.getRentedCostume().getCostume().getBarcode(),
                rc.getRentedCostume().getCostume().getName(),
                fmtDate(rc.getRentedCostume().getRentedAt()),
                rc.getRentedCostume().getQuantity(),
                rc.getQuantity(),
                rc.getRentedFee()
            });
        }
        return m;
    }

    private DefaultTableModel buildDamageModel() {
        DefaultTableModel m = new DefaultTableModel(
            new String[]{"Costume ID","Costume Name","Damage name","Damage Costume Quantity","Total Fine Fee","Note"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (ReturnedCostume rc : returnedReceipt.getListReturnedCostume()) {
            if (rc.getListReturnedDamage() == null) continue;
            for (ReturnedDamage rd : rc.getListReturnedDamage()) {
                m.addRow(new Object[]{
                    rc.getRentedCostume().getCostume().getBarcode(),
                    rc.getRentedCostume().getCostume().getName(),
                    rd.getDamage().getName(),
                    rd.getQuantity(),
                    rd.getFee() * rd.getQuantity(),
                    rd.getDamage().getNote()
                });
            }
        }
        return m;
    }

    private DefaultTableModel buildDepositModel() {
        DefaultTableModel m = new DefaultTableModel(
            new String[]{"ID","Name","Deposit Date","Quantity","Total Value","Note"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (RentedDeposit rd : depositsToRefund) {
            m.addRow(new Object[]{
                rd.getId(),
                rd.getDepositItem().getName(),
                fmtDate(rd.getRentedAt()),
                rd.getQuantity(),
                rd.getDepositItem().getValue() * rd.getQuantity(),
                rd.getNote()
            });
        }
        return m;
    }

    // ── Confirm action ─────────────────────────────────────────────────────
    private void handleConfirm() {
        RentedReceiptDAO  rDao   = new RentedReceiptDAO();
        ReturnedReceiptDAO retDao = new ReturnedReceiptDAO();
        CostumeDAO        cDao   = new CostumeDAO();

        retDao.addReturnedReceipt(returnedReceipt);
        rDao.updateRentedStatus(new RentedReceipt());
        for (ReturnedCostume rc : returnedReceipt.getListReturnedCostume()) {
            cDao.updateQuantity(rc.getRentedCostume().getCostume().getBarcode(), rc.getQuantity());
        }
        rDao.updateDepositStatus(new RentedReceipt());

        JOptionPane.showMessageDialog(this, "Giao dich hoan tat va phieu da duoc in!");
        new CashierHomeFrm(u).setVisible(true);
        dispose();
    }

    // ── Layout helpers ─────────────────────────────────────────────────────
    private JPanel buildSection(DefaultTableModel m) {
        JTable table = new JTable(m);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.getTableHeader().setBackground(Color.WHITE);
        table.setFont(LABEL_FONT);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(new LineBorder(new Color(180, 195, 210), 1));
        int rows = Math.min(m.getRowCount() + 1, 5);
        scroll.setPreferredSize(new Dimension(Integer.MAX_VALUE, rows * 31 + 26));

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR);
        panel.add(scroll, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height + 60));
        return panel;
    }

    private JLabel sectionLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(LABEL_FONT);
        lbl.setForeground(TEXT_COLOR);
        lbl.setBorder(new EmptyBorder(4, 5, 4, 0));
        return lbl;
    }

    private JLabel metaLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(LABEL_FONT);
        lbl.setForeground(TEXT_COLOR);
        return lbl;
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
