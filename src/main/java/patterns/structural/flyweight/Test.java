package patterns.structural.flyweight;

public class Test {
    public static void main(String[] args) {
        FordMustang fordMustang1 = new FordMustang("dupa","duzy");
        FordMustang fordMustang2 = new FordMustang("dupa","mala");
        FordMustang fordMustang3 = new FordMustang("onet","mala");

        System.out.println(fordMustang1.toString());
        System.out.println(fordMustang2.toString());
        System.out.println(fordMustang3.toString());
    }
}
