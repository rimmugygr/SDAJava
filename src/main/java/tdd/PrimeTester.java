package tdd;

public class PrimeTester {
    public static boolean isPrimeTest(int number){
               if(number<2)return false;
        for (int i = 2; i < number; i++) {
            if(number%i==0) return false;

        }
        return true;
    }
}
