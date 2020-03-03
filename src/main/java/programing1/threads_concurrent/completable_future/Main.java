package programing1.threads_concurrent.completable_future;

import org.apache.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    protected static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello")
                .thenCompose(s ->CompletableFuture.supplyAsync(()->s + "World"));
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(()->"Hello1");
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->"Hello2");




        //pobranie zwracanej przez wartości przez completableFuture
        CompletableFuture<Void> future1 = completableFuture.thenAccept(s -> LOG.info("Computation returned :" + s));
        future1.get();
        //po zakonczeniu wywołanie kolejngo zdania
        CompletableFuture<Void> future2 = completableFuture.thenRun(() -> LOG.info("Computation returned"));
        future2.get();

        // gdy wszystkie się skonczą jest odpalany podany
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(completableFuture,completableFuture1,completableFuture2);
        combinedFuture.get();



    }
}
