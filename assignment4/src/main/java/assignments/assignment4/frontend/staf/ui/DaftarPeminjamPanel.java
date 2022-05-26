package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
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
public class DaftarPeminjamPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JLabel labelPilihBuku;
    private JComboBox<String> boxBuku;
    private JLabel labelDaftarPeminjamBuku;
    private JPanel daftarPeminjamBukuPanel;
    private JButton lihatButton;
    private JButton kembaliButton;
    private JPanel buttonPanel;
    private String[] listJudulBuku;
    private String[] listPenulisBuku;

    public DaftarPeminjamPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan

        // set text , set font, dan set alignment
        daftarPeminjamBukuPanel = this;
        titleLabel = new JLabel("Lihat Daftar Peminjam");
        labelPilihBuku = new JLabel("Pilih buku");
        boxBuku = new JComboBox<String>();
        lihatButton = new JButton("Lihat");
        kembaliButton = new JButton("Kembali");
        buttonPanel = new JPanel();
        labelDaftarPeminjamBuku = new JLabel("", JLabel.CENTER);

        titleLabel.setFont(HomeGUI.fontTitle);
        labelPilihBuku.setFont(HomeGUI.fontGeneral);
        boxBuku.setFont(HomeGUI.fontGeneral);
        lihatButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);
        labelDaftarPeminjamBuku.setFont(HomeGUI.fontGeneral);

        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelPilihBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPilihBuku.setForeground(new Color(0, 255, 0));
        labelDaftarPeminjamBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDaftarPeminjamBuku.setForeground(new Color(0, 255, 0));

        boxBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(lihatButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        // Jika tombol di klik

        lihatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (boxBuku.getItemCount() > 0) {
                    String[] splitBoxBuku = boxBuku.getSelectedItem().toString().split(" oleh ", 2);
                    String judulBuku = splitBoxBuku[0];
                    String penulisBuku = splitBoxBuku[1];
                    Buku selectedBoxFindBuku = SistakaNG.findBuku(judulBuku, penulisBuku);
                    String selectedDaftarPeminjam = SistakaNG.daftarPeminjam(selectedBoxFindBuku);
                    labelDaftarPeminjamBuku.setText(selectedDaftarPeminjam);
                } else {
                    JOptionPane.showMessageDialog(daftarPeminjamBukuPanel,
                            String.format("Silahkan Memilih Buku"), "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }

        });

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
                labelDaftarPeminjamBuku.setText("");

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

        // formatting Frame paenl layout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.setBackground(new Color(30, 30, 30));

        this.add(titleLabel, gbc);
        gbc.gridy = 1;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 2;

        this.add(labelPilihBuku, gbc);
        gbc.gridy = 3;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 4;

        this.add(boxBuku, gbc);
        gbc.gridy = 5;
        this.add(Box.createRigidArea(new Dimension(0, 3)), gbc);
        gbc.gridy = 6;

        this.add(labelDaftarPeminjamBuku, gbc);

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
        listJudulBuku = new String[SistakaNG.getDaftarBuku().size()];
        listPenulisBuku = new String[SistakaNG.getDaftarBuku().size()];
        boxBuku.removeAllItems();
        if (SistakaNG.getDaftarBuku().size() > 0) {
            for (int i = 0; i < SistakaNG.getDaftarBuku().size(); i++) {
                listJudulBuku[i] = String.valueOf(SistakaNG.getDaftarBuku().get(i).getJudul());
                listPenulisBuku[i] = String.valueOf(SistakaNG.getDaftarBuku().get(i).getPenulis());
                boxBuku.addItem(listJudulBuku[i] + " oleh " + listPenulisBuku[i]);
            }

        }

    }
}
