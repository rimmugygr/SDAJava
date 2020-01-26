package podstawy.tablicePetle;
import java.util.Scanner;
public class Tablica {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        /////  Zadania z tablic
//        int tab = 10;
//        String[] zakupy= new String[tab];
//        int i=0;
//        while(i<tab){
//            zakupy[i]=input.nextLine().toLowerCase();
//            i++;
//        }
//
//        for(i=0;i<tab;i++){
//            System.out.printf("zakup %d to %s \n",i+1,zakupy[i]);
//        }
//
//        for(String zakup:zakupy){
//            System.out.printf("zakup to %s \n",zakup);
//        }


//        System.out.printf("dlugosc tablicy");
//        int tab = input.nextInt();
//        int[] tablica= new int[tab];
//        int suma=0;
//
//        for(int i=0;i<tab;i++){
//            tablica[i]=input.nextInt();
//            suma+=tablica[i];
//        }
//
//        System.out.printf("suma=%d\n",suma);

//        String[] tablica={"adam","janusz","edyta","ania","ewa"};
//
//        String imiona="";
//        for(String imie:tablica){
//
//            if(!imiona.equals("")) imiona += (" , " + imie); else imiona=imie;
//        }
//        System.out.printf("%s\n",imiona);
//
//        imiona="";
//        for(String imie:tablica){
//            if (imie.length()<5){
//                if(!imiona.equals("")) imiona += " , " + imie; else imiona=imie;
//            }
//        }
//        System.out.printf("%s\n",imiona);

        //1. Napisz program, który dla zadanej tablicy typu int zwraca:
        //a) Największą wartość
        //b) Najmniejszą wartość
        //c) Sumę wszystkich wartości
        //d) *Wartość średnią
        //e) *Medianę

//        System.out.printf("dlugosc tablicy, potem elementy : ");
//        int tab = input.nextInt();
//        int[] tablica= new int[tab];
//        for(int i=0;i<tab;i++){
//            tablica[i]=input.nextInt();
//        }
//        int max=tablica[0];
//        for(int i=0;i<tab;i++){
//            if(max<tablica[i])max=tablica[i];
//        }
//        int min=tablica[0];
//        for(int i=0;i<tab;i++){
//            if(min>tablica[i])min=tablica[i];
//        }
//        int suma=0;
//        for(int i=0;i<tab;i++){
//            suma+=tablica[i];
//        }
//        float srednia;
//        srednia = (float)suma/(float)tablica.length;
//
//
//        // sortowanie
//        int minTemp; // najmniejsza znaleziona liczba
//        int index; // index najmniejszej liczby
//        int[] temp= tablica; // tablica z posortowanymi numerami
//        for(int j=0;j<tab;j++){ // j index miejsca w tablicy w który jest wstawiana najmniejsza liczba
//            for(int i=j;i<tab;i++){ // wyszukiwanie w tablicy pomnijeszonej o posortowane liczby
//                minTemp=tablica[j];     // początkowa niepostowana liczba
//                index=j;                // początkowa niepostowana liczba (jej indesk)
//                if(minTemp>temp[i]) {minTemp=temp[i];index=i;}
//                temp[index]=temp[j];      // zamiana w nieposortowanej częsci (najmniejszya liczba na początek)
//                temp[j]=minTemp;          //
//            }
//        }
//        float mediana;
//        if(temp.length%2==0)mediana=((float)temp[temp.length/2]+(float)temp[temp.length/2-1])/2; // gdy parzysta liczba
//        else mediana=(float)temp[temp.length/2];// gdy nieparzysta liczba
//
//
//
//        System.out.printf("minimum = %d\n",min);
//        System.out.printf("maksimum = %d\n",max);
//        System.out.printf("suma = %d\n",suma);
//        System.out.printf("srednia = %f\n",srednia);
//        System.out.printf("mediana = %f\n",mediana);
//        System.out.printf("Posortowana tablica:\n");
//        for(int i = 0; i<tab;i++){
//            System.out.printf("%3d",temp[i]);
//        }




        //Napisz program, który zwraca w postaci tablicy zbiór wszystkich liczb mniejszych od
        //zadanej przez użytkownika liczby oraz:
        //a) Podzielnych przez 2
        //b) Podzielnych przez 3
        //c) *Podzielnych przez zadaną przez użytkownika liczbę
        System.out.printf("Zadana liczba : ");
        int zadanaLiczba=input.nextInt();
        System.out.printf("Podzielne przez liczbe : ");
        int zadanaPodzielna=input.nextInt();
        int[] tab=new int[zadanaLiczba];
        int podzielne2=0;
        int podzielne3=0;
        int podzielneLiczba=0;
        for(int i=0;i<zadanaLiczba;i++){// tworzenie tablicz z liczbami z zakresu oraz liczbę liczb podzielnych
            tab[i]=i;
            if(tab[i]%2==0)podzielne2++;
            if(tab[i]%3==0)podzielne3++;
            if(tab[i]%zadanaPodzielna==0)podzielneLiczba++;
        }
        int[] tab2=new int[podzielne2];
        int[] tab3=new int[podzielne3];
        int[] tabLiczba=new int[podzielneLiczba];
        for (int i=0,index2=0,index3=0,indexLiczba=0;i<zadanaLiczba;i++){//uzupełnianie dablic o podzielne liczby

            if(tab[i]%2==0){
                tab2[index2]=tab[i];
                index2++;
            }
            if(tab[i]%3==0){
                tab3[index3]=tab[i];
                index3++;
            }
            if(tab[i]%zadanaPodzielna==0){
                tabLiczba[indexLiczba]=tab[i];
                indexLiczba++;
            }

        }




        System.out.printf("Wszystkie liczby mniejsze : ");
        for(int i=0;i<zadanaLiczba;i++){
            System.out.printf(" %2d",tab[i]);
        }
        System.out.printf("\nPodzielne przez 2 liczby : ");
        for(int i=0;i<podzielne2;i++){
            System.out.printf(" %2d",tab2[i]);
        }
        System.out.printf("\nPodzielne przez 3 liczby : ");
        for(int i=0;i<podzielne3;i++){
            System.out.printf(" %2d",tab3[i]);
        }
        System.out.printf("\nPodzielne przez %d liczby : ",zadanaPodzielna);
        for(int i=0;i<tabLiczba.length;i++){
            System.out.printf(" %2d",tabLiczba[i]);
        }






    }
}
