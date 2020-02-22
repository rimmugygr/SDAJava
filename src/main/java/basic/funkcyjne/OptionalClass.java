package basic.funkcyjne;

public class OptionalClass {
    public static void main(String[] args) {
        Programista programista = new Programista();
        System.out.println("Nie podaliśmy języka programisty...");
        if(programista.podajGlownyJezyk() != null) {
            System.out.println("Glowny jezyk programisty to : "
                    + programista.podajGlownyJezyk());
        }
        System.out.println("... więc nic się nie wyświetli");
        System.out.println("Chyba, że zastosujemy Optional!");
        System.out.println("Główny język programisty to : "
                + programista.podajGlownyJezykOpt().orElse("Java!"));
    }

}
