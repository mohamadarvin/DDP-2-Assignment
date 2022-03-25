package assignments.assignment2;

public class Category {

    // Inisialiasasi atribut
    private String name;
    private int point;

    // Constructor
    public Category(String name, int point) {
        this.name = name;
        this.point = point;
    }

    // Getter Nama
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        // TODO
        return "Kategori " + this.name + " dengan " + this.point + " point berhasil ditambahkan";
    }
}
