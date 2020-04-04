package programing2.Wallet;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        Cash smallMoney = new Cash((double) 543);
        Cash bigMoney = new Cash((double) 678);
        Cash mediumMoney =  new Cash((double) 765);

        Person adolf = new Person("Adolf","Kowalski");
        adolf.addMoney(mediumMoney);

        Person jozef = new Person("Jozef","Kowalski");
        jozef.addMoney(bigMoney);


        logger.info(adolf.toString());
        logger.info(jozef.toString());

        //transaction
        Person.transaction(jozef,adolf,smallMoney);

        logger.info(adolf.toString());
        logger.info(jozef.toString());

    }
}
