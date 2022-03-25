package assignments.assignment2;

public class Book {

    // Inisialiasasi atribut
    private String title;
    private String author;
    private String publisher;
    private int stok;
    private String category;

    // Constructor
    public Book(String title, String author, String publisher, int stok, String category) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.stok = stok;
        this.category = category;
    }

    // Setter dan getter tiap method

    public String gettitle() {
        return this.title;
    }

    public String getauthor() {
        return this.author;
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getcategory() {
        return this.category;
    }

    public boolean cekStok(int stok) {
        return stok > 0;
    }

    @Override
    public String toString() {
        // TODO
        return "Buku " + this.title + " oleh " + this.author + " berhasil ditambahkan";

    }

}
