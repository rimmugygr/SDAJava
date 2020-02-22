package programing1;

import java.util.Scanner;

/*public static boolean isLeapYear(int year)
        sprawdzającą czy rok jest przestępny (podzielny przez 4 ale nie przez 100 lub
        podzielny przez 400). Jeśli podany rok będzie spoza zakresu 1 – 9999, metoda
        ma zwrócić false. Napisz drugą metodę
public static int getDaysInMonth(int month, int year)
        zwracającą ilość dni w miesiącu. Wykorzystaj wcześniej napisaną metodę
        isLeapYear. Jeśli numer miesiąca jest spoza zakresu 1 – 12, zwróć -1.*/

public class DaysInMonth {
    private static final int MIN_RAGE_YEAR = 0;
    private static final int MAX_RAGE_YEAR = 19999;
    private static final int[] DAY_IN_MONTH_NORMAL_YEAR={31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] DAY_IN_MONTH_LEAP_YEAR={31,29,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            int rok = input.nextInt();
            System.out.println("Czy w zakrsie rok " + isInRage((int) rok));
            System.out.println("Czy przystepny rok " + isLeapYear((int) rok));
            int miesiac = input.nextInt();
            if (getDaysInMonth(miesiac ,rok)==-1)System.out.println("nie ma takiego miesiaca");
            else if (getDaysInMonth(miesiac ,rok)==0)System.out.println("rok z poza zakresu");
            else System.out.println(miesiac +" miesiac ma " + getDaysInMonth( miesiac ,rok)+" dni");

        } while (true);
    }

    public static boolean isLeapYear(int year) {
        if (!isInRage(year)) return false;
        return (year % 4 == 0 && year % 100 != 0 && year % 400 != 0);
    }

    private static boolean isInRage(int year) {
        return MIN_RAGE_YEAR < year && year < MAX_RAGE_YEAR;
    }

    public static int getDaysInMonth(int month, int year){
        if ((month < 0) || (month > 12)) return -1;
        if (!isInRage(year)) return 0;
        if (isLeapYear(year)) return DAY_IN_MONTH_LEAP_YEAR[month-1];
        else return DAY_IN_MONTH_NORMAL_YEAR[month-1];

    }




}