package programing1.threads.basic;

import static programing1.threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE+"---=== main thread ===---");

        Thread otherTread = new OtherThread();
        otherTread.setName("---=== other thread ===---");
        otherTread.start();//wywołujemy start medode mino że w kalsie przładowaliśmy run

        Thread runnableSample= new Thread(new RunnableSampleThread());
        runnableSample.start();

        //watek klasy anonimowej
        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"---=== anonymous sample thread ===---");
            }
        }.start();

//        runnableSample = new Thread(
//        ()->{
//            System.out.println(ANSI_RED + "---=== runnable on lambda overridden sample thread ===---");
//        }
//
//        );

        runnableSample = new Thread(new RunnableSampleThread(){
            @Override
            public void run(){
                System.out.println(ANSI_CYAN+"---=== overridden runnable sample thread ===---");

                try {
                    otherTread.join();
                    System.out.println(ANSI_CYAN + "---=== overridden runnable sample thread ===--- Other thread terminated so i work again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN+"---=== overridden runnable sample thread ===---");
                }


            }
        });
        runnableSample.start();
        //otherTread.interrupt();




        System.out.println(ANSI_PURPLE+"---=== end main thread ===---");
    }
}
