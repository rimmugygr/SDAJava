package programowanie1.simpleIO;

public class Varargs {

    public static void main(String[] args) {
        System.out.println(Varargs.varargsSum(3,3));
        System.out.println(Varargs.varargsSum(3,3,222));
        System.out.println(Varargs.varargsSum(3,3,2,2,2,2,2));
        System.out.println(Varargs.varargsSum(3));
        System.out.println(Varargs.varargsSum(3,3,2,22,2,2,2,2,2,22,2,2,2,2,2,2));

    }
    public static final int varargsSum(int a, int ...b){
        int suma=a;
        for (int i = 0; i < b.length ; i++) {
            suma+=b[i];
        }
        return suma;
    }
}
