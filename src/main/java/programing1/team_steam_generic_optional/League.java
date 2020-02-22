package programing1.team_steam_generic_optional;


import java.util.*;

public class League {
    private String name;
    private List<Team> teams;

    public League(String name) {
        this.name = name;
        this.teams= new ArrayList<>();
    }

    public boolean addTeam(Team team){
        if(!teams.contains(team)){
            System.out.println("dodaje "+ team.toString() +" do ligi "+this.name);
            this.teams.add(team);
            return true;
        }
        System.out.println(team.toString() + " juz jest w lidze");
       return false;
    }

    @Override
    public String toString() {
        String xxx = " --= League " + this.name + " =-- \n";
        Collections.sort(teams);
        for(Team t:teams){
            xxx+=t.toString() +"\n";
        }

        return xxx;
    }

    public void setName(String name) {
        this.name = name;
    }
}
