package programing1.person_collections_sort;


import org.apache.log4j.Logger;

import java.util.*;

public class Main {
    protected final static Logger LOGGER= Logger.getLogger(Main.class);

    public static void main(String[] args) {

//        Person janek=new Person();
//        janek.setAge(77);
//        janek.setFirstName("aaa");
//        janek.setLastName("bbb");
//        janek.setSex("men");
//
//        Person aneta=new Person("aaa","bbbc",44,"women");
//        System.out.println(janek.toString()+" emeryt:"+janek.isRetired());
//        System.out.println(aneta.toString()+" emeryt:"+aneta.isRetired());

        Polish wlodek=new Polish("xxx","yyy",26,"M",4,"23123123");
        System.out.println(wlodek.toString()+" emeryt:"+wlodek.isRetired()+" karta:"+wlodek.enabledKDR());

        Polish anta = new Polish("aaa","bbb",44,"W",5,"1234567" );
        System.out.println(anta.toString()+" emeryt:"+anta.isRetired()+" karta:"+anta.enabledKDR());

        English john=new English("ccccc","dddddd",30,"M","abs12345");
        System.out.println(john.toString()+" emeryt:"+john.isRetired()+" prawo jazdy:"+john.isDrivingLicense());

        Race rajdDakkar  = new Race("Dakkar",20);
        rajdDakkar.addDriver(wlodek);
        rajdDakkar.addDriver(anta);
        rajdDakkar.addDriver(john);
        System.out.println(rajdDakkar.toString());


        Race rajdLol = new Race("Dakkar",20);
        Race rajdLo2 = new Race("3lol2",20);
        Race rajdLo3 = new Race("2lol3",20);
        Race rajdLo4 = new Race("1lol4",33);
        rajdDakkar.setRaceYear(2018);
        rajdLol.setRaceYear(2019);
        rajdLo2.setRaceYear(2019);
        rajdLo3.setRaceYear(2019);
        rajdLo4.setRaceYear(2020);

        rajdLol.addDriver(john);
        rajdLo2.addDriver(john);

        List<Race> races= new LinkedList<>();
        races.add(rajdDakkar);
        races.add(rajdDakkar);
        races.add(rajdLol);
        races.add(rajdLo2);
        races.add(rajdLo3);
        races.add(rajdLo4);
        System.out.println("\nbez sorotwania");
        for (Race race:races){
            System.out.println(race.toString());
        }
        System.out.println("\nz sorotwaniem po wieku");
        Collections.sort(races);
        for (Race race:races){
            System.out.println(race.toString());
        }
        System.out.println("\nz sorotwaniem po wieku i nazwie");
        Collections.sort(races,new RaceSortByMinAgeAndName());
        for (Race race:races){
            System.out.println(race.toString());
        }
        System.out.println("\nz sorotwaniem nazawie i liczbie zawodnikow");
        Collections.sort(races,new RaceSortByMinAgeAndName());
        for (Race race:races){
            System.out.println(race.toString());
        }

        Set<Race> racesSet= new HashSet ();
        racesSet.add(rajdDakkar);
        racesSet.add(rajdDakkar);//nie dodaje
        racesSet.add(rajdDakkar);//nie dodaje
        racesSet.add(rajdDakkar);//nie dodaje
        racesSet.add(rajdLol);
        racesSet.add(rajdLo2);
        racesSet.add(rajdLo3);
        racesSet.add(rajdLo4);
        System.out.println("\nna secie -----------------");
        for (Race race:races){
            System.out.println(race.toString());
        }

        // String dobry na wartosć klucza gdyż niepowtarzalny
        System.out.println("\nna mapie klucz stringiem----------------- ");
        Map<String,Race> racesMap= new HashMap ();
        racesMap.put(rajdDakkar.getRaceName(),rajdDakkar);
        racesMap.put(rajdDakkar.getRaceName() ,rajdDakkar);//nie dodaje taki sam klucz bo taka sama klasa
        racesMap.put(rajdLol.getRaceName() ,rajdLol);//klucz taki sam w obu kalsachnie dodaje
        racesMap.put(rajdLo2.getRaceName(),rajdLo2);
        racesMap.put(rajdLo3.getRaceName(),rajdLo3);
        racesMap.put(rajdLo4.getRaceName(),rajdLo4);
        System.out.println("\npo wartosci ");
        for (Race race:racesMap.values()){
            System.out.println(race.toString());
        }
        System.out.println("\npo kluczach");
        for (String key:racesMap.keySet()){
            System.out.println(racesMap.get(key).toString());
        }
        //jak nie string to tworzymy nowa klase na klucz
        System.out.println("\nna mapie z klasa na klucze ----------------- ");
        Map<RaceKey,Race> racesMap2=new HashMap<>();
        racesMap2.put(new RaceKey(rajdDakkar.getRaceName(),rajdDakkar.getRaceYear()) , rajdDakkar);
        racesMap2.put(new RaceKey(rajdDakkar.getRaceName(),rajdDakkar.getRaceYear()) , rajdDakkar);//klucz unikalny bo nowa klasa wiec dodaje drugi raz to samo
        racesMap2.put(new RaceKey(rajdLol.getRaceName(),rajdLol.getRaceYear()) , rajdLol);//klucz unikalny bo nowa klasa juz dodaje
        racesMap2.put(new RaceKey(rajdLo2.getRaceName(),rajdLo2.getRaceYear()) , rajdLo2);
        racesMap2.put(new RaceKey(rajdLo3.getRaceName(),rajdLo3.getRaceYear()) , rajdLo3);
        racesMap2.put(new RaceKey(rajdLo4.getRaceName(),rajdLo4.getRaceYear()) , rajdLo4);
        System.out.println("\npo kluczach");
        for (RaceKey raceKey:racesMap2.keySet()){
            System.out.println(racesMap2.get(raceKey).toString());
        }

        Set<Race> setFromlist = new HashSet<>(races);
        LOGGER.error("This is error message");
        LOGGER.warn("This is warnig");
        LOGGER.fatal("This is fatal error");
        LOGGER.debug("This is debug maessage");
        LOGGER.info("This is info message");
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("info po sprawdzeniu");
        }

        Main mainTest = new Main();
        try {
            mainTest.divide(10,0);
        }catch (ArithmeticException ex){
            LOGGER.error("wrong something's", ex);
        }
    }

    private void divide(int a , int b){
        int i = a/b;
    }
}
