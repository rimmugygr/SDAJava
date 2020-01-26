package podstawy.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZapisOdczytZadania {

    public static void main(String[] args) {
        /*1. Stwórz plik (ręcznie) o zawartości pochodzącej z generatora Lorem Ipsum.
        2. Odczytaj zawartość pliku za pośrednictwem java.io.
        3. Zmodyfikuj tekst tak aby:
        a) nie zawierał kropek i przecinków
        b) był cały zapisany małymi literami
        4. Policz wystąpienie dowolnego wyrazu w tekście. Zweryfikuj poprawność.
        5. Zapisz przetworzony tekst do dowolnego pliku.
        *Osoby, które wykonały zadanie domowe mogą zamiast powyższego zadania:
        a) dane, które pochodziły z konsoli zastąpić danymi z pliku
        b) zapisać wszystko to, co program wypisze na ekran – do pliku*/
        String tekst="",linia="";
        String pattern="aaa";
//        Pattern wzor = Pattern.compile(pattern);
//        Matcher informacje;
        int liczba=0,temp=0;
        try{
            File plik= new File("Plik.txt");
            Scanner input = new Scanner(plik);
            while(input.hasNextLine()){
                linia = input.nextLine().replace(".","").replace(",","").toLowerCase();
                //linia = input.nextLine().replaceAll("[,.]","").toLowerCase();
                //informacje=wzor.matcher(linia);


                temp=linia.indexOf(pattern);// pierwsze wystapienie
                if(temp!=-1)liczba++;//gdy zapisana pozycja elemntu
                while (temp!=(-1)){//sprawdznie czy sa kolejne wystapienia
                temp=linia.indexOf(pattern,temp+1);//przypiszanie numeru elementu
                if(temp!=-1)liczba++;//gdy zapisana pozycja elemntu
                }

                //do{
                //    if(informacje.find())
                //        liczba++;
                //}while (!informacje.find());

                System.out.println(liczba);
                //System.out.println(informacje.groupCount());

                tekst+="\n";
                tekst +=linia;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(tekst);






    }



}
