package basic;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class SteamClass
{
    public static void main(String[] args) {
        Dieta warzywna = new Dieta("warzywna", 1000);
        Dieta wywazona = new Dieta("wyważona", 2200);
        Dieta naMase = new Dieta("Na masę", 3500);
        List<Dieta> diety = new ArrayList<>();
        diety.add(warzywna);
        diety.add(wywazona);
        diety.add(naMase);
        List<Dieta> zdroweDiety = diety.stream()
                .filter(dieta -> dieta.podajLiczbeKalorii() < 2500)
                .collect(Collectors.toList());
        for (Dieta dieta: zdroweDiety) {
            System.out.println(dieta.podajNazwe());
        }
    }
}
