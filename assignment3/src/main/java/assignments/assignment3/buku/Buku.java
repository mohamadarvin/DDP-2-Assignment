package assignments.assignment3.buku;

import assignments.assignment3.pengguna.CanBorrow;

import java.util.ArrayList;

public class Buku {
    // TODO: Implementasi kelas ini sesuai dengan UML Diagram (attribute, method,
    // inheritance, dll)
    private String judul;
    private String penulis;
    private String penerbit;
    private int stokAwal;
    private int stok;
    private Kategori kategori;
    private ArrayList<CanBorrow> daftarPeminjam = new ArrayList<CanBorrow>();

    public Buku(String judul, String penulis, String penerbit, Kategori kategori, int stokAwal) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.kategori = kategori;
        this.stokAwal = stokAwal;
        this.setStok(stokAwal);
    }

    public String getJudul() {
        return judul;
    }

    public int getStokAwal() {
        return stokAwal;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public ArrayList<CanBorrow> getDaftarPeminjam() {
        return daftarPeminjam;
    }

    @Override
    public String toString() {
        return String.format("Judul Buku: %s%nPenulis Buku: %s%nPenerbit Buku: %s%nKategori: %s%nPoin: %d",
                this.getJudul(), this.getPenulis(), this.getPenerbit(), this.getKategori().getNama(),
                this.getKategori().getpoin());
    }

}
