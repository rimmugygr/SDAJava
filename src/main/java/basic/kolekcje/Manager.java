package basic.kolekcje;

public class Manager extends Person {
    Manager(String imie,String nazwisko){
        super(imie,nazwisko);
    }

    @Override
    public String toString() {
        return " szef "+super.toString();
    }
}
