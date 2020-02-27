package programing1.threads.producer_consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private BlockingQueue<String> queue;
    ResaultBuffer resaultBuffer = new ResaultBuffer();
    private String name;
    private Map<String,Integer> result= new HashMap<>(10);
    private int numOfProcessData=0;

    public Consumer(BlockingQueue<String> queue, ResaultBuffer resaultBuffer) {
        this.queue = queue;
        this.resaultBuffer = resaultBuffer;
    }

    @Override
    public void run() {
        try {
            do {
                String element=queue.poll(100, TimeUnit.MILLISECONDS);
                if(element!=null){
                    resaultBuffer.procces(element);
                    numOfProcessData++;
                    Thread.sleep(10);
                }
            } while (true);
        } catch (InterruptedException e) {
           // e.printStackTrace();
        } finally {
            System.out.println("Thread: "+Thread.currentThread().getName()+" process data: "+ numOfProcessData);
        }


    }
}
