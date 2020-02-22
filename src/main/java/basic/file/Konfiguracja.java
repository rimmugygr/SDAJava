package basic.file;


import java.io.*;
import java.util.Properties;

public class Konfiguracja {
    public static void main(String[] args) {

        Properties ustawieniaWy = new Properties();
        OutputStream wyjscie = null;
        try {
            wyjscie = new FileOutputStream("app.cfg");
            ustawieniaWy.setProperty("uzytkownik", "admin");
            ustawieniaWy.setProperty("haslo", "123456");
            ustawieniaWy.setProperty("port", "4000");
            ustawieniaWy.store(wyjscie, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (wyjscie != null) {
                try {
                    wyjscie.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        Properties ustawieniaWe = new Properties();
        InputStream wejscie = null;
        try {
            wejscie = new FileInputStream("app.cfg");
            ustawieniaWe.load(wejscie);
            System.out.println(ustawieniaWe.getProperty("uzytkownik"));
            System.out.println(ustawieniaWe.getProperty("haslo"));
            System.out.println(ustawieniaWe.getProperty("port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (wejscie != null) {
                try {
                    wejscie.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
