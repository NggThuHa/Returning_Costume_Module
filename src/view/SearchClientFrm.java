package view;

import dao.ClientDAO;
import model.Client;
import model.User;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchClientFrm extends BaseFrm {
    private User u;
    private JTextField txtFullname, txtEmail, txtTel;
    private JTable tblClient;
    private DefaultTableModel tableModel;
    private List<Client> listClient;

    public SearchClientFrm(User user) {
        super("Search Client - Return Costume");
        this.u = user;
        initComponents();
        setSize(900, 600);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
        mainPanel.setBackground(BACKGROUND_COLOR);

        // ── Title ──────────────────────────────────────────────────────────
        JLabel lblTitle = new JLabel("Searching client", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 32));
        lblTitle.setForeground(TEXT_COLOR);
        lblTitle.setBorder(new EmptyBorder(30, 0, 20, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // ── Search panel ───────────────────────────────────────────────────
        // Left: 3 label+field rows; Right: Search + Clear buttons
        JPanel searchBox = new JPanel(new BorderLayout(15, 0));
        searchBox.setBackground(BACKGROUND_COLOR);
        searchBox.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 215, 230), 1),
            new EmptyBorder(20, 20, 20, 20)
        ));

        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 8, 14));
        fieldsPanel.setBackground(BACKGROUND_COLOR);

        fieldsPanel.add(makeLabel("Fullname"));
        txtFullname = makeField(); fieldsPanel.add(txtFullname);

        fieldsPanel.add(makeLabel("Email"));
        txtEmail = makeField(); fieldsPanel.add(txtEmail);

        fieldsPanel.add(makeLabel("Tel"));
        txtTel = makeField(); fieldsPanel.add(txtTel);

        searchBox.add(fieldsPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        btnPanel.setBackground(BACKGROUND_COLOR);
        JButton btnSearch = new JButton("Search");
        styleBtn(btnSearch, new Color(149, 182, 214), TEXT_COLOR);
        JButton btnClear  = new JButton("Clear");
        styleBtn(btnClear, new Color(228, 234, 240), TEXT_COLOR);
        btnPanel.add(btnSearch);
        btnPanel.add(btnClear);

        // wrap btnPanel so it's vertically centred
        JPanel btnWrap = new JPanel(new GridBagLayout());
        btnWrap.setBackground(BACKGROUND_COLOR);
        btnWrap.add(btnPanel);
        searchBox.add(btnWrap, BorderLayout.EAST);

        JPanel searchWrapper = new JPanel(new BorderLayout());
        searchWrapper.setBackground(BACKGROUND_COLOR);
        searchWrapper.setBorder(new EmptyBorder(0, 30, 20, 30));
        searchWrapper.add(searchBox);

        // ── Result table ───────────────────────────────────────────────────
        String[] cols = {"ID", "Fullname", "Address", "Tel", "Email", "Note"};
        tableModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblClient = new JTable(tableModel);
        tblClient.setRowHeight(30);
        tblClient.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tblClient.getTableHeader().setBackground(Color.WHITE);

        JScrollPane scrollTable = new JScrollPane(tblClient);
        scrollTable.setBorder(new LineBorder(new Color(190, 200, 215), 1));

        JPanel tableWrapper = new JPanel(new BorderLayout());
        tableWrapper.setBackground(BACKGROUND_COLOR);
        tableWrapper.setBorder(new EmptyBorder(0, 30, 30, 30));
        tableWrapper.add(scrollTable);

        // ── Center: search + table stacked ────────────────────────────────
        JPanel center = new JPanel(new BorderLayout(0, 0));
        center.setBackground(BACKGROUND_COLOR);
        center.add(searchWrapper, BorderLayout.NORTH);
        center.add(tableWrapper, BorderLayout.CENTER);
        mainPanel.add(center, BorderLayout.CENTER);

        // ── Actions ────────────────────────────────────────────────────────
        btnSearch.addActionListener(e -> performSearch());
        btnClear.addActionListener(e -> {
            txtFullname.setText(""); txtEmail.setText(""); txtTel.setText("");
            tableModel.setRowCount(0);
            listClient = null;
        });

        tblClient.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblClient.getSelectedRow() != -1 && listClient != null) {
                Client selected = listClient.get(tblClient.getSelectedRow());
                new ClientInfoFrm(u, selected).setVisible(true);
                this.dispose();
            }
        });

        add(mainPanel);
    }

    private void performSearch() {
        String fullname = txtFullname.getText().trim();
        String email    = txtEmail.getText().trim();
        String tel      = txtTel.getText().trim();
        listClient = new ClientDAO().searchClient(fullname, email, tel);
        tableModel.setRowCount(0);
        for (Client c : listClient) {
            tableModel.addRow(new Object[]{
                c.getId(), c.getFullname(), c.getAddress(), c.getTel(), c.getEmail(), c.getNote()
            });
        }
    }

    // ── Helpers ────────────────────────────────────────────────────────────
    private JLabel makeLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(LABEL_FONT);
        lbl.setForeground(TEXT_COLOR);
        return lbl;
    }

    private JTextField makeField() {
        JTextField tf = new JTextField();
        tf.setFont(LABEL_FONT);
        tf.setBorder(BorderFactory.createLineBorder(new Color(200, 215, 230), 1));
        tf.setPreferredSize(new Dimension(300, 32));
        return tf;
    }

    private void styleBtn(JButton btn, Color bg, Color fg) {
        btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 200, 220), 1),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(130, 45));
    }
}
