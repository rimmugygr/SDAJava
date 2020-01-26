package podstawy.kolekcje;
/*2. Stwórz listę przechowującą dany znak, np. „*”.

        a) Narysuj linię pionową
        b) Narysuj kwadrat pełen gwiazdek.
        c) *Wewnątrz pętli pozwól użytkownikowi na wybór „dodaj”/”usuń”
        „wiersz”/”kolumnę” – wyświetlaj efekt po każdym wyborze.*/
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DrawSymbol {
    public static void main(String[] args) {
    do {
        Scanner input=new Scanner(System.in);

        System.out.println("znak");
        String znak = input.nextLine();
        System.out.println("wiersz");
        int liczba1 = input.nextInt();
        System.out.println("kolumna");
        int liczba2 = input.nextInt();
        drawSquare(getSquareSymbol(znak,liczba1,liczba2));
        input.nextLine();

        do {
            System.out.println("dodaj/usun/koniec wiersz/kolumna ");
            String[] komenda=input.nextLine().split("[ ]");
            if(komenda.length==2) {
                if (komenda[0].equals("dodaj") || komenda[1].equals("wiersz")) liczba1++;
                if (komenda[0].equals("usun") || komenda[1].equals("wiersz")) liczba1--;
                if (komenda[0].equals("dodaj") || komenda[1].equals("kolumna")) liczba2++;
                if (komenda[0].equals("usun") || komenda[1].equals("kolumna")) liczba2--;
                drawSquare(getSquareSymbol(znak, liczba1, liczba2));
            }
            if(komenda.length==1)if(komenda[0].equals("koniec"))break;
        }while (true);

    }while (true);
    }

    private static List<String> getLineSymnol(String znak, int dlugosc){
        List<String> result=new LinkedList<>();
        for (int i=1 ; i<=dlugosc ; i++) result.add(znak);
        return result;
    }
    private static List<List<String>> getSquareSymbol(String znak,int dlugosc, int wysokosc){
        List<String> lane = getLineSymnol(znak, dlugosc);
        List<List<String>> result = new  LinkedList<>();
        for (int i=1 ; i<=wysokosc ; i++) result.add(lane);
        return result;
    }

    public static void drawLine(List<String> lane){
        for (String a:lane) System.out.print(a);
        System.out.println();
    }
    public static void drawSquare(List<List<String>> tab){
        for (List<String> lane:tab) drawLine(lane);
    }


}
