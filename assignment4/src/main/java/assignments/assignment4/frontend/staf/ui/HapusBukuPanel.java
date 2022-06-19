package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class HapusBukuPanel extends SistakaPanel {
    private JPanel hapusBukuPanel;
    private JLabel titleLabel;
    private JLabel LabelBuku;
    private JComboBox<String> boxBuku;
    private JButton hapusButton;
    private JButton kembaliButton;
    private JPanel buttonPanel;
    private String[] listJudulBuku;
    private String[] listPenulisBuku;

    public HapusBukuPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang

        // Set text pada label dan panel
        hapusBukuPanel = this;
        titleLabel = new JLabel("Hapus Buku");
        LabelBuku = new JLabel("Buku");
        boxBuku = new JComboBox<String>();
        hapusButton = new JButton(String.format("hapus"));
        kembaliButton = new JButton(String.format("Kembali"));
        buttonPanel = new JPanel();

        // set font
        titleLabel.setFont(HomeGUI.fontTitle);
        LabelBuku.setFont(HomeGUI.fontGeneral);
        boxBuku.setFont(HomeGUI.fontGeneral);
        hapusButton.setFont(HomeGUI.fontGeneral);
        kembaliButton.setFont(HomeGUI.fontGeneral);

        // Alignment dan set warna
        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelBuku.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelBuku.setForeground(new Color(0, 255, 0));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(hapusButton);
        boxBuku.setAlignmentX(Component.CENTER_ALIGNMENT);

        // klik hapus button
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (boxBuku.getItemCount() > 0) {
                    String[] splitBoxBuku = boxBuku.getSelectedItem().toString().split(" oleh ", 2);
                    String judulBuku = splitBoxBuku[0];
                    String penulisBuku = splitBoxBuku[1];
                    Buku selectedBoxFindBuku = SistakaNG.findBuku(judulBuku, penulisBuku);
                    int stokBukuSekarang = selectedBoxFindBuku.getStok();

                    // Buku sedang dipinjam
                    if (stokBukuSekarang != selectedBoxFindBuku.getStokAwal()) {
                        JOptionPane.showMessageDialog(hapusBukuPanel,
                                String.format("Buku %s oleh %s tidak dapat dihapus karena sedang dipinjam", judulBuku,
                                        penulisBuku),
                                "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                    // Berhasil dihapus
                    else {
                        SistakaNG.deleteBuku(selectedBoxFindBuku);
                        JOptionPane.showMessageDialog(hapusBukuPanel,
                                String.format("Buku %s oleh %s berhasil dihapus,", judulBuku, penulisBuku));
                        main.setPanel("staf");
                    }
                }

            }
        });

        // Layout button panel
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(kembaliButton);

        // Klik kembali button
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("staf");
            }
        });

        // Klik Hapus button
        hapusButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                hapusButton.setBackground(new Color(59, 80, 250));
                hapusButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                hapusButton.setBackground(new Color(30, 30, 30));
                hapusButton.setForeground(new Color(209, 209, 209));
            }
        });

        // Klik kembali button
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

        // formatting frame panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(30, 30, 30));
        this.add(Box.createRigidArea(new Dimension(0, 300)));
        this.add(titleLabel);
        this.add(LabelBuku);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(boxBuku);
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
