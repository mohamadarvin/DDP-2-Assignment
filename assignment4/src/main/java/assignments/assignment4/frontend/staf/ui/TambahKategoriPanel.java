package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Kategori;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.print.attribute.IntegerSyntax;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahKategoriPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JLabel labelNama;
    private JTextField textNama;
    private JLabel labelPoin;
    private JTextField textPoin;
    private JButton tambahButton;
    private JButton kembaliButton;
    private JPanel buttonPanel;
    private JPanel tambahKategoriPanel;

    public TambahKategoriPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        tambahKategoriPanel = this;

        // text pada labeel dan button
        titleLabel = new JLabel("Tambah Kategori");
        labelNama = new JLabel("Nama");
        textNama = new JTextField();
        labelPoin = new JLabel("Poin");
        textPoin = new JTextField();
        tambahButton = new JButton(String.format("Tambah"));
        kembaliButton = new JButton(String.format("Kembali"));
        buttonPanel = new JPanel();

        // Set Font
        titleLabel.setFont(HomeGUI.fontTitle);
        labelNama.setFont(HomeGUI.fontGeneral);
        textNama.setFont(HomeGUI.fontGeneral);
        labelPoin.setFont(HomeGUI.fontGeneral);
        textPoin.setFont(HomeGUI.fontGeneral);
        tambahButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);

        // Set Alignment dan warna
        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(0, 255, 0));
        textNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNama.setMaximumSize(new Dimension(500, 25));
        labelPoin.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPoin.setForeground(new Color(0, 255, 0));
        textPoin.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPoin.setMaximumSize(new Dimension(500, 25));

        // Klik tambah button
        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Jika input tidak valid
                if (textPoin.getText().equals("")) {
                    JOptionPane.showMessageDialog(tambahKategoriPanel, "Mohon isi Field Poin", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }

                // Jika sudah pernah ditambahkan
                else if (SistakaNG.findKategori(textNama.getText()) != null) {
                    JOptionPane.showMessageDialog(tambahKategoriPanel,
                            String.format("Kategori %s sudah pernah ditambahkan!", textNama.getText()), "Warning",
                            JOptionPane.WARNING_MESSAGE);

                } else {
                    SistakaNG.addKategori(textNama.getText(), Integer.parseInt(textPoin.getText()));
                    JOptionPane.showMessageDialog(
                            tambahKategoriPanel, String.format("Kategori %s dengan poin %d berhasil ditambahkan",
                                    textNama.getText(), Integer.parseInt(textPoin.getText())));

                    main.setPanel("staf");
                    textNama.setText("");
                    textPoin.setText("");
                }
            }
        });

        // Layout button panel beserta isinya
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(tambahButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        // Klik kembali button
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
                textNama.setText("");
                textPoin.setText("");

            }
        });

        // Warna button ketika mneggunakan mouse
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

        // Formatting frame panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(30, 30, 30));
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        this.add(titleLabel);
        this.add(labelNama);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textNama);
        this.add(labelPoin);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textPoin);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPanel);
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}
