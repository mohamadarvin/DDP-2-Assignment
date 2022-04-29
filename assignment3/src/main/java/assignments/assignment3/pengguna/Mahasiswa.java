package assignments.assignment3.pengguna;

import assignments.assignment3.buku.Buku;
import assignments.assignment3.buku.Peminjaman;

import java.util.HashMap;

public class Mahasiswa extends Anggota {
    public static final int BATAS_JUMLAH_PEMINJAMAN_BUKU = 3;
    public static final long BATAS_MAKSIMAL_DENDA = 5000;
    private String tanggalLahir;
    private String programStudi;
    private String angkatan;
    static HashMap<Character, Integer> charToValue = new HashMap<>(36);
    static char[] valueToChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public Mahasiswa(String nama, String tanggalLahir, String programStudi, String angkatan) {
        super(null, nama, 0, 0);
        this.tanggalLahir = tanggalLahir;
        this.programStudi = programStudi;
        this.angkatan = angkatan;
        this.setId(this.generateId()); //
        this.setDaftarPeminjaman(this.getDaftarPeminjaman());

    }

    public String getAngkatan() {
        return angkatan;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    // membuat ID Mahasiswa
    @Override
    protected String generateId() {
        // TODO Auto-generated method stub
        if (!isValidProgramStudi(this.getProgramStudi()))
            return "Input tidak valid!";

        String angkatanCode = checkAndGetAngkatanCode(this.getAngkatan());
        if (angkatanCode.length() > 2)
            return angkatanCode; // Input tidak valid!

        String tanggalLahirCode = checkAndGetTanggalLahirCode(this.getTanggalLahir());
        if (tanggalLahirCode.length() > 6)
            return tanggalLahirCode; // Input tidak valid!

        String nomorKeanggotaanStr = this.getProgramStudi() + angkatanCode + tanggalLahirCode;
        nomorKeanggotaanStr += getChecksum(nomorKeanggotaanStr); // Checksum "C"
        nomorKeanggotaanStr += getChecksum(nomorKeanggotaanStr); // Checksum "K"

        return nomorKeanggotaanStr;
    }

    // Pinjam Buku
    @Override
    public String pinjam(Buku buku, String tanggalPeminjaman) {

        // Jika stok kosong
        if (buku.getStok() == 0) {
            return String.format("Buku %s oleh %s tidak tersedia", buku.getJudul(), buku.getPenulis());
        }

        // Jika peminjaman sudah mencapai batas maksimal buku
        if (this.getDaftarPeminjaman().size() == BATAS_JUMLAH_PEMINJAMAN_BUKU) {
            return "Jumlah buku yang sedang dipinjam sudah mencapai batas maksimal";

        }

        // Jika denda mencapai batas maksimal
        else if (this.getDenda() >= BATAS_MAKSIMAL_DENDA) {
            return "Denda lebih dari Rp5000";

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

    // Output kelas Mahasiswa
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    /*
     * Method buildMapCodeToNumber adalah method untuk membuat mapping reference
     * numbers Code 93
     */
    public static void buildMapCharToValue() {
        for (int count = 0; count < valueToChar.length; count++) {
            charToValue.put(valueToChar[count], count);
        }
    }

    /*
     * Method getCharFromValue adalah method yang akan mengembalikan Code 93 dari
     * value yang diberikan
     */
    private static char getCharFromValue(int value) {
        return valueToChar[value];
    }

    /*
     * Method getValueFromChar adalah method yang akan mengembalikan value dari Code
     * 93 yang diberikan
     */
    private static int getValueFromChar(char character) {
        buildMapCharToValue();
        return charToValue.get(character);
    }

    private static boolean isValidProgramStudi(String programStudi) {
        if (programStudi.length() != 3)
            return false;

        if (programStudi.equals("SIK"))
            return true;
        if (programStudi.equals("SSI"))
            return true;
        if (programStudi.equals("MIK"))
            return true;
        if (programStudi.equals("MTI"))
            return true;
        if (programStudi.equals("DIK"))
            return true;

        return false;
    }

    private static String checkAndGetAngkatanCode(String angkatan) {
        if (angkatan.length() != 4)
            return "Input tidak valid!";
        if (Integer.parseInt(angkatan) < 2000 || Integer.parseInt(angkatan) > 2021)
            return "Input tidak valid!";
        return angkatan.substring(2);
    }

    private static boolean isNumerik(String word) {
        if (word.isEmpty())
            return false;

        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }

    private static String checkAndGetTanggalLahirCode(String tanggalLahir) {
        String[] arrOfTanggalLahir = tanggalLahir.split("/");

        // Cek apakah ada 3 input (untuk dd, mm, dan yyyy)
        if (arrOfTanggalLahir.length != 3) {
            return "Input tidak valid!";
        }

        // Cek apakah semuanya numerik
        for (String s : arrOfTanggalLahir) {
            if (!isNumerik(s)) {
                return "Input tidak valid!";
            }
        }

        // Cek apakah jumlah digitnya memenuhi aturan (2 digit untuk tanggal dan bulan,
        // serta 4 digit untuk year)
        if (arrOfTanggalLahir[0].length() != 2 || arrOfTanggalLahir[1].length() != 2
                || arrOfTanggalLahir[2].length() != 4) {
            return "Input tidak valid!";
        }

        // Cek apakah memenuhi aturan tanggal (tanggal antara 1 - 31)
        int tanggal = Integer.parseInt(arrOfTanggalLahir[0]);
        if (tanggal < 1 || tanggal > 31) {
            return "Input tidak valid!";
        }

        // Cek apakah memenuhi aturan bulan (bulan antara 1 - 12)
        int bulan = Integer.parseInt(arrOfTanggalLahir[1]);
        if (bulan < 1 || bulan > 12) {
            return "Input tidak valid!";
        }

        return arrOfTanggalLahir[0] + arrOfTanggalLahir[1] + arrOfTanggalLahir[2].substring(2);
    }

    private static char getChecksum(String data) {
        char[] arrayOfChar = data.toCharArray();

        int count = 0;
        for (int idx = 0; idx < arrayOfChar.length; idx++) {
            // Mendapatkan bobot
            int weight = arrayOfChar.length - idx;

            // Jumlah hasil kali value dan bobot setiap karakter
            count += getValueFromChar(arrayOfChar[idx]) * weight;
        }

        int checksum = count % 36;
        return getCharFromValue(checksum);
    }

    /*
     * Method checkValidity adalah method untuk mengecek validitas ID keanggotaan
     * perpustakaan
     * Parameter dan return type dari method ini tidak boleh diganti
     */
    public static boolean checkValidity(String idAnggota) {
        if (idAnggota.length() != 13 || !isUpperCaseLetterOrNumerik(idAnggota))
            return false;

        char checksumC = getChecksum(idAnggota.substring(0, 11));
        if (checksumC == idAnggota.charAt(11)) {
            char checksumK = getChecksum(idAnggota.substring(0, 12));
            if (checksumK == idAnggota.charAt(12)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isUpperCaseLetterOrNumerik(String word) {
        if (word.isEmpty())
            return false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }

            if (Character.isLetter(c)) {
                if (!Character.isUpperCase(c)) {
                    return false;
                }
            }
        }

        return true;
    }

}
