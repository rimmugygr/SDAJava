package patterns.behavior.interator;

public class Test {
    public static void main(String[] args) {
        Peyment[] peyments = {
                new Peyment("aaa"),
                new Peyment("bbb"),
                new Peyment("ccc")
        };
        PeymentList peymentList = new PeymentList(peyments);
        MyIterator<Peyment> peymentMyIterator = peymentList.interator();
        System.out.println("lista :");
        while (peymentMyIterator.hasNext()){
            Peyment currentPayment = peymentMyIterator.next();
            System.out.println(currentPayment.getName());
        }
    }
}
