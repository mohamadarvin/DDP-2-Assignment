package assignments.assignment4.frontend.anggota.ui;

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
public class PengembalianPanel extends SistakaPanel {
    private JPanel pengembalianPanel;
    private JLabel titleLabel;
    private JLabel labelBuku;
    private JComboBox<String> boxBuku;
    private JLabel labelTanggalPengembalian;
    private JTextField textTanggalPengembalian;
    private JButton kembalikanButton;
    private JButton kembaliButton;
    private JPanel buttonPanel;
    private String[] listJudulBuku;
    private String[] listPenulisBuku;

    public PengembalianPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        pengembalianPanel = this;
        titleLabel = new JLabel("Pengembalian Buku");
        labelBuku = new JLabel("Buku");
        labelTanggalPengembalian = new JLabel("Tanggal Pengembalian (DD/MM/YYYY)");
        textTanggalPengembalian = new JTextField();
        kembalikanButton = new JButton("Kembalikan");
        kembaliButton = new JButton("Kembali");
        buttonPanel = new JPanel();
        boxBuku = new JComboBox<String>();

        titleLabel.setFont(HomeGUI.fontTitle);
        labelBuku.setFont(HomeGUI.fontGeneral);
        labelTanggalPengembalian.setFont(HomeGUI.fontGeneral);
        textTanggalPengembalian.setFont(HomeGUI.fontGeneral);
        kembalikanButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);
        boxBuku.setFont(HomeGUI.fontGeneral);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(kembalikanButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        textTanggalPengembalian.setMaximumSize(new Dimension(500, 25));

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTanggalPengembalian.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        kembalikanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (boxBuku.getItemCount() > 0) {
                    String[] splitBoxBuku = boxBuku.getSelectedItem().toString().split(" oleh ", 2);
                    String judulBuku = splitBoxBuku[0];
                    String penulisBuku = splitBoxBuku[1];
                    Buku selectedBoxFindBuku = SistakaNG.findBuku(judulBuku, penulisBuku);

                    if (!SistakaPanel.isDateValid(textTanggalPengembalian.getText())) {

                        JOptionPane.showMessageDialog(pengembalianPanel,
                                String.format("Tanggal yang dimasukkan harus dalam format DD/MM/YYYY"));
                    } else {
                        JOptionPane.showMessageDialog(pengembalianPanel,
                                String.format(
                                        SistakaNG.kembalikanBuku(selectedBoxFindBuku,
                                                textTanggalPengembalian.getText())));
                        main.setPanel("anggota");
                        textTanggalPengembalian.setText("");

                    }


                }

            }
        });

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("anggota");

            }
        });

        kembalikanButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                kembalikanButton.setBackground(new Color(59,80,250));
                kembalikanButton.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                kembalikanButton.setBackground(new Color(30,30,30));
                kembalikanButton.setForeground(new Color(209,209,209));
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

        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(titleLabel);

        this.add(labelBuku);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(boxBuku);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelTanggalPengembalian);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textTanggalPengembalian);
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
