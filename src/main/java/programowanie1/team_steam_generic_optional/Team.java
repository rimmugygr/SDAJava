package programowanie1.team_steam_generic_optional;

public abstract class Team implements Comparable<Team>{
    private String name;
    private int points;
    {
        points=0;
    }
    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    //komentarz do
    /**
     * use reciveName method
     * @return team name
     */
    @Deprecated //oznacza że przestarzałe
    public String getName() {
        return name;
    }

    public String reciveName() { return name;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team: "+ name + " points: " + points ;
    }

    @Override
    public int compareTo(Team team) {
        return this.points - team.points;
    }
}
