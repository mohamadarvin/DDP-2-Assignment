package assignments.assignment3.buku;

public class Kategori {
    private String nama;
    private int poin;

    public Kategori(String nama, int poin) {
        this.nama = nama;
        this.poin = poin;
    }

    public String getNama() {
        return nama;
    }

    public int getpoin() {
        return poin;
    }

    // output kelas Kategori
    @Override
    public String toString() {
        return String.format("Kategori: %s%nPoin: %d", this.getNama(), this.getpoin());
    }
}
