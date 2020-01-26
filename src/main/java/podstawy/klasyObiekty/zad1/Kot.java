package podstawy.klasyObiekty.zad1;

public class Kot extends Zwierzeta{


    Kot(String rasa, String plec, int wiek){
        super(rasa, plec, wiek);
    }
    Kot(String rasa, String plec){
        super(rasa, plec);
    }
    @Override
    public void dajGlos( ) {
        System.out.printf("miałłłłłłu\n");
    }


}
