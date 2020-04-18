package programing2.Wallet;


import org.junit.jupiter.api.*;
import programing2.Wallet.exceptions.IncorrectAmountException;
import programing2.Wallet.exceptions.IncorrectCurrencyException;
import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of Wallet class")
@Tag("All")
class WalletTest {
    Wallet walletTenPLN;
    Wallet walletEmpty;
    Cash cashTenPLN;
    Cash cashTwentyPLN;
    Cash cashTenUSD;
    Cash cashNegativeValuePLN;

    @DisplayName("Adding cash in Wallet")
    @Nested
    class AddCash{
        @BeforeEach
        void init(){
            walletTenPLN = new Wallet(new Cash(BigDecimal.TEN, Currency.PLN));
            walletEmpty = new Wallet();
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
            cashTenUSD = new Cash(BigDecimal.TEN,Currency.USD);
            cashNegativeValuePLN = new Cash(BigDecimal.TEN.negate(),Currency.PLN);

        }
        @DisplayName("should add new currency in empty wallet")
        @Test
        void addCashNewCurrencyInEmpty() throws IncorrectCurrencyException, IncorrectAmountException {
            assertAll(
                    ()->assertTrue(walletEmpty.addCash(cashTenPLN)),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.PLN),walletEmpty.getMoneyList().get(0)),
                    ()->assertEquals(1, walletEmpty.getMoneyList().size())
            );
        }
        @DisplayName("should add new currency in not empty wallet")
        @Test
        void addCashNewCurrencyInNotEmpty() throws IncorrectCurrencyException, IncorrectAmountException {
            assertAll(
                    ()->assertTrue(walletTenPLN.addCash(cashTenUSD)),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.USD),walletTenPLN.getMoneyList().get(1)),
                    ()->assertEquals(2, walletTenPLN.getMoneyList().size())
            );
        }
        @DisplayName("should sum actual and given value when is that currency")
        @Test
        void addCashAndSumValue() throws IncorrectCurrencyException, IncorrectAmountException {
            assertAll(
                    ()->assertTrue(walletTenPLN.addCash(cashTenPLN)),
                    ()->assertEquals(new Cash(BigDecimal.valueOf(20),Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(1, walletTenPLN.getMoneyList().size())
            );
        }
        @DisplayName("should not sum given negative value")
        @Test
        void addCashIncorrectAmount(){
            assertAll(
                    ()->assertFalse(walletTenPLN.addCash(cashNegativeValuePLN)),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(1, walletTenPLN.getMoneyList().size())
            );
        }
        @DisplayName("should not exceed timeout")
        @RepeatedTest(2)
        void addCashInTimeLimit(){
            boolean value = assertTimeoutPreemptively(Duration.ofMillis(100),()->walletTenPLN.addCash(cashTenPLN));
            assertTrue(value);
        }
    }



    @DisplayName("Remove cash in wallet")
    @Nested
    class RemoveCash{
        @BeforeEach
        void init(){
            walletTenPLN = new Wallet(new Cash(BigDecimal.TEN, Currency.PLN));
            walletEmpty = new Wallet();
            cashTenPLN = new Cash(BigDecimal.TEN,Currency.PLN);
            cashTwentyPLN = new Cash(BigDecimal.valueOf(20),Currency.PLN);
            cashTenUSD = new Cash(BigDecimal.TEN,Currency.USD);
            cashNegativeValuePLN = new Cash(BigDecimal.TEN.negate(),Currency.PLN);

        }
        @DisplayName("should not remove in empty wallet")
        @Test
        void removeCashNewCurrencyInEmpty() {
            assertAll(
                    ()->assertFalse(walletEmpty.removeCash(cashTenPLN)),
                    ()->assertEquals(new Cash(BigDecimal.ZERO,Currency.PLN),walletEmpty.getMoneyList().get(0)),
                    ()->assertEquals(1, walletEmpty.getMoneyList().size())
            );
            System.out.println(walletEmpty.getMoneyList().toString());
        }
        @DisplayName("should not remove new currency in not empty wallet")
        @Test
        void removeCashNewCurrencyInNotEmpty() {
            assertAll(
                    ()->assertFalse(walletTenPLN.removeCash(cashTenUSD)),
                    ()->assertEquals(2, walletTenPLN.getMoneyList().size()),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(new Cash(BigDecimal.ZERO,Currency.USD),walletTenPLN.getMoneyList().get(1))
            );
        }
        @DisplayName("should not remove in wallet when value of cash is to small")
        @Test
        void removeCashToSmallValue() {
            assertAll(
                    ()->assertFalse(walletTenPLN.removeCash(cashTwentyPLN)),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(1, walletTenPLN.getMoneyList().size())
            );
        }
        @DisplayName("should not remove given negative value")
        @Test
        void removeCashIncorrectAmount(){
            assertAll(
                    ()->assertFalse(walletTenPLN.removeCash(cashNegativeValuePLN)),
                    ()->assertEquals(new Cash(BigDecimal.TEN,Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(1, walletTenPLN.getMoneyList().size())
            );
        }
        @DisplayName("should remove when given right value")
        @Test
        void removeCashCorrectAmount(){
            assertAll(
                    ()->assertTrue(walletTenPLN.removeCash(cashTenPLN)),
                    ()->assertEquals(new Cash(BigDecimal.ZERO,Currency.PLN),walletTenPLN.getMoneyList().get(0)),
                    ()->assertEquals(1, walletTenPLN.getMoneyList().size())
            );
        }
        @DisplayName("should not exceed timeout")
        @RepeatedTest(2)
        void addCashInTimeLimit(){
            boolean value = assertTimeoutPreemptively(Duration.ofMillis(100),()->walletTenPLN.removeCash(cashTenPLN));
            assertTrue(value);
        }

    }
}
