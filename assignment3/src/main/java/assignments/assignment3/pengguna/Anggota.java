package assignments.assignment3.pengguna;

import java.security.GeneralSecurityException;

import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

import java.util.ArrayList;

public abstract class Anggota extends Pengguna implements CanBorrow, Comparable<Anggota> {

    protected long denda;
    protected int poin;

    // Peminjam aktif
    protected ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<Peminjaman>();

    // Buku yang pernah di pinjam
    protected ArrayList<Peminjaman> riwayatPeminjaman = new ArrayList<Peminjaman>();

    public Anggota(String id, String nama, int denda, int poin) {
        super(id, nama);
        this.denda = denda;
        this.poin = poin;
    }

    // Tiap tipe anggota berbedak teknis meminjam
    public abstract String pinjam(Buku buku, String tanggalPeminjaman);

    // Format ID berbeda sesuai tioe anggota
    protected abstract String generateId();

    public int getPoin() {
        return poin;
    }

    public ArrayList<Peminjaman> getRiwayatPeminjaman() {
        return riwayatPeminjaman;
    }

    public ArrayList<Peminjaman> getDaftarPeminjaman() {
        return daftarPeminjaman;
    }

    public long getDenda() {
        return denda;
    }

    public void setDenda(long denda) {
        this.denda = denda;
    }

    public void setDaftarPeminjaman(ArrayList<Peminjaman> daftarPeminjaman) {
        this.daftarPeminjaman = daftarPeminjaman;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    // Method pengembalian buku
    @Override
    public String kembali(Buku buku, String tanggalPengembalian) {
        boolean dikembalikan = false;
        for (int i = 0; i < daftarPeminjaman.size(); i++) {

            // jika sedang meminjam buku
            if (buku == this.getDaftarPeminjaman().get(i).getBuku()) {
                buku.setStok(buku.getStok() + 1);
                this.getDaftarPeminjaman().get(i).kembalikanBuku(tanggalPengembalian);

                long dendaBuku = this.getDaftarPeminjaman().get(i).hitungDenda();

                this.getRiwayatPeminjaman().get(i).setDenda(dendaBuku);
                this.setDenda(this.getDenda() + dendaBuku);
                this.getDaftarPeminjaman().remove(i);
                dikembalikan = true;
            }

            // Tanggal pengembalian dicatat
            if (buku == this.getRiwayatPeminjaman().get(i).getBuku()
                    && this.getRiwayatPeminjaman().get(i).getTanggalPeminjaman().equals("-")) {
                this.getRiwayatPeminjaman().get(i).kembalikanBuku(tanggalPengembalian);
            }
        }

        // Jika Buku dikembalikan
        if (dikembalikan == true) {

            // Perhtiungan denda anggota
            this.setPoin(this.getPoin() + buku.getKategori().getpoin());
            return String.format("Buku %s berhasil dikembalikan oleh %s dengan denda Rp%d!", buku.getJudul(),
                    this.getNama(), this.getDenda());

        }

        return String.format("Buku %s tidak sedang dipinjam oleh %s", buku.getJudul(), this.getNama());
    }

    // Detail anggota
    public void detail() {
        System.out.println(this.toString());
        System.out.println("Riwayat Peminjaman Buku:");

        // Jika belum pernah meminjam buku
        if (riwayatPeminjaman.size() == 0) {
            System.out.println("Belum pernah meminjam buku");

            // Jika pernah meminjam buku
        } else {
            for (int i = 0; i < riwayatPeminjaman.size(); i++) {

                System.out.println(String.format("----------------- %d -----------------%n%s",
                        (i + 1), riwayatPeminjaman.get(i).toString()));
            }
        }
    }

    // Method Pembayaran denda
    public String bayarDenda(long jumlahBayar) {

        // Jika tidak punya denda
        if (this.getDenda() == 0) {
            return String.format("%s tidak memiliki denda", this.getNama());

        }
        // Jika bayar tidak sampai lunas
        else if (jumlahBayar < this.getDenda()) {
            this.setDenda(this.getDenda() - jumlahBayar);
            return String.format("%s berhasil membayar denda sebesar Rp%d%nSisa denda saat ini: Rp%d", this.getNama(),
                    jumlahBayar, this.getDenda());
        }

        // Jika membayar lunas
        long jumlahKembalian = jumlahBayar - this.getDenda();
        this.setDenda(0);
        return String.format("%s berhasil membayar lunas denda%nJumlah kembalian: Rp%d", this.getNama(),
                jumlahKembalian);
    }

    // Method untuk sorting
    @Override
    public int compareTo(Anggota other) {
        // jika Poin lebih besar
        if (this.getPoin() > other.getPoin()) {
            return -1;
        }
        // Jika poin lebih kecil
        if (this.getPoin() < other.getPoin()) {
            return 1;
        }

        // jika poin sama, compare dengan leksikograf
        else {
            return this.getNama().compareTo(other.getNama());
        }
    }

    // Output kelas Anggota
    @Override
    public String toString() {
        return String.format("ID Anggota: %s%nNama Anggota: %s%nTotal Poin: %d%nDenda: Rp%d",
                this.getId(), this.getNama(), this.getPoin(), this.getDenda());
    }

}
