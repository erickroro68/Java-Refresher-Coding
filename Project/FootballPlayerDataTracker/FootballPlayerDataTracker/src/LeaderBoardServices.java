import java.util.ArrayList;

public class LeaderBoardServices {
    // total passing, rushing, general yardss , touchdowns all void

    public void printPassingYardLeader(ArrayList<Player> players) {
        System.out.println("\n===== Passing Yards Leaderboard =====");
        ArrayList<Player> sortedPLayerList = new ArrayList<>(players);
        sortedPLayerList
                .sort((playerA, playerB) -> Double.compare(playerB.getPassingYards(), playerA.getPassingYards()));

        for (int i = 0; i < sortedPLayerList.size(); i++) {
            Player currentPlayer = sortedPLayerList.get(i);

            // print: rank number, last name, passing yards
            System.out.println((i + 1) + ") " + currentPlayer.getFullName()
                    + " - " +
                    currentPlayer.getPassingYards()
                    + " total passing yards");
        }
    }

    public void printRushingLeader(ArrayList<Player> players) {
        System.out.println("\n=== Rushing Yards Leaderboard ===");
        ArrayList<Player> sortedRushingLeaderList = new ArrayList<>(players);

        sortedRushingLeaderList.sort(
                (playerA, playerB) -> Double.compare(playerB.getRushingYardsAmt(), playerA.getRushingYardsAmt()));

        for (int i = 0; i < sortedRushingLeaderList.size(); i++) {
            Player currentPlayer = sortedRushingLeaderList.get(i);
            System.out.println((i + 1) + ") " + currentPlayer.getFullName() + " - " +
                    currentPlayer.getRushingYardsAmt() + " rushing yards");
        }
    }

    public void printRecievingLeaders(ArrayList<Player> players) {
        System.out.println("\n=== Receiving Yards Leaderboard ===");
        ArrayList<Player> sortedRushingList = new ArrayList<>(players);
        sortedRushingList
                .sort((playerA, playerB) -> Double.compare(playerB.getReceivingYards(), playerA.getReceivingYards()));

        for (int i = 0; i < sortedRushingList.size(); i++) {
            Player currentPlayer = sortedRushingList.get(i);
            System.out.println((i + 1) + ") " +
                    currentPlayer.getFullName() + " - " + currentPlayer.getReceivingYards() + " recieving yards");
        }
    }

    public void printTouchdownLeaders(ArrayList<Player> players) {
        System.out.println("\n" + "=== Touchdown Leaderboard ===");
        ArrayList<Player> sortedTouchdownList = new ArrayList<>(players);

        sortedTouchdownList
                .sort((playerA, playerB) -> Double.compare(playerB.getTouchdownAmt(), playerA.getTouchdownAmt()));

        for (int i = 0; i < sortedTouchdownList.size(); i++) {
            Player currentPlayer = sortedTouchdownList.get(i);
            System.out.println((i + 1) + ") " +
                    currentPlayer.getFullName() + " - " + currentPlayer.getTouchdownAmt() + " total touchdowns");

        }
    }

}
