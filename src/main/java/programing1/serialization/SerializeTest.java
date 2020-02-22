package programing1.serialization;

import java.io.*;

public class SerializeTest {
    public static void main(String[] args) {
        Person person=new Person("aaa","bbb",12);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("PersonSerialized.data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(person);
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
