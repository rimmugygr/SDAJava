package programing1.threads_concurrent.executores;

import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class Main {
    protected final static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*10);//*1 cieżkie obliczeniowe, *10 dla lżejszych watków
        LOG.info("ThreadPool");
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                LOG.info("Asynchronus task"+ Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
        Thread.sleep(100);



        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        LOG.info("ThreadPool");
        for (int i = 0; i < 5; i++) {
            executorService1.execute(()->{
                LOG.info("Asynchronus task"+ Thread.currentThread().getName());
            });
        }
        executorService1.shutdown();
        Thread.sleep(100);

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        LOG.info("SingleThread");
        for (int i = 0; i < 5; i++) {
            executorService2.execute(()->{
                LOG.info("Asynchronus task"+ Thread.currentThread().getName());
            });
        }
        executorService2.shutdown();
        Thread.sleep(100);

        ExecutorService executorService3 = Executors.newCachedThreadPool();
        LOG.info("CachedThreadPool");
        for (int i = 0; i < 5; i++) {
            executorService3.execute(()->{
                LOG.info("Asynchronus task"+ Thread.currentThread().getName());
            });
        }
        executorService3.shutdown();
        Thread.sleep(100);

        ScheduledExecutorService executorService4 = Executors.newSingleThreadScheduledExecutor();
        LOG.info("SingleThreadScheduled");
        for (int i = 0; i < 5; i++) {
            executorService4.scheduleWithFixedDelay(()-> LOG.info("Asynchronus task"+ Thread.currentThread().getName())
                    ,1,1, TimeUnit.MILLISECONDS);
        }
        executorService4.shutdown();

    }
}
