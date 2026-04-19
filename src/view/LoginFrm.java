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
        super("Login - He thong tra do va thanh toan");
        initComponents();
        setSize(500, 400);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(40, 60, 40, 60));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        // Title
        JLabel lblTitle = new JLabel("Login", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 36));
        lblTitle.setForeground(TEXT_COLOR);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1;
        mainPanel.add(lblTitle, gbc);

        // Username row
        gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0;
        gbc.insets = new Insets(20, 5, 10, 15);
        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(LABEL_FONT);
        mainPanel.add(lblUser, gbc);

        inUsername = new JTextField(20);
        inUsername.setFont(LABEL_FONT);
        inUsername.setBorder(BorderFactory.createLineBorder(new Color(200, 210, 225), 1));
        inUsername.setPreferredSize(new Dimension(280, 36));
        gbc.gridx = 1; gbc.weightx = 1;
        mainPanel.add(inUsername, gbc);

        // Password row
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        gbc.insets = new Insets(10, 5, 10, 15);
        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(LABEL_FONT);
        mainPanel.add(lblPass, gbc);

        inPassword = new JPasswordField(20);
        inPassword.setFont(LABEL_FONT);
        inPassword.setBorder(BorderFactory.createLineBorder(new Color(200, 210, 225), 1));
        inPassword.setPreferredSize(new Dimension(280, 36));
        gbc.gridx = 1; gbc.weightx = 1;
        mainPanel.add(inPassword, gbc);

        // Login button
        JButton subLogin = new JButton("Login");
        subLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subLogin.setBackground(new Color(149, 182, 214));
        subLogin.setForeground(TEXT_COLOR);
        subLogin.setFocusPainted(false);
        subLogin.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        subLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 1;
        gbc.insets = new Insets(25, 60, 10, 60);
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
                JOptionPane.showMessageDialog(this, "Dang nhap that bai. Kich ban: cashier / a@123");
            }
        });

        // Enter key on password
        inPassword.addActionListener(e -> subLogin.doClick());

        add(mainPanel, BorderLayout.CENTER);
    }
}
