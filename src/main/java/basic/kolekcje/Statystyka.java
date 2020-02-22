package basic.kolekcje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Statystyka {
    public static void main(String[] args) throws FileNotFoundException {
       /* 2. **Statystyka
        a) Stwórz plik, który będzie zawierał dowolny tekst.
        b) Stwórz statystykę wyrazów zawartych w tekście.
        c) Wyświetl liczbę wystąpień poszczególnych wyrazów w formie
                <wyraz> : <liczba wystąpień>
        d) *j/w posortowane*/
        File plik= new File("Plik.txt");
        Scanner wejscie= new Scanner(plik);
        String linia;
        Integer temp;

        Map<String,Integer> slownik=new HashMap<>();
        while (wejscie.hasNextLine()){
            linia=wejscie.nextLine();
            String[] tablica=linia.split("[., ]");//zczytywanie słow z lini

            for (String wyraz:tablica) {//z tablicy dodawanie słow do slownika
                if (wyraz.equals(""))continue;//sa puste slowa
                if(slownik.containsKey(wyraz)){// jesli juz zawiera
                    temp = slownik.get(wyraz);
                    slownik.replace(wyraz,++temp);// to zwieksz ilisc wystapien
                } else  slownik.put(wyraz,1);
            }
        }
        for (Map.Entry<String,Integer> rekord:   slownik.entrySet()) {
            System.out.println("*"+rekord.getKey()+"* - "+rekord.getValue());
        }
        for (Map.Entry<String,Integer> rekord:   (new TreeMap<String,Integer>(slownik)).entrySet()) {
            System.out.println("Sort *"+rekord.getKey()+"* - "+rekord.getValue());
        }
    }
}
