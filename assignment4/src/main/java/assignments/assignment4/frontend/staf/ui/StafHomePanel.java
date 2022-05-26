package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.LoginPanel;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class StafHomePanel extends SistakaPanel {

    private JLabel titleLabel;
    private JButton tambahMahasiwaButton;
    private JButton tambahDosenButton;
    private JButton tambahKategoriButton;
    private JButton tambahBukuButton;
    private JButton hapusBukuButton;
    private JButton tigaPeringkatPertamaButton;
    private JButton detailAnggotaButton;
    private JButton daftarPeminjamanBukuButton;
    private JButton logoutButton;

    public StafHomePanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        titleLabel = new JLabel();
        tambahMahasiwaButton = new JButton(String.format("Tambah Mahasiwa"));
        tambahDosenButton = new JButton(String.format("Tambah Dosen"));
        tambahKategoriButton = new JButton(String.format("Tambah Kategori"));
        tambahBukuButton = new JButton(String.format("Tambah Buku"));
        hapusBukuButton = new JButton(String.format("Hapus Buku"));
        tigaPeringkatPertamaButton = new JButton(String.format("3 Peringkat Pertama"));
        detailAnggotaButton = new JButton(String.format("Detail Anggota"));
        daftarPeminjamanBukuButton = new JButton(String.format("Daftar Peminjaman Buku"));
        logoutButton = new JButton(String.format("Logout"));

        titleLabel.setFont(HomeGUI.fontTitle);
        tambahMahasiwaButton.setFont(HomeGUI.fontGeneral);
        tambahDosenButton.setFont(HomeGUI.fontGeneral);
        tambahKategoriButton.setFont(HomeGUI.fontGeneral);
        tambahBukuButton.setFont(HomeGUI.fontGeneral);
        hapusBukuButton.setFont(HomeGUI.fontGeneral);
        tigaPeringkatPertamaButton.setFont(HomeGUI.fontGeneral);
        detailAnggotaButton.setFont(HomeGUI.fontGeneral);
        daftarPeminjamanBukuButton.setFont(HomeGUI.fontGeneral);
        logoutButton.setFont(HomeGUI.fontGeneral);

        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        tambahMahasiwaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahMahasiwaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahMhs");

            }
        });
        tambahDosenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahDosenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahDosen");

            }
        });
        tambahKategoriButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahKategoriButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahKategori");

            }
        });
        tambahBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahBuku");

            }
        });
        hapusBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hapusBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("hapusBuku");

            }
        });
        tigaPeringkatPertamaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("peringkat");

            }
        });


        detailAnggotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("detailAnggota");

            }
        });

        daftarPeminjamanBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("daftarPeminjam");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("login");
            }
        });
        
        hapusBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tigaPeringkatPertamaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailAnggotaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        daftarPeminjamanBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new GridLayout(10, 1, 0, 10));

        this.add(titleLabel);
        this.add(tambahMahasiwaButton);
        this.add(tambahDosenButton);
        this.add(tambahKategoriButton);
        this.add(tambahBukuButton);
        this.add(hapusBukuButton);
        this.add(tigaPeringkatPertamaButton);
        this.add(detailAnggotaButton);
        this.add(daftarPeminjamanBukuButton);
        this.add(logoutButton);
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        titleLabel.setText(String.format("Selamat datang kembali %s!", main.getUser().getNama()));
    }

}
