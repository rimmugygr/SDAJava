package programowanie1.bank_file;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InputFile {
    private static Map<Integer, List<String>> dataFileMap = new HashMap<>();

    private static final void read1LineFile(String nameFile){

        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){
            Integer numberLine=0;
            String input;
            String filedSepartor = ":::";
            while ((input=reader.readLine())!=null){//wczytuje puki jest następna linia
                dataFileMap.put(numberLine++,Arrays.asList(input.split(filedSepartor)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read2LineFile(String nameFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){
            Integer numberLine=0;
            String input;
            String filedSepartor = ":::";
            List<String> stringOldLine = new ArrayList<>();
            List<String> stringsActualLine = new ArrayList<>();

            //init
            input = reader.readLine();
            stringOldLine.addAll(Arrays.asList(input.split(filedSepartor)));

            //petla
            while ((input = reader.readLine())!=null){
                stringsActualLine.clear();//czyscimy smieci
                stringsActualLine.addAll(Arrays.asList(input.split(filedSepartor)));//1linia


                if(stringsActualLine.get(0).equals("O")||stringsActualLine.get(0).equals("R")//przypadek 2 lini
                        ||stringsActualLine.get(0).equals("P")||stringsActualLine.get(0).equals("T")){
                    List<String> lineString = new ArrayList<>();//dodajemy 2 linie
                    lineString.addAll(stringOldLine);
                    lineString.addAll(stringsActualLine);
                    dataFileMap.put(numberLine++,lineString);

                    System.out.println(stringOldLine+"1if");
                    stringOldLine.clear();
                    stringOldLine.addAll(stringsActualLine);
                   continue;
                }

                if(!(stringOldLine.get(0).equals("O")||stringOldLine.get(0).equals("R")//przypadek 1 lini
                        ||stringOldLine.get(0).equals("P")||stringOldLine.get(0).equals("T"))) {
                    List<String> lineString = new ArrayList<>();//dodajemy 1 linie
                    lineString.addAll(stringOldLine);
                    dataFileMap.put(numberLine++, lineString);//przypadek 1 lini, brak 2 lini
                    System.out.println(stringOldLine+"2if");
                }
                stringOldLine.clear();
                stringOldLine.addAll(stringsActualLine);
            }
            // przypadek gdzie 1 linia koczy sie plik
            if(!(stringsActualLine.get(0).equals("O")||stringsActualLine.get(0).equals("R")//przypadek 1 lini
                    ||stringsActualLine.get(0).equals("P")||stringsActualLine.get(0).equals("T"))) {
                List<String> lineString = new ArrayList<>();//dodajemy 1 linie
                lineString.addAll(stringsActualLine);
                dataFileMap.put(numberLine++, lineString);//przypadek 1 lini, brak 2 lini
                System.out.println(stringsActualLine+"end");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Map.Entry<Integer, List<String>> integerListEntry : dataFileMap.entrySet()) {
            System.out.println(integerListEntry.getKey()+" "+integerListEntry.getValue());
        }

    }

    public static final List<Client> getClientFromFile1Line(String fileName){
        read1LineFile(fileName);
        List<Client> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> lineFile : dataFileMap.entrySet()) {
            Client client = listToClient(lineFile.getValue());
            result.add(client);
        }
        return result;
    }

    public static final List<Client> getClientFromFile2Line(String fileName){
        read2LineFile(fileName);
        List<Client> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> lineFile : dataFileMap.entrySet()) {
            Client client = listToClient(lineFile.getValue());
            result.add(client);
        }
        return result;
    }



    private static Client listToClient(List<String> listString){
        Client client = new Client(listString.get(1),listString.get(2),listString.get(0));
        for (int i = 3; i < listString.size(); i+=2) {
            Account account = new Account(listString.get(i));
            account.payIn(Double.parseDouble(listString.get(i+1)));
            client.addAccount(account);
        }
        return client;
    }

    public static final String viewFile(){
        String result = "";
        for (Map.Entry<Integer, List<String>> client : dataFileMap.entrySet()) {
            result+=client.getKey()+" "+client.getValue()+"\n" ;
        }
        return result;
    }
}
