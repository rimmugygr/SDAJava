package basic.kolekcje;

public class Person {
    protected String imie;
    protected String nazwisko;
    Person(String imie,String nazwisko){
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

    @Override
    public String toString() {
        return "imie='" + imie + '\'' +
                "nazwisko='" + nazwisko + '\'';
    }
}
