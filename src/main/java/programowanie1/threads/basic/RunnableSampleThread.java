package programowanie1.threads.basic;

import static programowanie1.threads.ThreadColor.ANSI_RED;

public class RunnableSampleThread implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED+"---=== runnable sample thread ===---");
    }
}
