package programing2.steam;

import java.util.stream.IntStream;

public class FirstNumber {
    public static void main(String[] args) {
        System.out.println(IntStream.range(201, 1200)
                        .filter(number->
                            IntStream
                                .rangeClosed(2, (int) Math.sqrt(number))
                                .noneMatch(n -> (number % n == 0)))
                        .filter(number -> (number % 10)==3)
                        .sum());
    }
}
