package view;

import dao.ClientDAO;
import model.Client;
import model.User;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchClientFrm extends BaseFrm {
    private User u;
    private JTextField txtFullname, txtEmail, txtTel;
    private JTable tblClient;
    private List<Client> listClient;

    public SearchClientFrm(User user) {
        super("Search Client - Return Costume");
        this.u = user;
        initComponents();
        setSize(800, 600);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Search Client");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        searchPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; searchPanel.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1; txtFullname = new JTextField(15); searchPanel.add(txtFullname, gbc);
        
        gbc.gridx = 2; searchPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 3; txtEmail = new JTextField(15); searchPanel.add(txtEmail, gbc);
        
        gbc.gridx = 4; searchPanel.add(new JLabel("Tel:"), gbc);
        gbc.gridx = 5; txtTel = new JTextField(10); searchPanel.add(txtTel, gbc);

        JButton btnSearch = createPrimaryButton("Search");
        gbc.gridx = 6; searchPanel.add(btnSearch, gbc);
        mainPanel.add(searchPanel, BorderLayout.CENTER);

        String[] cols = {"ID", "Fullname", "Address", "Tel", "Email"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tblClient = new JTable(model);
        tblClient.setRowHeight(30);

        JPanel content = new JPanel(new BorderLayout());
        content.add(searchPanel, BorderLayout.NORTH);
        content.add(new JScrollPane(tblClient), BorderLayout.CENTER);
        mainPanel.add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnCancel = createSecondaryButton("Cancel");
        footer.add(btnCancel);
        mainPanel.add(footer, BorderLayout.SOUTH);

        btnSearch.addActionListener(e -> {
            Client criteria = new Client();
            criteria.setFullname(txtFullname.getText());
            criteria.setEmail(txtEmail.getText());
            criteria.setTel(txtTel.getText());
            listClient = new ClientDAO().searchClient(criteria);
            model.setRowCount(0);
            for (Client c : listClient) {
                model.addRow(new Object[]{c.getId(), c.getFullname(), c.getAddress(), c.getTel(), c.getEmail()});
            }
        });
        
        tblClient.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblClient.getSelectedRow() != -1) {
                Client selected = listClient.get(tblClient.getSelectedRow());
                new ClientInfoFrm(u, selected).setVisible(true);
                this.dispose();
            }
        });

        btnCancel.addActionListener(e -> {
            new CashierHomeFrm(u).setVisible(true);
            this.dispose();
        });

        add(mainPanel);
    }
}
