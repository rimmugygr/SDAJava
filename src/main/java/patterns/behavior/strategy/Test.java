package patterns.behavior.strategy;

public class Test {
    public static void main(String[] args) {
        Travel travel = new Travel("Rzeszow","Krakow");
        travel.setTravelPlan(new WalkStrategy(true));
        travel.setTravelPlan(new CarStrategy(false,false));
        travel.setTravelPlan(new CarStrategy(true,true));
    }
}
