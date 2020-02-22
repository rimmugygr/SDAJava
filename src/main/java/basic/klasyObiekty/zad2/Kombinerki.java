package basic.klasyObiekty.zad2;

public class  Kombinerki extends Produkt{
    private static int liczbaKombinerek=0;              //liczba wszystkich kombinerek
    private static int id=1;                            //id kombinerek

    Kombinerki(String nazwa,double cena, int liczbaKombinerek){
        super(nazwa,cena,liczbaKombinerek);
        this.liczbaKombinerek+=liczbaKombinerek;
    }

    public static int getLiczbaKombinerek() {
        return liczbaKombinerek;
    }

    public  int getId() {
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
