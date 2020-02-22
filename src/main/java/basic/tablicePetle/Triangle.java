package basic.tablicePetle;

public class Triangle {
    private double a;
    private double b;
    private double c;
    Triangle(){
        this.defaultValue();
    }
    Triangle(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    private void defaultValue(){
        a=4;b=3;c=5;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
