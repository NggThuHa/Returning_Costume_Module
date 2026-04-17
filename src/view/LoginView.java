package view;

import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends BaseFrm {
    private JTextField inUsername;
    private JPasswordField inPassword;

    public LoginView() {
        super("Login - Costume Rental System");
        initComponents();
        setSize(400, 350);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel lblTitle = new JLabel("Login System", SwingConstants.CENTER);
        lblTitle.setFont(TITLE_FONT);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainPanel.add(lblTitle, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Username:"), gbc);
        inUsername = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(inUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Password:"), gbc);
        inPassword = new JPasswordField(15);
        gbc.gridx = 1;
        mainPanel.add(inPassword, gbc);

        JButton subLogin = createPrimaryButton("Login");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        mainPanel.add(subLogin, gbc);

        subLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        add(mainPanel, BorderLayout.CENTER);
    }

    private void handleLogin() {
        String username = inUsername.getText();
        String password = new String(inPassword.getPassword());

        // Simple mock login
        if (username.equals("cashier") || username.equals("manager")) {
            User user = new User(username, password, "Full Name", "cashier");
            new CashierHomeView(user).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password!");
        }
    }
}
