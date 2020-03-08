package patterns.behavior.state;

public class Flight {
    private FlightState flightState;

    public Flight() {
        this.flightState = Onboarding.getInstance();
    }

    public void setFlightState(FlightState flightState) {
        this.flightState = flightState;
    }

    public void update(){
        flightState.updateState(this);
    }


}
