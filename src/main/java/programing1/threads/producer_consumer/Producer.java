package programing1.threads.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> queue;
    private String name;
    private int numOfSendData=0;

    public Producer(BlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            while (true) {
                numOfSendData++;
                queue.put(name);
                Thread.sleep((long) (10+Math.random()*100));
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
            System.out.println("Thread: "+Thread.currentThread().getName()+" send: "+numOfSendData);
        }

    }
}
