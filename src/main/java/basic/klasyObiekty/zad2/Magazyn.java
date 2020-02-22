package basic.klasyObiekty.zad2;

import java.util.Arrays;

public class Magazyn {

    private Produkt[] produkt;                                          /// tablica z produktami
    private int liczbaProduktow;                                                /// pozycje w magazynie

    Magazyn(Produkt produkt,int wielkoscMagazynu){
        this.produkt=new Produkt[wielkoscMagazynu];
        this.produkt[0]=produkt;
        liczbaProduktow=1;
    }

    Magazyn(int wielkoscMagazynu){
        this.produkt=new Produkt[wielkoscMagazynu];
        liczbaProduktow=0;
    }

    void dodajProdukt(Produkt produkt){

        if(liczbaProduktow==this.produkt.length)System.out.printf("Pelny Magazyn");
        else {
            this.produkt[liczbaProduktow]=produkt;
            liczbaProduktow++;
        }
    }

    public Produkt[] getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt[] produkt) {
        this.produkt = produkt;
    }

    @Override
    public String toString() {
        return
                "produkty="+Produkt.getLiczbaProduktow()+" " + Arrays.toString(produkt) +" kombinerki=" +Kombinerki.getLiczbaKombinerek() + " wiertarka=" + Wiertarka.getLiczbaWiertarek();
    }
}
