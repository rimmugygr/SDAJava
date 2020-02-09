package programowanie1.threads.basic;

import static programowanie1.threads.ThreadColor.ANSI_BLUE;

public class OtherThread extends Thread{

    @Override
        public void run() {// run nadpisujemy
        System.out.println(ANSI_BLUE + currentThread().getName());

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "---=== other thread ===--- :somebody woke me up");
        }
        System.out.println(ANSI_BLUE + "---=== other thread ===--- :enought sleeping, back to work");
    }
}
