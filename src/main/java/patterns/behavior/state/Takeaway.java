package patterns.behavior.state;

public class Takeaway implements FlightState {
    private static Takeaway instance = new Takeaway();

    private Takeaway(){

    }

    public static Takeaway getInstance() {
        return instance;
    }

    @Override
    public void updateState(Flight flight) {
        System.out.println("takeaway");
        flight.setFlightState(Flying.getInstance());
    }
}
