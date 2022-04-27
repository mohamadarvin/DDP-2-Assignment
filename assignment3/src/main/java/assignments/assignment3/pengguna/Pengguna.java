package assignments.assignment3.pengguna;

public abstract class Pengguna {
    // TODO: Implementasi kelas ini sesuai dengan UML Diagram (attribute, method, inheritance, dll)
    private String id;
    private String nama;

    public Pengguna(String id, String nama){
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

    protected abstract String generateId();
    
    
    public abstract String toString();
}
