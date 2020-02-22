package programing1.simpleIO;

public class DataStorage {
    private static int count =0;
    private int index=0;
    private String Data1;
    private String Data2;



    public DataStorage( String data1, String data2) {
        index=count++;
        Data1 = data1;
        Data2 = data2;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData1() {
        return Data1;
    }

    public void setData1(String data1) {
        Data1 = data1;
    }

    public String getData2() {
        return Data2;
    }

    public void setData2(String data2) {
        Data2 = data2;
    }
}
