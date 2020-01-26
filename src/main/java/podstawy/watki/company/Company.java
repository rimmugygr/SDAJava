package podstawy.watki.company;

import java.util.List;

public class Company implements Runnable {
    List<Employee> workers;
    private int cash;

    public Company(List<Employee> workers) {
        this.workers = workers;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public void run() {
        System.out.println("poczatek dnia firma ma "+ Employee.companyCash+"$");
        for (Employee e:this.workers) {
            new Thread(e).start();
            System.out.println(e.toString()+ " zaczoł prace FIRMA MA : " + Employee.companyCash);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("koniec dnia firma ma "+ Employee.companyCash+"$");
        for (Employee e:this.workers) {
            e.setGoHome(true);
        }
        this.cash=Employee.companyCash;


    }
}
