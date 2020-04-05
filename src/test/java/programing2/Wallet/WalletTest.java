package programing2.Wallet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tdd.WorkDayHelper;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @ParameterizedTest
    @MethodSource("sourceForAdd")
    public void addTest(Wallet wallet, Wallet expected) {
        //assertEquals();
    }

    private static Stream<Arguments> sourceForAdd() {
        return Stream.of(
                Arguments.of(LocalDate.of(2020, 2,29),LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 2,1), LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 2,5), LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 3,1), LocalDate.of(2020, 3,31)),
                Arguments.of(LocalDate.of(2020, 3,31), LocalDate.of(2020, 3,31))
        );
    }




    @Test
    void removeCash() {
    }
}