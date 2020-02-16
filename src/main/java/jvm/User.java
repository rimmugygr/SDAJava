package jvm;

/**
 * Immutable class
 */

public class User {
    private final String name;//nie ma domyœlego konstruktora bezparametrowa User()
    private final String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User replaceName(String name){
        return new User(name,this.surname);
    }
    public User replaceSurname(String surname){
        return new User(this.name,surname);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
