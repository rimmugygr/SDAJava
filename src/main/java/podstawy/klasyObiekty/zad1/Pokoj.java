package podstawy.klasyObiekty.zad1;

public class Pokoj {
    private double szerokosc;
    private double wysokosc;
    private double dlugosc;
    Pokoj(double szerokosc, double wysokosc, double dlugosc){
        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;
        this.dlugosc=dlugosc;
    }
    Pokoj(double szerokosc, double dlugosc){
        this.szerokosc=szerokosc;
        this.wysokosc=2.4;
        this.dlugosc=dlugosc;
    }



    public double objetosc(){
        return this.dlugosc*this.wysokosc*this.szerokosc;
    }

    public double pole(){
        return 2*szerokosc*wysokosc+2*wysokosc*dlugosc+2*dlugosc*szerokosc;
    }

    @Override
    public String toString() {
        return "Pokoj{" +
                "szerokosc=" + szerokosc +
                ", wysokosc=" + wysokosc +
                ", dlugosc=" + dlugosc +
                '}';
    }

    public void wyswietlObjetosc(){
        System.out.printf("objetosc %12.3f\n",objetosc());
    }

    public void wyswietlPole(){
        System.out.printf("pole     %12.3f\n",pole());
    }

}
