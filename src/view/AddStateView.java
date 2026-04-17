package view;

import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddStateView extends BaseFrm {
    private AddDamageCostumeView parent;
    private ReturnedCostume returnedCostume;
    private int rowIndex;
    
    private JTextField inName;
    private JTextField inDetail;
    private JTextField inFee;
    private JTextField inNote;

    public AddStateView(AddDamageCostumeView parent, ReturnedCostume rc, int rowIndex) {
        super("Add State/Damage");
        this.parent = parent;
        this.returnedCostume = rc;
        this.rowIndex = rowIndex;
        initComponents();
        setSize(400, 450);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(new JLabel("State Name:"), gbc);
        inName = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(inName, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(new JLabel("Detail:"), gbc);
        inDetail = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(inDetail, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Fee:"), gbc);
        inFee = new JTextField("0", 20);
        gbc.gridx = 1;
        mainPanel.add(inFee, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("Note:"), gbc);
        inNote = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(inNote, gbc);

        JButton btnAdd = createPrimaryButton("Add State");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        mainPanel.add(btnAdd, gbc);

        btnAdd.addActionListener(e -> {
            handleSave();
        });

        add(mainPanel);
    }

    private void handleSave() {
        try {
            String name = inName.getText();
            String detail = inDetail.getText();
            float fee = Float.parseFloat(inFee.getText());
            String note = inNote.getText();

            Damage d = new Damage(name, detail, fee);
            d.setNote(note);
            
            ReturnedDamage rd = new ReturnedDamage();
            rd.setDamage(d);
            rd.setFee(fee);
            rd.setQuantity(1);
            rd.setIsPaid(true);

            returnedCostume.getListReturnedDamage().add(rd);
            parent.updateRow(rowIndex);
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid fee.");
        }
    }
}
