package assignments.assignment4.frontend;

import javax.swing.*;

import assignments.assignment4.SistakaNGUI;

import java.awt.*;

import java.awt.event.*;

public class WelcomePanel extends SistakaPanel {
    private  JLabel titleLabel;
    private JButton loginButton;
    private JButton keluarButton ;

    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);
        // TODO: Implementasikan hal-hal yang diperlukan
        titleLabel = new JLabel("Welcome to SistakaNG");
        loginButton = new JButton(String.format("Login "));
        keluarButton = new JButton(String.format("Keluar"));
        titleLabel.setFont(HomeGUI.fontTitle);
        loginButton.setFont(HomeGUI.fontGeneral);
        keluarButton.setFont(HomeGUI.fontGeneral);

        
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(500,50));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Ketika tombol diclick akan membuat object TambahMahasiswaGUI
                homeGUI.setPanel("login");
                
            }
        });
        loginButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                loginButton.setBackground(new Color(59,80,250));
                loginButton.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                loginButton.setBackground(new Color(30,30,30));
                loginButton.setForeground(new Color(209,209,209));
            }
        });
        
         keluarButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                keluarButton.setBackground(new Color(59,80,250));
                keluarButton.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                keluarButton.setBackground(new Color(30,30,30));
                keluarButton.setForeground(new Color(209,209,209));
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
                
                homeGUI.exit();;
                
            }
        });

        keluarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        keluarButton.setMaximumSize(new Dimension(500,50));

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
