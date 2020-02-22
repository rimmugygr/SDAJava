package programing1.person_collections_sort;

import java.util.ArrayList;
import java.util.List;

public class Race implements Comparable<Race> {
    private String raceName;
    private List<Person> drivers;
    private int minimumAge;
    private int raceYear;

    public Race(String raceName,  int minimumAge) {
        this.raceName = raceName;
        this.drivers = new ArrayList<>();
        this.minimumAge = minimumAge;
    }

    public boolean addDriver(Person driver) {
        if ( driver.getAge()>=this.minimumAge && !isDriverOnList(driver) ){
            this.drivers.add(driver);
            return true;
        }
        System.out.println(driver.getName()+" za mlody lub juz jest");
        return false;
    }

    private boolean isDriverOnList(Person driver){
        return drivers.indexOf(driver) >=0;
    }

    public boolean removeDriver(Person driver) {
        if (this.drivers.contains(driver)){
            this.drivers.remove(driver);
            return true;
        }
        System.out.println(driver.getName()+" nie ma takiego kierowcy na liscie");
        return false;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public List<Person> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Person> drivers) {
        this.drivers = drivers;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getRaceYear() {
        return raceYear;
    }

    public void setRaceYear(int raceYear) {
        this.raceYear = raceYear;
    }

    public String toStringDrivers(){
        String value="";
        for(Person p:this.drivers){
            value +=p.getName()+", ";
        }
        return value;

    }

    @Override
    public String toString() {
        return
                "raceName='" + raceName + '\'' +
                ", raceYear=" + raceYear +
                ", minimumAge=" + minimumAge +
                 ", drivers= "+ toStringDrivers();
    }

    @Override
    public int compareTo(Race o) {
        return o.getMinimumAge()-minimumAge;
    }


}
