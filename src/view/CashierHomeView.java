package view;

import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CashierHomeView extends BaseFrm {
    private User user;

    public CashierHomeView(User user) {
        super("Cashier Home - Costume Rental System");
        this.user = user;
        initComponents();
        setSize(600, 400);
        centerWindow();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel header = createHeader("Cashier Dashboard");
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel content = new JPanel(new GridLayout(1, 2, 20, 20));
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(40, 40, 40, 40));

        JButton subRent = createMenuButton("Rent Costume", "Process new rental");
        JButton subReturn = createMenuButton("Return & Payment", "Process costume return");

        content.add(subRent);
        content.add(subReturn);

        subReturn.addActionListener(e -> {
            new SearchClientView(user).setVisible(true);
            this.dispose();
        });

        mainPanel.add(content, BorderLayout.CENTER);

        JButton btnLogout = createSecondaryButton("Logout");
        btnLogout.addActionListener(e -> {
            new LoginView().setVisible(true);
            this.dispose();
        });
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(BACKGROUND_COLOR);
        footer.add(btnLogout);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JButton createMenuButton(String title, String subTitle) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(PRIMARY_COLOR);
        
        JLabel lblSub = new JLabel(subTitle, SwingConstants.CENTER);
        lblSub.setFont(LABEL_FONT);
        lblSub.setForeground(SECONDARY_TEXT_COLOR);

        button.add(lblTitle, BorderLayout.CENTER);
        button.add(lblSub, BorderLayout.SOUTH);

        return button;
    }
}
