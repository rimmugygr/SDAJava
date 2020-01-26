package podstawy.tablicePetle;

public class ZadaniaTablice {
    public String concatenate(String pierwszy, String drugi){
        return pierwszy+drugi;
    }
    public  int power(int postawa,int potega){
        int wynik = postawa;
        if (potega>0) {
            while (potega != 1) {
                wynik = postawa * wynik;
                potega--;
            }
        }
        if (potega==0) wynik=1;

        return wynik;
    }
    public int potega3(int liczba){
        int i=1,wynik=0;
        while (i<=liczba ){
            i*=3;
            wynik++;
        }
        return wynik;
    }


    /*Tablice
        1. Napisz metodę print, która wypisze w konsoli elementy tablicy intów, przekazanej jako parametr.
        2. Napisz metodę getMax, która przyjmie za parametr tablicę intów, a która zwróci największą wartość z tej tablicy.
        3. Napisz metodę getMin, która zwróci najmniejszy element przekazanej tablicy intów.
        4. Napisz metodę getSum, która przyjmie za parametr tablicę intów, a któa zwróci sumę jej elementów.
        5. Napisz metodę getMaxMinAndSum, która przyjmie za parametr tablicę intów, a która zwróci tablicę trzyelementową, której
        pierwszy element to wartość największa, drugi to najmniejsza, a trzeci suma wszystkich elementów.
        6. Napisz metodę getLarger, która przyjmie za parametry dwie tablice intów, a która zwróci tę tablicę, której suma elementów
        jest większa.
        7. Napisz metodę merge, która za parametry dwie tablice intów, a która zwróci tablicę, która zawierać będzie wszystkie
        elementy z jednej i drugiej tablicy.
        3 | 8
        8. Napisz metodę getDistinct, która za parametr przyjmie tablicę, a która zwróci tablicę, w której będą elementy bez
        powtórzeń z tablicy przekazanej w parametrze.*/


    public void print(int[]tab){
        for (int element:tab) {
            System.out.printf("%3d",element);
        }
    }
    public int getMax(int[]tab){
        int wynik=tab[0];
        for (int element:tab) {
            if(element>wynik)wynik=element;
        }
        return wynik;
    }
    public int getMin(int[]tab){
        int wynik=tab[0];
        for (int element:tab) {
            if(element<wynik)wynik=element;
        }
        return wynik;
    }
    public int getSum(int[]tab){
        int wynik=0;
        for (int element:tab) {
            wynik+=element;
        }
        return wynik;
    }

    public int[] getMinMaxSum(int[] tab){
        int[] wynik=new int[3];
        wynik[0]=getMin(tab);
        wynik[1]=getMax(tab);
        wynik[2]=getSum(tab);
        return wynik;
    }

    public int[] getLarger(int[] tab1,int[] tab2){
        if(getMax(tab1)>getMax(tab2)) return tab1;
        else return tab2;
    }

    public int[]  merge(int[] tab1,int[] tab2){
        int[] temp=new int[tab1.length+tab2.length];
        for (int i=0;i<tab1.length;i++){
            temp[i]=tab1[i];
        }
        for (int i=0;i<tab2.length;i++){
            temp[i+tab1.length]=tab2[i];
        }
        return temp;
    }


    public int[] getDistinct(int[] tab){
        int[] temp=new int[tab.length];                 //tymczasowa tablica
        int counter=1;
        boolean warunek=true;                           //warunek czy powtarza się dany znak
        temp[0]=tab[0];
        for (int i=0;i<tab.length;i++){                 //przeszukiwanie tablicy z argumentu metody
            warunek=true;
            for (int j=0;j<counter;j++) {               //przeszukiwanie tablicy wyciagnietymi elementami
                if (tab[i] == temp[j]) warunek=false;   //ustawianie false gdy dany znak powtarza się
            }
           if(warunek){                                 //gdy nie powtarza się dany element to przypisz i zwiększ index
               temp[counter] = tab[i];
               counter++;
           }
        }
        int[] wynik=new int[counter];
        for (int i=0;i<counter;i++){
            wynik[i]=temp[i];
        }



        return wynik;
    }




}
