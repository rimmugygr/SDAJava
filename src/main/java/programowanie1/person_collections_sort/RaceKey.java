package programowanie1.person_collections_sort;

public class RaceKey {
   private String raceName;
   private int raceYear;

    public RaceKey(String raceName, int raceYear) {
        this.raceName = raceName;
        this.raceYear = raceYear;
    }

    @Override
    public String toString() {
        return  raceName + " " + raceYear;
    }
}
