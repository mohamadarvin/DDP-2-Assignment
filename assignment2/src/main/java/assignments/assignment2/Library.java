package assignments.assignment2;

import java.util.Scanner;

import javax.lang.model.element.Name;

import java.util.HashMap;

public class Library {
    private Scanner input = new Scanner(System.in);

    private Member[] members;
    private Book[] books;
    private Category[] categories;
    private static HashMap<Character, Integer> charToValue = new HashMap<>(36);
    private static char[] valueToChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void main(String[] args) {
        Library program = new Library();
        program.menu();
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
        return charToValue.get(character);
    }

    public boolean membandingkanKategori(String nama) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getName().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public boolean membandingkanJudul(String judul) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].gettitle().equalsIgnoreCase(judul)) {
                return true;
            }
        }
        return false;
    }

    public boolean membandingkanPenulis(String penulis) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getauthor().equalsIgnoreCase(penulis)) {
                return true;
            }
        }
        return false;
    }

    public boolean membandingkanId(String id) {
        for (int i = 0; i < members.length; i++) {
            if (members[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public Book membandingkanBuku(String judul, String penulis) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].gettitle().equalsIgnoreCase(judul) && books[i].getauthor().equalsIgnoreCase(penulis)) {
                return books[i];
            }
        }
        return null;
    }

    public Member mencariMember(String id) {
        for (int i = 0; i < members.length; i++) {
            if (members[i].getId().equalsIgnoreCase(id)) {
                return members[i];
            }
        }
        return null;
    }

    /*
     * Method isProgramStudi adalah method yang mereturn true
     * jika nama program studi valid
     */
    public static boolean isProgramStudi(String programStudi) {
        return (programStudi.equals("SIK")) || programStudi.equals("SSI") ||
                (programStudi.equals("MIK")) || (programStudi.equals("MTI")) ||
                (programStudi.equals("DIK"));
    }

    /*
     * Method isAngkatan adalah method yang mereturn true
     * jika tahun angkatan valid
     */
    public static boolean isAngkatan(String angkatan) {
        int intAngkatan = Integer.parseInt(angkatan);
        return intAngkatan >= 2000 && intAngkatan <= 2021;
    }

    /*
     * Method checkSumC adalah method untuk menggabungkan
     * Nilai Checksum "C" dengan ID keanggotaan
     */
    public static String checkSumC(String idAngggotaWithoutCheckSumC) {

        // Inisiasi nilai sumC
        int sumC = 0;

        // Perhitungan sum “C”
        for (int i = 0, j = idAngggotaWithoutCheckSumC.length(); i < idAngggotaWithoutCheckSumC.length(); i++, j--) {
            sumC += getValueFromChar(idAngggotaWithoutCheckSumC.charAt(i)) * j;
        }

        // ID keanggotaan dengan Checksum “C”
        return idAngggotaWithoutCheckSumC + getCharFromValue(sumC % 36);
    }

    /*
     * Method checkSumC adalah method untuk menggabungkan
     * Nilai Checksum "k" dengan ID keanggotaan
     */
    public static String checkSumK(String idAngggotaWithoutCheckSumK) {

        // Inisiasi nilai sumK
        int sumK = 0;

        // Perhitungan sum “K”
        for (int i = 0, j = idAngggotaWithoutCheckSumK.length(); i < idAngggotaWithoutCheckSumK.length(); i++, j--) {
            sumK += getValueFromChar(idAngggotaWithoutCheckSumK.charAt(i)) * j;
        }

        // ID keanggotaan dengan Checksum “K”
        return idAngggotaWithoutCheckSumK + getCharFromValue(sumK % 36);
    }

    public static String generateId(String programStudi, String angkatan, String tanggalLahir) {

        // Validasi input
        if ((isProgramStudi(programStudi)) && (isAngkatan(angkatan))
                && (tanggalLahir.length() == 10) && ((tanggalLahir.substring(2, 3)).equals("/")) &&
                ((tanggalLahir.substring(5, 6)).equals("/"))) {

            // ID keanggotaan tanpa Checksum
            String idAngggotaWithoutCheckSum = programStudi + angkatan.substring(2) + tanggalLahir.substring(0, 2) +
                    tanggalLahir.substring(3, 5) + tanggalLahir.substring(8, 10);

            // ID keanggotaan dengan Checksum “C” dan Checksum “K”
            return checkSumK(checkSumC(idAngggotaWithoutCheckSum));

        }
        return "false";

    }

    public void menu() {
        buildMapCharToValue();
        int command = 0;
        boolean hasChosenExit = false;
        System.out.println("Selamat Datang di Sistem Perpustakaan SistakaNG!");
        while (!hasChosenExit) {
            System.out.println("================ Menu Utama ================\n");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Tambah Kategori");
            System.out.println("3. Tambah Buku");
            System.out.println("4. Peminjaman");
            System.out.println("5. Pengembalian");
            System.out.println("6. Pembayaran Denda");
            System.out.println("7. Detail Anggota");
            System.out.println("8. 3 Peringkat Pertama");
            System.out.println("99. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            command = Integer.parseInt(input.nextLine());
            System.out.println();
            if (command == 1) {
                System.out.println("---------- Tambah Anggota ----------");
                System.out.print("Nama: ");
                String nama = input.nextLine();
                System.out.print("Program Studi: ");
                String programStudi = input.nextLine();
                System.out.print("Angkatan: ");
                String angkatan = input.nextLine();
                System.out.print("Tanggal Lahir: ");
                String tanggalLahir = input.nextLine();

                if (generateId(programStudi, angkatan, tanggalLahir).equals("false")) {
                    System.out.println("Tidak dapat menambahkan anggota silahkan periksa kembali input anda!");
                } else {
                    Member newMember = new Member(generateId(programStudi, angkatan, tanggalLahir), nama, tanggalLahir,
                            programStudi, angkatan);
                    if (members == null) {
                        members = new Member[1];
                        members[0] = newMember;
                        System.out.println(newMember);
                    }

                    else {
                        Member[] newMembers = new Member[members.length + 1];
                        for (int i = 0; i < members.length; i++) {
                            newMembers[i] = members[i];
                        }
                        newMembers[members.length] = newMember;
                        members = newMembers;
                        System.out.println(newMember);

                    }

                }

            } else if (command == 2) {
                System.out.println("---------- Tambah Kategori ----------");
                System.out.print("Nama kategori: ");
                String namaKategori = input.nextLine();
                System.out.print("point: ");
                int point = input.nextInt();
                input.nextLine();
                Category newCategory = new Category(namaKategori, point);

                if (categories == null) {
                    categories = new Category[1];
                    categories[0] = newCategory;
                    System.out.println(newCategory);
                }

                else if (membandingkanKategori(newCategory.getName())) {
                    System.out.println("Kategori " + newCategory.getName() + " sudah pernah ditambahkan");
                }

                else {
                    Category[] newCategories = new Category[categories.length + 1];
                    for (int i = 0; i < categories.length; i++) {
                        newCategories[i] = categories[i];
                    }
                    newCategories[categories.length] = newCategory;
                    categories = newCategories;
                    System.out.println(newCategory);

                }

            } else if (command == 3) {
                System.out.println("---------- Tambah Buku ----------");
                System.out.print("judul: ");
                String judul = input.nextLine();
                System.out.print("Penulis: ");
                String penulis = input.nextLine();
                System.out.print("Penerbit: ");
                String penerbit = input.nextLine();
                System.out.print("Kategori: ");
                String kategori = input.nextLine();
                System.out.print("Stok: ");
                int stok = input.nextInt();
                input.nextLine();

                Book newBook = new Book(judul, penulis, penerbit, stok, kategori);

                if (books == null) {
                    if (membandingkanKategori(newBook.getcategory())) {
                        if (newBook.cekStok(newBook.getStok())) {
                            books = new Book[1];
                            books[0] = newBook;
                            System.out.println(newBook);
                        } else {
                            System.out.println("Stok harus lebih dari 0");
                        }

                    } else {
                        System.out.println("Kategori " + newBook.getcategory() + "tidak ditemukan");
                    }
                    // System.out.println(newCategory);
                } else {
                    if (membandingkanJudul(newBook.gettitle()) && membandingkanPenulis(newBook.getauthor())) {

                        System.out.println("Buku " + newBook.gettitle() + " oleh " + newBook.getauthor()
                                + " sudah pernah ditambahkan");

                    } else if (!membandingkanKategori(newBook.getcategory())) {
                        System.out.println("kategori " + newBook.getcategory() + " tidak ditemukan");
                    }

                    else if (!newBook.cekStok(newBook.getStok())) {
                        System.out.println("Stok harus lebih dari 0");
                    } else {
                        Book[] newBooks = new Book[books.length + 1];
                        for (int i = 0; i < books.length; i++) {
                            newBooks[i] = books[i];
                        }
                        newBooks[books.length] = newBook;
                        books = newBooks;
                        System.out.println(newBook);

                    }

                }

            } else if (command == 4) {
                System.out.println("---------- Peminjaman Buku ----------");
                System.out.print("ID Anggota: ");
                String idAnggota = input.nextLine();
                System.out.print("Judul Buku: ");
                String judulBuku = input.nextLine();
                System.out.print("penulis Buku: ");
                String penulisBuku = input.nextLine();
                System.out.print("Tanggal Peminjaman: ");
                String tanggalPeminjaman = input.nextLine();

                if (membandingkanId(idAnggota) == false) {
                    System.out.println("Anggota dengan ID " + idAnggota + " tidak ditemukan");
                }

                else if (membandingkanBuku(judulBuku, penulisBuku) == null) {
                    System.out.println("Buku " + judulBuku + " oleh " + penulisBuku + " tidak ditemukan");

                } else if ((membandingkanBuku(judulBuku, penulisBuku).getStok() == 0)) {
                    System.out.println("Buku " + judulBuku + " oleh " + penulisBuku + " tidak tersedia");

                } else if (mencariMember(idAnggota).getTotalBukuYangDipinjam() >= 3) {
                    System.out.println("Jumlah buku yang sedang dipinjam sudah mencapai batas maksimal");
                } else if (mencariMember(idAnggota).getFine() >= 5000) {
                    System.out.println("Denda lebih dari Rp 5000");
                } else if (mencariMember(idAnggota).mencariBuku(judulBuku, penulisBuku)) {
                    System.out.println("Buku " + judulBuku + " oleh " + penulisBuku + " sedang dipinjam");
                }

                else {
                    mencariMember(idAnggota).pinjam(membandingkanBuku(judulBuku, penulisBuku), tanggalPeminjaman);
                    System.out
                            .println(mencariMember(idAnggota).getName() + " berhasil meminjam Buku " + judulBuku + "!");
                }

            } else if (command == 5) {
                System.out.println("---------- Pengembalian Buku ----------");
                System.out.print("ID Anggota: ");
                String idAnggota = input.nextLine();
                System.out.print("Judul Buku: ");
                String judulBuku = input.nextLine();
                System.out.print("penulis Buku: ");
                String penulisBuku = input.nextLine();
                System.out.print("Tanggal Pengembalian: ");
                String tanggalPengembalian = input.nextLine();

                if (membandingkanId(idAnggota) == false) {
                    System.out.println("Anggota dengan ID " + idAnggota + " tidak ditemukan");
                } else if (membandingkanBuku(judulBuku, penulisBuku) == null) {
                    System.out.println("Buku " + judulBuku + " oleh " + penulisBuku + " tidak ditemukan");
                } else if (mencariMember(idAnggota).mencariBuku(judulBuku, penulisBuku) == false) {
                    System.out.println("Buku " + judulBuku + " oleh " + penulisBuku + " tidak sedang dipinjam");

                } else {
                    mencariMember(idAnggota).kembali(membandingkanBuku(judulBuku, penulisBuku), tanggalPengembalian);
                    mencariMember(idAnggota).setFine(membandingkanBuku(judulBuku, penulisBuku));
                    System.out.println(mencariMember(idAnggota).getFine());
                }
                // TODO
            } else if (command == 6) {
                // TODO
            } else if (command == 7) {
                // TODO
            } else if (command == 8) {
                // TODO
            } else if (command == 99) {
                System.out.println("Terima kasih telah menggunakan SistakaNG!");
                hasChosenExit = true;
            } else {
                System.out.println("Menu tidak dikenal!");
            }
            System.out.println();
        }

        input.close();
    }
}
