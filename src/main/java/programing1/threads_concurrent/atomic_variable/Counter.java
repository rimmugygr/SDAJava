package programing1.threads_concurrent.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getValue(){
        return counter.get();
    }

    public void increment(){
        while (true){
            int existingValue=getValue();
            if (counter.compareAndSet(existingValue,existingValue+1)) {
                return;
            }
        }
    }

}
