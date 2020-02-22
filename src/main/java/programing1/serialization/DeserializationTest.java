package programing1.serialization;

import java.io.*;

public class DeserializationTest {
    public static void main(String[] args) {
        Person person= null;
        try {
            FileInputStream fileInputStream = new FileInputStream("PersonSerialized.data");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            person=(Person) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(person.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
