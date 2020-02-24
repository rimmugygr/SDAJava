package tdd;

import java.util.UUID;

public class Genereted {
    private String preGen;
    private int numberPart;
    {
        preGen= UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
        numberPart=0;
    }
    public String generate(){
        String result = preGen;
        System.out.print (result+=getPrefix());
        System.out.println(" "+Integer.parseInt(result.substring(32)) );
        return result;
    }

    private String getPrefix(){
        String result = String.valueOf(numberPart++);
        while (result.length()<9) result="0"+result;
        return result;
    }
}
