package basic.watki;

import java.util.concurrent.TimeUnit;
public class WatekRunnable {
    public static void main(String[] args) {
        ZadanieRunnable[] zadania = new ZadanieRunnable[3];
        zadania[0] = new ZadanieRunnable("Pracownik A");
        zadania[1] = new ZadanieRunnable("Pracownik B");
        zadania[2] = new ZadanieRunnable("Pracownik C");
        for (ZadanieRunnable zadanieRunnable : zadania) {
            new Thread(zadanieRunnable).start();
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (ZadanieRunnable zadanieRunnable : zadania) {
            zadanieRunnable.wylacz();
        }
    }
}