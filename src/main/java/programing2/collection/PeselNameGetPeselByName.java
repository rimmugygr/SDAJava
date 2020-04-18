package programing2.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PeselNameGetPeselByName {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Map<String,List<String>> better
        Map<String, String> peselNameMap = new HashMap<>();
        boolean isNotEnd = true;
        do {
            String temp[] = input.nextLine().split(" ");
            if (String.valueOf(0).equals(temp[0])) {
                isNotEnd = false;
            } else {
                peselNameMap.put(String.valueOf(temp[0]), temp[1] + " " + temp[2]);
            }
        } while (isNotEnd);
        System.out.println("###### Pesel from Name #######");
        //peselNameMap.forEach((x,y) -> System.out.println(x +" "+ y));
        String name = input.nextLine();
        //System.out.println(peselNameMap.containsValue(name));
        peselNameMap.keySet()
                .stream()
                .filter((x) -> peselNameMap.get(x).equals(name))
                .forEach(System.out::println);
    }
}

