package podstawy.klasyObiekty.zad1;

public class Kaganiec {
    private int rozmiar;
    private String material;
    Kaganiec(int rozmiar,String material){
        this.rozmiar=rozmiar;
        this.material=material;
    }

    @Override
    public String toString() {
        return "Kaganiec{" +
                "rozmiar=" + rozmiar +
                ", material='" + material + '\'' +
                '}';
    }
}
