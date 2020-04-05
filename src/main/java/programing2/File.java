package programing2;

import javax.sound.midi.Patch;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Zadanie
 * Program odczytujący plik i wyświetlający zawartość
 * Program listujący pliki w konkretnym folderze
 * Program wczytujący text od użytkownika i szukający tego tekstu w plikach
 * */
public class File {
    public static void main(String[] args) throws IOException {
/*// //Lista plików w katalogu
//        Path path = Paths.get("/");
//        Files.list(path).forEach(f -> System.out.println(f.getFileName()));
//
////Zapis do pliku
//        Path path = Paths.get("info.log");
//        Files.write(path, "tekst".getBytes());
//        Files.write(path, "tekst".getBytes(), StandardOpenOption.APPEND);
//
////Odczyt pliku linia po linii
//        Path path = Paths.get("plik.txt");
//        Files.lines(path).forEach(line -> System.out.println(line));
//
////Odczyt tekstu
//        Path path = Paths.get("info.log");
//        String tekst = new String(Files.readAllBytes(path));

        Path pathCatalog = Paths.get("./");     // OR "" OR "."
        Files.list(pathCatalog).forEach(System.out::println);

        Path pathFile = Paths.get("Plik.txt");
        System.out.println(Files.lines(pathFile).collect(Collectors.toList()));
        Files.lines(pathFile).forEach(System.out::println);
*/
        String tekst = "sollicitudin";
 //       String regex = "^.*("+tekst+").*$";
       String regex = ""+tekst+"";
        Path pathFile = Paths.get("Plik.txt");
        String target = Files.lines(pathFile).collect(Collectors.toList()).toString();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);

        System.out.println("First match:"+matcher.find());
        System.out.println("Second match:"+matcher.find());
        System.out.println("Third match:"+matcher.find());
        System.out.println("Four match:"+matcher.find());


    }
}
