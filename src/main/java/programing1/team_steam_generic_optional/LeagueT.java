package programing1.team_steam_generic_optional;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueT<T> {// T typ generyczny
    private String name;
    private List<T> teams;// Ttyp generyczny

    public LeagueT(String name) {
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
            System.out.println("dodaje "+ ((Team)team).getName() );//rzutowanie na obiekt Team żeby miec dostęp na metody z tej klasy
            this.teams.add(team);
            return true;
        }
        System.out.println(team.toString() + " juz jest w lidze");
       return false;
    }

    @Override
    public String toString() {
        String xxx = " --= League " + this.name + " =-- \n";
        Collections.sort((List<Team>) teams);
        for(T t:teams){//T typ generyczny
            xxx+="Team: "+ ((Team)t).getName() + " points: " + ((Team)t).getPoints()+ "\n";//rzutowanie na obiekt Team żeby miec dostęp na metody z tej klasy
        }

        return xxx;
    }
}
