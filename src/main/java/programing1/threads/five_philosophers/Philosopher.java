package programing1.threads.five_philosophers;

public class Philosopher implements Runnable {
    private Object leftFolk;
    private Object rightFolk;
    private int countEat;

    public Philosopher(Object leftFolk, Object rightFolk) {
        this.leftFolk = leftFolk;
        this.rightFolk = rightFolk;
        countEat=0;
    }

    private void log(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" "+action);
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true){
                log("thinking");
                synchronized (leftFolk){
                    log("take left folk");
                    synchronized (rightFolk){
                        log("take right folk;");
                        countEat++;
                        log("eat "+ countEat);
                        log("takeover right foke");
                    }
                    log("takeover left folk");
                }
            }
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
        }
    }
}
