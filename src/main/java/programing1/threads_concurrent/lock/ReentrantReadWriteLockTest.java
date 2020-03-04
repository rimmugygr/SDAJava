package programing1.threads_concurrent.lock;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    protected static final Logger LOG = Logger.getLogger(ReentrantReadWriteLockTest.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Map<String,String> map = new HashMap<>();

        // gdy odczyt częsty a zapis zadko się zdarza
        ReadWriteLock lock = new ReentrantReadWriteLock();

        executorService.submit(()->{
            lock.writeLock().lock();
            try {
                try {
                    LOG.info("Waite.");
                    Thread.sleep(1000);
                    LOG.info("Waite..");
                    Thread.sleep(1000);
                    LOG.info("Waite...");
                    Thread.sleep(1000);
                    LOG.info("Put in map");
                    map.put("foo","bar");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable read = ()->{
            lock.readLock().lock();
            try {
                try {
                    Thread.sleep(100);
                    LOG.info(Arrays.toString(map.values().toArray()));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.readLock().unlock();
            }


        };
        executorService.submit(read);
        executorService.submit(read);
        executorService.submit(read);

        executorService.shutdown();


    }
}
