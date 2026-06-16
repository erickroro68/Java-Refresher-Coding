public class main {
    public static void main(String[] args) {

        Player p1 = new Player("Erick Ro", "OL", "Vikings", 220, 6.1);
        Player p2 = new Player("Justin Jefferson", "WR", "Vikings", 195, 6.1);
        Player p3 = new Player("Patrick Mahomes", "QB", "Chiefs", 225, 6.2);
        Player p4 = new Player("Ben Rummer", "RB", "Baltimore Ravens", 198, 5.8);
        FootballTracker tracker = new FootballTracker();
        LeaderBoardServices leaders = new LeaderBoardServices();
        Simulations sim = new Simulations();
        tracker.addPlayer(p1);
        tracker.addPlayer(p2);
        tracker.addPlayer(p3);
        tracker.addPlayer(p4);

        p1.addTouchdown();
        p1.addRunningYards(12);

        p2.addTouchdown();
        p2.addRunningYards(12);
        p2.addPassingYards(69);

        p3.addTouchdown();
        p3.addRunningYards(12);
        p3.addPassingYards(123);

        tracker.viewPlayers();

        tracker.viewPlayerStats(2);

        sim.printWeekSimulation(tracker.getPlayerList());
    }
}