package patterns.creational;

import patterns.creational.abstract_factory.AFObject1Factory;
import patterns.creational.abstract_factory.AFObject2Factory;
import patterns.creational.abstract_factory.AFObjectFactory;
import patterns.creational.abstract_factory.AFObjectType;
import patterns.creational.bulider.BObject;
import patterns.creational.factory.ObjectFactory;
import patterns.creational.factory.ObjectType;
import patterns.creational.singleton.BillPughSingleton;
import patterns.creational.singleton.EagerSingleton;
import patterns.creational.singleton.LazySingleton;

public class CreationalTest {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>---===Singleton===---<<<<<<<<<<<<<<<<<");
        eagerSingletonTest();
        System.out.println(">>>>>>>>>>>><<<<<<<<<<<<<<<<<");
        lazySingletonTest();
        System.out.println(">>>>>>>>>>>><<<<<<<<<<<<<<<<<");
        billSingletonTest();
        System.out.println(">>>>>>>>>>>>----===Factory===---<<<<<<<<<<<<<<<<<");
        factoryTest();
        System.out.println(">>>>>>>>>>>>----===Abstract=Factory===---<<<<<<<<<<<<<<<<<");
        abstractFactoryTest();
        System.out.println(">>>>>>>>>>>>----===Bulider===---<<<<<<<<<<<<<<<<<");
        buliderTest();





    }

    private static void eagerSingletonTest(){
        EagerSingleton.getInstance();
        System.out.println(EagerSingleton.getInstance().toString());
        EagerSingleton.getInstance();
        System.out.println(EagerSingleton.getInstance().toString());
    }
    private static void lazySingletonTest(){
        LazySingleton.getInstance();
        System.out.println(LazySingleton.getInstance().toString());
        LazySingleton.getInstance();
        System.out.println(LazySingleton.getInstance().toString());
    }
    private static void billSingletonTest(){
        BillPughSingleton.getInstance();
        System.out.println(BillPughSingleton.getInstance().toString());
        BillPughSingleton.getInstance();
        System.out.println(BillPughSingleton.getInstance().toString());
    }

    private static void factoryTest(){
        ObjectType objectType1 =
                ObjectFactory.getObjectType("type1","aaa","bbb",1);
        ObjectType objectType2 =
                ObjectFactory.getObjectType("type2","bbb","ccc",3);
        ObjectType objectType3 =
                ObjectFactory.getObjectType("type3","ccc","yyy",7);
        System.out.println(objectType1);
        System.out.println(objectType2);
        System.out.println(objectType3);
    }

    private static void abstractFactoryTest(){
        AFObjectType objectType1 =
                AFObjectFactory.getObject(new AFObject1Factory("aaa","bbb",2));
        AFObjectType objectType2 =
                AFObjectFactory.getObject(new AFObject2Factory("ccc","ddd",2));
        System.out.println(objectType1);
        System.out.println(objectType2);
    }

    private static void buliderTest(){
        BObject bObject1 =
                new  BObject.BObjectBulider("sdsd","Sds").setParam2(6).setParam3(true).bulid();
        BObject bObject2 =
                new  BObject.BObjectBulider("qwqw","jojo").setParam2(3).bulid();
        BObject bObject3 =
                new  BObject.BObjectBulider("aaaaa","wowowo").bulid();
        System.out.println(bObject1);
        System.out.println(bObject2);
        System.out.println(bObject3);
    }
}
