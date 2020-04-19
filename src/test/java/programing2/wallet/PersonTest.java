package programing2.wallet;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of Person class")
@Tag("Wallet")
class PersonTest {
    Person personA;
    Person personB;

    Cash cashZeroPln;
    Cash cash20Pln;
    Cash cash5Pln;
    Cash cashTeenEuro;
    Cash cashMinusEuro;

    @DisplayName("is adding money")
    @ParameterizedTest
    @MethodSource("personIsAddMoney")
    public void iSAddingCash(boolean expected, Person target, Cash cash) {
        assertEquals(expected, target.addMoney(cash));
    }

    private static Stream<Arguments> personIsAddMoney() {
        Person personA = new Person("aaa", "aaa");
        Cash cashZeroPln = new Cash(BigDecimal.ZERO,Currency.PLN);
        Cash cashTeenEuro = new Cash(BigDecimal.TEN,Currency.EURO);
        Cash cashMinusEuro = new Cash(BigDecimal.TEN.negate(),Currency.EURO);

        return Stream.of(
                Arguments.of(true, personA, cashZeroPln ),
                Arguments.of(true, personA, cashTeenEuro),
                Arguments.of(false, personA, cashMinusEuro)
        );
    }

    @DisplayName("is removing money")
    @ParameterizedTest
    @MethodSource("personIsRemoveMoney")
    public void iSRemovedCash(boolean expected, Person target, Cash cash) {
        assertEquals(expected, target.removeMoney(cash));
    }

    private static Stream<Arguments> personIsRemoveMoney() {
        List<Cash> cashList = new ArrayList<>();
        cashList.add(new Cash(BigDecimal.TEN,Currency.PLN));
        cashList.add(new Cash(BigDecimal.TEN,Currency.EURO));
        Wallet wallet = new Wallet(cashList);
        Person personA = new Person("aaa", "aaa", wallet);

        Cash cashZeroPln = new Cash(BigDecimal.ZERO,Currency.PLN);
        Cash cash20Pln = new Cash(BigDecimal.valueOf(20),Currency.PLN);
        Cash cash5Pln = new Cash(BigDecimal.valueOf(5),Currency.PLN);
        Cash cashTeenEuro = new Cash(BigDecimal.TEN,Currency.EURO);
        Cash cashMinusEuro = new Cash(BigDecimal.TEN.negate(),Currency.EURO);

        return Stream.of(
                Arguments.of(true, personA, cashZeroPln),
                Arguments.of(true, personA, cashTeenEuro),
                Arguments.of(false, personA, cashMinusEuro),
                Arguments.of(false, personA, cash20Pln),
                Arguments.of(true, personA, cash5Pln)
        );
    }




    @DisplayName("Is transaction work")
    @Nested
    class TransactionMoney {
        @BeforeEach
        void init() {
            List<Cash> cashListA = new ArrayList<>();
            cashListA.add(new Cash(BigDecimal.TEN,Currency.PLN));
            cashListA.add(new Cash(BigDecimal.valueOf(20),Currency.EURO));
            Wallet walletA = new Wallet(cashListA);
            personA = new Person("aaa", "aaa", walletA);

            List<Cash> cashListB = new ArrayList<>();
            cashListB.add(new Cash(BigDecimal.ZERO,Currency.PLN));
            Wallet walletB = new Wallet(cashListB);
            personB = new Person("bbb", "bbb", walletB);

            cashZeroPln = new Cash(BigDecimal.ZERO,Currency.PLN);
            cash20Pln = new Cash(BigDecimal.valueOf(20),Currency.PLN);
            cash5Pln = new Cash(BigDecimal.valueOf(5),Currency.PLN);
            cashTeenEuro = new Cash(BigDecimal.TEN,Currency.EURO);
            cashMinusEuro = new Cash(BigDecimal.TEN.negate(),Currency.EURO);
        }

        @DisplayName("should transfer money")
        @Test
        void isMovingMoney() {
            System.out.println(cashTeenEuro);
            assertAll(
                    () -> assertTrue(personA.giveCashTo(personB,cashTeenEuro)),
                    () -> assertEquals(new Cash(BigDecimal.TEN, Currency.EURO), personA.getWallet().getMoneyList().get(1)),
                    () -> assertEquals(new Cash(BigDecimal.TEN, Currency.EURO), personB.getWallet().getMoneyList().get(1)),
                    () -> assertEquals(2, personB.getWallet().getMoneyList().size()),
                    () -> assertEquals(2, personA.getWallet().getMoneyList().size())
            );
        }

        @DisplayName("should not transfer money when source have not enough money")
        @Test
        void isNotMovingMoneyWhenNotEnough() {
            System.out.println(cashTeenEuro);
            assertAll(
                    () -> assertFalse(personB.giveCashTo(personA,cashTeenEuro)),
                    () -> assertEquals(new Cash(BigDecimal.valueOf(20), Currency.EURO), personA.getWallet().getMoneyList().get(1)),
                    () -> assertEquals(new Cash(BigDecimal.ZERO, Currency.EURO), personB.getWallet().getMoneyList().get(1)),
                    () -> assertEquals(2, personB.getWallet().getMoneyList().size()),
                    () -> assertEquals(2, personA.getWallet().getMoneyList().size())
            );
        }

    }
}
