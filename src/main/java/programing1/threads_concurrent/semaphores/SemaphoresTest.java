package programing1.threads_concurrent.semaphores;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoresTest {
    protected static final Logger LOG = Logger.getLogger(SemaphoresTest.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Semaphore semaphore = new Semaphore(5);


        Runnable runningTask = ()->{
          boolean permit=false;
            try {
                permit=semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
                if (permit){
                    LOG.info("Semaphore given");
                    Thread.sleep(999);
                } else {
                    LOG.info("Semaphore looked");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (permit){
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10).forEach(i -> executorService.submit(runningTask));

        executorService.shutdown();




    }


}
