package programing1.team_steam_generic_optional;

public class MainT {
    public static void main(String[] args) {


        Team stall0 = new FootballTeam("stall0");
        Team stall1 = new FootballTeam("stall1");
        FootballTeam stall2 = new FootballTeam("stall2");
        FootballTeam stall3 = new FootballTeam("stall2");

        stall0.setPoints(10);
        stall1.setPoints(33);
        stall2.setPoints(22);
        stall3.setPoints(1);

        LeagueT ligaPilki= new LeagueT("pilka");
        ligaPilki.addTeam(stall0);
        ligaPilki.addTeam(stall1);
        ligaPilki.addTeam(stall2);
        ligaPilki.addTeam(stall3);
        System.out.print(ligaPilki.toString());

        Team resovia1 = new VolleyballTeam();
        Team resovia2= new VolleyballTeam();
        VolleyballTeam resovia3 = new VolleyballTeam();
        VolleyballTeam resovia4 = new VolleyballTeam();

        resovia1.setName("resovia1");
        resovia1.setPoints(4);
        resovia2.setName("resovia2");
        resovia2.setPoints(22);
        resovia3.setName("resovia3");
        resovia3.setPoints(33);
        resovia4.setName("resovia4");
        resovia4.setPoints(1);

        LeagueT ligaSiatki= new LeagueT("siatka");
        ligaSiatki.addTeam(resovia1);
        ligaSiatki.addTeam(resovia2);
        ligaSiatki.addTeam(resovia3);
        ligaSiatki.addTeam(resovia4);
        System.out.print(ligaSiatki.toString());

        ligaSiatki.addTeam(stall0);// bez ograniczen mozna dodac

        System.out.println("--="+ " League " + ligaPilki.getName() +" =--");
        for (Object object : ligaPilki.getTeams()) {
            System.out.println( ((Team)object).getName() +" "+ ((Team)object).getPoints() );
        }


    }
}
