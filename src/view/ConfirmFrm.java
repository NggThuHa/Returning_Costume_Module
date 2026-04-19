package view;

import dao.CostumeDAO;
import dao.RentedReceiptDAO;
import dao.ReturnedReceiptDAO;
import model.Costume;
import model.RentedDeposit;
import model.RentedReceipt;
import model.ReturnedCostume;
import model.ReturnedReceipt;
import model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

public class ConfirmFrm extends BaseFrm {
    private final User u;
    private final ReturnedReceipt returnedReceipt;
    private final List<RentedDeposit> depositsToRefund;

    public ConfirmFrm(User user, ReturnedReceipt receipt) {
        super("Confirm Return Receipt");
        this.u = user;
        this.returnedReceipt = receipt;
        receipt.setBarcode("INV-" + (System.currentTimeMillis() % 10000));

        depositsToRefund = new ArrayList<>();
        List<RentedReceipt> receipts = new RentedReceiptDAO().searchByClient(receipt.getClient());
        for (RentedReceipt rentedReceipt : receipts) {
            if (rentedReceipt.getListRentedDeposit() != null) {
                for (RentedDeposit rentedDeposit : rentedReceipt.getListRentedDeposit()) {
                    if (!rentedDeposit.isReturned() && rentedReceipt.isCompleted()) {
                        depositsToRefund.add(rentedDeposit);
                    }
                }
            }
        }

        initComponents();
        setSize(900, 800);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Confirm Invoice / Return Receipt");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel infoPanel = new JPanel(new GridLayout(3, 2));
        infoPanel.setBackground(java.awt.Color.WHITE);
        infoPanel.add(new JLabel("Invoice: " + returnedReceipt.getBarcode()));
        infoPanel.add(new JLabel("Date: " + returnedReceipt.getReturnedAt()));
        infoPanel.add(new JLabel("Cashier: " + returnedReceipt.getUser().getFullname()));
        infoPanel.add(new JLabel("Client: " + returnedReceipt.getClient().getFullname()));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        content.add(infoPanel, gbc);

        String[] columns = {"Barcode", "Item Name", "Qty", "Rent Fee", "Fine Fee"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable tblReturnedCostume = new JTable(model);
        tblReturnedCostume.setRowHeight(30);
        for (ReturnedCostume ret : returnedReceipt.getListReturnedCostume()) {
            model.addRow(new Object[]{
                    ret.getRentedCostume().getCostume().getBarcode(),
                    ret.getRentedCostume().getCostume().getName(),
                    ret.getQuantity(),
                    ret.getRentedFee() + " VND",
                    ret.getFineFee() + " VND"
            });
        }
        JPanel pnl1 = new JPanel(new BorderLayout());
        pnl1.add(new JLabel("Returned Costumes:"), BorderLayout.NORTH);
        pnl1.add(new JScrollPane(tblReturnedCostume), BorderLayout.CENTER);
        gbc.gridy = 1;
        gbc.weighty = 1;
        content.add(pnl1, gbc);

        String[] depCols = {"Deposit Name", "Qty", "Value"};
        DefaultTableModel depModel = new DefaultTableModel(depCols, 0);
        JTable tblReturnedDeposit = new JTable(depModel);
        tblReturnedDeposit.setRowHeight(30);
        for (RentedDeposit rd : depositsToRefund) {
            depModel.addRow(new Object[]{
                    rd.getDepositItem().getName(),
                    rd.getQuantity(),
                    rd.getDepositAmount() + " VND"
            });
        }
        JPanel pnl2 = new JPanel(new BorderLayout());
        pnl2.add(new JLabel("Refundable Deposits:"), BorderLayout.NORTH);
        pnl2.add(new JScrollPane(tblReturnedDeposit), BorderLayout.CENTER);
        gbc.gridy = 2;
        gbc.weighty = 1;
        content.add(pnl2, gbc);

        float totalDeposit = 0;
        for (RentedDeposit rentedDeposit : depositsToRefund) {
            totalDeposit += rentedDeposit.getDepositAmount();
        }

        JPanel totalsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        totalsPanel.setBackground(BACKGROUND_COLOR);
        totalsPanel.setBorder(new EmptyBorder(10, 400, 10, 0));

        totalsPanel.add(new JLabel("Subtotal Rent:"));
        totalsPanel.add(new JLabel(returnedReceipt.getTotalRentedFee() + " VND", SwingConstants.RIGHT));

        totalsPanel.add(new JLabel("Subtotal Fine:"));
        totalsPanel.add(new JLabel(returnedReceipt.getTotalFineFee() + " VND", SwingConstants.RIGHT));

        totalsPanel.add(new JLabel("Refundable Deposit:"));
        totalsPanel.add(new JLabel(totalDeposit + " VND", SwingConstants.RIGHT));

        float totalPayable = returnedReceipt.getTotalReceiptFee() - totalDeposit;
        JLabel lblTotal = new JLabel(totalPayable >= 0 ? "CLIENT PAYS:" : "REFUND CLIENT:");
        lblTotal.setFont(BUTTON_FONT);
        totalsPanel.add(lblTotal);
        JLabel lblTotalVal = new JLabel(Math.abs(totalPayable) + " VND", SwingConstants.RIGHT);
        lblTotalVal.setFont(BUTTON_FONT);
        lblTotalVal.setForeground(PRIMARY_COLOR);
        totalsPanel.add(lblTotalVal);

        gbc.gridy = 3;
        gbc.weighty = 0;
        content.add(totalsPanel, gbc);

        mainPanel.add(content, BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);

        JButton btnConfirm = createPrimaryButton("Confirm & Print");
        JButton btnCancel = createSecondaryButton("Cancel");

        btnConfirm.addActionListener(e -> {
            RentedReceiptDAO rentedReceiptDAO = new RentedReceiptDAO();
            ReturnedReceiptDAO returnedReceiptDAO = new ReturnedReceiptDAO();
            CostumeDAO costumeDAO = new CostumeDAO();

            returnedReceiptDAO.addReturnedReceipt(returnedReceipt);
            rentedReceiptDAO.applyReturnedItemsToRentedReceipt(returnedReceipt);

            for (ReturnedCostume rc : returnedReceipt.getListReturnedCostume()) {
                Costume costumeToUpdate = new Costume();
                costumeToUpdate.setBarcode(rc.getRentedCostume().getCostume().getBarcode());
                costumeToUpdate.setQuantity(rc.getQuantity());
                costumeDAO.updateQuantity(costumeToUpdate);
            }

            JOptionPane.showMessageDialog(this, "Transaction completed and receipt printed!");
            new CashierHomeFrm(u).setVisible(true);
            this.dispose();
        });

        btnCancel.addActionListener(e -> {
            new ReturnProcessingFrm(u, returnedReceipt.getClient(), returnedReceipt.getListReturnedCostume()).setVisible(true);
            this.dispose();
        });

        footer.add(btnCancel);
        footer.add(btnConfirm);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
