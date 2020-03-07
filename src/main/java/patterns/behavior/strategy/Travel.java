package patterns.behavior.strategy;

public class Travel {
    private String startPoint;
    private String endPoint;

    public Travel(String startPoint, String endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void setTravelPlan(TravelStrategy plan) {
        plan.setTravelPlan(startPoint,endPoint);
    }
}
