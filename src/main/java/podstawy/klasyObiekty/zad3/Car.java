package podstawy.klasyObiekty.zad3;

public class Car extends Vehicle{


    private String data;






    Car(String marka, String data){
        setMarka(marka);
        this.data=data;
    }

    public String getData() {
        return data;
    }



    @Override
    public String toString() {
        return "Car{" +
                "marka='" + this.getMarka() + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
