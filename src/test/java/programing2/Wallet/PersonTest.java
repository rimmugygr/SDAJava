package programing2.Wallet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tdd.WorkDayHelper;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeAll
    void init() {
        Person personA = new Person("aaa", "aaa");
        Person personB = new Person("bbb", "bbb");
    }

    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @MethodSource("persons")
    public void iSAddingCash(LocalDate localDate, LocalDate expected) {

        assertEquals(expected, WorkDayHelper.getLastWorkDay(localDate));
    }

    private static Stream<Arguments> persons() {
        return Stream.of(
                Arguments.of(LocalDate.of(2020, 2,29),LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 2,1), LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 2,5), LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 3,1), LocalDate.of(2020, 3,31)),
                Arguments.of(LocalDate.of(2020, 3,31), LocalDate.of(2020, 3,31))
        );
    }
}