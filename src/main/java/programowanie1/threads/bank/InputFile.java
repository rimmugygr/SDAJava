package programowanie1.threads.bank;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputFile {
    private static Map<String,String> dataFileMap = new HashMap<>();

    public static final Map reaWithBufferedReader(String nameFile){
        

        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){
            String input;
            String filedSepartor = "|";
            while ((input=reader.readLine())!=null){//wczytuje puki jest następna linia
                String[] dataLine=input.split(filedSepartor);//dzelimy linie na pola
                for (String s : dataLine) {

                }
                DataStorage storage=new DataStorage(dataLine[1],dataLine[2]);//tworzymy obiekt
                dataFileMap.put(Integer.parseInt(dataLine[0]),storage);//dodajmy do mapy
            }
            return dataFileMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFileMap;
    }
}
