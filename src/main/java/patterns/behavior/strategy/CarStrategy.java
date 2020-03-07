package patterns.behavior.strategy;

public class CarStrategy implements TravelStrategy {
    private boolean includePaidMotorways;
    private boolean includeGroundRoads;

    public CarStrategy(boolean includePaidMotorways, boolean includeGroundRoads) {
        this.includePaidMotorways = includePaidMotorways;
        this.includeGroundRoads = includeGroundRoads;
    }

    @Override
    public void setTravelPlan(String from, String to) {
        StringBuilder result = new StringBuilder("Traveling in car from ")
                .append(from)
                .append(" to ")
                .append(to)
                .append(includeGroundRoads ? " ground roads allowed" : "")
                .append(includePaidMotorways? " paid motorways allowed":"");
        System.out.println(result);
    }
}
