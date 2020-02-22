package programing1;

import java.util.Scanner;

public class iloscMinut {
    private static final long MINUTES_IN_YEAR=356*24*60;
    private static final long MINUTES_IN_DAY=24*60;
    private static final long MINUTES_IN_HOUR=60;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        do {
            long liczba = input.nextLong();
            minutesInYears(liczba);

        }while (true);
    }

    public static void minutesInYears(long number){
        long lata,dni,godziny,minuty;
        minuty=number;

        godziny=minuty/60;
        minuty=minuty-godziny*60;

        dni=godziny/24;
        godziny=godziny-dni*24;

        lata=dni/254;
        dni=dni-lata*254;

        System.out.println("lata = "+lata);
        System.out.println("dni = "+dni);
        System.out.println("godziny = "+godziny);
        System.out.println("minuty = "+minuty);


        if(number<0L)System.out.println("zle");
        else {
            lata=number/MINUTES_IN_YEAR;
            if(lata<0)lata=0;
            dni=(number-lata*MINUTES_IN_YEAR)/MINUTES_IN_DAY;
            if(dni<0)dni=0;
            godziny=(number-lata*MINUTES_IN_YEAR-dni*MINUTES_IN_DAY)/MINUTES_IN_HOUR;
            if(godziny<0)godziny=0;
            System.out.println(lata+"Y "+dni+"D "+godziny+"H");
        }











    }




}
