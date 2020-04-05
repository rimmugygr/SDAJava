package programing2.Wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programing2.Wallet.exceptions.IncorrectCurrencyException;
import programing2.Wallet.exceptions.IncorretAmountExeption;
import programing2.Wallet.exceptions.NoEnoughMoneyException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {
    private Cash cash0;
    private Cash cash1;
    private Cash cash2;
    private Cash cash3;
    private Cash cashTemp;
    private Cash cashUSD;
    private Cash cashEURO;
    private Exception IncorrectCurrencyException;

//    @BeforeAll
//    static void initAll() {
//        cash0 = new Cash(Currency.PLN);
//        cash1 = new Cash((double) 10,Currency.PLN);
//        cash2 = new Cash((double) 20,Currency.PLN);
//        cash3 = new Cash((double) 30,Currency.PLN);
//        cashTemp = new Cash(Currency.PLN);
//    }
//    @BeforeEach
//    void initEach() {
//        cash0 = new Cash(BigDecimal.ZERO , Currency.PLN);
//        cash1 = new Cash(BigDecimal.TEN,Currency.PLN);
//        cash2 = new Cash((double) 20,Currency.PLN);
//        cash3 = new Cash((double) 30,Currency.PLN);
//        cashTemp = new Cash(Currency.PLN);
//        cashUSD = new Cash(BigDecimal.ZERO, Currency.USD);
//        cashEURO = new Cash(BigDecimal.valueOf(10),Currency.EURO);
//    }

    @Test
    void isAddCashAmountTest() throws IncorrectCurrencyException, IncorretAmountExeption {
        cash0 = new Cash(BigDecimal.ZERO, Currency.PLN);
        cashTemp = new Cash(BigDecimal.ZERO, Currency.PLN);
        cash0.addCash(cashTemp);
        assertEquals(BigDecimal.ZERO, cash0.getAmount());

        cash1 = new Cash(BigDecimal.ZERO, Currency.PLN);
        cashTemp = new Cash(BigDecimal.TEN, Currency.PLN);
        cash1.addCash(cashTemp);
        assertEquals(BigDecimal.TEN,cash1.getAmount());

        cash2 = new Cash((double) 50, Currency.USD);
        cashTemp = new Cash((double) 100, Currency.USD);
        cash2.addCash(cashTemp);
        assertEquals(BigDecimal.valueOf(150),cash2.getAmount());
    }

    @Test
    void isAddCashExceptionTest()  {
        cash0 = new Cash(BigDecimal.ZERO, Currency.PLN);
        cashTemp = new Cash(BigDecimal.ZERO, Currency.USD);
        assertThrows(IncorrectCurrencyException, cash0.addCash(cashTemp));


        cash1 = new Cash(BigDecimal.ZERO, Currency.PLN);
        cashTemp = new Cash(BigDecimal.TEN, Currency.PLN);
        cash1.addCash(cashTemp);
        assertEquals(BigDecimal.TEN,cash1.getAmount());

        cash2 = new Cash((double) 50, Currency.USD);
        cashTemp = new Cash((double) 100, Currency.USD);
        cash2.addCash(cashTemp);
        assertEquals(BigDecimal.valueOf(150),cash2.getAmount());
    }




    @Test
    void isRemoveCash() throws IncorrectCurrencyException, NoEnoughMoneyException, IncorretAmountExeption {
        cash0.removeCash(cashTemp);
        assertEquals(cash0.getAmount(),cash0.getAmount());
        cash3.removeCash(cash2);
        assertEquals(cash3.getAmount(),cash1.getAmount());
        cash2.removeCash(cash1);
        assertEquals(cash2.getAmount(),cash1.getAmount());
    }

    @Test
    void isCheckCurrency() {
        assertTrue(cashTemp.isSameCurrency(cash0));
        assertTrue(cashUSD.isSameCurrency(new Cash(Currency.USD)));

        assertFalse(cashUSD.isSameCurrency(cashEURO));
        assertFalse(cashEURO.isSameCurrency(cashTemp));
    }


    @Test
    void isEnoughAmount() {
        assertTrue(cash0.isEnoughAmount(cashTemp));
        assertTrue(cash1.isEnoughAmount(cashTemp));
        assertTrue(cash2.isEnoughAmount(cash1));
        assertTrue(cash2.isEnoughAmount(cash2));

        assertFalse(cash1.isEnoughAmount(cash3));
        assertFalse(cash0.isEnoughAmount(cash1));
    }

    @Test
    void isZeroAmount() {
        assertTrue(cash0.isZeroAmount());
        assertTrue(cashTemp.isZeroAmount());

        assertFalse(cash1.isZeroAmount());
        assertFalse(cashEURO.isZeroAmount());
    }

    @Test
    void setAmountToZero() {
        cash0.setAmountToZero();
        assertEquals(cash0.getAmount(),cashTemp.getAmount());
        cash3.setAmountToZero();
        assertEquals(cash3.getAmount(),cashTemp.getAmount());
    }
}