import java.util.ArrayList;

public class LeaderBoardServices {
    // total passing, rushing, general yardss , touchdowns all void

    public void printPassingYardLeader(ArrayList<Player> players) {
        System.out.println("\n===== Passing Yards Leaderboard =====");
        ArrayList<Player> sortedPLayerList = new ArrayList<>(players);

        for (int i = 0; i < sortedPLayerList.size(); i++) {
            sortedPLayerList
                    .sort((playerA, playerB) -> Double.compare(playerB.getPassingYards(), playerA.getPassingYards()));

            Player currentPlayer = sortedPLayerList.get(i);

            // print: rank number, last name, passing yards
            System.out.println((i + 1) + ") " + currentPlayer.getFullName()
                    + " - " +
                    currentPlayer.getPassingYards()
                    + " total passing yards");
        }
    }
}
