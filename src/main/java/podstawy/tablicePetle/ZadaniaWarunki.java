package podstawy.tablicePetle;
import  java.util.Scanner;
public class ZadaniaWarunki {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        /*Ćwiczenie 2
        • Zadeklaruj dwie zmienne odpowiadające bokom prostokąta i policz jego pole oraz obwód. ◦ Przypisz wartość obwodu do zmiennej. Jakiego typu może być ta zmienna?
        • Zadeklaruj dwie zmienne odpowiadające bokom trójkąta prostokątnego i policz jego pole. ◦ Przypisz wartość pola do zmiennej. Jakiego typu może być ta zmienna?
        • Zadeklaruj zmienną odpowiadającą średnicy koła i policz jego pole i obwód.
        ◦ Przypisz wartości pola i obwodu do zmiennych. Jakiego typu mogą być te zmienne?
        • Zadeklaruj trzy zmienne odpowiadające bokom trójkąta i sprawdź, czy jest on prostokątny. ◦ Przypisz wynik do zmiennej. Jakiego typu powinna być ta zmienna?*/
        float wysokosc=2;
        float szerpokosc=3;
        float srednica=4;
        float pi= (float) 3.14;
        float poleProstokatu=wysokosc*szerpokosc;
        float obwodProstokatu=2*wysokosc+2*szerpokosc;
        float poleTrojkata=poleProstokatu/2;
        float poleKola=pi*(srednica/2)*(srednica/2);
        float obwodKola=2*pi*(srednica/2);

        float a=4,b=5,c=3;
        boolean czyProstokatny=false;
        if((a*a+b*b)==(c*c)||(c*c+b*b)==(a*a)||(a*a+c*c)==(b*b)){
            czyProstokatny=true;
            System.out.printf("prostokatny kwadrat\n");
        }

        /*Ćwiczenie 3
        W zmiennej dayOfWeek przechowujemy numer dnia tygodnia.
        Napisz program, który wyświetla napis "Pracujący" dla dni od poniedziałku do piątku, "Wolny" dla soboty, "Święto"
        dla niedzieli oraz "Błędny dzień tygodnia!!!" dla pozostałych wartości.
        */
        int dayOfWeek=0;
        if (dayOfWeek>=1&&dayOfWeek<=5)System.out.printf("Pracujacy\n");
        else if (dayOfWeek==6)System.out.printf("Wolny\n");
        else if (dayOfWeek==7)System.out.printf("Święto\n");
        else System.out.printf("Błędny dzień tygodnia!!!\n");

        /*Ćwiczenie 4
        Za pomocą specjalnej metody klasy Math zasymuluj rzut kostką do gry.
        • wyświetl informację, czy wynik jest parzysty, czy nieparzysty
        • jeśli wyrzucono wartość 6 wypisz dodatkowo napis WYGRAŁEŚ*/

        double random=Math.random();
        double rzut=Math.floor(random*7);
        System.out.printf("%f\n",random);
        System.out.printf("%.0f\n", rzut);
        if(rzut%2==0)System.out.printf("pazysta ");
        else System.out.printf("niepazysta ");
        if(rzut==6)System.out.printf("you win");

    }
}
