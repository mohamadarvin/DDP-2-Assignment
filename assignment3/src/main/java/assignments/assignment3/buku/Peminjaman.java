package assignments.assignment3.buku;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import assignments.assignment3.pengguna.Anggota;

public class Peminjaman {
    // TODO: Implementasi kelas ini sesuai dengan UML Diagram (attribute, method,
    // inheritance, dll)
    private static final long DENDA_PER_HARI = 3000;
    private Anggota anggota;
    private Buku buku;
    private String tanggalPeminjaman;
    private String tanggalPengembalian;
    private long denda;

    public Peminjaman(Buku buku, String tanggalPeminjaman, Anggota anggota) {
        this.buku = buku;
        this.anggota = anggota;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = "-";
        buku.setStok(buku.getStok() - 1);
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

    public long hitungDenda() { // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(this.getTanggalPeminjaman());
            d2 = format.parse(this.getTanggalPengembalian());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffInDays = diff / (60 * 60 * 1000 * 24);

        if (diffInDays > 7) {
            return (diffInDays - 7) * DENDA_PER_HARI;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s%nTanggal Peminjaman: %s%nTanggal Pengembalian: %s%nDenda: Rp%d",
                buku.toString(), this.getTanggalPeminjaman(), this.getTanggalPengembalian(), this.getDenda());
    }

}
