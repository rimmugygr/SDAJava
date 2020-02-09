package programowanie1.threads.bank;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InputFile {


    public static final Map<Integer,List<String>> reaWithBufferedReader(String nameFile){
        Map<Integer,List<String>> dataFileMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){

            Integer numberLine=0;
            String input;
            String filedSepartor = "|";
            while ((input=reader.readLine())!=null){//wczytuje puki jest następna linia
                List<String> listLine = new ArrayList<String>(Arrays.asList(input.split(filedSepartor)));//dzelimy linie na pola
                dataFileMap.put(numberLine++,listLine);
            }


            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return dataFileMap;
    }
}
