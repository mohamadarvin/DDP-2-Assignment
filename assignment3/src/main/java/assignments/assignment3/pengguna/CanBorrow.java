package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;

public interface CanBorrow {
    // Method peminjaman buku
    public abstract String pinjam(Buku buku, String tanggalPeminjaman);

    // Method pengembalian buku
    public abstract String kembali(Buku buku, String tanggalPeminjaman);
}
