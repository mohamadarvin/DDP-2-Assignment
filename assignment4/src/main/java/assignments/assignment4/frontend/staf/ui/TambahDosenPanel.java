package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Dosen;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahDosenPanel extends SistakaPanel {
    private JLabel titleLabel;
    private JLabel labelNama;
    private JTextField textNama;
    private JButton tambahButton;
    private JButton kembaliButton;
    private JPanel tambahDosenPanel;
    private JPanel buttonPanel;

    public TambahDosenPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        tambahDosenPanel = this;
        titleLabel = new JLabel("Tambah Dosen");
        labelNama = new JLabel("Nama");
        textNama = new JTextField();
        tambahButton = new JButton(String.format("Tambah"));
        kembaliButton = new JButton(String.format("Kembali"));
        buttonPanel = new JPanel();

        titleLabel.setFont(HomeGUI.fontTitle);
        labelNama.setFont(HomeGUI.fontGeneral);
        textNama.setFont(HomeGUI.fontGeneral);
        tambahButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNama.setAlignmentX(Component.CENTER_ALIGNMENT);

        textNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNama.setMaximumSize(new Dimension(500, 25));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(tambahButton);
        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (textNama.getText().equals("")) {
                    JOptionPane.showMessageDialog(tambahDosenPanel,
                            "Tidak dapat menambahkan Dosen silah periksa kembali input anda!");
                } else {
                    SistakaNG.addDosen(textNama.getText());
                    JOptionPane.showMessageDialog(tambahDosenPanel,
                            String.format("Behasil menambahkan dosen dengan id %s",
                                    SistakaNG.getDaftarAnggota().get(SistakaNG.getDaftarAnggota().size() - 1).getId()));
                    main.setPanel("staf");
                    textNama.setText("");

                }
            }
        });
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
                textNama.setText("");

            }
        });

        tambahButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahButton.setBackground(new Color(59,80,250));
                tambahButton.setForeground(new Color(221,224,253));
            }
            public void mouseExited(MouseEvent event) {
                tambahButton.setBackground(new Color(30,30,30));
                tambahButton.setForeground(new Color(209,209,209));
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

        this.add(labelNama);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(textNama);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(buttonPanel);
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
    }
}
