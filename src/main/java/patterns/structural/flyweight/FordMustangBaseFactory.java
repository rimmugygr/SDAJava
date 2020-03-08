package patterns.structural.flyweight;

import java.util.HashSet;
import java.util.Set;

public class FordMustangBaseFactory {
    private static Set<FordMustangBase> fordMustangBases = new HashSet<>();

    public static FordMustangBase getFordMustangBases(String color) {
        FordMustangBase fordMustangBase;
        System.out.println(FordMustangBaseFactory.class + " getMustang " + color);
        if(fordMustangBases.size()>0){
            fordMustangBase = fordMustangBases.stream()
                    .filter(f->color.equals(f.getColor()))
                    .findAny()
                    .orElseGet(()->new FordMustangBase(color));//nie wykona się zawsze tak jak .orElse();
        } else {
            fordMustangBase = new FordMustangBase(color);
        }
        fordMustangBases.add(fordMustangBase);
        return fordMustangBase;
    }
}
