package programing2.wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CantorTest {
    Cash cashTenPLN;
    Cash cashTenUSD;
    Cantor cantor = new Cantor("dataCourse");

    @BeforeEach
    void setUp() {
        cashTenPLN = new Cash(BigDecimal.TEN, Currency.PLN);
        cashTenUSD = new Cash(BigDecimal.TEN, Currency.USD);
    }

    @Test
    void howMuchGet() {
        assertAll(
               // () -> assertEquals(new Cash(BigDecimal.valueOf(2.20), Currency.EURO), cantor.howMuchGet(cashTenPLN,Currency.EURO)),
                () -> assertEquals(BigDecimal.valueOf(2.2), BigDecimal.TEN.multiply(BigDecimal.valueOf(0.22))) //????
               // () -> assertEquals(new Cash(BigDecimal.valueOf(9.30), Currency.EURO), cantor.howMuchGet(cashTenUSD,Currency.EURO))
        );
    }
}
