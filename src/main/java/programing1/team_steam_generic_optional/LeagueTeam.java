package programing1.team_steam_generic_optional;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueTeam<T extends Team> {// T typ generyczny
    private String name;
    private List<T> teams;// Ttyp generyczny

    public LeagueTeam(String name) {
        this.name = name;
        this.teams= new ArrayList<>();
    }

    public List<T> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team){// T typ generyczny
        if(!teams.contains(team)){
            System.out.println("dodaje "+ team.getName() );//custowanie na obiekt Team nie trzeba
            this.teams.add(team);
            return true;
        }
        System.out.println(team.toString() + " juz jest w lidze");
       return false;
    }

    @Override
    public String toString() {
        String xxx = " --= League " + this.name + " =-- \n";
        Collections.sort( teams);
        for(T t:teams){//T typ generyczny
            xxx+="Team: "+ t.getName() + " points: " + t.getPoints()+ "\n";//custowanie na obiekt Team nie potrzeba
        }

        return xxx;
    }

    public void printTableBySteam(){
        System.out.println("---= Strumien Sortowanie Tabela " + this.name + " =---");
        teams.stream()
                .sorted()
                .forEach(yyy-> System.out.println(yyy.getName()+" "+yyy.getPoints()));
                //.forEach(System.out::println);
    }
}
