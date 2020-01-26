package podstawy.klasyObiekty.zad3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringParser {
    static private String pattern = "([a-z,A-Z]+)\\s+([a-z,A-Z]+)";
    static private Pattern wzor = Pattern.compile(pattern);
    static private Matcher informacje;
    static private String imie;                                     //imie
    static private String nazwisko;
    static private String[] wynik=new String[2];

    public static void setDane(String dane){                       //wydobycie imienia i nazwiska i zapisanie ich w odpowiedniach polach
        informacje = wzor.matcher(dane);
        if (informacje.find( )) {
            imie=informacje.group(1);
            nazwisko=informacje.group(2);
        }
    }

    public static String getImie() {                               //zwraca imie
        return imie;
    }

    public static String getNazwisko() {                            //zwraca nazwisko
        return nazwisko;
    }

    public static String [] getDane(){                              //zraca tablice 2 elemntową imie_+ naziwsko
        wynik[0]=imie;
        wynik[1]=nazwisko;
        return wynik;
    }
}
