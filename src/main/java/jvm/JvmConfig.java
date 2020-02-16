package jvm;

public class JvmConfig {
    public static void main(String[] args) {
        System.out.println("Virtual machine: "+System.getProperty("java.vm.name"));
        System.out.println("Home: "+System.getProperty("java.home"));
        System.out.println("Java version: "+System.getProperty("java.version"));
        System.out.println("Vendor: "+System.getProperty("java.vendor"));
        System.out.println("Vendor: "+System.getProperty("java.specification.vendor"));

    }
}
/**
 * Statyczna analiza kodu przez kompilator intelije
 *
 * kod czytelny , nie ma co optymalizowaæ bo to siê zrobi automatycznie w JIT
 *
 * JIT analiza po statystykach , dodatkowy kompilator
 * Java z czasem wykonywania szybsza bp optymalizuje po statystykach
 * na pocz¹tku wolniejsza
 *
 *
 * Pamiêæ:
 *
 * Heap:
 * Pamiêæ Generyczna:
 * Young(eden->survivor)->Old        //->pernament od 11 nie ma
 *
 * Off-Heap:
 * niedostêpna , tu jest stos
 *
 *
 * debug , break poin warukowy -> conditon ->leftclick on break point
 *
 *
 * Garbare collector:
 *
 * stop the wolrd : garbare collektor work there and application stop there
 *
 *
 * Skalarny://przestarza³y
 * sprawdza iloœæ referencji do obiektu // jeœli zero referencji to usuwamy
 *
 * Wektorowy:
 *
 *
 *
 *
 *
 * JVM - flagi
 * Xms - minimum rozmiar pamiêci heap
 * Xmx - maksymalny rozmiar pamiêci heap
 */