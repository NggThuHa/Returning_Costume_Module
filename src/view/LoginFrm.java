package view;

import model.User;
import dao.UserDAO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrm extends BaseFrm {
    private JTextField inUsername;
    private JPasswordField inPassword;

    public LoginFrm() {
        super("Dang nhap - He thong tra do va thanh toan");
        initComponents();
        setSize(460, 360);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel lblTitle = new JLabel("DANG NHAP HE THONG", SwingConstants.CENTER);
        lblTitle.setFont(TITLE_FONT);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainPanel.add(lblTitle, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Ten dang nhap:"), gbc);
        inUsername = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(inUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Mat khau:"), gbc);
        inPassword = new JPasswordField(15);
        gbc.gridx = 1;
        mainPanel.add(inPassword, gbc);

        JLabel lblHint = new JLabel("Tai khoan kich ban: A / a@123", SwingConstants.CENTER);
        lblHint.setForeground(SECONDARY_TEXT_COLOR);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 0, 0);
        mainPanel.add(lblHint, gbc);

        JButton subLogin = createPrimaryButton("Dang nhap");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        mainPanel.add(subLogin, gbc);

        subLogin.addActionListener(e -> {
            String username = inUsername.getText().trim();
            String password = new String(inPassword.getPassword()).trim();
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui long nhap day du ten dang nhap va mat khau.");
                return;
            }

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            if (new UserDAO().checkLogin(user)) {
                new CashierHomeFrm(user).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Dang nhap that bai. Vui long dung tai khoan A va mat khau a@123.");
            }
        });
        add(mainPanel, BorderLayout.CENTER);
    }
}
