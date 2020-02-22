package basic;

public class Dieta {
    private int liczbaKalorii;
    private String nazwa;
    Dieta(String nazwa, int kalorie) {
        this.nazwa = nazwa;
        this.liczbaKalorii = kalorie;
    }
    public int podajLiczbeKalorii() {
        return this.liczbaKalorii;
    }
    public String podajNazwe() {
        return this.nazwa;
    }

}
