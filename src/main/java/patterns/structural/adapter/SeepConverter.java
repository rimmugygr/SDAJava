package patterns.structural.adapter;

public enum SeepConverter {
    MILES_TO_KILOMETRS(1.609344),
    KILOMETRES_TO_MILES(0.6213712);

    private double converter;

    SeepConverter(double converter) {
        this.converter = converter;
    }

    public  double getConverter(){
        return converter;
    }
}
