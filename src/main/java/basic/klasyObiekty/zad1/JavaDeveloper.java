package basic.klasyObiekty.zad1;

public class JavaDeveloper extends Programista{
    JavaDeveloper(){
        super();
        System.out.printf("Kostruktor JavaDeveloper\n");
    }
    public void cosTamWypisz(String aaaa, String bbbbb){
        System.out.printf(aaaa+" "+bbbbb+"\n");
    }
}
