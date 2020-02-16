package patterns.creational.singleton;

public class LazySingleton {

    private static LazySingleton instance;
    private LazySingleton(){
        System.out.println("Inicjalization LazySingleton");
    }

    public static LazySingleton getInstance(){
        System.out.println("Call for LazySingleton");
        if (instance==null){
            System.out.println("Create LazySingleton");
            instance=new LazySingleton();
        }
        return instance;
    }
}
