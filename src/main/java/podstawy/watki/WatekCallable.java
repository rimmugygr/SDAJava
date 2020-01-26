package podstawy.watki;

import java.util.concurrent.*;
public class WatekCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Zabieram się do pracy!");
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(5000);
            return "Praca skończona!";
        });
        while(!future.isDone()) {
            System.out.println("Pracuję..");
            Thread.sleep(1000);
        }
        String wynik = future.get();
        System.out.println(wynik);
        executorService.shutdown();
    }
}