package programing2.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MonteCarlo {
    static double  threadResult = 0;
    static int hitCount = 0;
    private static final int  THREAD = 5;
    private static final int ITERATIONS = 5_000_000;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(THREAD);

        for (int i = 0; i < THREAD ; i++) {
            es.execute(() -> {
                counterResult(monteCarlo(ITERATIONS));
            });
        }
        es.shutdown();
        // zaczekaj max 10 sekunt do zakonczenia
        es.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(threadResult/THREAD);
    }

    public static double monteCarlo(long iterations) {
        double localHit = 0;
        for (long i = 0; i < iterations; i++) {
            double x = Math.random();
            double y = Math.random();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                localHit++;
            }
        }
        return 4*(localHit)/iterations;
    }
    synchronized private static void counterResult(double result) {
        threadResult += result;
    }

}
