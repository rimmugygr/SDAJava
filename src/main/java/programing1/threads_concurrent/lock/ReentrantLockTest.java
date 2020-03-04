package programing1.threads_concurrent.lock;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    protected static final Logger LOG = Logger.getLogger(ReentrantLockTest.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Lock lock = new ReentrantLock();

        executorService.submit(()->{
            lock.lock();
            try {
                LOG.info(((ReentrantLock)lock).isHeldByCurrentThread());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        });

        executorService.shutdown();


    }
}
