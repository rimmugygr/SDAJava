package programowanie1.team_steam_generic_optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTeam {
    public static void main(String[] args) {


        Team stall0 = new FootballTeam("stall0");
        Team stall1 = new FootballTeam("stall1");
        FootballTeam stall2 = new FootballTeam("stall2");
        FootballTeam stall3 = new FootballTeam("stall2");

        stall0.setPoints(10);
        stall1.setPoints(33);
        stall2.setPoints(22);
        stall3.setPoints(1);

        LeagueTeam<FootballTeam> ligaPilki= new LeagueTeam("pilka");
        ligaPilki.addTeam((FootballTeam) stall0);//bo ograniczenie nie można dodać trzeba castowac
        ligaPilki.addTeam((FootballTeam) stall1);
        ligaPilki.addTeam(stall2);
        ligaPilki.addTeam(stall3);
        System.out.print(ligaPilki.toString());

        Team resovia1 = new VolleyballTeam();
        Team resovia2= new VolleyballTeam();
        VolleyballTeam resovia3 = new VolleyballTeam();
        VolleyballTeam resovia4 = new VolleyballTeam();

        resovia1.setName("resovia1");
        resovia1.setPoints(4);
        resovia2.setName("resovia2");
        resovia2.setPoints(22);
        resovia3.setName("resovia3");
        resovia3.setPoints(33);
        resovia4.setName("resovia4");
        resovia4.setPoints(1);

        LeagueTeam<VolleyballTeam> ligaSiatki= new LeagueTeam("siatka");
        ligaSiatki.addTeam((VolleyballTeam) resovia1);// cast na klasę ktora dziedziczy
        ligaSiatki.addTeam((VolleyballTeam) resovia2);
        ligaSiatki.addTeam(resovia3);
        ligaSiatki.addTeam(resovia4);
        System.out.print(ligaSiatki.toString());

        //ligaSiatki.addTeam((VolleyballTeam) stall0);// ograniczenia ale dalej problemy z rzutowaniem bo te klasy mają wspolengo przodka a to nie wystrcza

        System.out.println("--="+ " League " + ligaPilki.getName() +" =--");
        for (Object object : ligaPilki.getTeams()) {
            System.out.println( ((Team)object).getName() +" "+ ((Team)object).getPoints() );
        }

        System.out.println("--="+ " League " + ligaPilki.getName() +" =--");
        for (FootballTeam team : ligaPilki.getTeams()) {//bo mmamy zaweżenie
            System.out.println( team.getName() +" "+ team.getPoints() );
        }

        System.out.println("==========STREAM=========");
        System.out.println("--= steam teams =--");
        ligaPilki.getTeams().stream()
                .forEach(xxx -> System.out.println(xxx.getName()));//xxx poszczegolny elenent strumienia

        System.out.println("--= mapping teams to names =--");
        ligaPilki.getTeams().stream()
                .map(xxx -> xxx.getName())
                .forEach(xxx -> System.out.println(xxx));// funkcja lambda

        System.out.println("--= mapping teams to names v2 =--");
        ligaPilki.getTeams().stream()
                .map(xxx -> xxx.getName())
                .forEach(System.out::println);//inny zapis bezpośrednio wywłujemy obiekt

        System.out.println("--= mapping teams to names v2 =--");
        ligaPilki.getTeams().stream()
                .map(Team::getName)//inny zapis ala C++
                .forEach(System.out::println);//inny zapis

        System.out.println("--= mapping teams to names where points above 10 =--");
        ligaPilki.getTeams().stream()
                .filter(xxx -> xxx.getPoints() >10)
                .map(Team::getName)//inny zapis ala C++
                .forEach(System.out::println);//inny zapis

        //kopiowanie
        System.out.println("--= Leauge copy where points above 10 =--");
        List<FootballTeam> teamCopy =ligaPilki.getTeams().stream()
                .filter(xxx -> xxx.getPoints() >10)
                .collect(Collectors.toList());//kopiujemy ze steama do lity//operacja konczaca
        teamCopy.stream()//tu wypisujemy listę skopiowaną
                .forEach(System.out::println);//operacja koncząca
        List<FootballTeam> teamCopy2 = ligaPilki.getTeams();//tworzymy drugą listę
        //laczenie strumieni
        List<FootballTeam> teamConcat =
                Stream.concat(teamCopy.stream(), teamCopy2.stream())//laczenie
                .collect(Collectors.toList())
                        .stream()//dlej otwieramy strumień
                        .collect(Collectors.toList());
                //strumien zakonczony, mmamy listę drużyn
        //laczenie strumieni v2
        List<FootballTeam> teamConcat2 = Stream.of(teamCopy,teamCopy2)//inne laczenie
                .flatMap(Collection::stream)//splaszczamy dwa strumienie
                .collect(Collectors.toList());
        //lista nazw z listy druzyn
        List<String> teamName=teamConcat2.stream()
                .map(Team::getName)
                .collect(Collectors.toList());
        System.out.println();
        for (String s : teamName) {
            System.out.println(s);
        }
        Set<String> teamNameSet=teamConcat2.stream()//na secie
                .map(Team::reciveName)
                .collect(Collectors.toSet());
        System.out.println();
        teamNameSet.stream().forEach(System.out::println);//wyswitlania

        // z metody wyswietlajacej steamem
        System.out.println("");
        ligaPilki.printTableBySteam();

        int sumPoints= ligaPilki.getTeams().stream()
                .map(Team::getPoints)//przeksztalcamy na strumien punktow
                .reduce(0,Integer::sum);////zakonczenie sumowanie
        long countElements= ligaPilki.getTeams().stream()
                .count();//sumowanie elemntow w strumieniu
        double countElements2 = ligaPilki.getTeams().stream()
                .filter(yyy -> yyy.getPoints()<22)//filtrowanie elementów z wyrażeniem lambda
                .count();

        ///suma punktow ze wszystkich druzyn
        //gdzie druzyna ma conajmnie  10 punktow

        List<Integer> listaPunktow1 = ligaPilki.getTeams().stream()
                .map(Team::getPoints).collect(Collectors.toList());
        List<Integer> listaPunktow2 = ligaSiatki.getTeams().stream()
                .map(Team::getPoints).collect(Collectors.toList());
        int sumaAll = Stream.concat(listaPunktow1.stream() ,listaPunktow2.stream())
                .filter(x->x>=10)
                .reduce(0,Integer::sum);


        //Integer nazwa to wapper tego obiektowego przedsrtawienia typu prostego
        Integer max = ligaPilki.getTeams().stream()
                .mapToInt( xxx -> xxx.getPoints())
                .max()
                .orElse(new Integer(0));//optional max zwraca

        Team teamExpected = ligaPilki.getTeams().stream()
                .max(Comparator.comparing(Team::getPoints))//zwraca elemnt z maksymalną liczbą punktów
                .orElseThrow(NoClassDefFoundError::new);//optional zwracający wyjątek

        Integer max2= ligaPilki.getTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .map(Team::getPoints)
                .orElseThrow(NoClassDefFoundError::new);

        System.out.println("max: "+max+" "+max2+" "+teamExpected.getPoints());

        Optional<Integer> max3=ligaPilki.getTeams().stream()//oczekuje optional
                .max(Comparator.comparing(Team::getPoints))
                .map(Team::getPoints);//zwraca optional
        if(max3.isPresent()) System.out.println("max: " + max3);//sprawdzanie w optionalu

        //int countInt = 3;
        //
        //IntStream.range(0,countInt).forEach(index -> result.add(products.get(index)));
    }
}
