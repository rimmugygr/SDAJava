package podstawy.tablicePetle;
import java.util.Scanner;
public class ZadaniaTablicePetle {


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

//        //1. Kwadrat pusty w środku (wyłącznie krawędzie).
//        System.out.printf("Długość boku: ");
//        int bok = input.nextInt();
//        System.out.printf("Znak: ");
//        String znak = input.next();
//        for (int i=0;i<bok;i++){
//            for (int j=0;j<bok;j++){
//               if(i==0|i==bok-1)System.out.printf("%3S",znak);
//               else if(j==0|j==bok-1)System.out.printf("%3S",znak);
//               else System.out.printf("   ");
//            }
//            System.out.printf("\n");
//        }

//        //2. Prostokąt pusty w środku.
//        System.out.printf("Wysokość prostokatu: ");
//        int wysokosc=input.nextInt();
//        System.out.printf("Długość prostokątu: ");
//        int dlugosc=input.nextInt();
//        System.out.printf("Znak: ");
//        String znak = input.next();
//        for (int i=0;i<wysokosc;i++){
//            for (int j=0;j<dlugosc;j++){
//               if(i==0|i==wysokosc-1)System.out.printf("%3S",znak);       //rysowanie pozioma linia
//               else if(j==0|j==dlugosc-1)System.out.printf("%3S",znak);   //rysowanie pionowa linia
//               else System.out.printf("   ");//pusta przetrzen
//            }
//            System.out.printf("\n");
//        }

//        //3. Literę „L”, o krawędziach równej długości.
//        System.out.printf("Długość ramienia: ");
//        int dlugosc=input.nextInt();
//        System.out.printf("Znak: ");
//        String znak = input.next();
//        for (int i=0;i<dlugosc;i++){
//            for (int j=0;j<dlugosc;j++){
//                if(i==dlugosc-1)System.out.printf("%3S",znak);    //rysowanie pozioma linia
//                else if(j==0)System.out.printf("%3S",znak);       //rysowanie pionowa linia
//                else System.out.printf("   ");                    //pusta przetrzen
//            }
//            System.out.printf("\n");
//        }

//        //4. *Trójkąt prostokątny.
//        System.out.printf("Długość ramienia: ");
//        int dlugosc=input.nextInt();
//        System.out.printf("Znak: ");
//        String znak = input.next();
//        for (int i=0;i<dlugosc;i++){
//            for (int j=0;j<dlugosc;j++){
//                if(i==dlugosc-1)System.out.printf("%3S",znak);    //rysowanie pozioma linia
//                else if(j==0)System.out.printf("%3S",znak);       //rysowanie pionowa linia
//                else if(j==i)System.out.printf("%3S",znak);       //rysowanie skosna linia
//                else System.out.printf("   ");                    //pusta przetrzen
//            }
//            System.out.printf("\n");
//        }

//        //7. **Kwadrat pusty w środku z dwiema przekątnymi.
//        System.out.printf("Długość boku: ");
//        int dlugosc=input.nextInt();
//        System.out.printf("Znak: ");
//        String znak = input.next();
//        for (int i=0;i<dlugosc;i++){
//            for (int j=0;j<dlugosc;j++){
//                if(i==dlugosc-1|i==0)System.out.printf("%3S",znak);       //rysowanie pozioma linia
//                else if(j==0|j==dlugosc-1)System.out.printf("%3S",znak);  //rysowanie pionowa linia
//                else if(j==i)System.out.printf("%3S",znak);               //rysowanie 1 skosna linia
//                else if(j==dlugosc-1-i)System.out.printf("%3S",znak);     //rysowanie 2 skosna linia
//                else System.out.printf("   ");                            //pusta przetrzen
//            }
//            System.out.printf("\n");
//        }

        //5. *Jak punkt 1, ale najpierw wprowadź wszystkie elementy do tablicy dwuwymiarowej, a
        //dopiero później je wyświetl.
//        System.out.printf("Długość boku: ");
//        int bok = input.nextInt();
//        System.out.printf("Znak: ");
//        String znak = input.next();
//        String[][]tab=new String[bok][bok];
//        for (int i=0;i<bok;i++){                            //uzupelnianie znakami tablicy
//            for (int j=0;j<bok;j++){
//               if(i==0|i==bok-1)tab[i][j]=znak;
//               else if(j==0|j==bok-1)tab[i][j]=znak;
//               else tab[i][j]="   ";
//            }
//        }
//
//        for (int i=0;i<tab.length;i++){                            //wyswietlanie tablicy
//            for (int j=0;j<tab.length;j++){                         //!!!!!!!!!!!! tab.length
//               System.out.printf("%3S",tab[i][j]);
//            }
//            System.out.printf("\n");
//        }

        /*1. Napisz aplikację, która:
        a) Będzie posiadała tablicę jednowymiarową składającą się z 3 elementów typu String:
        kombinerek, nożyczek i śrubokrętu.
        b) Pobierze imię użytkownika.
        c) Wypisze na ekran: „Witaj <imię>! W naszej ofercie mamy: ” + lista elementów z tablicy
        produktów zdefiniowanych w podpunkcie a, każdy w nowej linii zaczynający się od
        myślnika + „Co chciałbyś kupić?”
        d) Za pośrednictwem pętli switch – case przeanalizuj wybór użytkownika, dla opcji default
        wypisz „Takiego produktu nie mamy w ofercie”
        e) Dla prawidłowego wyboru usuń dany element z tablicy i potwierdź użytkownikowi
        wybrany produkt.
        f) Potwierdź usunięcie elementu z listy poprzez jej ponowne wyświetlenie.

        i) W przypadku błędnego wyboru produktu pozwól na ponowny wybór tak długo, aż
        użytkownik nie napisze „do widzenia”*/

//        String[] tablica=new String[]{"kombinerki","nożyczki","śrubokręt"};
//        String imie=input.nextLine();
//        boolean warunek=true;                                               //warunek zakonczenia petli
//        do{
//            System.out.printf("Witaj %s W naszej ofercie mamy:\n",imie);
//            for (String element:tablica) {                                  //wyspiywanie listy
//                System.out.printf(" - %s\n",element);
//            }
//            System.out.printf("Co chciałbyś kupić?  ");
//            String wybor=input.nextLine().toLowerCase();
//            switch (wybor){                                                 //usuwanie z listy elementu zakupionego
//                case "kombinerki":
//                    System.out.printf("Kupiłeś kombinerki\n");
//                    tablica=new String[]{"nożyczki","śrubokręt"};
//                    break;
//                case "nożyczki":
//                    System.out.printf("Kupiłeś nożyczki\n");
//                    tablica=new String[]{"kombinerki","śrubokręt"};
//                    break;
//                case "śrubokręt":
//                    System.out.printf("Kupiłeś śrubokręt\n");
//                    tablica=new String[]{"nożyczki","kombinerki"};
//                    break;
//                case "do widzenia":
//                    warunek=false;
//                    break;
//                default:
//                    System.out.printf("Takiego produktu nie mamy w ofercie\n");
//            }
//        }while(warunek);
//        System.out.printf("Do widzenia\n");

       /* g) *Imię użytkownika przekaż przez Varargs jako pierwszy parametr.
        h) *Produkty do kupienia również.*/
        args = new String[]{"aaa", "bbb", "ccc", "ddd"};

        String imie=args[0];                                                //pobranie elementow z argumentow maina
        String[] tablica=new String[args.length-1];
        for (int i=1; i<args.length; i++) tablica[i-1]=args[i];

        boolean warunekPetli=true;
        boolean znalezionoElement=false;
        do{                                                                 //petla głowna
            System.out.printf("Witaj %s W naszej ofercie mamy:\n",imie);
            for (String element:tablica) {                                  //wyspiywanie listy
                System.out.printf(" - %s\n",element);
            }
            System.out.printf("Co chciałbyś kupić?  ");
            String wybor=input.nextLine().toLowerCase();

            for (String element:tablica) {                              //przeszukiwanie tablicy
                if(wybor.equals(element)) {
                    System.out.printf("Kupiłeś %s\n",wybor);
                    znalezionoElement=true;                             //znaleziono element, ustawienie flagi
                    String[] tempTablica=tablica;                       //tymczsowa tablica
                    tablica=new String[tablica.length-1];               //tablica zmniejszona o 1 element
                    for (int i=0,j=0;i<tempTablica.length;i++) {        //kopiowanie elementów bez wybranego do zmniejszonej tablicy
                        if(!wybor.equals(tempTablica[i])) {
                            tablica[j]=tempTablica[i];
                            j++;
                        }
                    }

                }
            }

            if(wybor.equals("do widzenia")){                            //sprawdzanie czy koniec
                System.out.printf("Do widzenia\n");
                warunekPetli=false;
            }else if(znalezionoElement==false){                         //sprawdzanie czy flaga znalezienia ustawiona
                System.out.printf("Takiego produktu nie mamy w ofercie\n");
            }
            znalezionoElement=false;







        }while(warunekPetli);


    }
}
