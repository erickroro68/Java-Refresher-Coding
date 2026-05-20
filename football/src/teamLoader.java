import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class teamLoader {
    
    Scanner input = new Scanner(System.in);

    public Map<String, Team> loadHardcodedTeam() {
        Map<String, Team> team = new HashMap<>();
    // order it goes in: team name, offensive overall, defensive overall, special teams overall, home stadium location
        team.put("Minnesota Vikings", new Team("Vikings", 85, 80, 75, "U.S. Bank Stadium"));
        team.put("Green Bay Packers", new Team("Packers", 76, 85, 76, "Lambeau Field"));
        team.put("Chicago Bears",new Team("Bears", 70, 78, 80, "Soldier Field"));
        team.put("Detroit Lions", new Team("Lions", 67, 76, 69, "Gary Field"));
        return team;
        

    }


}
