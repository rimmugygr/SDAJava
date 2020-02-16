package patterns.creational.abstract_factory;

public class AFObjectFactory {
    public static AFObjectType getObject(AFObjectAbstractFactory abstractFactory){
        return abstractFactory.createObject();
    }
}
