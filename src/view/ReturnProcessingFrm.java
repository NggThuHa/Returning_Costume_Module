package view;

import model.Client;
import model.ReturnedCostume;
import model.ReturnedDamage;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnProcessingFrm extends BaseFrm {
    private final User u;
    private final Client clientInfo;
    private final List<ReturnedCostume> returnedItems;
    private JTable tblReturnedCostume;
    private JLabel txtTotalRentedCost;
    private JLabel txtTotalFineFee;

    public ReturnProcessingFrm(User user, Client client, List<ReturnedCostume> returnedItems) {
        super("Update Status - Costume Rental System");
        this.u = user;
        this.clientInfo = client;
        this.returnedItems = returnedItems;
        for (ReturnedCostume rc : this.returnedItems) {
            if (rc.getListReturnedDamage() == null) {
                rc.setListReturnedDamage(new ArrayList<>());
            }
        }
        initComponents();
        setSize(1000, 700);
        centerWindow();
        updateTotals();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Update Costume Status");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel content = new JPanel(new BorderLayout(0, 20));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel txtReturnedAt = new JLabel("Return Date: " + new Date());
        txtReturnedAt.setFont(LABEL_FONT);
        content.add(txtReturnedAt, BorderLayout.NORTH);

        String[] columns = {"Barcode", "Name", "Qty", "Rent Fee", "Fine", "States"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        tblReturnedCostume = new JTable(model);
        tblReturnedCostume.setRowHeight(40);

        for (ReturnedCostume ret : returnedItems) {
            model.addRow(new Object[]{
                    ret.getRentedCostume().getCostume().getBarcode(),
                    ret.getRentedCostume().getCostume().getName(),
                    ret.getQuantity(),
                    ret.getRentedFee() + " VND", "0 VND", "None"
            });
        }
        content.add(new JScrollPane(tblReturnedCostume), BorderLayout.CENTER);

        JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        txtTotalRentedCost = new JLabel("Total Rent: 0 VND");
        txtTotalFineFee = new JLabel("Total Fine: 0 VND");
        JButton btnAddDamage = createSecondaryButton("Add Damage");

        summaryPanel.add(txtTotalRentedCost);
        summaryPanel.add(txtTotalFineFee);
        summaryPanel.add(btnAddDamage);

        content.add(summaryPanel, BorderLayout.SOUTH);
        mainPanel.add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnCancel = createSecondaryButton("Cancel");
        JButton btnFinish = createPrimaryButton("Finish");

        btnAddDamage.addActionListener(e -> {
            int row = tblReturnedCostume.getSelectedRow();
            if (row != -1) {
                new AddDamageFrm(this, returnedItems.get(row), row).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Select an item to add damage.");
            }
        });

        btnFinish.addActionListener(e -> {
            ReturnedReceipt receipt = new ReturnedReceipt();
            receipt.setClient(clientInfo);
            receipt.setUser(u);
            receipt.setReturnedAt(new Date());
            receipt.setListReturnedCostume(returnedItems);
            receipt.calculateTotalReceipt(returnedItems);

            new ConfirmFrm(u, receipt).setVisible(true);
            this.dispose();
        });

        btnCancel.addActionListener(e -> {
            new ClientInfoFrm(u, clientInfo).setVisible(true);
            this.dispose();
        });

        footer.add(btnCancel);
        footer.add(btnFinish);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void updateRow(int row) {
        ReturnedCostume ret = returnedItems.get(row);
        StringBuilder states = new StringBuilder();
        for (ReturnedDamage rd : ret.getListReturnedDamage()) {
            if (states.length() > 0) {
                states.append(", ");
            }
            states.append(rd.getDamage().getName());
        }
        tblReturnedCostume.setValueAt(ret.getFineFee() + " VND", row, 4);
        tblReturnedCostume.setValueAt(states.toString(), row, 5);
        updateTotals();
    }

    private void updateTotals() {
        float totalRent = 0;
        float totalFine = 0;
        for (ReturnedCostume ret : returnedItems) {
            totalRent += ret.getRentedFee();
            totalFine += ret.getFineFee();
        }
        txtTotalRentedCost.setText("Total Rent: " + totalRent + " VND");
        txtTotalFineFee.setText("Total Fine: " + totalFine + " VND");
    }
}
