package podstawy.klasyObiekty.zad3;

public class Person {
    private String imie;
    private String nazwisko;


    Person(String[] dane){
        this.imie=dane[0];
        this.nazwisko=dane[1];
    }
    Person(String imie, String nazwisko){
        this.imie=imie;
        this.nazwisko=nazwisko;
    }



    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +

                '}';
    }
}
