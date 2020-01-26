package podstawy.kolekcje;

import java.util.*;

public class ZadaniaLista {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

//        List<String> listaObrazow = new LinkedList<>();
//        listaObrazow.add("Krzyk");
//        listaObrazow.add("Mona Lisa");
//        System.out.println("W naszej galerii posiadamy : ");
//        for (String obraz: listaObrazow) {
//            System.out.println(" - " + obraz);
//        }

        /*1. Stwórz Listę oraz wyświetl jej rezultat (dane pobieraj z konsoli lub wprowadź na
        stałe do kodu):
        a) Zakupów do zrobienia. Jeśli dany element już występuje na liście, to nie
        powinien zostać dodany.
                i. Dodaj do powyższego przykładu możliwość „wykreślania” zakupów, które  zostały zrealizowane.
                ii. Wyświetl tylko te zakupy, które zaczynają się na „m”
                iii. *Wyświetl tylko te zakupy, których następny produkt na liście zaczyna się na „m”
      */


//        List<String> listaStringow = new LinkedList<>();
//        String temp;
//
//
//        do {
//            System.out.println("\topcje : dodaj , wykresl , wypisz");
//           temp = input.nextLine().toLowerCase();
//            switch (temp){
//                case "dodaj":
//                    temp = input.nextLine();
//                    if (!listaStringow.contains(temp)) listaStringow.add(temp);
//                    break;
//                case "wykresl":
//                    temp = input.nextLine();
//                    if (listaStringow.contains(temp)) listaStringow.remove(temp);
//                    break;
//                case "wypisz":
//                    System.out.println("\twszystkie");
//                    for (String napis:listaStringow) {
//                        System.out.println(napis);
//                    }
//
//                    System.out.println("\twszystkie na m");
//                    for (String napis:listaStringow) {
//                        if ('m'==(napis.charAt(0)))System.out.println(napis);
//                    }
//
//                    System.out.println("\tte przed tymi na litere na m");
//                    for (int i = 1; i < listaStringow.size(); i++) {
//                        if(listaStringow.get(i).charAt(0)=='m')System.out.println(listaStringow.get(i-1));
//                    }
//                    break;
//                default:
//                    System.out.println("zleeeeee");
//
//            }
//
//        }while (true);



        /*b) Otrzymanych ocen. Wyświetl ich średnią. Liczby nie mogą być mniejsze niż 1 i
        większe niż 6.
       */


//        List<Integer> listaOcen= new LinkedList<>();
//        Integer temp;
//
//        System.out.println("dodaj");
//        temp=input.nextInt();
//        if(temp>=1&&temp<=6)listaOcen.add(temp);
//        temp=input.nextInt();
//        if(temp>=1&&temp<=6)listaOcen.add(temp);
//        temp=input.nextInt();
//        if(temp>=1&&temp<=6)listaOcen.add(temp);
//
//        System.out.println("wszystkie");
//        double srednia=0;
//        for (Integer ocena:listaOcen) {
//            System.out.println(ocena);
//            srednia+=ocena;
//        }
//        srednia=srednia/listaOcen.size();
//        System.out.print("srednia ");
//        System.out.println(srednia);

        /*c) *Listę list – tabliczka mnożenia (wykorzystując program z prezentacji)
        */

//        //List<List<Integer>> tabliczka=new ArrayList<List<Integer>>();
//        List<List<Integer>> tabliczka=new LinkedList<List<Integer>>();
//        //List<List<Integer>> tabliczka=new ArrayList<>();
//        Integer temp;
//
//
//        for (int i=1;i<=10 ; i++){
//            List<Integer> wiersz= new LinkedList<>();
//            for (int j=1; j<=10 ; j++){
//               wiersz.add(i*j);
//            }
//            tabliczka.add(wiersz);
//        }
//
//
//        for (List<Integer> wierszLiczb:tabliczka) {
//            for (Integer liczba:wierszLiczb) {
//                System.out.printf(" %3d",liczba);
//            }
//            System.out.printf("\n");
//        }

        /*d) *Listę Map – gdzie kluczem mapy będzie nazwa budynku, a wartością jej adres
                (np. „Neptun” : „Grunwaldzka …”)*/


//        List<Map<String ,String>> listaMap =new LinkedList<Map<String,String>>();
//
//        Map<String, String> mapa = new HashMap<>();
//        mapa.put("wiezowiec","grunwaldzka 3");
//        mapa.put("szkola","3maja 8");
//
//        Map<String, String> mapa2 = new HashMap<>();
//        mapa2.put("wiezowiec duzy","grunwaldzka 2");
//        mapa2.put("szkola mala","3maja 7b");
//        mapa2.put("koszary","kwiecista");
//
//        listaMap.add(mapa);
//        listaMap.add(mapa2);
//
//        int i=1;
//        for (Map<String, String> bierzacaMapa:listaMap) {
//            System.out.printf("Lista nr %d\n",i++);
//            for(Map.Entry<String, String> domUlica: bierzacaMapa.entrySet()) {
//                String dom = domUlica.getKey();
//                String ulica = domUlica.getValue();
//                System.out.printf("%s : %s\n", dom, ulica);
//            }
//            System.out.printf("\n");
//        }

//        /*1. Stwórz mapę oraz wyświetl jej rezultat (dane pobieraj z konsoli lub wprowadź na
//        stałe do kodu):
//        a) Imion i nazwisk
//        b) Imion i wieku.
//                c) Imion i list znajomych (innych imion).
//        */
//
//        /////////////////////////////////
//        System.out.println("\n//////imie + nazwisko//////");
//        Map<String, String> imieNazwisko = new HashMap<>();
//        imieNazwisko.put("piotr", "kuska");
//        imieNazwisko.put("piotr drugi", "wwwkuska");
//        imieNazwisko.put("piotr trzeci", "wwwwwwwwwkuska");
//        for(Map.Entry<String, String> rekord: imieNazwisko.entrySet()) {
//            String imie = rekord.getKey();
//            String nazwisko = rekord.getValue();
//            System.out.printf("%s - %s\n", imie, nazwisko);
//        }
//
//
//        /////////////////////////////////
//        System.out.println("\n//////imie + wiek//////");
//        Map<String, Integer> imieWiek = new HashMap<>();
//        imieWiek.put("piotr", 77);
//        imieWiek.put("piotr nastepny", 78);
//        for(Map.Entry<String, Integer> rekord: imieWiek.entrySet()) {
//            String imie = rekord.getKey();
//            Integer wiek = rekord.getValue();
//            System.out.printf("%s - %d\n", imie, wiek);
//        }
//
//        /////////////////////////////////
//        System.out.println("\n//////imie + znajomi//////");
//        Map<String, List<String>> imieZnajomi = new HashMap<>();
//
//        List<String> listaZnajomych=new LinkedList<>();
//        listaZnajomych.add("wojtek");
//        listaZnajomych.add("michal");
//        imieZnajomi.put("piotr",listaZnajomych);
//
//        List<String> listaZnajomych2=new LinkedList<>();
//        listaZnajomych2.add("michal");
//        listaZnajomych2.add("wojtek");
//        imieZnajomi.put("piotr drugi",listaZnajomych2);
//
//        for(Map.Entry<String, List<String>> rekord: imieZnajomi.entrySet()) {
//            String imie = rekord.getKey();
//            List<String> znajomi = rekord.getValue();
//            System.out.printf("%s - %s\n", imie, znajomi.toString());
//        }
//
//        /*d) *Imion i danych szczegółowych (mapę map), np.
//                „Marek” :
//                „Pesel” : „…”,
//                „Nazwisko” : „…”*/
//
//        /////////////////////////////////
//        System.out.println("\n//////imie + mapa danych//////");
//        Map<String,Map> imieDane= new HashMap<>();
//
//        Map<String,String> dane= new HashMap<>();
//        dane.put("pesel","234234234");
//        dane.put("nazwisko","kuska");
//        dane.put("adres","kwiatowa7");
//        imieDane.put("jacek",dane);
//
//        //Map<String,String> dane2= new HashMap<>();
//        dane.put("adres","kwiatowa78");
//        dane.put("nazwisko","kuska8");
//        dane.put("pesel","2342342348");
//        dane.put("aaa","bb");
//        imieDane.put("filip",dane);
//
//        for(Map.Entry<String, Map> wiersz: imieDane.entrySet()) {
//            String imie = wiersz.getKey();
//            Map<String,String> daneMapa = wiersz.getValue();
//            System.out.printf("\t%s :\n", imie);
//            for (Map.Entry<String, String> daneWartosc: daneMapa.entrySet()) {
//                String klucz = daneWartosc.getKey();
//                String wartosc = daneWartosc.getValue();
//                System.out.printf("%s - %s\n", klucz, wartosc);
//            }
//        }

/*
        1. Jedziemy na wakacje.
                a) Wewnątrz pętli pobieramy informacje od użytkownika jaki kraj odwiedza, a następnie jakie miasta w danym kraju
                odwiedził – korzystamy z kolekcji HashMap jako kolekcji nadrzędnej. Kluczem jest String (państwo), a wartością Lista
                (miasta).
                b) Pobieramy miasta tak długo, aż nie otrzymamy od użytkownika „jadę dalej”, następnie pobieramy informację o
                nazwie kolejnego odwiedzanego państwa, itd.
                c) Po otrzymaniu komunikatu „wracam do domu” kończymy pobieranie danych i wyświetlamy odwiedzone państwa i
                miasta za pośrednictwem zagnieżdżonych pętli for each.
                d) *Pozwalamy na maksymalnie dwukrotne odwiedziny danego miasta (na przykład jadąc tam
                i z powrotem).
                e) *Jeśli dane miasto znajduje się na liście dwukrotnie, to wyświetlamy je tylko jeden raz z informacją „(tam i powrót)”.
                Skorzystaj ze zbioru Set.

*/

//        Map<String,List> mapaPanstw = new HashMap<>();
//        Set<String> odwiedzoneMiasta = new HashSet<>();
//
//        do{
//            System.out.println("kraj:");
//            String kraj=input.nextLine().toLowerCase();
//            if(kraj.equals("koniec"))break;
//
//
//            List<String> listaMiast = new LinkedList<>();   // nowa lista
//            String miasto;
//            do{                                             //petla ktora : dodawanie miast do tej listy
//                System.out.println("miasta:");
//                miasto = input.nextLine().toLowerCase();
//                if(miasto.equals("koniec")) break;          //koniec nowych miast
//                if(listaMiast.contains(miasto)) {           //jesli miasto juz odwiedzone dodaj adnotacje
//                    listaMiast.set(listaMiast.indexOf(miasto),miasto+"2 razy");
//                    continue;
//                }
//                if(listaMiast.contains(miasto+"2 razy"))    //misto 3 raz nie mozna odwiedzic
//                    continue;
//                listaMiast.add(miasto);
//                odwiedzoneMiasta.add(miasto);
//            }while (true);
//            mapaPanstw.put(kraj,listaMiast);                //dodanie listy do mapy
//        }while (true);
//
//        System.out.println("Odwiedzone kraje - miasta");
//        for(Map.Entry<String, List> rekord: mapaPanstw.entrySet()) {
//            String kraj = rekord.getKey();
//            List<String> miasta = rekord.getValue();
//            System.out.printf("%s - %s\n", kraj, miasta.toString());
//        }
//
//        System.out.println("Odwiedzone miasta (posortowane): ");
//        for (String miasto: new ArrayList<String>(new TreeSet(odwiedzoneMiasta))) {
//            System.out.println(" - " + miasto);
//        }
//        System.out.println("Odwiedzone miasta : ");
//        for (String miasto: odwiedzoneMiasta){
//            System.out.println(" - " + miasto);
//        }



       /* 2. Planujemy wakacje (i robimy korektę po powrocie).
                a) Tworzymy słownik (j/w), który zawiera państwa i miasta, które chcemy odwiedzić oraz ją wyświetlamy.
                b) Następnie pobieramy w pętli od użytkownika informacje, których państw/miast nie udało mu się odwiedzić –
                 usuwamy je z naszego słownika.
                c) Wyświetlamy odwiedzone państwa i miasta.
                d) *Wyświetlamy, czego nie udało nam się odwiedzić.*/
        Set<String> slownikMiast = new HashSet<>();
        Set<String> slownikKrajow = new HashSet<>();
        String tekstZKonsoli;
        System.out.println("kraje:");
        do{
            tekstZKonsoli=input.nextLine().toLowerCase();
            slownikKrajow.add(tekstZKonsoli);
        }while (!tekstZKonsoli.equals("koniec"));
        System.out.println("miasta:");
        do{
            tekstZKonsoli=input.nextLine().toLowerCase();
            slownikMiast.add(tekstZKonsoli);
        }while (!tekstZKonsoli.equals("koniec"));

        System.out.println("kraje:");
        do{
            tekstZKonsoli=input.nextLine().toLowerCase();
            slownikKrajow.remove(tekstZKonsoli);
        }while (!tekstZKonsoli.equals("koniec"));
        System.out.println("miasta:");
        do{
            tekstZKonsoli=input.nextLine().toLowerCase();
            slownikMiast.remove(tekstZKonsoli);
        }while (!tekstZKonsoli.equals("koniec"));

        for (String aaa: slownikKrajow) {
            System.out.println(aaa);
        }
        for (String aaa: slownikMiast) {
            System.out.println(aaa);
        }
    }

}
