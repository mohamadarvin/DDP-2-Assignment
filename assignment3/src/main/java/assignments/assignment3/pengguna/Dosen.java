package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;

import assignments.assignment3.buku.Peminjaman;

public class Dosen extends Anggota {
    // TODO: Implementasi kelas ini sesuai dengan UML Diagram (attribute, method,
    // inheritance, dll)
    private static int jumlahDosen;
    public static final int BATAS_JUMLAH_PEMINJAMAN_BUKU = 5;
    public static final long BATAS_MAKSIMAL_DENDA = 5000;

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

    @Override
    protected String generateId() {
        setJumlahDosen(getJumlahDosen() + 1);
        return String.format("DOSEN-%d", getJumlahDosen());
        // TODO Auto-generated method stub

    }

    @Override
    public String pinjam(Buku buku, String tanggalPeminjaman) {
        // TODO Auto-generated method stub

        if (buku.getStok() == 0) {
            return String.format("Buku %s oleh %s tidak tersedia", buku.getJudul(), buku.getPenulis());
        }

        if (this.getDaftarPeminjaman().size() == BATAS_JUMLAH_PEMINJAMAN_BUKU) {
            return "Jumlah buku yang sedang dipinjam sudah mencapai batas maksimal";

        } else if (this.getDenda() >= BATAS_MAKSIMAL_DENDA) {
            return "Denda lebih dari Rp5000";

        } else {
            for (int i = 0; i < this.getDaftarPeminjaman().size(); i++) {
                if (this.getDaftarPeminjaman().get(i).getBuku().getJudul().equalsIgnoreCase(buku.getJudul()) &&
                        this.getDaftarPeminjaman().get(i).getBuku().getPenulis().equalsIgnoreCase(buku.getPenulis())) {
                    return String.format("Buku %s oleh %s sedang dipinjam",
                            this.getDaftarPeminjaman().get(i).getBuku().getJudul(),
                            this.getDaftarPeminjaman().get(i).getBuku().getPenulis());

                }
            }
        }

        Peminjaman peminjaman = new Peminjaman(buku, tanggalPeminjaman, this);
        this.getDaftarPeminjaman().add(peminjaman);
        super.getRiwayatPeminjaman().add(peminjaman);
        return String.format("%s berhasil meminjam Buku %s!",
                this.getNama(),
                this.getDaftarPeminjaman().get(this.getDaftarPeminjaman().size() - 1).getBuku().getJudul());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
