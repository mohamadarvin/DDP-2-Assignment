package assignments.assignment2;

import java.security.PublicKey;

// TODO
public class Member {
    private String id;
    private String name;
    private String dateOfBirth;
    private String studyProgram;
    private String angkatan;
    private long fine;
    private int point;
    private BookLoan[] bookLoans;

    public Member(String id, String name, String dateOfBirth, String studyProgram, String angkatan) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.studyProgram = studyProgram;
        this.angkatan = angkatan;
    }

    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    public long getFine() {
        
    return this.fine;
    }

    public long  setFine(Book book){
        for (int i = 0; i < (bookLoans.length -1); i++) {
            if(book == bookLoans[i].getBook()){
                this.fine = bookLoans[i].setfine(bookLoans[i].selisihHari());                
            }
        } 
    }

  

   

    public int getPoint() {
        return this.point;
    }

    public long getTotalBukuYangDipinjam() {
        if (bookLoans == null) {
            return 0;
        } else {
            return bookLoans.length;
        }
    }

    public boolean mencariBuku(String judul, String penulis) {
        if (bookLoans == null) {
            return false;
        } else {
            for (int i = 0; i < bookLoans.length; i++) {
                if (bookLoans[i].getBook().gettitle().equalsIgnoreCase(judul)
                        && bookLoans[i].getBook().getauthor().equalsIgnoreCase(penulis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pinjam(Book book, String loanDate) {
        BookLoan newBookLoan = new BookLoan(book, loanDate);
        if (bookLoans == null) {
            bookLoans = new BookLoan[1];
            bookLoans[0] = newBookLoan;
        }

        else {
            BookLoan[] newBookLoans = new BookLoan[bookLoans.length + 1];
            for (int i = 0; i < bookLoans.length; i++) {
                newBookLoans[i] = bookLoans[i];
            }
            newBookLoans[bookLoans.length] = newBookLoan;
            bookLoans = newBookLoans;
        }

        book.setStok(book.getStok()-1);


        // TODO: method untuk melakukan peminjaman oleh member
    }

    public void kembali(Book book, String returnDate) {
        BookLoan[] newBookLoans = new BookLoan[bookLoans.length - 1];
        int shifter = 0;

        

      
        for (int i = 0; i < (bookLoans.length -1); i++) {
            if(book == bookLoans[i].getBook()){
                continue;
            }
            newBookLoans[shifter] = bookLoans[i];
            shifter++;

        }
        bookLoans = newBookLoans;
        book.setStok(book.getStok()+1);
        // TODO: method untuk melakukan pengembalian oleh member
    }

    public void detail() {
        // TODO: method untuk menampilkan detail anggota
    }

    public void bayarDenda(long amount) {
        // TODO: method untuk melakukan pembayaran denda
    }

    @Override
    public String toString() {
        // TODO
        return "Member " + this.name + " berhasil ditambahkan dengan data:" + "\r\n" +
                "ID Anggota: " + this.id + "\r\n" +
                "Nama Anggota: " + this.name + "\r\n" +
                "Total point: " + this.point + "\r\n" +
                "Denda: " + this.fine + "\r\n";

    }
}
