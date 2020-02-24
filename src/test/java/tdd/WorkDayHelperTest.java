package tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WorkDayHelperTest {
    @ParameterizedTest
    @MethodSource("primes")
    public void anotherTest(LocalDate localDate, LocalDate expected) {
        assertEquals(expected, WorkDayHelper.getLastWorkDay(localDate));
    }

    private static Stream<Arguments> primes() {
        return Stream.of(
                Arguments.of(LocalDate.of(2020, 2,29),LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 2,1), LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 2,5), LocalDate.of(2020, 2,28)),
                Arguments.of(LocalDate.of(2020, 3,1), LocalDate.of(2020, 3,31)),
                Arguments.of(LocalDate.of(2020, 3,31), LocalDate.of(2020, 3,31))
        );
    }

    @ParameterizedTest
    @MethodSource("second")
    public void anotherTest2(LocalDate localDate, LocalDate expected) {
        assertEquals(expected, WorkDayHelper.getFirstWorkDay(localDate));
    }

    private static Stream<Arguments> second() {
        return Stream.of(
                Arguments.of(LocalDate.of(2020, 2,29),LocalDate.of(2020, 2,3)),
                Arguments.of(LocalDate.of(2020, 2,1), LocalDate.of(2020, 2,3)),
                Arguments.of(LocalDate.of(2020, 2,22), LocalDate.of(2020, 2,3)),
                Arguments.of(LocalDate.of(2020, 4,1), LocalDate.of(2020, 4,1)),
                Arguments.of(LocalDate.of(2020, 4,30), LocalDate.of(2020, 4,1))
        );
    }


//    @Test
//    void shuldGetFirstWorkDayInDate() {
//        LocalDate localDateInput= LocalDate.of(2020, 2,29);
//        LocalDate localDateResult= LocalDate.of(2020, 2,3);
//        assertEquals(WorkDayHelper.getFirstWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 2,1);
//        localDateResult= LocalDate.of(2020, 2,3);
//        assertEquals(WorkDayHelper.getFirstWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 2,22);
//        localDateResult= LocalDate.of(2020, 2,3);
//        assertEquals(WorkDayHelper.getFirstWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 4,1);
//        localDateResult= LocalDate.of(2020, 4,1);
//        assertEquals(WorkDayHelper.getFirstWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 4,2);
//        localDateResult= LocalDate.of(2020, 4,1);
//        assertEquals(WorkDayHelper.getFirstWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 4,30);
//        localDateResult= LocalDate.of(2020, 4,1);
//        assertEquals(WorkDayHelper.getFirstWorkDay(localDateInput)   , localDateResult);
//    }
//
//    @Test
//    void shouldGetLastWorkDayInDate() {
//        LocalDate localDateInput= LocalDate.of(2020, 2,29);
//        LocalDate localDateResult= LocalDate.of(2020, 2,28);
//        assertEquals(WorkDayHelper.getLastWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 2,1);
//        localDateResult= LocalDate.of(2020, 2,28);
//        assertEquals(WorkDayHelper.getLastWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 2,5);
//        localDateResult= LocalDate.of(2020, 2,28);
//        assertEquals(WorkDayHelper.getLastWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 3,1);
//        localDateResult= LocalDate.of(2020, 3,31);
//        assertEquals(WorkDayHelper.getLastWorkDay(localDateInput)   , localDateResult);
//        localDateInput= LocalDate.of(2020, 3,31);
//        localDateResult= LocalDate.of(2020, 3,31);
//        assertEquals(WorkDayHelper.getLastWorkDay(localDateInput)   , localDateResult);
//    }


}