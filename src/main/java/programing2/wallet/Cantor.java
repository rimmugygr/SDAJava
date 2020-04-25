package programing2.wallet;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Cantor {
    // course By
    private static Currency currency;
    // key -> currency , value -> {BuyCash, SellCash}
    private static Map<Currency, List<Cash>> courseBuySell;


    static boolean getCourseByFile(String source)  {
        List<Cash> resultLine;
        //Map<Currency,List<Cash>> //todo
        Path pathFile = Paths.get(source);
        try {
            List<String> courseStringLine = Files.lines(pathFile).collect(Collectors.toList());
            for (String line : courseStringLine) {
                String[] tabLine = line.split(" ");
                Currency actualCurrency = Currency.valueOf(tabLine[0]);
                if(tabLine[1].equals("#")) {
                    currency = actualCurrency;
                    continue;
                }
                resultLine = new ArrayList<>();
                Cash cashBuy = new Cash(BigDecimal.valueOf(Long.parseLong(tabLine[1])),actualCurrency);
                Cash cashSell = new Cash(BigDecimal.valueOf(Long.parseLong(tabLine[2])),actualCurrency);
                resultLine = new ArrayList<>();
                resultLine.add(cashBuy);
                resultLine.add(cashSell);

            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
