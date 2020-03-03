package programing1.threads_concurrent.count_down_lane;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    protected static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        List<String> outputScraper= Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);//licznika
        List<Thread> workers = Stream
                .generate(()-> new Thread(new Worker(outputScraper,countDownLatch)))
                .limit(5)
                .collect(Collectors.toList());

        workers.forEach(Thread::start);
        countDownLatch.await();// dalej wykona sie jeżeli licznik zejdzie do 0;
        outputScraper.add("Reslised");
        LOG.info(outputScraper);



    }
}
