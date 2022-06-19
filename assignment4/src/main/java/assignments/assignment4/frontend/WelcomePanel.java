package assignments.assignment4.frontend;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class WelcomePanel extends SistakaPanel {
    private JLabel titleLabel;
    private JButton loginButton;
    private JButton keluarButton;

    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);
        // TODO: Implementasikan hal-hal yang diperlukan

        // Text label dan button
        titleLabel = new JLabel("Welcome to SistakaNG");
        loginButton = new JButton(String.format("Login "));
        keluarButton = new JButton(String.format("Keluar"));

        // Set Font
        titleLabel.setFont(HomeGUI.fontTitle);
        loginButton.setFont(HomeGUI.fontGeneral);
        keluarButton.setFont(HomeGUI.fontGeneral);

        // Alignmet dan warna text
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(0, 255, 0));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(500, 50));

        // Login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                homeGUI.setPanel("login");
            }
        });

        // Keluar
        keluarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                homeGUI.exit();
                ;

            }
        });

        // Warna login button ketika mneggunakan mouse
        loginButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                loginButton.setBackground(new Color(59, 80, 250));
                loginButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                loginButton.setBackground(new Color(30, 30, 30));
                loginButton.setForeground(new Color(209, 209, 209));
            }
        });

        // Warna keluar button ketika mneggunakan mouse
        keluarButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                keluarButton.setBackground(new Color(59, 80, 250));
                keluarButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                keluarButton.setBackground(new Color(30, 30, 30));
                keluarButton.setForeground(new Color(209, 209, 209));
            }
        });

        // Formatting frame panel
        this.setBackground(new Color(30, 30, 30));
        keluarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        keluarButton.setMaximumSize(new Dimension(500, 50));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        this.add(titleLabel);
        this.add(Box.createRigidArea(new Dimension(0, 250)));
        this.add(loginButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(keluarButton);

    }

    @Override
    public void refresh() {
        // ignored
    }
}
