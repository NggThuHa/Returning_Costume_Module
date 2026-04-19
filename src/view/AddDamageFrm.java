package view;

import dao.DamageDAO;
import model.Damage;
import model.ReturnedCostume;
import model.ReturnedDamage;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AddDamageFrm extends BaseFrm {
    private final ReturnProcessingFrm parent;
    private final ReturnedCostume target;

    private JTextField  txtName, txtFee;
    private JTextArea   txtDetail, txtNote;

    public AddDamageFrm(ReturnProcessingFrm parent, ReturnedCostume target) {
        super("Adding Damage");
        this.parent = parent;
        this.target = target;
        initComponents();
        setSize(480, 560);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Title
        JLabel lblTitle = new JLabel("Adding Damage", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 28));
        lblTitle.setBorder(new EmptyBorder(20, 0, 20, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // Form
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(BACKGROUND_COLOR);
        form.setBorder(new EmptyBorder(0, 40, 10, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(8, 5, 8, 5);

        // Name
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0; gbc.weighty = 0;
        form.add(fieldLabel("Name"), gbc);
        txtName = new JTextField();
        styleField(txtName);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtName, gbc);

        // Fee
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        form.add(fieldLabel("Fee"), gbc);
        txtFee = new JTextField();
        styleField(txtFee);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtFee, gbc);

        // Detail (textarea)
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0; gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        form.add(fieldLabel("Detail"), gbc);
        txtDetail = new JTextArea(4, 20);
        txtDetail.setFont(LABEL_FONT);
        txtDetail.setBorder(BorderFactory.createLineBorder(new Color(200, 215, 230), 1));
        txtDetail.setLineWrap(true);
        gbc.gridx = 1; gbc.weightx = 1; gbc.weighty = 1;
        form.add(new JScrollPane(txtDetail), gbc);

        // Note (textarea)
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0; gbc.weighty = 0;
        form.add(fieldLabel("Note"), gbc);
        txtNote = new JTextArea(4, 20);
        txtNote.setFont(LABEL_FONT);
        txtNote.setBorder(BorderFactory.createLineBorder(new Color(200, 215, 230), 1));
        txtNote.setLineWrap(true);
        gbc.gridx = 1; gbc.weightx = 1; gbc.weighty = 1;
        form.add(new JScrollPane(txtNote), gbc);

        mainPanel.add(form, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        footer.setBackground(BACKGROUND_COLOR);
        JButton btnAdd    = styledBtn("Add",    new Color(149, 182, 214));
        JButton btnCancel = styledBtn("Cancel", new Color(228, 234, 240));
        footer.add(btnAdd);
        footer.add(btnCancel);
        mainPanel.add(footer, BorderLayout.SOUTH);

        btnCancel.addActionListener(e -> dispose());
        btnAdd.addActionListener(e -> handleAdd());

        add(mainPanel);
    }

    private void handleAdd() {
        String name   = txtName.getText().trim();
        String feeStr = txtFee.getText().trim();
        String detail = txtDetail.getText().trim();
        String note   = txtNote.getText().trim();

        if (name.isEmpty() || feeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name va Fee la bat buoc.");
            return;
        }
        float fee;
        try { fee = Float.parseFloat(feeStr); } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fee phai la so.");
            return;
        }

        Damage d = new Damage();
        d.setName(name);
        d.setDetail(detail);
        d.setFee(fee);
        d.setNote(note);
        new DamageDAO().addDamage(d);

        ReturnedDamage rd = new ReturnedDamage();
        rd.setDamage(d);
        rd.setFee(fee);
        rd.setQuantity(1); // default 1 per damage entry

        target.getListReturnedDamage().add(rd);
        parent.addDamageRow(target, rd);
        dispose();
    }

    // ── Helpers ───────────────────────────────────────────────────────────
    private JLabel fieldLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(LABEL_FONT);
        lbl.setForeground(TEXT_COLOR);
        return lbl;
    }

    private void styleField(JTextField tf) {
        tf.setFont(LABEL_FONT);
        tf.setBorder(BorderFactory.createLineBorder(new Color(200, 215, 230), 1));
        tf.setPreferredSize(new Dimension(250, 32));
    }

    private JButton styledBtn(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btn.setBackground(bg);
        btn.setForeground(TEXT_COLOR);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 200, 220), 1),
            BorderFactory.createEmptyBorder(10, 40, 10, 40)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
}
