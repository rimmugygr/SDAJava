package programing2.collection;

import java.util.*;

public class Names {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // uncial
        Set<String> stringSet = new HashSet<>();
        boolean isNotEnd=true;
        do {
            String temp = input.nextLine();
            if ("-".equals(temp)){
                isNotEnd = false;
            } else {
                stringSet.add(temp);
            }
        } while (isNotEnd);
        System.out.println("######Unical#######");
        stringSet.forEach(System.out::println);
        // sorted
        List<String> stringList = new ArrayList<>();
        isNotEnd=true;
        do {
            String temp = input.nextLine();
            if ("-".equals(temp)){
                isNotEnd = false;
            } else {
                stringList.add(temp);
            }
        } while (isNotEnd);
        stringList.sort(String::compareTo);
        System.out.println("#######Sorted######");
        stringList.forEach(System.out::println);
        // sorted and uncial
        Set<String> stringSetTree = new TreeSet<>(String::compareTo);
        isNotEnd=true;
        do {
            String temp = input.nextLine();
            if ("-".equals(temp)){
                isNotEnd = false;
            } else {
                stringSetTree.add(temp);
            }
        } while (isNotEnd);
        System.out.println("#######Sorted&Uncial######");
        stringSetTree.forEach(System.out::println);

    }
}
