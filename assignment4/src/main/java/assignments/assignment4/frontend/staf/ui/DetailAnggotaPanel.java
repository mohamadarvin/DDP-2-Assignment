package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;

import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

// TODO: Implementasikan hal-hal yang diperlukan
public class DetailAnggotaPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JLabel labelPilihIdAnggota;
    private JComboBox<String> boxIdAnggota;
    private JButton lihatButton;
    private JButton kembaliButton;
    private JPanel buttonPanel;
    private JLabel labelDetailAnggota;
    private String[] IdAnggota;
    private JPanel detailAnggotaPanel = this;

    public DetailAnggotaPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan

        // set text , set font, dan set alignment
        titleLabel = new JLabel("Lihat Detail Anggota");
        labelPilihIdAnggota = new JLabel("Pilih ID Anggota");
        boxIdAnggota = new JComboBox<String>();
        lihatButton = new JButton("Lihat");
        kembaliButton = new JButton("Kembali");
        buttonPanel = new JPanel();
        labelDetailAnggota = new JLabel("", JLabel.CENTER);

        titleLabel.setFont(HomeGUI.fontTitle);
        labelPilihIdAnggota.setFont(HomeGUI.fontGeneral);
        boxIdAnggota.setFont(HomeGUI.fontGeneral);
        lihatButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);
        labelDetailAnggota.setFont(HomeGUI.fontGeneral);
        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPilihIdAnggota.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxIdAnggota.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxIdAnggota.setMaximumSize(new Dimension(50, 25));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(lihatButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        labelDetailAnggota.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDetailAnggota.setForeground(new Color(0, 255, 0));

        // Jika tombol di klik

        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (boxIdAnggota.getItemCount() > 0) {
                    String selectedIdAnggota = boxIdAnggota.getSelectedItem().toString();
                    labelDetailAnggota.setText((SistakaNG.findAnggota(selectedIdAnggota)).detail());
                } else {
                    JOptionPane.showMessageDialog(detailAnggotaPanel,
                            String.format("Silahkan Masukkan ID Anggota!"), "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
                labelDetailAnggota.setText("");

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

        // Frame paenl layout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.setBackground(new Color(30, 30, 30));

        this.add(titleLabel, gbc);
        gbc.gridy = 1;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 2;
        this.add(labelPilihIdAnggota, gbc);
        gbc.gridy = 3;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 4;
        this.add(boxIdAnggota, gbc);
        gbc.gridy = 5;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 6;
        this.add(labelDetailAnggota, gbc);
        gbc.gridy = 7;
        this.add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        gbc.gridy = 8;
        this.add(buttonPanel, gbc);
        gbc.gridy = 9;

    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        IdAnggota = new String[SistakaNG.getDaftarAnggota().size()];
        boxIdAnggota.removeAllItems();
        if (SistakaNG.getDaftarAnggota().size() > 0) {
            for (int i = 0; i < SistakaNG.getDaftarAnggota().size(); i++) {
                IdAnggota[i] = String.valueOf(SistakaNG.getDaftarAnggota().get(i).getId());
                boxIdAnggota.addItem(IdAnggota[i]);
            }

        }
    }
}
