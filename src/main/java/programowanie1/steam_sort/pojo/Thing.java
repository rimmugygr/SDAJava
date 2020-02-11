package programowanie1.steam_sort.pojo;

import java.util.ArrayList;
import java.util.List;

public class Thing {
    private String name;
    private String pesel;
    private int age;

    public Thing(String name, String pesel, int age) {
        this.name = name;
        this.pesel = pesel;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Thing>init(){
        List<Thing> result=new ArrayList<>();
        result.add(new Thing("aaa","bbb",5));
        result.add(new Thing("kkk","xxx",6));
        result.add(new Thing("fff","ccc",7));
        result.add(new Thing("kkk","vvv",2));
        result.add(new Thing("hhh","vvv",2));
        return result;
    }

    public void view(){
        System.out.println(this.toString());
    }

    public  boolean isOlderThan5(){
        return this.age>5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
