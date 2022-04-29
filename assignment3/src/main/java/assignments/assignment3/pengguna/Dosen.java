package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;

import assignments.assignment3.buku.Peminjaman;

public class Dosen extends Anggota {
    private static int jumlahDosen = 0;
    public static final int BATAS_JUMLAH_PEMINJAMAN_BUKU = 5;
    public static final long BATAS_MAKSIMAL_DENDA = 10000;

    public Dosen(String nama) {
        super(null, nama, 0, 0);
        this.setId(this.generateId());

    }

    public static int getJumlahDosen() {
        return jumlahDosen;
    }

    public static void setJumlahDosen(int jumlahDosen) {
        Dosen.jumlahDosen = jumlahDosen;
    }

    // membuat ID dosen
    @Override
    protected String generateId() {
        setJumlahDosen(getJumlahDosen() + 1);
        return String.format("DOSEN-%d", getJumlahDosen());
    }

    // Method meminjam buku
    @Override
    public String pinjam(Buku buku, String tanggalPeminjaman) {

        // Jika stok buku habus
        if (buku.getStok() == 0) {
            return String.format("Buku %s oleh %s tidak tersedia", buku.getJudul(), buku.getPenulis());
        }

        // Jika peminjaman sudah mencapai batas maksimal buku
        if (this.getDaftarPeminjaman().size() == BATAS_JUMLAH_PEMINJAMAN_BUKU) {
            return "Jumlah buku yang sedang dipinjam sudah mencapai batas maksimal";

        }

        // Jika denda mencapai batas maksimal
        else if (this.getDenda() >= BATAS_MAKSIMAL_DENDA) {
            return "Denda lebih dari Rp10000";

        }

        // Jika Buku sedang dipinjam
        else {
            for (int i = 0; i < this.getDaftarPeminjaman().size(); i++) {
                if (this.getDaftarPeminjaman().get(i).getBuku().getJudul().equalsIgnoreCase(buku.getJudul()) &&
                        this.getDaftarPeminjaman().get(i).getBuku().getPenulis().equalsIgnoreCase(buku.getPenulis())) {
                    return String.format("Buku %s oleh %s sedang dipinjam",
                            this.getDaftarPeminjaman().get(i).getBuku().getJudul(),
                            this.getDaftarPeminjaman().get(i).getBuku().getPenulis());

                }
            }
        }

        // Jika syarat terpenuhi
        Peminjaman peminjaman = new Peminjaman(buku, tanggalPeminjaman, this);
        this.getDaftarPeminjaman().add(peminjaman);
        super.getRiwayatPeminjaman().add(peminjaman);
        return String.format("%s berhasil meminjam Buku %s!",
                this.getNama(),
                this.getDaftarPeminjaman().get(this.getDaftarPeminjaman().size() - 1).getBuku().getJudul());
    }

    // Output kelas dosen
    @Override
    public String toString() {
        return super.toString();
    }
}
