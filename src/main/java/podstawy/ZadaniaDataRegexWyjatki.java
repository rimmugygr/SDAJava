package podstawy;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.time.LocalDateTime;


public class ZadaniaDataRegexWyjatki {





    /*

        DATA i CZAS:
        3. Napisz funkcję, która przyjmie za parametry obiekt typu LocalDate oraz LocalTime,
        a która zwróci obiekt LocalDateTime o odpowiednich wartościach.
        4. Napisz metodę, która za parametr przyjmie rok (int), a która zwróci informację, czy rok jest przestępny. Skorzystaj z klas Calendar oraz GregorianCalendar.
        */
    public static LocalDateTime czas(LocalDate date, LocalTime time){
        return LocalDateTime.of(date, time);
    }

    public static boolean przystepnyRok(int iii){
        Calendar kalendarz = new GregorianCalendar(iii, Calendar.FEBRUARY,1);
        int dniMiesiac= kalendarz.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (dniMiesiac!=28) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);





        /*WYJĄTKI:
        2. Napisz metodę dzielenieLiczb, która przyjmie dwa parametry typu int, która w przypadku dzielenia przez 0 zwróci null
        oraz w konsoli wyświetli odpowiednią informację, zamiast wyrzucania wyjątku (w treści metody używając składni try/catch).*/

        int a=7,b=0;




        try{
            System.out.print(a / b+"\n");
        }catch (ArithmeticException e){
            System.out.print("Kurwa dzielisz przez zero\n");
            System.err.println("aaaaabbb");
        }
        catch (NullPointerException e){
            System.err.println("aaaaabbb");

        }








        /*

        DATA i CZAS:
        3. Napisz funkcję, która przyjmie za parametry obiekt typu LocalDate oraz LocalTime,
        a która zwróci obiekt LocalDateTime o odpowiednich wartościach.
        4. Napisz metodę, która za parametr przyjmie rok (int), a która zwróci informację, czy rok jest przestępny. Skorzystaj z klas Calendar oraz GregorianCalendar.
        */
        int rok=2016;
        Calendar kalendarz= new GregorianCalendar(rok,Calendar.FEBRUARY,1);
        int iloscDni=kalendarz.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(iloscDni);
        System.out.print("rok "+rok+" jest przystepny : "+ ZadaniaDataRegexWyjatki.przystepnyRok(rok)+"\n");

        /*

        STRING:
        5. Napisać program, który wczytuje od użytkownika ciąg znaków, a następnie wyświetla informację o tym ile razy w tym ciągu powtarza się jego ostatni znak.
        Przykład, dla ciągu „Abrakadabra” program powinien wyświetlić 4, ponieważ ostatnim znakiem jest literka „a”, która występuje w podanym ciągu łącznie 4 razy. Skorzystaj z charAt
        6. Napisać program, który wczytuje od użytkownika ciąg znaków, a następnie sprawdza, czy podany ciąg jest palindromem. Skorzystaj z charAt*/

        System.out.print("podaj stringa : ");
        String ciagZnakow = input.nextLine();
        char znak=ciagZnakow.charAt(ciagZnakow.length()-1);             // zapisanie ostatniego znaku do zmiennej
        int i=0, counter=0;                                             // warunek poczatkowy , ustawinie na pierwszy element stringu
        do {
            i = ciagZnakow.indexOf(znak,i);                             // sprawdzenie na jakiej pozycji znajduje sie znak i zwrocenie jej
            counter++;                                                  //licznik wystapien
            i++;                                                        //ustawienie sprawdzania na nastepny znak po wystapieniu
            //System.out.print(counter+" "+i+"\n");//test
        }while (i<ciagZnakow.length());                                 //warunk gdy dojdziemy do ostatniego znaku
        System.out.print(znak+" poajawia sie "+counter+" razy\n");

        boolean warunek=true;                                                           // flaga czy jest palindromem
        for(int j=0;j<ciagZnakow.length();j++){                                         // petla po elementach w stringu
            if(ciagZnakow.charAt(ciagZnakow.length()-1-j)!=ciagZnakow.charAt(j)){       //sprawdzanie elenetu z odpowienim z drugiej strony
                //System.out.print(j+"  "+(ciagZnakow.length()-1-j)+"   \n");//test
                warunek=false;                                                          // ustawinie flagi na false gdy jakis test niewyszedl
                break;                                                                  // wyjscie z petli bo już nie ma co dalej sprawdzać
            }
        }
        System.out.print(ciagZnakow+" jest palindromem : "+warunek);




    }
}
