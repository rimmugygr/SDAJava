package patterns.behavior.interator;

public interface MyIterator<E extends Object> {
    E next();
    E current();
    boolean hasNext();
}
