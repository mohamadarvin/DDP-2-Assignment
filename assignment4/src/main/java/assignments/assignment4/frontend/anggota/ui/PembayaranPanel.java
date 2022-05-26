package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

// TODO: Implementasikan hal-hal yang diperlukan
public class PembayaranPanel extends SistakaPanel {

    private JLabel titleLabel;
    private JLabel labelJumlahDenda;
    private JTextField textDenda;
    private JButton bayarButton;
    private JButton kembaliButton;
    private JPanel pembayaranPanel;
    private JPanel buttonPanel;
    private String bayarDenda;

    public PembayaranPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        pembayaranPanel = this;
        titleLabel = new JLabel("Bayar Denda");
        labelJumlahDenda = new JLabel("Jumlah Denda");
        textDenda = new JTextField();
        bayarButton = new JButton(String.format("Bayar"));
        kembaliButton = new JButton(String.format("Kembali"));
        buttonPanel = new JPanel();

        titleLabel.setFont(HomeGUI.fontTitle);
        labelJumlahDenda.setFont(HomeGUI.fontGeneral);
        textDenda.setFont(HomeGUI.fontGeneral);
        bayarButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelJumlahDenda.setAlignmentX(Component.CENTER_ALIGNMENT);
        textDenda.setAlignmentX(Component.CENTER_ALIGNMENT);
        textDenda.setMaximumSize(new Dimension(500, 25));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(bayarButton);
        bayarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (isNumeric(textDenda.getText()) == false) {
                    JOptionPane.showMessageDialog(pembayaranPanel,
                            "Jumlah Bayar harus berupa angka!");
                } else {

                    JOptionPane.showMessageDialog(pembayaranPanel,
                            String.format(SistakaNG.bayarDenda(Long.parseLong(textDenda.getText()))));
                            main.setPanel("anggota");
                            textDenda.setText("");
                }
            }
        });
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("anggota");
                textDenda.setText("");

            }
        });

        bayarButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                bayarButton.setBackground(new Color(59,80,250));
                bayarButton.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                bayarButton.setBackground(new Color(30,30,30));
                bayarButton.setForeground(new Color(209,209,209));
            }
        });

        kembaliButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                kembaliButton.setBackground(new Color(59,80,250));
                kembaliButton.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                kembaliButton.setBackground(new Color(30,30,30));
                kembaliButton.setForeground(new Color(209,209,209));
            }
        });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        this.add(titleLabel);

        this.add(labelJumlahDenda);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textDenda);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPanel);
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        if (!textDenda.getText().equalsIgnoreCase("")) {
            bayarDenda = SistakaNG.bayarDenda(Long.parseLong(textDenda.getText()));
        }
    }
}
