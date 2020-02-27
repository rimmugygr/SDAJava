package programing1.threads.producer_consumer;

import java.util.HashMap;
import java.util.Map;

public class ResaultBuffer {
    private Map<String,Integer> map = new HashMap<>();

    public synchronized void procces(String name) {
        int counter=0;
        if(map.containsKey(name)){
            counter=map.get(name);
        }
        counter++;
        map.put(name,counter);
    }

    public void printResult(){
        System.out.println("Result: " + map.toString());
    }
}
