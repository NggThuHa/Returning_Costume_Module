package view;

import model.Client;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchClientView extends BaseFrm {
    private User user;
    private JTextField inFullname;
    private JTextField inEmail;
    private JTextField inTel;
    private JTable outsubListClient;
    private List<Client> mockClients;

    public SearchClientView(User user) {
        super("Search Client - Costume Rental System");
        this.user = user;
        this.mockClients = createMockClients();
        initComponents();
        setSize(800, 600);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Search Client for Return");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        searchPanel.add(new JLabel("Full Name:"));
        inFullname = new JTextField();
        searchPanel.add(inFullname);

        searchPanel.add(new JLabel("Email:"));
        inEmail = new JTextField();
        searchPanel.add(inEmail);

        searchPanel.add(new JLabel("Phone:"));
        inTel = new JTextField();
        searchPanel.add(inTel);

        JButton subSearch = createPrimaryButton("Search");
        subSearch.addActionListener(e -> handleSearch());

        JPanel tablePanel = new JPanel(new BorderLayout(0, 10));
        tablePanel.setBackground(BACKGROUND_COLOR);
        tablePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        tablePanel.add(searchPanel, BorderLayout.NORTH);

        String[] columns = {"Full Name", "Email", "Phone", "Address"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        outsubListClient = new JTable(model);
        outsubListClient.setRowHeight(35);
        tablePanel.add(new JScrollPane(outsubListClient), BorderLayout.CENTER);

        tablePanel.add(subSearch, BorderLayout.SOUTH);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnBack = createSecondaryButton("Back");
        JButton btnNext = createPrimaryButton("Next");

        btnNext.addActionListener(e -> {
            int row = outsubListClient.getSelectedRow();
            if (row != -1) {
                Client selected = mockClients.get(row);
                new ClientInfoView(user, selected).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Select a client.");
            }
        });

        footer.add(btnBack);
        footer.add(btnNext);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handleSearch() {
        DefaultTableModel model = (DefaultTableModel) outsubListClient.getModel();
        model.setRowCount(0);
        for (Client c : mockClients) {
            model.addRow(new Object[]{c.getFullname(), c.getEmail(), c.getTel(), c.getAddress()});
        }
    }

    private List<Client> createMockClients() {
        List<Client> list = new ArrayList<>();
        list.add(new Client("Nguyen Van B", "b@gmail.com", "0123456789", "Ha Noi", ""));
        return list;
    }
}
