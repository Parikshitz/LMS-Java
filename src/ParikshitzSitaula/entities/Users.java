package ParikshitzSitaula.entities;

public class Users {
    private int id;
    private String name;

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters...
    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return id + ". " + name ;
    }
}
