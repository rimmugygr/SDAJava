package programing1.simpleIO;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadWriteFile {
    public static final boolean simpleWriteToFile(){
        try{
            FileWriter fileWriter = new FileWriter("xxx.txt");
            fileWriter.write("aaaaa\n");
            fileWriter.write("bbbbb\n");
            fileWriter.close();//!!!!!!!!!!!!!!!
            return true;
        }catch (IOException c){
            System.out.println(c.getMessage());
        }
        return false;
    }
    public static final boolean writeToFileWithResources() {
        final String lineDelimiter="\n";
        // w nazwiasach tworzymy zasoby, one się automatycznie zamykaja
        // gdy się nie uda utworzyć to cały try się nie uruchamia w ogóle
        // java 7
        try(FileWriter fileWriter = new FileWriter("yyy.txt")) {//try resources
            fileWriter.write("aaaa"+lineDelimiter);
            fileWriter.write("bbbb"+lineDelimiter);
            fileWriter.write("cccc");
            return true;
        } catch (IOException e){
            e.printStackTrace();
        } catch (ArithmeticException e){
            System.out.println("Bład w obliczniach");
        }
        return false;
    }

    public static final boolean readFileSample(){
        String fileName="xxx.txt";
        File file = new File(fileName);// obiekt pliku, jest nowszy
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(file.getName()));//FileReader potrzebuje stringu nazwy
            scanner.useDelimiter("\n");
            System.out.println("Reading file : " + fileName);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("End file.");
            return true;
        } catch (FileNotFoundException e){
            //java 1.7 można kilka wyjatków obsłużyć w jednym catchu
        //} catch (FileNotFoundException | Exception e) {
            //metoda(e);
            System.out.println("nie ma pliku");
            e.printStackTrace();
        }
        return false;
    }

    /***
     * Z bufferem i zwraca wyjatek w metodzie który trzeba na zewnątrz obsłużyć
     * @param dataToWrite lista
     * @return
     * @throws IOException
     */
    public static final boolean writeWithBufferedWriter(List<DataStorage> dataToWrite, String nameFile) throws IOException{
        String fieldSeparator=",";
        String lineSeparator=";\n";
        BufferedWriter file = new BufferedWriter(new FileWriter(nameFile));
        for (DataStorage storage : dataToWrite) {
            file.write(storage.getIndex() + fieldSeparator+
                    storage.getData1()+fieldSeparator+
                    storage.getData2()+lineSeparator);

        }
        file.close();
        return false;
    }

    public static final Map reaWithBufferedReader(String nameFile){
        Map<Integer,DataStorage> dataStorageMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){
            String input;
            String filedSepartor = ",";
            while ((input=reader.readLine())!=null){//wczytuje puki jest następna linia
                String[] dataLine=input.split(filedSepartor);//dzelimy linie na pola
                DataStorage storage=new DataStorage(dataLine[1],dataLine[2]);//tworzymy obiekt
                dataStorageMap.put(Integer.parseInt(dataLine[0]),storage);//dodajmy do mapy
            }
            return dataStorageMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataStorageMap;
    }





}
