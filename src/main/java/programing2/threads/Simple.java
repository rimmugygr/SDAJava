package programing2.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class Simple<hitCount> {
    static Logger logger = Logger.getLogger("Main");
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService service = Executors.newFixedThreadPool(2);
//
//        service.execute(() -> {
//            for(int i = 0; i < 100;i++) {
//                logger.info(String.valueOf(i));
//            }
//        });
//
//        service.execute(() -> {
//            for(int i = 100; i < 200;i++) {
//                logger.info(String.valueOf(i));
//            }
//        });
//        logger.info("aaaaaaaaaaaaaaaa");
//
//        service.shutdown();
//        //service.awaitTermination(10, TimeUnit.SECONDS);
//
//        ExecutorService es = Executors.newFixedThreadPool(2);
//
//
//        es.execute(() -> {
//            for(int i = 0; i < 10_000_000;i++) counter();
//        });
//        es.execute(() -> {
//            for(int i = 0; i < 10_000_000;i++) counter();
//        });
//
//        es.shutdown();
//        // zaczekaj max 10 sekunt do zakonczenia
//        es.awaitTermination(10, TimeUnit.SECONDS);
//        System.out.println(counter);

        ExecutorService es = Executors.newFixedThreadPool(2);

        AtomicReference<Double> aaa = new AtomicReference<>((double) 0);
        AtomicReference<Double> bbb = new AtomicReference<>((double) 0);

        es.execute(() -> {
             aaa.set(monteCarlo(1000_000));
        });
        es.execute(() -> {
            bbb.set(monteCarlo(100_000_000));
        });

        es.shutdown();
        // zaczekaj max 10 sekunt do zakonczenia
        es.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(aaa + " " + bbb);

    }
    static int hitCount = 0;
    public static double monteCarlo(long iterations) {

        for (long i = 0; i < iterations; i++) {
            double x = Math.random();
            double y = Math.random();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                counterForMonteCarlo();
            }
        }
        return 4.0 * hitCount / iterations;
    }
    synchronized private static void counterForMonteCarlo() {
        counter++;
    }









    synchronized private static void counter() {
        counter++;
    }
}
