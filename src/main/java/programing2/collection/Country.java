package programing2.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Country {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> countryMap = new HashMap<>();
        // druga odwrotna mapa
        boolean isNotEnd = true;
        do {
            String temp[] = input.nextLine().split(" ");
            System.out.println(Arrays.toString(temp));
            if (("-").equals(temp[0])) {
                isNotEnd = false;
            } else {
                countryMap.put(temp[0], temp[1]);
            }
        } while (isNotEnd);
        //countryMap.forEach((x,y) -> System.out.println(x +" "+ y));

        System.out.println("###### Symbol from Name #######");
        String countryName = input.nextLine();
        System.out.println(countryMap.get(countryName));

        // druga odwrotna mapa
        System.out.println("###### Name from Symbol #######");
        String countrySymbol = input.nextLine();
        countryMap.keySet()
                .stream()
                .filter((x) -> countryMap.get(x).equals(countrySymbol))
                .forEach(System.out::println);
    }
}
