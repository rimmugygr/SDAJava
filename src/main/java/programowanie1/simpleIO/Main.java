package programowanie1.simpleIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)  {


        ReadWriteFile.simpleWriteToFile();
        ReadWriteFile.writeToFileWithResources();
        ReadWriteFile.readFileSample();



        List<DataStorage> storage = new ArrayList<>();
        storage.add(new DataStorage("aaa","xxx"));
        storage.add(new DataStorage("bbb","yyy"));
        storage.add(new DataStorage("ccc","zzz"));

        try{
            ReadWriteFile.writeWithBufferedWriter(storage, "DataList.txt");
        }catch (IOException e){
            e.printStackTrace();
        }

        Map<Integer,DataStorage> content = ReadWriteFile.reaWithBufferedReader("DataList.txt");

        content.values().stream().forEach(s -> System.out.println(s.getIndex()+s.getData1()+s.getData2()));





    }
}
