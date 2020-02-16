package patterns.creational.abstract_factory;

public abstract class AFObjectType {
    public abstract String getName();
    public abstract String getParam1();
    public abstract int getParam2();

    @Override
    public String toString() {
        return "ObjectType{ "+
                this.getName()+" " +
                this.getParam1()+" " +
                this.getParam2()+" }";
    }
}
