package programing2.Wallet;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        Person adolf = new Person("Adolf","Kowalski");
        adolf.addMoney(100);

        Person jozef = new Person("Jozef","Kowalski");
        jozef.addMoney(200);


        logger.info(adolf.toString());
        logger.info(jozef.toString());

        //transaction
        adolf.removeMoney(50);
        jozef.addMoney(50);

        logger.info(adolf.toString());
        logger.info(jozef.toString());

    }
}
