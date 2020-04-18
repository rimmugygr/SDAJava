package programing2.wallet;

import org.junit.jupiter.api.*;
import programing2.wallet.exceptions.IncorrectCurrencyException;
import programing2.wallet.exceptions.IncorrectAmountException;
import programing2.wallet.exceptions.NoEnoughMoneyException;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of Cash class")
@Tag("All")
class CashTest {
    private Cash cashZeroPLN;
    private Cash cashTenPLN;
    private Cash cashThirtyPLN;
    private Cash cashNegativePLN;
    private Cash cashZeroUSD;

    @DisplayName("Adding Cash //addCash method")
    @Nested
    class AddCash{
        @BeforeEach
        void initEach() {
            cashZeroPLN = new Cash(BigDecimal.ZERO , Currency.PLN);
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
            cashThirtyPLN = new Cash((double) 30,Currency.PLN);
            cashNegativePLN = new Cash((double) -100, Currency.PLN);
            cashZeroUSD = new Cash(BigDecimal.ZERO, Currency.USD);
        }
        @DisplayName("add zero value")
        @Test
        void isAddCashAmountZeroTest() throws IncorrectCurrencyException, IncorrectAmountException {
            cashTenPLN.addMoney(cashZeroPLN);
            assertEquals(BigDecimal.TEN, cashTenPLN.getAmount());
        }
        @DisplayName("add some value")
        @Test
        void isAddCashAmountSomeValueTest() throws IncorrectCurrencyException, IncorrectAmountException {
            cashThirtyPLN.addMoney(cashTenPLN);
            assertEquals(BigDecimal.valueOf(40), cashThirtyPLN.getAmount());
        }
        @DisplayName("throw exception at wrong currency")
        @Test
        void isAddCashThrowIncorrectCurrencyException(){
            assertThrows(IncorrectCurrencyException.class,()->cashZeroUSD.addMoney(cashTenPLN));
        }
        @DisplayName("throw exception at wrong amount")
        @Test
        void isAddCashThrowIncorrectAmountException(){
            assertThrows(IncorrectAmountException.class,()->cashTenPLN.addMoney(cashNegativePLN));
        }
    }


    @DisplayName("Remove Cash //removeCash method")
    @Nested
    class RemoveCash{
        @BeforeEach
        void initEach() {
            cashZeroPLN = new Cash(BigDecimal.ZERO , Currency.PLN);
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
            cashThirtyPLN = new Cash((double) 30,Currency.PLN);
            cashNegativePLN = new Cash((double) -100, Currency.PLN);
            cashZeroUSD = new Cash(BigDecimal.ZERO, Currency.USD);
        }
        @DisplayName("zero value")
        @Test
        void isRemoveCashAmountZeroTest() throws IncorrectCurrencyException, IncorrectAmountException, NoEnoughMoneyException {
            cashTenPLN.removeMoney(cashZeroPLN);
            assertEquals(BigDecimal.TEN, cashTenPLN.getAmount());
        }
        @DisplayName("some value")
        @Test
        void isRemoveCashAmountSomeValueTest() throws IncorrectCurrencyException, IncorrectAmountException, NoEnoughMoneyException {
            cashThirtyPLN.removeMoney(cashTenPLN);
            assertEquals(BigDecimal.valueOf(20), cashThirtyPLN.getAmount());
        }
        @DisplayName("throw exception at wrong currency")
        @Test
        void isRemoveCashThrowIncorrectCurrencyException(){
            assertThrows(IncorrectCurrencyException.class,()->cashTenPLN.removeMoney(cashZeroUSD));
        }
        @DisplayName("throw exception at wrong amount")
        @Test
        void isRemoveCashThrowIncorrectAmountException(){
            assertThrows(IncorrectAmountException.class,()->cashTenPLN.removeMoney(cashNegativePLN));
        }
        @DisplayName("throw exception at no enough amount")
        @Test
        void isRemoveCashThrowNoEnoughMoneyException(){
            assertThrows(NoEnoughMoneyException.class,()->cashTenPLN.removeMoney(cashThirtyPLN));
        }
    }


    @DisplayName("Checking that is the same currency //isTheSameCurrency method")
    @Nested
    class CheckCurrency{
        @BeforeEach
        void initEach() {
            cashZeroPLN = new Cash(BigDecimal.ZERO , Currency.PLN);
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
            cashZeroUSD = new Cash(BigDecimal.ZERO, Currency.USD);
        }
        @DisplayName("for true")
        @Test
        void checkCurrencyForTrue() {
            assertTrue(cashTenPLN.isTheSameCurrency(cashZeroPLN));
        }
        @DisplayName("for false")
        @Test
        void checkCurrencyForFalse() {
            assertFalse(cashZeroUSD.isTheSameCurrency(cashTenPLN));
        }
    }



    @DisplayName("Checking that is EnoughAmount //isEnoughAmount method")
    @Nested
    class EnoughAmount {
        @BeforeEach
        void initEach() {
            cashZeroPLN = new Cash(BigDecimal.ZERO , Currency.PLN);
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
            cashThirtyPLN = new Cash((double) 30,Currency.PLN);
        }
        @DisplayName("for zero amount")
        @Test
        void isEnoughAmountTrueForZero() {
            assertTrue(cashTenPLN.isEnoughAmount(cashTenPLN));
        }
        @DisplayName("with smallest amount")
        @Test
        void isEnoughAmountTrueForSomeValue() {
            assertTrue(cashThirtyPLN.isEnoughAmount(cashTenPLN));
        }
        @DisplayName("with bigger amount")
        @Test
        void isEnoughAmountFalse() {
            assertFalse(cashTenPLN.isEnoughAmount(cashThirtyPLN));
        }
    }

    @DisplayName("Checking that is zero in amount //isZeroAmount method")
    @Nested
    class ZeroAmount{
        @BeforeEach
        void initEach() {
            cashZeroPLN = new Cash(BigDecimal.ZERO , Currency.PLN);
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
        }
        @DisplayName("for zero value")
        @Test
        void isZeroAmountTrue() {
            assertTrue(cashZeroPLN.isZeroAmount());
        }
        @DisplayName("for positive value")
        @Test
        void isZeroAmountFalse() {
            assertFalse(cashTenPLN.isZeroAmount());
        }
    }

}
