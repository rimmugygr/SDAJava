package podstawy.watki.company;

import java.util.concurrent.Callable;

public class Employee implements Runnable{
    private static final int MAX_SUM = 10;

    public static int companyCash;
    private String name;
    private int delay;
    private int amountMoney;
    private boolean goHome;


    {
        amountMoney=0;
        companyCash=0;
        goHome=false;
    }

    public Employee(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Employee " +
                "name='" + name;
    }

    public void setGoHome(boolean goHome) {
        this.goHome = goHome;
    }

    @Override
    public void run() {
        while(this.amountMoney<MAX_SUM&&this.goHome==false) {
            amountMoney++;
            companyCash++;
            System.out.println(this.name + " wypracowal " + this.amountMoney + "$");

            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(this.name + " idzie do domu i zarobił : "+ this.amountMoney +" FIRMA MA : " + Employee.companyCash);

    }



}
