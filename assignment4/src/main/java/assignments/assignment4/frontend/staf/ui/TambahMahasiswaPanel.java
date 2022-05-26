package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.IdGenerator;
import assignments.assignment4.backend.pengguna.Mahasiswa;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.annotation.processing.Generated;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan

public class TambahMahasiswaPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JPanel tambahmahasiswaPanel;
    private JTextField textNama;
    private JTextField textTanggalLahir;
    private JTextField textAngkatan;
    private JButton tambahButton;
    private JButton kembaliButton;
    private JLabel labelNama;
    private JLabel labelTanggalLahir;
    private JLabel labelProdi;
    private JLabel labelAngkatan;
    private JComboBox<String> boxProdi;
    private JPanel buttonPanel;

    public TambahMahasiswaPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan

        tambahmahasiswaPanel = this;

        // Text Pada label dan button
        titleLabel = new JLabel("Tambah Mahasiswa");
        textNama = new JTextField();
        textTanggalLahir = new JTextField();
        textAngkatan = new JTextField();
        tambahButton = new JButton(String.format("Tambah"));
        kembaliButton = new JButton(String.format("Kembali"));
        labelNama = new JLabel("Nama");
        labelTanggalLahir = new JLabel("Tanggal Lahir(DD/MM/YYYY)");
        labelProdi = new JLabel("Program Studi");
        labelAngkatan = new JLabel("Angkatan");
        boxProdi = new JComboBox<String>();
        buttonPanel = new JPanel();

        // Set Font pada label dan button
        titleLabel.setFont(HomeGUI.fontTitle);
        textNama.setFont(HomeGUI.fontGeneral);
        textTanggalLahir.setFont(HomeGUI.fontGeneral);
        textAngkatan.setFont(HomeGUI.fontGeneral);
        tambahButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);
        labelNama.setFont(HomeGUI.fontGeneral);
        labelTanggalLahir.setFont(HomeGUI.fontGeneral);
        labelProdi.setFont(HomeGUI.fontGeneral);
        labelAngkatan.setFont(HomeGUI.fontGeneral);
        boxProdi.setFont(HomeGUI.fontGeneral);

        // Set Alignment,warna, serta format
        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setForeground(new Color(0, 255, 0));
        labelAngkatan.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelAngkatan.setForeground(new Color(0, 255, 0));
        labelProdi.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelProdi.setForeground(new Color(0, 255, 0));
        labelTanggalLahir.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTanggalLahir.setForeground(new Color(0, 255, 0));
        textNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNama.setMaximumSize(new Dimension(500, 25));
        textTanggalLahir.setAlignmentX(Component.CENTER_ALIGNMENT);
        textTanggalLahir.setMaximumSize(new Dimension(500, 25));
        boxProdi.setAlignmentX(Component.CENTER_ALIGNMENT);
        boxProdi.setMaximumSize(new Dimension(50, 25));
        boxProdi.addItem("SIK");
        boxProdi.addItem("SSI");
        boxProdi.addItem("MIK");
        boxProdi.addItem("MTI");
        boxProdi.addItem("DIK");
        textAngkatan.setAlignmentX(Component.CENTER_ALIGNMENT);
        textAngkatan.setMaximumSize(new Dimension(500, 25));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(tambahButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        // Klik Tambah Button
        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Mahasiswa penambahanMahasiswa = SistakaNG.addMahasiswa(textNama.getText(), textTanggalLahir.getText(),
                        boxProdi.getSelectedItem().toString(), textAngkatan.getText());

                // Jika input kurang tepat
                if (textNama.getText().equals("") || penambahanMahasiswa == null) {
                    JOptionPane.showMessageDialog(tambahmahasiswaPanel,
                            "Tidak dapat menambahkan anggota silahkan periksa kembali input anda!", "Warning",
                            JOptionPane.WARNING_MESSAGE);

                    // Input Sudah tepat
                } else {
                    JOptionPane.showMessageDialog(tambahmahasiswaPanel,
                            String.format("Berhasil menambahkan mahasiswa dengan id %s",
                                    IdGenerator.generateId(boxProdi.getSelectedItem().toString(),
                                            textAngkatan.getText(), textTanggalLahir.getText())));
                    main.setPanel("staf");
                    textAngkatan.setText("");
                    textNama.setText("");
                    textTanggalLahir.setText("");
                }

            }
        });

        // Klik tombol krmbali
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
                textAngkatan.setText("");
                textNama.setText("");
                textTanggalLahir.setText("");

            }
        });

        // Warna tamabhbutton ketika mneggunakan mouse
        tambahButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahButton.setBackground(new Color(59, 80, 250));
                tambahButtonf.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tambahButton.setBackground(new Color(30, 30, 30));
                tambahButton.setForeground(new Color(209, 209, 209));
            }
        });

        // Warna kembalibutton ketika mneggunakan mouse
        kembaliButton.addMouseListener(new MouseAdapter() {
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
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(titleLabel);
        this.add(labelNama);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textNama);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelTanggalLahir);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textTanggalLahir);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelProdi);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(boxProdi);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(labelAngkatan);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textAngkatan);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPanel);

    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}
