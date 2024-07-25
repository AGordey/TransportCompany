package by.gordey.transportCompany.exceptions;

public class DuplicateProductException extends Exception {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Товар с id = %s и именем %s уже существует", id, name);
    }
}
