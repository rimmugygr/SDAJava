package tdd;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder extends PrimeTester {

    public static List<Integer> getPrimes(int numberPrimes){
        List<Integer> result= new ArrayList<>();
        if (numberPrimes<=0) return result;
        int count=0;
        int i=2;
        do{
           if(isPrimeTest(i++))
           {
               result.add(i);
               count++;
               i++;
           }
        }while (count<numberPrimes);
        return result;
    }


}
