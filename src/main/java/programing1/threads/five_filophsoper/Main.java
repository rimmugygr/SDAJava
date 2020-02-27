package programing1.threads.five_filophsoper;

public class Main {
    public static void main(String[] args) {

        Philosophers[] philosophers= new Philosophers[5];
        Object[] forks= new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i]= new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i+1) % forks.length];

            if (i==philosophers.length-1){  //przeciwko zakleszczeiu sie
                philosophers[i]=new Philosophers(rightFork,leftFork);
            }else {
                philosophers[i]=new Philosophers(leftFork,rightFork);
            }


            Thread thread = new Thread(philosophers[i], "Philosophe "+ (i+1));
            thread.start();
        }

    }
}
