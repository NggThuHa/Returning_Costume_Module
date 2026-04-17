package view;

import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReturnReceiptFrm extends BaseFrm {
    private User user;
    private ReturnedReceipt receipt;

    public ReturnReceiptFrm(User user, ReturnedReceipt receipt) {
        super("Return Receipt - Costume Rental System");
        this.user = user;
        this.receipt = receipt;
        receipt.setBarcode("INV-" + System.currentTimeMillis() % 10000);
        initComponents();
        setSize(900, 800);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Header
        JPanel header = createHeader("Invoice / Return Receipt");
        mainPanel.add(header, BorderLayout.NORTH);

        // Content
        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Info Section
        JPanel infoPanel = new JPanel(new GridLayout(4, 2));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            new EmptyBorder(15, 15, 15, 15)
        ));
        
        infoPanel.add(new JLabel("Invoice No: " + receipt.getBarcode()));
        infoPanel.add(new JLabel("Date: " + receipt.getReturnedAt().toString()));
        infoPanel.add(new JLabel("Cashier: " + receipt.getCreator().getFullname()));
        infoPanel.add(new JLabel("Client: " + receipt.getClient().getFullname()));
        infoPanel.add(new JLabel("Phone: " + receipt.getClient().getTel()));
        infoPanel.add(new JLabel("Email: " + receipt.getClient().getEmail()));

        gbc.gridx = 0; gbc.gridy = 0; gbc.weighty = 0;
        content.add(infoPanel, gbc);

        // Table
        String[] columns = {"Barcode", "Item Name", "Qty", "Rent Fee", "Fine Fee"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setRowHeight(30);
        for (ReturnedCostume ret : receipt.getReturnedCostumes()) {
            model.addRow(new Object[]{
                ret.getRentedCostume().getCostume().getBarcode(),
                ret.getRentedCostume().getCostume().getName(),
                ret.getQuantity(),
                ret.getRentFee() + " VNĐ",
                ret.getFineFee() + " VNĐ"
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        gbc.gridy = 1; gbc.weighty = 1;
        content.add(scrollPane, gbc);

        // Totals
        JPanel totalsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        totalsPanel.setBackground(BACKGROUND_COLOR);
        totalsPanel.setBorder(new EmptyBorder(10, 400, 10, 0));
        
        totalsPanel.add(new JLabel("Subtotal Rent:"));
        totalsPanel.add(new JLabel(receipt.getTotalRentFee() + " VNĐ", SwingConstants.RIGHT));
        
        totalsPanel.add(new JLabel("Subtotal Fine:"));
        totalsPanel.add(new JLabel(receipt.getTotalFineFee() + " VNĐ", SwingConstants.RIGHT));
        
        float totalPayable = receipt.getTotalRentFee() + receipt.getTotalFineFee();
        JLabel lblTotal = new JLabel("TOTAL TO PAY:");
        lblTotal.setFont(BUTTON_FONT);
        totalsPanel.add(lblTotal);
        JLabel lblTotalVal = new JLabel(totalPayable + " VNĐ", SwingConstants.RIGHT);
        lblTotalVal.setFont(BUTTON_FONT);
        lblTotalVal.setForeground(PRIMARY_COLOR);
        totalsPanel.add(lblTotalVal);

        totalsPanel.add(new JLabel("Refundable Deposit:"));
        totalsPanel.add(new JLabel(receipt.getTotalRefundDeposit() + " VNĐ", SwingConstants.RIGHT));

        gbc.gridy = 2; gbc.weighty = 0;
        content.add(totalsPanel, gbc);

        mainPanel.add(content, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        footer.setBorder(new EmptyBorder(10, 20, 20, 20));
        
        JButton btnPrint = createPrimaryButton("Confirm & Print");
        JButton btnCancel = createSecondaryButton("Cancel");

        btnPrint.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Transaction completed and receipt printed!");
            new CashierHomeFrm(user).setVisible(true);
            this.dispose();
        });

        btnCancel.addActionListener(e -> {
            new AddDamageFrm(user, receipt.getClient(), null).setVisible(true); // Simplified
            this.dispose();
        });

        footer.add(btnCancel);
        footer.add(btnPrint);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
