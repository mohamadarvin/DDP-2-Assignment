package assignments.assignment3.pengguna;

public abstract class Pengguna {

    private String id;
    private String nama;

    public Pengguna(String id, String nama) {
        this.id = id;
        this.nama = nama;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    // Method untuk membentuk ID
    protected abstract String generateId();

    // Output dipakai di subclass
    public abstract String toString();
}
