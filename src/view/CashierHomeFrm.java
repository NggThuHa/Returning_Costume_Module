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
        setSize(500, 400);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Welcome, " + u.getFullname());
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel body = new JPanel(new GridLayout(3, 1, 20, 20));
        body.setBackground(BACKGROUND_COLOR);
        body.setBorder(new EmptyBorder(40, 60, 40, 60));

        JButton btnRent = createSecondaryButton("Rent Costume");
        JButton btnReturn = createPrimaryButton("Return Costume & Payment");
        JButton btnLogout = createSecondaryButton("Logout");

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
}
