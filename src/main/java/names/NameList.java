package names;

public class NameList {
    String name;
    String surname;
    String gender;
    String region;

    public NameList(String name, String surname, String gender, String region) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.region = region;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
