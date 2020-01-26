package podstawy.klasyObiekty.zad2;

abstract public class Produkt {

    private static int liczbaProduktow = 0;             //liczba wszystkich elementow w magazynie
    protected double cena;                              //cena elementu
    protected String nazwa;
    protected int liczba;                               //liczba sztuk elemntu

    Produkt(String nazwa, double cena, int liczbaProduktow){
        this.cena=cena;
        this.nazwa=nazwa;
        this.liczbaProduktow+=liczbaProduktow;
        this.liczba=liczbaProduktow;
    }

    abstract int getId();

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public static int getLiczbaProduktow() {
        return liczbaProduktow;
    }
}
