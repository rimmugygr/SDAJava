package basic.funkcyjne;

public class LambdaClass {
    interface PrzykladLambda1 {
        String podajPowitanie(String imie);
    }
    interface PrzykladLambda2 {
        int wynikMnozenia(int x, int y);
    }
    public static void main(String[] args) {
        PrzykladLambda1 powitanie = (imie) -> "Witaj, " + imie + "!";
        System.out.println(powitanie.podajPowitanie("Marek"));
        PrzykladLambda2 mnozenie = (x, y) -> x * y;
        System.out.println("Wynik mnozenia 10 * 5 = " + mnozenie.wynikMnozenia(10,5));
    }
}