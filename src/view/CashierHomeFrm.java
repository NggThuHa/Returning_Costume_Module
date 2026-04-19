package view;

import model.User;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CashierHomeFrm extends BaseFrm {
    private User u;

    public CashierHomeFrm(User user) {
        super("Cashier Home - Costume Rental System");
        this.u = user;
        initComponents();
        setSize(600, 480);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Title
        JLabel lblTitle = new JLabel("Cashier\u2019s home", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 36));
        lblTitle.setForeground(TEXT_COLOR);
        lblTitle.setBorder(new EmptyBorder(50, 0, 30, 0));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // Buttons panel - centered
        JPanel body = new JPanel(new GridLayout(3, 1, 0, 20));
        body.setBackground(BACKGROUND_COLOR);
        body.setBorder(new EmptyBorder(10, 80, 60, 80));

        JButton btnRent   = makeMenuButton("Rent costume",   new Color(149, 182, 214));
        JButton btnReturn = makeMenuButton("Return costume",  new Color(149, 182, 214));
        JButton btnLogout = makeMenuButton("Logout",          new Color(228, 234, 240));

        btnReturn.addActionListener(e -> {
            new SearchClientFrm(u).setVisible(true);
            this.dispose();
        });

        btnLogout.addActionListener(e -> {
            new LoginFrm().setVisible(true);
            this.dispose();
        });

        body.add(btnRent);
        body.add(btnReturn);
        body.add(btnLogout);
        mainPanel.add(body, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JButton makeMenuButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 20));
        btn.setBackground(bg);
        btn.setForeground(TEXT_COLOR);
        btn.setFocusPainted(false);
        btn.setBorderPainted(true);
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(190, 210, 230), 1),
            BorderFactory.createEmptyBorder(14, 20, 14, 20)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        return btn;
    }
}
