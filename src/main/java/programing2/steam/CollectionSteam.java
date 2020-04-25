package programing2.steam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionSteam {

    public static void main(String[] args) {
        //first solution on stream
        List<Integer>  integerList = generateList();
        integerList.removeIf(n -> (n%2 == 0));
        integerList = integerList.stream().
                map(i -> i*i).
                collect(Collectors.toList());
        integerList = integerList.stream().
                filter(i -> i<=701).
                collect(Collectors.toList());
        Map<Integer,String> integerStringMap = integerList.stream().
                collect(Collectors.toMap (i -> i, Object::toString));
        System.out.print(integerStringMap);
        System.out.println();
        //second solution on stream
        integerStringMap = IntStream.range(0,99)
                .filter(x -> x%2==1)
                .map(i -> i*i)
                .filter(i -> i<=701)
                .boxed()// from intstream to stream
                .collect(Collectors.toMap (i -> i, Object::toString));
        System.out.print(integerStringMap);
        System.out.println();

        //third solution on for
        integerList.clear();
        integerStringMap.clear();
        for ( int i = 0; i < 100; i++){
            integerList.add(i);
        }

        for ( int i = 0; i < integerList.size(); i++){
            if (integerList.get(i)%2==0) {
                integerList.remove(integerList.get(i));
            }
        }

        List<Integer> squaresList = new ArrayList<>();
        for (Integer integer : integerList) {
            if (integer*integer <= 701 ) {
                squaresList.add(integer*integer);
            }
        }

        for (Integer integer : squaresList) {
            integerStringMap.put(integer,String.valueOf(Math.sqrt(integer)));
        }

        System.out.print(integerStringMap);
        System.out.println();


    }


    private static List<Integer> generateList() {
        List<Integer> integerList = new ArrayList<>();
        for (int i= 0 ; i<100 ; i++){
            integerList.add(i);
        }
        return integerList;
    }
}
