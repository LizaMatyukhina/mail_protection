package mail_protection;

public class Person {
    public String name;
    public String dateOfBirth;

    public Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return name + ", " + dateOfBirth;
    }
}
