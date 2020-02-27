package programing1.threads.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20);
        ResaultBuffer resaultBuffer = new ResaultBuffer();

        Thread producer1 = new Thread(new Producer(blockingQueue,"P1"));
        producer1.setName("P1");
        Thread producer2 = new Thread(new Producer(blockingQueue,"P2"));
        producer2.setName("P2");
        Thread producer3 = new Thread(new Producer(blockingQueue,"P3"));
        producer3.setName("P3");


        Thread consumer1 = new Thread(new Consumer(blockingQueue,resaultBuffer));
        consumer1.setName("C1");
        Thread consumer2 = new Thread(new Consumer(blockingQueue,resaultBuffer));
        consumer2.setName("C2");
        Thread consumer3 = new Thread(new Consumer(blockingQueue,resaultBuffer));
        consumer3.setName("C3");
        Thread consumer4 = new Thread(new Consumer(blockingQueue,resaultBuffer));
        consumer4.setName("C4");

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

        Thread.sleep(2000);

        producer1.interrupt();
        producer2.interrupt();
        producer3.interrupt();

        Thread.sleep(500);

        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();
        consumer4.interrupt();

        Thread.sleep(500);

        resaultBuffer.printResult();

    }
}
