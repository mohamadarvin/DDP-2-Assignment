package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.awt.*;
import java.awt.event.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PeminjamanPanel extends SistakaPanel {
    private JPanel peminjamanPanel;
    private JLabel titleLabel;
    private JLabel labelBuku;
    private JComboBox<String> boxBuku;
    private JLabel labelTanggalPeminjaman;
    private JTextField textTanggalPeminjaman;
    private JButton pinjamButton;
    private JButton kembaliButton;
    private JPanel buttonPanel;
    private String[] listJudulBuku;
    private String[] listPenulisBuku;

    public PeminjamanPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        peminjamanPanel = this;
        titleLabel = new JLabel("Pinjam Buku");
        labelBuku = new JLabel("Buku");
        labelTanggalPeminjaman = new JLabel("Tanggal Peminjaman (DD/MM/YYYY)");
        textTanggalPeminjaman = new JTextField();
        pinjamButton = new JButton("Pinjam");
        kembaliButton = new JButton("Kembali");
        buttonPanel = new JPanel();
        boxBuku = new JComboBox<String>();

        titleLabel.setFont(HomeGUI.fontTitle);
        labelBuku.setFont(HomeGUI.fontGeneral);
        labelTanggalPeminjaman.setFont(HomeGUI.fontGeneral);
        textTanggalPeminjaman.setFont(HomeGUI.fontGeneral);
        pinjamButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);
        boxBuku.setFont(HomeGUI.fontGeneral);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(pinjamButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        textTanggalPeminjaman.setMaximumSize(new Dimension(500, 25));

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(0,255,0));
        labelBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelBuku.setForeground(new Color(0,255,0));
        boxBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTanggalPeminjaman.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTanggalPeminjaman.setForeground(new Color(0,255,0));
        textTanggalPeminjaman.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        pinjamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (boxBuku.getItemCount() > 0) {
                    String[] splitBoxBuku = boxBuku.getSelectedItem().toString().split(" oleh ", 2);
                    String judulBuku = splitBoxBuku[0];
                    String penulisBuku = splitBoxBuku[1];
                    Buku selectedBoxFindBuku = SistakaNG.findBuku(judulBuku, penulisBuku);

                    if (!SistakaPanel.isDateValid(textTanggalPeminjaman.getText())) {

                        JOptionPane.showMessageDialog(peminjamanPanel,
                                String.format("Tanggal yang dimasukkan harus dalam format DD/MM/YYYY"),"Warning",JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(peminjamanPanel,
                                String.format(
                                        SistakaNG.pinjamBuku(selectedBoxFindBuku, textTanggalPeminjaman.getText())));
                        main.setPanel("anggota");
                        textTanggalPeminjaman.setText("");
                    }

                }

            }
        });

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("anggota");

            }
        });

        pinjamButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                pinjamButton.setBackground(new Color(59, 80, 250));
                pinjamButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                pinjamButton.setBackground(new Color(30, 30, 30));
                pinjamButton.setForeground(new Color(209, 209, 209));
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(30, 30, 30));

        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(titleLabel);

        this.add(labelBuku);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(boxBuku);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelTanggalPeminjaman);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textTanggalPeminjaman);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPanel);
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

        if (boxBuku.getItemCount() == 0) {
            boxBuku.setMaximumSize(new Dimension(50, 25));
        } else {
            boxBuku.setMaximumSize(new Dimension(200, 25));
        }
    }
}
