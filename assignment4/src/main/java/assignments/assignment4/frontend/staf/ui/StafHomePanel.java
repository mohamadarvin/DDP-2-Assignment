package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.frontend.HomeGUI;

import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class StafHomePanel extends SistakaPanel {

    private JLabel titleLabel;
    private JButton tambahMahasiswaButton;
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

        // set text pada label dan box
        titleLabel = new JLabel();
        tambahMahasiswaButton = new JButton(String.format("Tambah Mahasiwa"));
        tambahDosenButton = new JButton(String.format("Tambah Dosen"));
        tambahKategoriButton = new JButton(String.format("Tambah Kategori"));
        tambahBukuButton = new JButton(String.format("Tambah Buku"));
        hapusBukuButton = new JButton(String.format("Hapus Buku"));
        tigaPeringkatPertamaButton = new JButton(String.format("3 Peringkat Pertama"));
        detailAnggotaButton = new JButton(String.format("Detail Anggota"));
        daftarPeminjamanBukuButton = new JButton(String.format("Daftar Peminjaman Buku"));
        logoutButton = new JButton(String.format("Logout"));

        // Set font
        titleLabel.setFont(HomeGUI.fontTitle);
        tambahMahasiswaButton.setFont(HomeGUI.fontGeneral);
        tambahDosenButton.setFont(HomeGUI.fontGeneral);
        tambahKategoriButton.setFont(HomeGUI.fontGeneral);
        tambahBukuButton.setFont(HomeGUI.fontGeneral);
        hapusBukuButton.setFont(HomeGUI.fontGeneral);
        tigaPeringkatPertamaButton.setFont(HomeGUI.fontGeneral);
        detailAnggotaButton.setFont(HomeGUI.fontGeneral);
        daftarPeminjamanBukuButton.setFont(HomeGUI.fontGeneral);
        logoutButton.setFont(HomeGUI.fontGeneral);

        // Set alignment dan warna
        titleLabel.setForeground(new Color(0, 255, 0));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahMahasiswaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hapusBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tigaPeringkatPertamaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailAnggotaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        daftarPeminjamanBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahDosenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahKategoriButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hapusBukuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Klik tambah Mahasiswa button
        tambahMahasiswaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahMhs");

            }
        });

        // Klik tambah Dosen button
        tambahDosenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahDosen");

            }
        });

        // Klik tambah kategori button

        tambahKategoriButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahKategori");

            }
        });

        // Klik tambah buku button
        tambahBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("tambahBuku");

            }
        });

        // Klik hapus buku button
        hapusBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("hapusBuku");

            }
        });

        // Klik tiga peringkat pertam button
        tigaPeringkatPertamaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("peringkat");

            }
        });

        // Klik detail anggota button
        detailAnggotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("detailAnggota");

            }
        });

        // Klik daftar peminjaman button
        daftarPeminjamanBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("daftarPeminjam");
            }
        });

        // Klik logout button
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                main.setPanel("login");
            }
        });

        // Pengatuh Mouse pada warna button
        tambahMahasiswaButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahMahasiswaButton.setBackground(new Color(59, 80, 250));
                tambahMahasiswaButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tambahMahasiswaButton.setBackground(new Color(30, 30, 30));
                tambahMahasiswaButton.setForeground(new Color(209, 209, 209));
            }
        });

        tambahDosenButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahDosenButton.setBackground(new Color(59, 80, 250));
                tambahDosenButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tambahDosenButton.setBackground(new Color(30, 30, 30));
                tambahDosenButton.setForeground(new Color(209, 209, 209));
            }
        });

        tambahKategoriButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahKategoriButton.setBackground(new Color(59, 80, 250));
                tambahKategoriButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tambahKategoriButton.setBackground(new Color(30, 30, 30));
                tambahKategoriButton.setForeground(new Color(209, 209, 209));
            }
        });

        tambahBukuButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tambahBukuButton.setBackground(new Color(59, 80, 250));
                tambahBukuButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tambahBukuButton.setBackground(new Color(30, 30, 30));
                tambahBukuButton.setForeground(new Color(209, 209, 209));
            }
        });

        hapusBukuButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                hapusBukuButton.setBackground(new Color(59, 80, 250));
                hapusBukuButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                hapusBukuButton.setBackground(new Color(30, 30, 30));
                hapusBukuButton.setForeground(new Color(209, 209, 209));
            }
        });

        tigaPeringkatPertamaButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                tigaPeringkatPertamaButton.setBackground(new Color(59, 80, 250));
                tigaPeringkatPertamaButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                tigaPeringkatPertamaButton.setBackground(new Color(30, 30, 30));
                tigaPeringkatPertamaButton.setForeground(new Color(209, 209, 209));
            }
        });

        detailAnggotaButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                detailAnggotaButton.setBackground(new Color(59, 80, 250));
                detailAnggotaButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                detailAnggotaButton.setBackground(new Color(30, 30, 30));
                detailAnggotaButton.setForeground(new Color(209, 209, 209));
            }
        });

        daftarPeminjamanBukuButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                daftarPeminjamanBukuButton.setBackground(new Color(59, 80, 250));
                daftarPeminjamanBukuButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                daftarPeminjamanBukuButton.setBackground(new Color(30, 30, 30));
                daftarPeminjamanBukuButton.setForeground(new Color(209, 209, 209));
            }
        });

        logoutButton.addMouseListener(new MouseAdapter() {
            // Ubah warna ketika hover dan kembalikan warna setelah sudah tidak di hover
            public void mouseEntered(MouseEvent event) {
                logoutButton.setBackground(new Color(59, 80, 250));
                logoutButton.setForeground(new Color(221, 224, 253));
            }

            public void mouseExited(MouseEvent event) {
                logoutButton.setBackground(new Color(30, 30, 30));
                logoutButton.setForeground(new Color(209, 209, 209));
            }
        });

        // Formatting pada frame panel;
        this.setLayout(new GridLayout(10, 1, 0, 10));
        this.setBackground(new Color(30, 30, 30));
        this.add(titleLabel);
        this.add(tambahMahasiswaButton);
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
