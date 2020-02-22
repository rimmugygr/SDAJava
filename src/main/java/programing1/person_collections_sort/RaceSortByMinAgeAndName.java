package programing1.person_collections_sort;

import java.util.Comparator;

public class RaceSortByMinAgeAndName implements Comparator<Race> {
    @Override
    public int compare(Race r1, Race r2) {
        if(r1.getMinimumAge() - r2.getMinimumAge() !=0)
            return r1.getMinimumAge() - r2.getMinimumAge();
        return r1.getRaceName().compareTo(r2.getRaceName());
    }
}
