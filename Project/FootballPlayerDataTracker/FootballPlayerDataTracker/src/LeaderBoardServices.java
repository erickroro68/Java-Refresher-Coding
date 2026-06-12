import java.util.ArrayList;

public class LeaderBoardServices {
    // total passing, rushing, general yardss , touchdowns all void

    public void printPassingYardLeader(ArrayList<Player> players) {
    System.out.println("===== Passing Yards Leaderboard =====");

    for (int i = 0; i < players.size(); i++) {
        
        Player currentPlayer = players.get(i);
        currentPlayer.sort(players1, players2) sortedPlayers.sort((player1, player2) ->
                Integer.compare(player2.getPassingYards(), player1.getPassingYards())
        );
        // print: rank number, last name, passing yards
        System.out.println((i+1) + ") " + currentPlayer.getLastName() + " - " + currentPlayer.getPassingYards() + " passing yards");
    }
}
}
