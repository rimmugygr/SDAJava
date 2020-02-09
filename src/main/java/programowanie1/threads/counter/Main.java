package programowanie1.threads.counter;

import static programowanie1.threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread thread1 = new CountdownThread(countdown);
        CountdownThread thread2 = new CountdownThread(countdown);
        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();

    }

}

class Countdown {
    private int i;



    public void doContdown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread1":
                color = ANSI_CYAN;
                break;
            case "Thread2":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }
        synchronized (this) { // synchronizacja, całość się wykonuje bez przeszkód
            for (int i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + "i= " + i);
            }
        }
    }
}

class CountdownThread extends Thread{
    private Countdown countdown;

    public CountdownThread(Countdown countdown) {
        this.countdown = countdown;
    }

    public void run(){
        countdown.doContdown();
    }
}