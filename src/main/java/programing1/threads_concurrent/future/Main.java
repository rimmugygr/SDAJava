package programing1.threads_concurrent.future;

import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class Main {
    protected final static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*10);

        Future future=executorService.submit(()-> {
            LOG.info("Asynchronus task"+ Thread.currentThread().getName());
            Thread.sleep(1000);
            return "result";
        });

        while (!future.isDone()){
            LOG.info("Work, ork , work ....");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            LOG.info(future.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
