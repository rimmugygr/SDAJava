package basic.klasyObiekty.zad1;

abstract public class Zwierzeta {
    private String rasa;
    private int wiek;
    private String plec;
    static private int liczbaZwierzat=0;


    Zwierzeta(String rasa,String plec) {
        this.rasa=rasa;
        this.plec=plec;
        this.wiek=0;
        liczbaZwierzat++;
    }

    Zwierzeta(String rasa,String plec,int wiek) {
        this.rasa=rasa;
        this.plec=plec;
        this.wiek=wiek;
        liczbaZwierzat++;
    }


    public static int getLiczbaZwierzat() {
        return liczbaZwierzat;
    }

    public int getWiek() {
        return wiek;
    }

    public String getPlec() {
        return plec;
    }

    public String getRasa() {
        return rasa;
    }

    public void setWiek(int aaa) {
        this.wiek=aaa;
    }
    abstract public void dajGlos();                          // cialo funkcji dopiero w dziedziczonych metodach
    @Override
    public String toString() {
        return String.format(" %7d %10s %10s ",this.wiek,this.plec,this.rasa);

    }
}
