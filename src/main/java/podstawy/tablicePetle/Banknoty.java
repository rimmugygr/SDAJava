package podstawy.tablicePetle;

import java.util.Arrays;

public class Banknoty {
    private int[] tablicaNominalow;
    private int[] tablicaBanknotow;
    Banknoty(){
        int[]tablicaNominalow={200,100,50,20,10,5,2,1};
        int[]tablicaBanknotow={0,0,0,0,0,0,0,0};
        this.tablicaNominalow=tablicaNominalow;
        this.tablicaBanknotow=tablicaBanknotow;
    }
    Banknoty(int[]tablicaNominalow,int kwota){
        int[] tablicaBanknotow=new int[tablicaNominalow.length];
        for (int i=0 ;i<tablicaNominalow.length ;i++ )tablicaBanknotow[i]=0;

        this.tablicaNominalow=tablicaNominalow;
        this.tablicaBanknotow=tablicaBanknotow;

        this.nowaKwota(kwota);
    }

    public int nowaKwota(int kwota){

        for(int i=0;i<this.tablicaBanknotow.length;i++){
            this.tablicaBanknotow[i]=kwota/tablicaNominalow[i];
            kwota=kwota%tablicaNominalow[i];
        }

        return kwota;
    }



    @Override
    public String toString() {

        return "\nNominaly=\n" + Arrays.toString(tablicaNominalow) +
                ", \nBanknoty=\n" + Arrays.toString(tablicaBanknotow) ;
    }
}
