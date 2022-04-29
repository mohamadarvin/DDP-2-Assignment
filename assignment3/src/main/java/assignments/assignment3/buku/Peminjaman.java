package assignments.assignment3.buku;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import assignments.assignment3.pengguna.Anggota;

public class Peminjaman {
    private static final long DENDA_PER_HARI = 3000;
    private Anggota anggota;
    private Buku buku;
    private String tanggalPeminjaman;
    private String tanggalPengembalian = "-";
    private long denda = 0;

    public Peminjaman(Buku buku, String tanggalPeminjaman, Anggota anggota) {
        this.buku = buku;
        this.anggota = anggota;
        this.tanggalPeminjaman = tanggalPeminjaman;

        // Jika dipinjam buku berkurang satu
        buku.setStok(buku.getStok() - 1);

        // Peminjam Buku
        buku.getDaftarPeminjam().add(this.getAnggota());
    }

    public void kembalikanBuku(String tanggalPengembalian) {
        this.setTanggalPengembalian(tanggalPengembalian);

    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public long getDenda() {
        return denda;
    }

    public void setDenda(long denda) {
        this.denda = denda;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    // Perhitungan denda
    public long hitungDenda() {

        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(this.getTanggalPeminjaman());
            d2 = format.parse(this.getTanggalPengembalian());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Selisih waktu
        long diff = d2.getTime() - d1.getTime();
        long diffInDays = diff / (60 * 60 * 1000 * 24);

        // Jika meminjam lebih dari 7 hari
        if (diffInDays > 7) {
            return (diffInDays - 7) * DENDA_PER_HARI;
        }

        return 0;
    }

    // output kelas peminjaman
    @Override
    public String toString() {
        return String.format("%s%nTanggal Peminjaman: %s%nTanggal Pengembalian: %s%nDenda: Rp%d",
                buku.toString(), this.getTanggalPeminjaman(), this.getTanggalPengembalian(), this.getDenda());
    }

}
