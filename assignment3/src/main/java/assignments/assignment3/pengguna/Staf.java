package assignments.assignment3.pengguna;

public class Staf extends Pengguna {
    // TODO: Implementasi kelas ini sesuai dengan UML Diagram (attribute, method, inheritance, dll)
    private static int jumlahStaf;

    public Staf(String nama){
        super(null,nama);
        this.setId(this.generateId());
    }

    public static int getJumlahStaf() {
        return jumlahStaf;
    }

    public static void setJumlahStaf(int jumlahStaf) {
        Staf.jumlahStaf = jumlahStaf;
    }

    @Override
    protected String generateId(){
        setJumlahStaf(getJumlahStaf()+1);
        return String.format("STAF-%d", getJumlahStaf());
    }

    @Override
    public String toString(){
        return String.format("ID Staf: %s%nNama Staf: %s", this.getId(), this.getNama());
    }
}
