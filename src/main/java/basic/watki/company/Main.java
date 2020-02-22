package basic.watki.company;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Employee aaa=new Employee("aaa",999);//obiekty pracownikow
        Employee bbb=new Employee("bbb",2111);
        Employee ccc=new Employee("ccc",3000);
        Employee ddd=new Employee("ddd",1255);

        List<Employee> pracownicy=new LinkedList<>();///lista kolejnosci
        pracownicy.add(ddd);
        pracownicy.add(ccc);
        pracownicy.add(bbb);
        pracownicy.add(aaa);

        //Menager chief= new Menager("xxx",grupOrder);

        Company tartak=new Company(pracownicy);
        tartak.run();
        Thread.sleep(3222);
        System.out.println("Firma ma w kasie : "+tartak.getCash());




    }
}
