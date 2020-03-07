package patterns.behavior.strategy;

public class WalkStrategy implements TravelStrategy {
    private boolean includeTouristPatch;
    private boolean excludesFastRoads;

    public WalkStrategy(boolean includeTouristPatch) {
        this.includeTouristPatch = includeTouristPatch;
        this.excludesFastRoads = true;
    }

    @Override
    public void setTravelPlan(String from, String to) {
        StringBuilder result = new StringBuilder("Traveling on fooot from ")
                .append(from)
                .append(" to ")
                .append(to)
                .append(includeTouristPatch ? " turist patch allowed" : "");
        System.out.println(result);
    }
}
