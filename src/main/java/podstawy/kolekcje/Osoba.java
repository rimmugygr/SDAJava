package podstawy.kolekcje;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String telefon;

    Osoba (String imie, String nazwisko, String telefon){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.telefon=telefon;
    }

    @Override
    public String toString() {
        return " imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon=" + telefon ;
    }
}
