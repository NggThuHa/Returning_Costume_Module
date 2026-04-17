package view;

import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClientInfoView extends BaseFrm {
    private User user;
    private Client outClient;
    private List<RentedCostume> outListRentedCostume;
    private JTable tblRented;

    public ClientInfoView(User user, Client client) {
        super("Client Info - Costume Rental System");
        this.user = user;
        this.outClient = client;
        this.outListRentedCostume = createMockRentedItems();
        initComponents();
        setSize(900, 700);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Client Rented Items");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        infoPanel.add(new JLabel("Full Name: " + outClient.getFullname()));
        infoPanel.add(new JLabel("Email: " + outClient.getEmail()));
        infoPanel.add(new JLabel("Phone: " + outClient.getTel()));

        String[] columns = {"Target", "Costume Name", "Price", "Qty", "Saleoff"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 0) ? Boolean.class : String.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) { return column == 0; }
        };
        tblRented = new JTable(model);
        for (RentedCostume rc : outListRentedCostume) {
            model.addRow(new Object[]{false, rc.getCostume().getName(), rc.getPrice(), rc.getQuantity(), rc.getSaleoff()});
        }

        JPanel content = new JPanel(new BorderLayout(0, 20));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));
        content.add(infoPanel, BorderLayout.NORTH);
        content.add(new JScrollPane(tblRented), BorderLayout.CENTER);

        mainPanel.add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        JButton subNext = createPrimaryButton("Next");
        subNext.addActionListener(e -> {
            List<RentedCostume> selected = new ArrayList<>();
            for (int i = 0; i < tblRented.getRowCount(); i++) {
                if ((Boolean) tblRented.getValueAt(i, 0)) {
                    selected.add(outListRentedCostume.get(i));
                }
            }
            if (!selected.isEmpty()) {
                new AddDamageCostumeView(user, outClient, selected).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Select item(s).");
            }
        });
        footer.add(subNext);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private List<RentedCostume> createMockRentedItems() {
        List<RentedCostume> list = new ArrayList<>();
        Costume c1 = new Costume();
        c1.setName("Ao dai cach tan den nu XL");
        RentedCostume rc1 = new RentedCostume();
        rc1.setCostume(c1);
        rc1.setQuantity(2);
        rc1.setPrice(1000);
        list.add(rc1);
        return list;
    }
}
