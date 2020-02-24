package tdd;

public class Validate {
    public static boolean validatePostCode(String postCode){
        if (postCode == null) return false;//dla null
        if (postCode.matches("0{2}[-]0{3}")) return false;//dla "00-000"
        //return postCode.matches("[0-9]{2}-[0-9]{3}");//gdy dobrze
        return postCode.matches("\\d{2}-\\d{3}");
    }
}
