package basic.klasyObiekty.zad3;

public class Bike extends Vehicle {

    private String data;


    Bike(String marka, String data){
       setMarka(marka);
        this.data=data;
    }

    public String getData() {
        return data;
    }



    @Override
    public String toString() {
        return "Bike{" +
                "marka='" + getMarka() + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
