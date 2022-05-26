package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

// TODO: Implementasikan hal-hal yang diperlukan
public class DetailUserPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JLabel labelPilihIdAnggota;
    private JComboBox<String> boxIdAnggota;

    private JButton kembaliButton;

    private JLabel labelDetailAnggota;
    private String[] IdAnggota;
    private JPanel detailAnggotaPanel = this;

    public DetailUserPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        titleLabel = new JLabel("Lihat Detail Anggota");
        kembaliButton = new JButton("Kembali");
        labelDetailAnggota = new JLabel("", JLabel.CENTER);

        titleLabel.setFont(HomeGUI.fontTitle);
        kembaliButton.setFont(HomeGUI.fontGeneral);
        labelDetailAnggota.setFont(HomeGUI.fontGeneral);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(0,255,0));

        kembaliButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelDetailAnggota.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDetailAnggota.setForeground(new Color(0,255,0));

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("anggota");

            }
        });

        kembaliButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                kembaliButton.setBackground(new Color(59, 80, 250));
                kembaliButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                kembaliButton.setBackground(new Color(30, 30, 30));
                kembaliButton.setForeground(new Color(209, 209, 209));
            }
        });

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setBackground(new Color(30,30,30));

        this.add(titleLabel, gbc);
        gbc.gridy = 1;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 2;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 3;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 4;
        this.add(labelDetailAnggota, gbc);
        gbc.gridy = 5;
        this.add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        gbc.gridy = 6;
        this.add(kembaliButton, gbc);
        gbc.gridy = 7;

    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        labelDetailAnggota.setText(SistakaNG.findAnggota(main.getUser().getId()).detail());

    }
}
