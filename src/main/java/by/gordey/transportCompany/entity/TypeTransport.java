package by.gordey.transportCompany.entity;

public class TypeTransport {
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TypeTransport() {
    }

    public TypeTransport(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeTransport{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
