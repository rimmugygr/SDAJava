package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeFinderTest {

    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,2,3,4,10,33,78,100})
    void resultHasGoodSize(int number) {
        List<Integer> integerList = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            integerList.add(0);
        }
        assertEquals(PrimeFinder.getPrimes(number).size(),integerList.size());
    }

//    @ParameterizedTest
//    @ValueSource(ints = {-1,0,1,2,3,4,10})
//    void resultHasBeanSorted(int number) {
//        List<Integer> integerList = PrimeFinder.getPrimes(number);
//
//        do(integerList.)
//        assertTrue();
//
//
//    }




}