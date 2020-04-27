package programing2.steam;


import java.util.stream.IntStream;

public class FirstNumber {
    public static void main(String[] args) {
        System.out.println(IntStream.range(201, 1200)
                .filter(number -> isPrime(number))
                .filter(number -> (number % 10) == 3)
                .map(number -> number * number)
                .sum());
    }

    private static boolean isPrime(int number) {
        return IntStream
                .rangeClosed(2, (int) Math.sqrt(number))
                 .noneMatch(n -> (number % n == 0));
    }

}
