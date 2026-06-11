public class main {
    public static void main(String[] args) {

        Player p1 = new Player("Erick Ro", "OL", "Vikings", 220, 6.1);
        Player p2 = new Player("Justin Jefferson", "WR", "Vikings", 195, 6.1);
        Player p3 = new Player("Patrick Mahomes", "QB", "Chiefs", 225, 6.2);

        footballTracker tracker = new footballTracker();

        tracker.addPlayer(p1);
        tracker.addPlayer(p2);
        tracker.addPlayer(p3);

        tracker.viewPlayers();

        tracker.viewPlayerStats(2);

        Player foundPlayer = tracker.searchByLastName("Ro");

        if (foundPlayer != null) {
            foundPlayer.printAllStats();
        } else {
            System.out.println("Player Not Found");
        }

    }
}