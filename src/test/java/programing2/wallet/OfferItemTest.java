package programing2.wallet;

import org.junit.jupiter.api.*;
import programing2.wallet.exceptions.IncorrectAmountException;
import programing2.wallet.exceptions.IncorrectCurrencyException;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of OfferItem class")
@Tag("Wallet")
class OfferItemTest {
    Set<OfferItem> offerItemsBuy;
    Set<OfferItem> offerItemsSell;
    Set<String> itemList;
    Map<String,Cash> resultMap;

    @DisplayName("Testing GetSucceedOfferOnItem")
    @Nested
    class GetSucceedOfferOnItem {
        @BeforeEach
        void initEach() {
            offerItemsSell = Set.of(
                    new OfferItem(
                            "xxx",
                            List.of(new Cash(BigDecimal.TEN,Currency.PLN),new Cash(BigDecimal.TEN,Currency.EURO)
                            )),
                    new OfferItem(
                            "yyy",
                            List.of(new Cash(BigDecimal.TEN,Currency.USD)
                            ))
            );
            itemList = Set.of("xxx","yyy");
        }

        @DisplayName("acceptable offer in the some value")
        @Test
        void isReturnRight() {
            offerItemsBuy = Set.of(
                    new OfferItem(
                            "xxx",
                            List.of(new Cash(BigDecimal.TEN,Currency.PLN),new Cash(BigDecimal.TEN,Currency.EURO)
                            )));

            resultMap = Map.of("xxx",new Cash(BigDecimal.TEN,Currency.PLN));
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(itemList,offerItemsBuy,offerItemsSell));
        }
        @DisplayName("not acceptable offer not enough value")
        @Test
        void isReturnNullMapNotEnoughValue() {
            offerItemsBuy = Set.of(
                    new OfferItem(
                            "xxx",
                            List.of(new Cash(BigDecimal.valueOf(5),Currency.PLN),new Cash(BigDecimal.valueOf(5),Currency.EURO)
                            )));

            resultMap = new HashMap<>();
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(itemList,offerItemsBuy,offerItemsSell));
        }
        @DisplayName("acceptable offer in right currency")
        @Test
        void isReturnRightCurrency() {
            offerItemsBuy = Set.of(
                    new OfferItem(
                            "xxx",
                            List.of(new Cash(BigDecimal.valueOf(5),Currency.PLN),new Cash(BigDecimal.TEN,Currency.EURO)
                            )));

            resultMap = Map.of("xxx",new Cash(BigDecimal.TEN,Currency.EURO));
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(itemList,offerItemsBuy,offerItemsSell));
        }
        @DisplayName("acceptable offer in right currency in favor of selling offer")
        @Test
        void isReturnRightCurrencyInFavorSellingOffer() {
            offerItemsBuy = Set.of(
                    new OfferItem(
                            "xxx",
                            List.of(new Cash(BigDecimal.valueOf(5),Currency.PLN),new Cash(BigDecimal.valueOf(33),Currency.EURO)
                            )));

            resultMap = Map.of("xxx",new Cash(BigDecimal.valueOf(33),Currency.EURO));
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(itemList,offerItemsBuy,offerItemsSell));
        }
        @DisplayName("acceptable multi offer")
        @Test
        void isReturnRightMultiOffer() {
            offerItemsBuy = Set.of(
                    new OfferItem(
                            "xxx",
                            List.of(new Cash(BigDecimal.valueOf(5),Currency.PLN),new Cash(BigDecimal.valueOf(33),Currency.EURO)
                            )),
                    new OfferItem(
                            "yyy",
                            List.of(new Cash(BigDecimal.valueOf(10),Currency.USD)
                            )),
                    new OfferItem(
                            "zzz",
                            List.of(new Cash(BigDecimal.valueOf(10),Currency.USD)
                            ))
            );

            resultMap = Map.of(
                    "xxx", new Cash(BigDecimal.valueOf(33),Currency.EURO),
                    "yyy", new Cash(BigDecimal.valueOf(10),Currency.USD)
                    );
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(itemList,offerItemsBuy,offerItemsSell));
        }
        @DisplayName("return right for empty inputs")
        @Test
        void isReturnRightForEmpty() {
            resultMap = Map.of();
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(Set.of(),Set.of(),Set.of()));
        }

        @DisplayName("return right for null inputs")
        @Test
        void isReturnRightForNull() {
            resultMap = Map.of();
            assertEquals(resultMap, OfferItem.getSucceedOfferOnItem(null, null, null));
        }
    }
}
