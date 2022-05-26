package assignments.assignment4.frontend;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Pengguna;
import assignments.assignment4.backend.pengguna.Staf;
import assignments.assignment4.frontend.HomeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan

public class LoginPanel extends SistakaPanel {
    private JPanel loginPanel;
    private JTextField textId;
    private JLabel idLabel;
    private JButton loginButton;

    public LoginPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan

        // Text pada label dan button
        loginPanel = this;
        idLabel = new JLabel();
        idLabel.setText("Masukkan id anda untuk login ke sistem");
        textId = new JTextField();
        loginButton = new JButton(String.format("Login "));

        // Set Font
        idLabel.setFont(HomeGUI.fontGeneral);
        textId.setFont(HomeGUI.fontGeneral);
        loginButton.setFont(HomeGUI.fontGeneral);

        // Set Alignment dan warna
        idLabel.setForeground(new Color(0, 255, 0));
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textId.setAlignmentX(Component.CENTER_ALIGNMENT);
        textId.setMaximumSize(new Dimension(500, 25));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Klik tombol Login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Pengguna pengguna = SistakaNG.handleLogin(textId.getText());
                if (textId.getText().equals("")) {
                    JOptionPane.showMessageDialog(loginPanel, "Harap masukkan id anda pada kotak diatas!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }

                else if (pengguna == null) {
                    JOptionPane.showMessageDialog(loginPanel, "tidak ada");
                } else {
                    main.setUser(pengguna);
                    if (SistakaNG.handleLogin(textId.getText()) instanceof Staf) {
                        main.setPanel("staf");
                        textId.setText("");
                    } else {
                        main.setPanel("anggota");
                        textId.setText("");
                    }
                }

            }
        });

        // Warna login button ketika mneggunakan mouse
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent event) {
                loginButton.setBackground(new Color(59, 80, 250));
                loginButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                loginButton.setBackground(new Color(30, 30, 30));
                loginButton.setForeground(new Color(209, 209, 209));
            }
        });

        // Formatting frame panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(30, 30, 30));
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        this.add(idLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(textId);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(loginButton);

    }

    @Override
    public void refresh() {
        // ignored
    }
}
