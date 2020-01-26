package programowanie1.person_collections_sort;

import java.util.Comparator;

public class RaceSortByNameAndRacerNumber implements Comparator<Race> {


    @Override
    public int compare(Race race1, Race race2) {
        if(race1.getRaceName().compareTo(race2.getRaceName())!=0)
            return race1.getRaceName().compareTo(race2.getRaceName());
        return race1.getDrivers().size()-race2.getDrivers().size();

    }
}
