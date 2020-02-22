package basic.klasyObiekty.zad1;

public class Programista extends Czlowiek {
    Programista(){
        super();
        System.out.printf("Konstruktor Programista\n");
    }
    protected void cosTamWypisz(String aaa){
        System.out.printf(aaa+"\n");
    }
}
