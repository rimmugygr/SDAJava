package jvm.money;

public class Test {
    public static void main(String[] args) {
        Money a = Money.of("1");
        Money b = Money.zero();

        System.out.println(a);
        System.out.println(b);
        System.out.println(a.add(a));
        System.out.println(a.substract(a));
        System.out.println(a.divide(a));
        System.out.println(a.equals(a));



        System.out.println(a);
        System.out.println(b);
        System.out.println(a.sum(a,a,b));
    }
}
