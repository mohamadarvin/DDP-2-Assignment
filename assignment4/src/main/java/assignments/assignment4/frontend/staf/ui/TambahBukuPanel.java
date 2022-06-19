package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;

import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahBukuPanel extends SistakaPanel {

    private JLabel titleLabel;
    private JPanel tambahBukuPanel;
    private JLabel LabelNama;
    private JTextField textNama;
    private JLabel labelPeulis;
    private JTextField textPenulis;
    private JLabel labelPenerbit;
    private JTextField textPenerbit;
    private JLabel labelKategori;
    private JComboBox<String> boxKategori;
    private JLabel labelStok;
    private JTextField textStok;
    private JButton tambahButton;
    private JButton kembaliButton;
    private JPanel buttonPanel = new JPanel();
    private String[] namaKategori;

    public TambahBukuPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        tambahBukuPanel = this;

        // text pada label dan button
        titleLabel = new JLabel("Tambah Buku");
        LabelNama = new JLabel("Judul");
        textNama = new JTextField();
        labelPeulis = new JLabel("Penulis");
        textPenulis = new JTextField();
        labelPenerbit = new JLabel("Penerbit");
        textPenerbit = new JTextField();
        labelKategori = new JLabel("Kategori");
        boxKategori = new JComboBox<String>();
        labelStok = new JLabel("Stok");
        textStok = new JTextField();
        tambahButton = new JButton(String.format("Tambah"));
        kembaliButton = new JButton(String.format("Kembali"));
        buttonPanel = new JPanel();

        // Set font
        titleLabel.setFont(HomeGUI.fontTitle);
        LabelNama.setFont(HomeGUI.fontGeneral);
        textNama.setFont(HomeGUI.fontGeneral);
        labelPeulis.setFont(HomeGUI.fontGeneral);
        textPenulis.setFont(HomeGUI.fontGeneral);
        labelPenerbit.setFont(HomeGUI.fontGeneral);
        textPenerbit.setFont(HomeGUI.fontGeneral);
        labelKategori.setFont(HomeGUI.fontGeneral);
        boxKategori.setFont(HomeGUI.fontGeneral);
        labelStok.setFont(HomeGUI.fontGeneral);
        textStok.setFont(HomeGUI.fontGeneral);
        tambahButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);

        // Set alignment dan warna
        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelNama.setForeground(new Color(0, 255, 0));
        textNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNama.setMaximumSize(new Dimension(500, 25));
        textPenulis.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPenulis.setMaximumSize(new Dimension(500, 25));
        textPenerbit.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPenerbit.setMaximumSize(new Dimension(500, 25));
        textStok.setAlignmentX(Component.CENTER_ALIGNMENT);
        textStok.setMaximumSize(new Dimension(500, 25));
        boxKategori.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelKategori.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelKategori.setForeground(new Color(0, 255, 0));
        labelPenerbit.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPenerbit.setForeground(new Color(0, 255, 0));
        labelPeulis.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPeulis.setForeground(new Color(0, 255, 0));
        labelStok.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelStok.setForeground(new Color(0, 255, 0));

        // Layout Button Panel
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(tambahButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        // Klik tambah button
        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (boxKategori.getItemCount() > 0) {

                    System.out.println((SistakaNG.findKategori(boxKategori.getSelectedItem().toString()).getNama()));

                    // Input tidak valid
                    if (textStok.getText().equals("") || Integer.parseInt(textStok.getText()) <= 0) {
                        JOptionPane.showMessageDialog(tambahBukuPanel,
                                String.format("Stok harus lebih dari 0"), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    // Buku sudah pernah ditambahkan
                    else if (SistakaNG.findBuku(textNama.getText(), textPenulis.getText()) != null) {
                        JOptionPane.showMessageDialog(tambahBukuPanel,
                                String.format("Buku %s oleh %s sudah pernah ditambahkan",
                                        SistakaNG.findBuku(textNama.getText(), textPenulis.getText()).getJudul(),
                                        SistakaNG.findBuku(textNama.getText(), textPenulis.getText()).getPenulis()),
                                "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        SistakaNG.addBuku(textNama.getText(), textPenulis.getText(), textPenerbit.getText(),
                                boxKategori.getSelectedItem().toString(), Integer.parseInt(textStok.getText()));
                        JOptionPane.showMessageDialog(tambahBukuPanel,
                                String.format("Buku %s oleh %s berhasil ditambahkan",
                                        SistakaNG.findBuku(textNama.getText(), textPenulis.getText()).getJudul(),
                                        SistakaNG.findBuku(textNama.getText(), textPenulis.getText()).getPenulis()));

                        main.setPanel("staf");
                        textNama.setText("");
                        textPenerbit.setText("");
                        textPenulis.setText("");
                        textStok.setText("");
                    }
                }
            }
        });

        // Klik kembali button

        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
                textNama.setText("");
                textPenerbit.setText("");
                textPenulis.setText("");
                textStok.setText("");

            }
        });

        // Klik mouse pada tombol memepengaruhi warna
        tambahButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahButton.setBackground(new Color(59, 80, 250));
                tambahButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tambahButton.setBackground(new Color(30, 30, 30));
                tambahButton.setForeground(new Color(209, 209, 209));
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

        // Formatting pada frame panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(30, 30, 30));
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(titleLabel);

        this.add(LabelNama);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textNama);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelPeulis);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textPenulis);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelPenerbit);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textPenerbit);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelKategori);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(boxKategori);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelStok);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textStok);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPanel);
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        namaKategori = new String[SistakaNG.getDaftarKategori().size()];
        boxKategori.removeAllItems();
        if (SistakaNG.getDaftarKategori().size() > 0) {
            for (int i = 0; i < SistakaNG.getDaftarKategori().size(); i++) {
                namaKategori[i] = String.valueOf(SistakaNG.getDaftarKategori().get(i).getNama());
                boxKategori.addItem(namaKategori[i]);
            }

        }

        if (boxKategori.getItemCount() == 0) {
            boxKategori.setMaximumSize(new Dimension(50, 25));
        } else {
            boxKategori.setMaximumSize(new Dimension(120, 25));
        }

    }
}
