package assignments.assignment2;

// TODO
public class Category {
    private String name;
    private int point;

    public Category(String name, int point){
        this.name = name;
        this.point = point;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        // TODO
        return "Kategori " + this.name + " dengan " + this.point + " point berhasil ditambahkan" ;
    }
}
