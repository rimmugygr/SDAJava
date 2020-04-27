package programing2.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programing2.wallet.exceptions.IncorrectCantorExchangeException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Cantor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private Set<Cash> moneyList;
    // KEY -> BASE Currency, VALUE -> Currency Map : { key -> currency to Buy , value -> Cash to give }
    private Map<Currency,Map<Currency, Cash>> courseToBuy = new HashMap<Currency,Map<Currency, Cash>>();

    public Cantor(String source) {
        getCourseByFile(source);
        initMoney();
    }

    public boolean exchange(Person person, Cash cashGiven, Currency currencyReceive) {
        if (isCourseAppear(cashGiven.getCurrency(),currencyReceive)) {
            if(person.removeMoney(cashGiven)) {
                try {
                    person.addMoney(howMuchGet(cashGiven,currencyReceive));
                    LOGGER.info("Cantor exchange " + cashGiven.getCurrency() + " to " + currencyReceive );
                    return true;
                } catch (IncorrectCantorExchangeException e) {
                    LOGGER.warn("Cantor dont exchange " + cashGiven.getCurrency() + " to " + currencyReceive );
                    person.addMoney(cashGiven);
                }
            }
        }
        return false;
    }

    public Cash howMuchGet(Cash cashGiven, Currency currencyReceive) throws IncorrectCantorExchangeException {
        if (!isCourseAppear(cashGiven.getCurrency(),currencyReceive)) throw new IncorrectCantorExchangeException();
        Cash course = getCourse(cashGiven.getCurrency(), currencyReceive);
        return cashGiven.changeCurrency(course);
    }

    public boolean isCourseAppear(Currency currencyGive, Currency currencyBack) {
        return this.courseToBuy.containsKey(currencyGive)
                && this.courseToBuy.get(currencyGive).containsKey(currencyBack);
    }

    private Cash getCourse(Currency given, Currency receive){
        return courseToBuy.get(given)
                .get(receive);
    }

    private List<Cash> initMoney(){
        LOGGER.debug("init money list");
        return courseToBuy.keySet()
                .stream()
                .map(currency -> new Cash(BigDecimal.valueOf(1_000_000),currency))
                .collect(Collectors.toList());
    }

    private boolean getCourseByFile(String source)  {
        Cash lineCashs;
        Map<Currency,Cash> mapCourse = new HashMap<>();
        Map<Currency,Map<Currency,Cash>> resultMapAllCourse = new HashMap<Currency,Map<Currency, Cash>>();

        Path pathFile = Paths.get(source);
        try {

            List<String> courseStringLine = Files.lines(pathFile).collect(Collectors.toList());
            Currency actualCurrency = null;
            for (String line : courseStringLine) {
                String[] tabLine = line.split(" ");
                Currency lineCurrency = Currency.valueOf(tabLine[0]);


                if(tabLine[1].equals("#")) {
                    if (!mapCourse.isEmpty()) resultMapAllCourse.put(actualCurrency,mapCourse);
                    actualCurrency = lineCurrency;
                    mapCourse = new HashMap<>();
                    continue;
                }

                lineCashs = new Cash(BigDecimal.valueOf(Double.parseDouble(tabLine[1])),lineCurrency);
                mapCourse.put(lineCurrency,lineCashs);
            }
            if (!mapCourse.isEmpty()) resultMapAllCourse.put(actualCurrency,mapCourse);
            this.courseToBuy =resultMapAllCourse;

        } catch (IOException e) {
            LOGGER.debug("dont load course from file because " + e.getMessage());
            return false;
        }
        LOGGER.debug("success to load course from file " + source);
        return true;
    }

    @Override
    public String toString() {
        return "Cantor{" +
                "moneyList=" + moneyList +
                ", courseToBuy=" + courseToBuy +
                '}';
    }
}
