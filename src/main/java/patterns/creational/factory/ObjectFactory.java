package patterns.creational.factory;

public class ObjectFactory {
    public static ObjectType getObjectType(String type,String name,String param1,int param2){
        if ("type1".equalsIgnoreCase(type))
            return new Object1(name, param1, param2);
        else if ("type2".equalsIgnoreCase(type))
            return new Object2(name, param1, param2);
        return null;
    }
}
