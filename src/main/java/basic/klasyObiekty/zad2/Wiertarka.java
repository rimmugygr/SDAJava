package basic.klasyObiekty.zad2;

public class Wiertarka extends Produkt{
    private static int liczbaWiertarek=0;                       // wszystkie wiertarki
    private static int id=2;                                    // id wiertarki


    Wiertarka(String nazwa,double cena, int liczbaWiertarek){
        super(nazwa,cena,liczbaWiertarek);
        this.liczbaWiertarek+=liczbaWiertarek;
    }

    public static int getLiczbaWiertarek() {
        return liczbaWiertarek;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "["+nazwa +
                " liczba= " + liczba +
                " cena=" + cena +
                "]";
    }
}
