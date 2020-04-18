package programing2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final Logger logger = LogManager.getLogger(Regex.class);
    public static void main(String[] args) {
        //String regex = "([A-Z].[a-z]+[ ]*)([A-Z].[a-z]+[ ]*).*";
        String regex = "^([A-Z][a-z]*)\\s+([A-Z][a-z]*).*$";

        String text = "Luki Mag";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println(text.matches(regex));
        System.out.println(matcher.find());
        System.out.println("Imię i Nazwisko: " +matcher.group(0));
        System.out.println("Imię: " + matcher.group(1));
        System.out.println("Nazwiasko: " + matcher.group(2));
        System.out.println("Ilosc grup: " + matcher.groupCount());


    }
}
