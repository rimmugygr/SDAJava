package basic.kolekcje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaneOsobowe {
    public static void main(String[] args) throws IOException,  FileNotFoundException {
        /*1. *Dane osobowe
                a) Stwórz plik zawierający dowolne dane osobowe (imię, nazwisko, numer
                telefonu). Dane poszczególnych osób powinny znajdować się w kolejnych
                liniach.
                b) Pobierz dane z pliku i utwórz na ich podstawie obiekty osób (w dowolny sposób
                – Regex, String.split…).
                c) Wprowadź utworzone obiekty do ArrayList lub Map (<numer linii> : <Osoba>).
        d) Zaprezentuj uzyskane dane.*/



        File odczyt = new File("DaneOsobowe.txt");
        Scanner input = new Scanner(odczyt);
        Pattern wzor = Pattern.compile("([a-z,A-Z]+)\\s+([a-z,A-Z]+)\\s+([0-9]+)");
        Matcher info ;
        Map<Integer,Osoba> daneOsobowe=new HashMap<>();





        int index=0;
        while(input.hasNextLine()){
            String linia = input.nextLine();
            info =wzor.matcher(linia);
            if(info.find()){
                Osoba osoba = new Osoba( info.group(1),info.group(2),info.group(3));
                daneOsobowe.put(index++,osoba);
            }

        }

        for (Map.Entry<Integer,Osoba> linia:daneOsobowe.entrySet()) {
            Integer numer=linia.getKey();
            Osoba osoba=linia.getValue();
            System.out.println("index:"+numer+" "+osoba.toString());
            
        }

    }
}
