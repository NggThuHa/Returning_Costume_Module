package view;

import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddDamageCostumeView extends BaseFrm {
    private User user;
    private Client outClientInfo;
    private List<RentedCostume> selectedRented;
    private List<ReturnedCostume> returnedItems;
    private JTable tblItems;
    private JLabel outReturnedDate;
    private JLabel outTotalFineFee;
    private JLabel outTotalRentedCostume;

    public AddDamageCostumeView(User user, Client client, List<RentedCostume> selectedRented) {
        super("Add Damage & State - Costume Rental System");
        this.user = user;
        this.outClientInfo = client;
        this.selectedRented = selectedRented;
        this.returnedItems = initReturnedItems();
        initComponents();
        setSize(1000, 700);
        centerWindow();
        updateTotals();
    }

    private List<ReturnedCostume> initReturnedItems() {
        List<ReturnedCostume> list = new ArrayList<>();
        for (RentedCostume rc : selectedRented) {
            ReturnedCostume ret = new ReturnedCostume();
            ret.setRentedCostume(rc);
            ret.setQuantity(rc.getQuantity());
            ret.setReturnedAt(new Date());
            ret.setListReturnedDamage(new ArrayList<>());
            list.add(ret);
        }
        return list;
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Update Costume Status");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel content = new JPanel(new BorderLayout(0, 20));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));

        outReturnedDate = new JLabel("Return Date: " + new Date().toString());
        outReturnedDate.setFont(LABEL_FONT);
        content.add(outReturnedDate, BorderLayout.NORTH);

        String[] columns = {"Barcode", "Name", "Qty", "Rent Fee", "Fine", "States"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        tblItems = new JTable(model);
        tblItems.setRowHeight(40);
        
        for (ReturnedCostume ret : returnedItems) {
            model.addRow(new Object[]{
                ret.getRentedCostume().getCostume().getBarcode(),
                ret.getRentedCostume().getCostume().getName(),
                ret.getQuantity(),
                "0", "0", "None"
            });
        }
        content.add(new JScrollPane(tblItems), BorderLayout.CENTER);

        JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        outTotalRentedCostume = new JLabel("Total Items: 0");
        outTotalFineFee = new JLabel("Total Fine: 0 VNĐ");
        JButton subAddState = createSecondaryButton("Add State/Damage");
        
        summaryPanel.add(outTotalRentedCostume);
        summaryPanel.add(outTotalFineFee);
        summaryPanel.add(subAddState);

        content.add(summaryPanel, BorderLayout.SOUTH);
        mainPanel.add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnBack = createSecondaryButton("Back");
        JButton subFinish = createPrimaryButton("Finish");
        
        subAddState.addActionListener(e -> {
            int row = tblItems.getSelectedRow();
            if (row != -1) {
                new AddStateView(this, returnedItems.get(row), row).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Select an item.");
            }
        });

        subFinish.addActionListener(e -> {
            ReturnedReceipt receipt = new ReturnedReceipt();
            receipt.setClient(outClientInfo);
            receipt.setUser(user);
            receipt.setReturnedAt(new Date());
            receipt.setListReturnedCostume(returnedItems);
            new ConfirmView(user, receipt).setVisible(true);
            this.dispose();
        });

        footer.add(btnBack);
        footer.add(subFinish);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void updateRow(int row) {
        ReturnedCostume ret = returnedItems.get(row);
        float fine = 0;
        StringBuilder states = new StringBuilder();
        for (ReturnedDamage rd : ret.getListReturnedDamage()) {
            fine += rd.getFee();
            if (states.length() > 0) states.append(", ");
            states.append(rd.getDamage().getName());
        }
        tblItems.setValueAt(fine + " VNĐ", row, 4);
        tblItems.setValueAt(states.toString(), row, 5);
        updateTotals();
    }

    private void updateTotals() {
        int count = 0;
        float totalFine = 0;
        for (ReturnedCostume ret : returnedItems) {
            count += ret.getQuantity();
            for (ReturnedDamage rd : ret.getListReturnedDamage()) {
                totalFine += rd.getFee();
            }
        }
        outTotalRentedCostume.setText("Total Items: " + count);
        outTotalFineFee.setText("Total Fine: " + totalFine + " VNĐ");
    }
}
