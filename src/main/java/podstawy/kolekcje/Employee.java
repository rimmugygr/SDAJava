package podstawy.kolekcje;

public class Employee extends Person {
    Employee(String imie,String nazwisko){
        super(imie,nazwisko);
    }

    @Override
    public String toString() {
        return " robol "+super.toString();
    }
}
