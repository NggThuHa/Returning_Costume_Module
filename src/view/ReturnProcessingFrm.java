package view;

import model.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class ReturnProcessingFrm extends BaseFrm {
    private final User u;
    private final Client clientInfo;
    private final List<ReturnedCostume> returnedItems;

    // Table models
    private DefaultTableModel processingModel;
    private DefaultTableModel rentDamageModel;    // existing damage (read-only)
    private DefaultTableModel processDamageModel; // damage being added this session

    public ReturnProcessingFrm(User user, Client client, List<ReturnedCostume> returnedItems) {
        super("Costume Processing - Return Costume");
        this.u = user;
        this.clientInfo = client;
        this.returnedItems = returnedItems;
        for (ReturnedCostume rc : this.returnedItems) {
            if (rc.getListReturnedDamage() == null) rc.setListReturnedDamage(new ArrayList<>());
        }
        initComponents();
        setSize(1100, 820);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Title
        JLabel lblTitle = new JLabel("Costume Processing", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        lblTitle.setBorder(new EmptyBorder(25, 0, 10, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // Scrollable centre
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(5, 20, 10, 20));

        // ── Client info (1-row table, no heading) ──────────────────────────
        content.add(buildClientInfoPanel());
        content.add(Box.createVerticalStrut(12));

        // ── Processing costumes ────────────────────────────────────────────
        processingModel = new DefaultTableModel(
            new String[]{"ID","Name","Rented Date","Rented Quantity","Returning Quantity","Total Rented Fee"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        for (ReturnedCostume rc : returnedItems) {
            processingModel.addRow(new Object[]{
                rc.getRentedCostume().getCostume().getBarcode(),
                rc.getRentedCostume().getCostume().getName(),
                fmtDate(rc.getRentedCostume().getRentedAt()),
                rc.getRentedCostume().getQuantity(),
                rc.getQuantity(),
                rc.getRentedFee()
            });
        }
        content.add(buildSection("Processing costumes", processingModel));
        content.add(Box.createVerticalStrut(12));

        // ── Rented Damage ─────────────────────────────────────────────────
        rentDamageModel = new DefaultTableModel(
            new String[]{"Costume ID","Costume Name","Damage name","Damage Costume Quantity","Found Date","Note"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        content.add(buildSection("Rented Damage", rentDamageModel));
        content.add(Box.createVerticalStrut(12));

        // ── Processing Damage ─────────────────────────────────────────────
        processDamageModel = new DefaultTableModel(
            new String[]{"Costume ID","Costume Name","Damage name","Damage Costume Quantity","Total Fine Fee","Note"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        content.add(buildSection("Processing Damage", processDamageModel));

        mainPanel.add(new JScrollPane(content), BorderLayout.CENTER);

        // ── Footer ─────────────────────────────────────────────────────────
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(BACKGROUND_COLOR);

        // "Add Damage" button aligned left inside footer
        JPanel leftFooter = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        leftFooter.setBackground(BACKGROUND_COLOR);

        // "Next / Cancel" buttons aligned right
        JPanel rightFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        rightFooter.setBackground(BACKGROUND_COLOR);
        JButton btnNext   = styledBtn("Next",   new Color(149, 182, 214));
        JButton btnCancel = styledBtn("Cancel", new Color(228, 234, 240));
        rightFooter.add(btnNext);
        rightFooter.add(btnCancel);

        footer.add(leftFooter, BorderLayout.WEST);
        footer.add(rightFooter, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        // ── Events ────────────────────────────────────────────────────────
        btnNext.addActionListener(e -> {
            ReturnedReceipt receipt = new ReturnedReceipt();
            receipt.setClient(clientInfo);
            receipt.setUser(u);
            receipt.setReturnedAt(new Date());
            receipt.setListReturnedCostume(returnedItems);
            receipt.calculateTotalReceipt(returnedItems);
            new ConfirmFrm(u, receipt).setVisible(true);
            dispose();
        });

        btnCancel.addActionListener(e -> {
            new ClientInfoFrm(u, clientInfo).setVisible(true);
            dispose();
        });

        add(mainPanel);
    }

    // Called from AddDamageFrm to refresh Processing Damage table
    public void addDamageRow(ReturnedCostume rc, ReturnedDamage rd) {
        processDamageModel.addRow(new Object[]{
            rc.getRentedCostume().getCostume().getBarcode(),
            rc.getRentedCostume().getCostume().getName(),
            rd.getDamage().getName(),
            rd.getQuantity(),
            rd.getFee() * rd.getQuantity(),
            rd.getDamage().getNote()
        });
        // Refresh total rented fee column in Processing costumes
        for (int i = 0; i < returnedItems.size(); i++) {
            if (returnedItems.get(i) == rc) {
                processingModel.setValueAt(rc.getRentedFee(), i, 5);
            }
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────
    private JPanel buildClientInfoPanel() {
        String[] cols = {"ID","Fullname","Address","Tel","Email","Note"};
        DefaultTableModel m = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        m.addRow(new Object[]{clientInfo.getId(), clientInfo.getFullname(),
            clientInfo.getAddress(), clientInfo.getTel(), clientInfo.getEmail(), clientInfo.getNote()});
        return buildSection(null, m);
    }

    private JPanel buildSection(String title, DefaultTableModel m) {
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

    private String fmtDate(java.util.Date d) {
        return d == null ? "" : new java.text.SimpleDateFormat("dd/MM/yyyy").format(d);
    }
}
