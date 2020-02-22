package basic.klasyObiekty.zad1;

public class Pies extends Zwierzeta{

    private Kaganiec kaganiec;
    static private int liczba=0;

    Pies(String rasa, String plec, int wiek){
        super(rasa, plec, wiek);
        liczba++;

    }
    Pies(String rasa, String plec, int wiek, int rozmiarKaganca, String materialKaganca){
        super(rasa, plec, wiek);
        kaganiec=new Kaganiec(rozmiarKaganca,materialKaganca);
        liczba++;
    }
    Pies(String rasa,String plec){
        super(rasa, plec);
        liczba++;
    }

    @Override
    public void dajGlos( ) {
        System.out.printf("woowowowof\n");
    }

    public String wypiszKaganiec(){
        return kaganiec.toString();

    }

    public static int getLiczba() {
        return liczba;
    }
}





