package assignments.assignment3;

import java.util.ArrayList;
import java.util.Collections;

import assignments.assignment3.pengguna.Pengguna;
import assignments.assignment3.pengguna.Staf;
import assignments.assignment3.pengguna.Anggota;
import assignments.assignment3.pengguna.Dosen;
import assignments.assignment3.pengguna.Mahasiswa;
import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Kategori;

import java.util.Scanner;

public class SistakaNG {
    private static Scanner input = new Scanner(System.in);

    // Array staf
    public static ArrayList<Staf> daftarStaf = new ArrayList<Staf>();

    // Array Anggota
    public static ArrayList<Anggota> daftarAnggota = new ArrayList<Anggota>();

    // Array Buku yang terdaftar
    public static ArrayList<Buku> daftarBuku = new ArrayList<Buku>();

    // Array kategoti yang terdaftar
    public static ArrayList<Kategori> daftarKategori = new ArrayList<Kategori>();

    // Pengguna yang sedang log in
    public static Pengguna penggunaLoggedIn;

    public static void main(String[] args) {
        System.out.println("Start - Register Staf...");
        registerStaf();
        System.out.println("Done - Register Staf...\n");
        menu();
        input.close();
    }

    // Method ini digunakan untuk mendaftarkan staf-staf ketika program dijalankan
    private static void registerStaf() {
        String[] listNama = new String[] { "Dek Depe", "Dek DePram", "Dek Sofita", "Winter", "Boo" };

        for (int i = 0; i < listNama.length; i++) {

            Staf staf = new Staf(listNama[i]);
            System.out.println("Berhasil menambahkan staf dengan data:");
            System.out.println(staf);
            daftarStaf.add(staf);
        }
    }

    // Method ini digunakan untuk mencetak menu utama dari SistakaNG
    public static void menu() {
        boolean hasChosenExit = false;
        System.out.println("Selamat Datang di Sistem Perpustakaan SistakaNG!");
        while (!hasChosenExit) {
            int command = 0;
            System.out.println("================ Menu Utama ================\n");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();
            if (command == 1) {
                menuLogin();
            } else if (command == 2) {
                System.out.println("Terima kasih telah menggunakan SistakaNG. Sampai jumpa di lain kesempatan!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }
    }

    // Method ini digunakan untuk mencetak menu login
    public static void menuLogin() {
        boolean isLoginSuccess = false;
        while (!isLoginSuccess) {
            System.out.println("Masukkan ID Anda untuk login ke sistem");
            System.out.print("ID: ");
            String id = input.nextLine();

            // Staf
            if (id.startsWith("STAF")) {
                for (int i = 0; i < daftarStaf.size(); i++) {
                    if (id.equals(daftarStaf.get(i).getId())) {
                        System.out.println(String.format("Halo, %s! Selamat datang di SistakaNG",
                                daftarStaf.get(i).getNama()));
                        isLoginSuccess = true;
                        penggunaLoggedIn = daftarStaf.get(i);
                    }

                }
            }

            // Dosen atau Mahasiswa
            else {
                for (int i = 0; i < daftarAnggota.size(); i++) {
                    if (id.equals(daftarAnggota.get(i).getId())) {
                        System.out.println(String.format("Halo, %s! Selamat datang di SistakaNG",
                                daftarAnggota.get(i).getNama()));
                        isLoginSuccess = true;
                        penggunaLoggedIn = daftarAnggota.get(i);
                    }
                }
            }

            // Input tidak valid
            if (isLoginSuccess == false) {
                System.out.println(String.format("Pengguna dengan ID %s tidak ditemukan", id));
            }

        }

        showMenu();
    }

    // Method ini digunakan untuk mencetak menu yang dapat diakses berdasarkan jenis
    // penggunaLoggedIn
    private static void showMenu() {
        if (penggunaLoggedIn instanceof Staf) {
            showMenuStaf();
        } else {
            showMenuAnggota();
        }
    }

    // Method ini digunakan untuk mencetak menu staf dari SistakaNG
    private static void showMenuStaf() {
        int command = 0;
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println("================ Menu Staf ================\n");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Tambah Kategori");
            System.out.println("3. Tambah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. 3 Peringkat Pertama");
            System.out.println("6. Detail Anggota");
            System.out.println("7. Daftar Peminjam Buku");
            System.out.println("99. Logout");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();

            // Tambah Anggota
            if (command == 1) {
                System.out.println("---------- Tambah Anggota ----------");
                System.out.print("Tipe Anggota: ");
                String tipeAnggota = input.nextLine();

                // Mahasiswa
                if (tipeAnggota.equals("Mahasiswa")) {
                    System.out.print("Nama: ");
                    String nama = input.nextLine();

                    System.out.print("Program Studi (SIK/SSI/MIK/MTI/DIK): ");
                    String programStudi = input.nextLine();

                    System.out.print("Angkatan: ");
                    String angkatan = input.nextLine();

                    System.out.print("Tanggal Lahir (dd/mm/yyyy): ");
                    String tanggalLahir = input.nextLine();

                    Mahasiswa mahasiswa = new Mahasiswa(nama, tanggalLahir, programStudi, angkatan);

                    // ID tidak valid
                    if (mahasiswa.getId().equals("Input tidak valid!")) {
                        System.out.println("Tidak dapat menambahkan anggota silahkan periksa kembali input anda!");
                    }

                    // Valid
                    else {
                        daftarAnggota.add(mahasiswa);
                        System.out.println(String.format("Berhasil menambahkan mahasiswa dengan data:%n%s",
                                daftarAnggota.get(daftarAnggota.size() - 1).toString()));
                    }

                }

                // Dosen
                else if (tipeAnggota.equals("Dosen")) {
                    System.out.print("Nama: ");
                    String nama = input.nextLine();
                    Dosen dosen = new Dosen(nama);
                    daftarAnggota.add(dosen);
                    System.out.println(String.format("Berhasil menambahkan dosen dengan data:%n%s", dosen.toString()));
                }

                // Tidak valid
                else {
                    System.out.println(String.format("Tipe Anggota %s tidak valid!", tipeAnggota));
                }

                // Penambahan Kategori
            } else if (command == 2) {

                System.out.println("---------- Tambah Kategori ----------");
                System.out.print("Nama Kategori: ");
                String namaKategori = input.nextLine();
                System.out.print("Poin: ");
                int poin = Integer.parseInt(input.nextLine());
                boolean lanjut = true;
                for (int i = 0; i < daftarKategori.size(); i++) {

                    // Jika sudah pernah dibuat
                    if (daftarKategori.get(i).getNama().equalsIgnoreCase(namaKategori)) {
                        System.out.println(
                                String.format("Kategori %s sudah pernah ditambahkan", daftarKategori.get(i).getNama()));
                        lanjut = false;
                        break;
                    }
                }

                // Penambahan berhasil
                if (lanjut == true) {
                    Kategori kategori = new Kategori(namaKategori, poin);
                    daftarKategori.add(kategori);
                    System.out.println(
                            String.format("Kategori %s dengan poin %d berhasil ditambahkan", namaKategori, poin));
                }

            }

            // Penambahan buku
            else if (command == 3) {

                System.out.println("---------- Tambah Buku ----------");
                System.out.print("Judul: ");
                String namaBuku = input.nextLine();
                System.out.print("Penulis: ");
                String penulis = input.nextLine();
                System.out.print("Penerbit: ");
                String penerbit = input.nextLine();
                System.out.print("Kategori: ");
                String namaKategori = input.nextLine();
                System.out.print("Stok: ");
                int stok = Integer.parseInt(input.nextLine());

                boolean lanjut = true;
                boolean lanjut1 = true;
                Kategori kategori = new Kategori(null, 0);

                while (lanjut1 == true) {
                    for (int i = 0; i < daftarKategori.size(); i++) {

                        // Kategori ada
                        if (daftarKategori.get(i).getNama().equalsIgnoreCase(namaKategori)) {
                            kategori = new Kategori(daftarKategori.get(i).getNama(), daftarKategori.get(i).getpoin());
                            lanjut1 = false;
                            break;
                        }
                    }

                    // Kategoti tidak ada
                    if (lanjut1 == true) {
                        System.out.println(String.format("Kategori %s tidak ditemukan", namaKategori));
                        lanjut1 = false;
                        lanjut = false;
                    }
                }

                // input stok tidak valid
                if (lanjut == true) {
                    if (stok <= 0) {
                        System.out.println("Stok harus lebih dari 0");
                        lanjut = false;
                    }
                }

                // Buku sudah pernah ditambahkan
                if (lanjut == true) {
                    for (int i = 0; i < daftarBuku.size(); i++) {
                        if (daftarBuku.get(i).getJudul().equalsIgnoreCase(namaBuku)
                                && daftarBuku.get(i).getPenulis().equalsIgnoreCase(penulis)) {
                            System.out.println(String.format("Buku %s oleh %s sudah pernah ditambahkan",
                                    daftarBuku.get(i).getJudul(), daftarBuku.get(i).getPenulis()));
                            lanjut = false;
                            break;
                        }
                    }
                }

                // Penambahan berhasil
                if (lanjut == true) {
                    Buku buku = new Buku(namaBuku, penulis, penerbit, kategori, stok);

                    daftarBuku.add(buku);
                    System.out.println(String.format("Buku %s oleh %s berhasil ditambahkan",
                            daftarBuku.get(daftarBuku.size() - 1).getJudul(),
                            daftarBuku.get(daftarBuku.size() - 1).getPenulis()));
                }

            }

            // Hapus Buku
            else if (command == 4) {
                System.out.println("---------- Hapus Buku ----------");
                System.out.print("Judul: ");
                String namaBuku = input.nextLine();
                System.out.print("Penulis: ");
                String penulis = input.nextLine();
                boolean lanjut = true;

                for (int i = 0; i < daftarBuku.size(); i++) {
                    if (daftarBuku.get(i).getJudul().equalsIgnoreCase(namaBuku)
                            && daftarBuku.get(i).getPenulis().equalsIgnoreCase(penulis)) {

                        // Berhasil dihapus
                        if (daftarBuku.get(i).getStok() == daftarBuku.get(i).getStokAwal()) {
                            System.out.println(String.format("Buku %s oleh %s berhasil dihapus",
                                    daftarBuku.get(i).getJudul(), daftarBuku.get(i).getPenulis()));
                            daftarBuku.remove(i);
                            lanjut = false;

                            break;

                        }

                        // Buku sedang dipinjam
                        else {
                            System.out.println(String.format(
                                    "Buku %s oleh %s tidak dapat dihapus karena sedang dipinjam", namaBuku, penulis));
                            lanjut = false;
                        }
                    }

                }

                // Buku tidak pernah ditambahkan
                if (lanjut == true) {
                    System.out.println(String.format("Buku %s oleh %s tidak ditemukan", namaBuku, penulis));

                }

            }

            // Peringkat Anggota
            else if (command == 5) {
                System.out.println("---------- Peringkat Anggota ----------");

                // Tidak ada anggota
                if (daftarAnggota.size() == 0) {
                    System.out.println("Belum ada anggota yang terdaftar pada sistem");

                }

                // Ada anggota
                else {
                    Collections.sort(daftarAnggota);
                    int count = 0;
                    for (int i = 0; i < daftarAnggota.size(); i++) {
                        if (count == 3) {
                            break;
                        }
                        System.out.println(String.format("----------------- %d -----------------%n%s", i + 1,
                                daftarAnggota.get(i).toString()));
                        count++;
                    }
                }

            }

            // Detail Anggota
            else if (command == 6) {
                System.out.println("---------- Detail Anggota ----------");
                System.out.print("ID Anggota: ");
                String idAnggota = input.nextLine();
                Boolean inputvalid = false;
                for (int i = 0; i < daftarAnggota.size(); i++) {

                    // Anggota ada
                    if (daftarAnggota.get(i).getId().equals(idAnggota)) {
                        inputvalid = true;
                        daftarAnggota.get(i).detail();

                    }
                }

                // Anggota tidak ada
                if (inputvalid == false) {
                    System.out.println(String.format("Anggota dengan ID %s tidak ditemukan", idAnggota));
                }

            }

            // Orang yang pernah meminjam buku
            else if (command == 7) {

                System.out.println("---------- Daftar Peminjam Buku ----------");
                System.out.print("Judul: ");
                String judul = input.nextLine();
                System.out.print("Penulis: ");
                String penulis = input.nextLine();
                boolean bukuAda = false;
                for (int i = 0; i < daftarBuku.size(); i++) {
                    if (daftarBuku.get(i).getJudul().equalsIgnoreCase(judul)
                            && daftarBuku.get(i).getPenulis().equalsIgnoreCase(penulis)) {
                        bukuAda = true;

                        // Buku belum pernah dipinjam
                        if (daftarBuku.get(i).getDaftarPeminjam().size() == 0) {
                            System.out.println(String.format(
                                    "%s%n---------- Daftar Peminjam ----------%nBelum ada anggota yang meminjam buku %s",
                                    daftarBuku.get(i).toString(), daftarBuku.get(i).getJudul()));
                        }

                        // Pernah dinpinjam
                        else {
                            System.out.println(daftarBuku.get(i).toString());
                            System.out.println("---------- Daftar Peminjam ----------");
                            for (int j = 0; j < daftarBuku.get(i).getDaftarPeminjam().size(); j++) {

                                System.out.println(String.format("----------------- %d -----------------%n%s", j + 1,
                                        daftarBuku.get(i).getDaftarPeminjam().get(j).toString()));
                            }
                        }
                    }
                }

                // Buku tidak pernah ditambahkan
                if (bukuAda == false) {
                    System.out.println(String.format("Buku %s oleh %s tidak ditemukan", judul, penulis));
                }

            } else if (command == 99) {
                System.out.println("Terima kasih telah menggunakan SistakaNG!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }
    }

    // Method ini digunakan untuk mencetak menu anggota dari SistakaNG
    private static void showMenuAnggota() {
        int command = 0;
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println("================ Menu Anggota ================\n");
            System.out.println("1. Peminjaman");
            System.out.println("2. Pengembalian");
            System.out.println("3. Pembayaran Denda");
            System.out.println("4. Detail Anggota");
            System.out.println("99. Logout");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();

            // Peminjaman buku
            if (command == 1) {
                System.out.println("---------- Peminjaman Buku ----------");
                System.out.print("Judul Buku: ");
                String namaBuku = input.nextLine();
                System.out.print("Penulis Buku: ");
                String penulis = input.nextLine();
                System.out.print("Tanggal Peminjaman: ");
                String tanggalPeminjaman = input.nextLine();
                boolean adaBuku = false;

                for (int i = 0; i < daftarBuku.size(); i++) {
                    if (daftarBuku.get(i).getJudul().equalsIgnoreCase(namaBuku)
                            && daftarBuku.get(i).getPenulis().equalsIgnoreCase(penulis)) {
                        adaBuku = true;

                        // Mahasiswa
                        if (penggunaLoggedIn instanceof Mahasiswa) {
                            Mahasiswa mahasiswa = (Mahasiswa) penggunaLoggedIn;
                            System.out.println(
                                    String.format("%s", mahasiswa.pinjam(daftarBuku.get(i), tanggalPeminjaman)));
                            break;
                        }

                        // Dosen
                        else {
                            Dosen dosen = (Dosen) penggunaLoggedIn;
                            System.out.println(String.format("%s", dosen.pinjam(daftarBuku.get(i), tanggalPeminjaman)));
                            break;
                        }
                    }
                }

                // Buku tidak ada
                if (adaBuku == false) {
                    System.out.println(String.format("Buku %s oleh %s tidak ditemukan", namaBuku, penulis));
                }
            }

            // Pengembalian Buku
            else if (command == 2) {

                System.out.println("---------- Pengembalian Buku ----------");
                System.out.print("Judul Buku: ");
                String namaBuku = input.nextLine();
                System.out.print("Penulis Buku: ");
                String penulis = input.nextLine();
                System.out.print("Tanggal Pengembalian: ");
                String tanggalPengembalian = input.nextLine();
                boolean adaBuku = false;

                for (int i = 0; i < daftarBuku.size(); i++) {

                    // Pengembalian berhasil
                    if (daftarBuku.get(i).getJudul().equalsIgnoreCase(namaBuku)
                            && daftarBuku.get(i).getPenulis().equalsIgnoreCase(penulis)) {
                        adaBuku = true;

                        Anggota anggota = (Anggota) penggunaLoggedIn;

                        System.out.println(anggota.kembali(daftarBuku.get(i), tanggalPengembalian));

                    }
                }

                // Buku tidak ada
                if (adaBuku == false) {
                    System.out.println(String.format("Buku %s oleh %s tidak ditemukan", namaBuku, penulis));
                }

            }

            // Pembayaran denda
            else if (command == 3) {

                System.out.println("---------- Pembayaran Denda ----------");
                System.out.print("Jumlah: ");
                long jumlah = Integer.parseInt(input.nextLine());

                Anggota anggota = (Anggota) penggunaLoggedIn;
                System.out.println(anggota.bayarDenda(jumlah));

            }

            // Detail aktivits peminjaman anggota
            else if (command == 4) {
                Anggota anggota = (Anggota) penggunaLoggedIn;
                anggota.detail();

            } else if (command == 99) {
                System.out.println("Terima kasih telah menggunakan SistakaNG!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }
    }
}
