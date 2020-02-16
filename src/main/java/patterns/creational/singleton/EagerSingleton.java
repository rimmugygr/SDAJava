package patterns.creational.singleton;

/**
 * pole na starcie inicjalizowane obiektem klasy
 * dostêp do obiektu w jednym egzemplarzu gdy¿
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){
        System.out.println("Create EagerSingleton");
    };

    public static EagerSingleton getInstance(){
        System.out.println("Call for EagerSingleton");
        return instance;
    }

}
