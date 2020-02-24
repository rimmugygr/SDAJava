package tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTesterTest {

    @ParameterizedTest
    @ValueSource( ints={2,3,5,7,11,17,23,97,107})
    void shuoldReturTruePrimeTest(int number ) {
        assertTrue(PrimeTester.isPrimeTest(number));
    }

    @ParameterizedTest
    @ValueSource( ints={0,1,-1,2,4,10,99,1200657})
    void shuoldReturFalsePrimeTest(int number ) {
        assertFalse(PrimeTester.isPrimeTest(number));
    }

}