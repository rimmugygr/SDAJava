package programing2.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PeselNameGetNameByPesel {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
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
        System.out.println("###### Name from Pesel #######");
        //peselNameMap.forEach((x,y) -> System.out.println(x +" "+ y));
        String pesel = input.nextLine();
        System.out.println(peselNameMap.get(pesel));
    }
}
