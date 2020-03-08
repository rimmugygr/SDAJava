package patterns.behavior.state;

public class Flying implements FlightState {
    private static Flying instance = new Flying();

    private Flying(){
    }

    public static Flying getInstance() {
        return instance;
    }

    @Override
    public void updateState(Flight flight) {
        System.out.println("fly");
    }

}
