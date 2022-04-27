package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;

public interface CanBorrow {
    // TODO: Implementasi kelas ini sesuai dengan UML Diagram (attribute, method,
    // inheritance, dll)
    public String pinjam(Buku buku, String tanggalPeminjaman);

    public String kembali(Buku buku, String tanggalPeminjaman);
}
