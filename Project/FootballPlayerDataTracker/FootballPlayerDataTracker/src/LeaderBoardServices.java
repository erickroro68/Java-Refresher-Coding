import java.util.ArrayList;

public class LeaderBoardServices {
    // total passing, rushing, general yardss , touchdowns all void

    public void printPassingYardLeader(ArrayList<Player> players) {
        System.out.println("===== Passing Yards Leaderboard =====");

        for (int i = 0; i < players.size(); i++) {
            Player playerLists = players.get(i);
            System.out.println(players.get(i));
        }
    }
}
