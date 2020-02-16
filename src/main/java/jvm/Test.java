package jvm;

public class Test {
    private final String i;// ="aaa";//1 wariant

    public Test() {
        this.i="aaa";//2 wariant
    }

    public static void main(String[] args) {
        String ala= "kot";//constatnt pool // string is immutable
        String basia = "kot";//constatnt pool
        ala.replace('k','a');//tworzy nowy obiekt i go zmienia
        System.out.println(ala);
        System.out.println(basia);
        ala=ala.replace('k','a');//tworzy nowy obiekt i go zmienia i przypisuje
        System.out.println(ala);
        System.out.println(basia);

        String kasia= new String("kot");



        User user = new User("aaa","bbb");





















    }


}
/**
 * //Stringi, czas, data s¹ immutable
 * Immutable: //gwarantuje ze zmianny tworz¹ nowy obiekt
 * -constant pool - cache
 * -security
 * -thread safety
 *
 *
 * String is final
 *
 *
 * Immutable for class:
 * class final //nie dziedziczy
 * pool private
 * pool final//zabezpiecza przed zmian¹
 * not set
 *
 *
 *
 *
 *
 * final:
 * zmienna
 * pole
 * klasa
 * metoda
 * parametr
 *
 */