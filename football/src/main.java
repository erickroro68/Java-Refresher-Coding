import java.util.*;
public class main {
    public static void main(String[] args) {
        
        teamLoader loader = new teamLoader();
        Map<String, Team> teams = loader.loadHardcodedTeam();

        for (String teamName : teams.keySet()) {
            Team team = teams.get(teamName);
            System.out.println("Team Name: " + team.getTeamName());
            System.out.println("Offensive Overall: " + team.getOffesnsiveOverall());
            System.out.println("Defensive Overall: " + team.getDefensiveOverall());
            System.out.println("Special Teams Overall: " + team.getSpecialTeamsOverall());
            System.out.println("Home Stadium Location: " + team.getHomeStadiumLocation());
            System.out.println();
        }

        gameGenerator generator = new gameGenerator();
        generator.generateGame(teams.get("Minnesota Vikings"), teams.get("Green Bay Packers")); 
        System.out.println(generator.getAnnouncementCall());
        

    }
}
