package programing1.threads_concurrent.count_down_lane;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        outputScraper.add("Counted dawn...");
        countDownLatch.countDown();//zmienjszenie licznika o 1
    }
}
