package ua.hillel.Contacts;

public enum Type {
    NUMBER("Номер"),EMAIL("Почта");

    private String name;
    Type(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
