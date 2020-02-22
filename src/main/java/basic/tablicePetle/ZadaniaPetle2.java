package basic.tablicePetle;
import java.util.Scanner;
public class ZadaniaPetle2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


 /*     String produkt;
        for(int i =0; i<10; i++) {
            produkt = input.next().toLowerCase();
            System.out.printf("dodałeś %10s i jest to %2d produkt z koleji\n",produkt,i+1);
        }*/

 /*     String produkt;
        int i=0;
        while(i<5){
            produkt=input.next().toUpperCase();
            System.out.printf("dodałeś %10s i jest to %2d produkt z koleji\n",produkt,i+1);
            i++;
        }*/






  /*      int lia=0;
        for(int i =0; i<5; i++) {
            lia = lia + input.nextInt();
        }
        System.out.printf("suma wynosi %d",lia);*/

        /*int liczba=0, i=0;
        while(i<5){

            int temp=input.nextInt();
            if(temp>10)liczba=liczba+temp;
            i++;
        }
        System.out.printf("suma wiekszych niz 10 rowan sie %d", liczba);*/


//        String napis;
//        do {
//            napis = input.nextLine().toLowerCase();
//            System.out.printf("%10s\n",napis);
//        }while(!(napis.compareTo("koniec")==0));
//
//        do {
//            napis = input.nextLine().toLowerCase();
//            System.out.printf("%10s\n",napis);
//        }while(!napis.equals("koniec"));  // bez wyswietlenia koniec


        String napis="";
        while(!(napis.compareTo("koniec")==0)){
            System.out.printf("%10s\n",napis);
            napis = input.nextLine().toLowerCase();
        }
        napis="";
        while(!napis.equals("koniec")){
            System.out.printf("%10s\n",napis);
            napis = input.nextLine().toLowerCase();
        }  //z wyswietleniem końca

  /*      for(int i=0 ; i<5 ; i++) {
            for(int j=0; j<5 ; j++){
                System.out.printf("zewnetrzna %d wewnetrzna %d \n",i,j);
            }
        }*/


/*        System.out.printf("liczba\n");
        int bok=input.nextInt();
        System.out.printf("jaki symbol\n");
        char znak=input.next().charAt(0);
        System.out.printf("twoj kawadrat\n");

        for(int i=0 ; i<bok ; i++) {
            for(int j=0; j<bok ; j++){
                System.out.printf("  %c",znak);
            }
            System.out.printf("\n");
        }*/








    }
}
