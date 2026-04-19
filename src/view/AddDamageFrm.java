package view;

import dao.DamageDAO;
import model.Damage;
import model.ReturnedCostume;
import model.ReturnedDamage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddDamageFrm extends BaseFrm {
    private ReturnProcessingFrm parent;
    private ReturnedCostume target;
    private int rowIndex;
    
    private JTextField txtName, txtDetail, txtFee, txtNote, txtQty;

    public AddDamageFrm(ReturnProcessingFrm parent, ReturnedCostume target, int rowIndex) {
        super("Add Damage & Fine");
        this.parent = parent;
        this.target = target;
        this.rowIndex = rowIndex;
        initComponents();
        setSize(400, 450);
        centerWindow();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Damage Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Detail:"));
        txtDetail = new JTextField();
        panel.add(txtDetail);

        panel.add(new JLabel("Fee (VNĐ):"));
        txtFee = new JTextField();
        panel.add(txtFee);

        panel.add(new JLabel("Quantity Damaged:"));
        txtQty = new JTextField("1");
        panel.add(txtQty);

        panel.add(new JLabel("Note:"));
        txtNote = new JTextField();
        panel.add(txtNote);

        JButton btnCancel = createSecondaryButton("Cancel");
        JButton btnAdd = createPrimaryButton("Add");

        btnCancel.addActionListener(e -> dispose());
        btnAdd.addActionListener(e -> {
            try {
                Damage d = new Damage();
                d.setName(txtName.getText());
                d.setDetail(txtDetail.getText());
                d.setFee(Float.parseFloat(txtFee.getText()));
                d.setNote(txtNote.getText());
                
                new DamageDAO().addDamage(d);

                ReturnedDamage rd = new ReturnedDamage();
                rd.setDamage(d);
                rd.setFee(d.getFee());
                rd.setQuantity(Integer.parseInt(txtQty.getText()));
                
                target.getListReturnedDamage().add(rd);
                parent.updateRow(rowIndex);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid form data.");
            }
        });

        panel.add(btnCancel);
        panel.add(btnAdd);
        add(panel, BorderLayout.CENTER);
    }
}
