package podstawy.file;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;




public class ZapisOdczyt {
    public static void main(String args[])
            throws FileNotFoundException{

        //// zapis
        PrintWriter zapis = new PrintWriter("dok_tekstowy.txt");
        zapis.println("Przykładowe zdanie");
        zapis.close();

        ////odczyt
        File plik = new File("dok_tekstowy.txt");
        Scanner in = new Scanner(plik);
        String tekst = in.nextLine();
        System.out.println(tekst);

        ///// zapis
        Charset utf8 = StandardCharsets.UTF_8;
        try {
            Files.write(Paths.get("Plik0.txt"), "Brak informacji o kodowaniu ąęźż".getBytes());
            Files.write(Paths.get("Plik1.txt"), "Kodowanie utf-8 ąęźż".getBytes(utf8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }



}
