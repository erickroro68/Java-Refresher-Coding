import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Collections;

public class Simulations {

    private Random random;
    // defenseWeight controls how strongly defense affects yard totals.
    // Example:
    // 0.25 = defense has a small effect
    // 0.50 = defense has a medium effect
    // 1.00 = defense has a strong effect
    private double defenseWeight;
    private HashMap<String, Double> teamDefenseRatings;
    private HashMap<String, Double> teamRushingOffenseRatings;
    private HashMap<String, Double> teamPassingOffenseRatings;
    private HashMap<String, Double> teamRecevingOffenseRatings;
    private HashMap<String, String> weeklyMatchups;
    private HashMap<String, Double> teamOffensiveLineRatings;
    // example: K = team name, V = Opponent Team name ie" Chiefs -> Vikings

    public Simulations() {
        // Create the Random object.
        random = new Random();
        // Set a starting defenseWeight.
        defenseWeight = .5;
        teamDefenseRatings = new HashMap<>();
        teamPassingOffenseRatings = new HashMap<>();
        teamRecevingOffenseRatings = new HashMap<>();
        teamRushingOffenseRatings = new HashMap<>();
        weeklyMatchups = new HashMap<>();
        teamOffensiveLineRatings = new HashMap<>();
    }

    private void initializeTeamRatings(ArrayList<Player> playersList) {

        for (int i = 0; i < playersList.size(); i++) {
            Player currentPlayer = playersList.get(i);
            String currentPlayersTeamName = currentPlayer.getPlayersTeam();

            if (!teamPassingOffenseRatings.containsKey(currentPlayersTeamName)) {
                teamPassingOffenseRatings.put(currentPlayersTeamName, getTeamRating());
            }

            if (!teamRecevingOffenseRatings.containsKey(currentPlayersTeamName)) {
                teamRecevingOffenseRatings.put(currentPlayersTeamName, getTeamRating());
            }

            if (!teamRushingOffenseRatings.containsKey(currentPlayersTeamName)) {
                teamRushingOffenseRatings.put(currentPlayersTeamName, getTeamRating());
            }

            if (!teamDefenseRatings.containsKey(currentPlayersTeamName)) {
                teamDefenseRatings.put(currentPlayersTeamName, getDefenseRating());
            }

            if (!teamOffensiveLineRatings.containsKey(currentPlayersTeamName)) {
                teamOffensiveLineRatings.put(currentPlayersTeamName, getTeamRating());
            }
        }

    }

    public void printWeekSimulation(ArrayList<Player> playersList) {

        System.out.println("===== Simulating One Week =====");

        initializeTeamRatings(playersList);
        System.out.println("\nInitialized Team Ratings!\n");

        createWeeklyMatchups(playersList);

        String gameScript = getGameScript();
        System.out.println("\nGame Script Chosen: " + gameScript);

        for (int i = 0; i < playersList.size(); i++) {

            Player currentPlayer = playersList.get(i);
            String teamOfCurrentPlayer = currentPlayer.getPlayersTeam();
            String opponentMatchup = weeklyMatchups.get(teamOfCurrentPlayer);

            if (opponentMatchup.equals("BYE")) {

                continue;

            }

            double opponentsDefenseRating = teamDefenseRatings.get(opponentMatchup);

            System.out.println(
                    "Player Name: " + currentPlayer.getFullName()
                            + "\nTeam Name: " + teamOfCurrentPlayer
                            + "\nOpponent: " + opponentMatchup +
                            "\nOpponent Defense Rating: " + opponentsDefenseRating);

            System.out.println();

            simulatePlayerWeek(currentPlayer, opponentsDefenseRating, gameScript);
        }
    }

    private double getRandomYards(double min, double max) {
        return min + (random.nextDouble() * (max - min));
    }

    private double getDefenseRating() {

        return 0.80 + (random.nextDouble() * (1.20 - 0.8));
    }

    private double getTeamRating() {
        return 0.80 + (random.nextDouble() * (1.20 - 0.8));
    }

    private double applyOffenseImpact(double baseYards, double offenseRating) {
        double offenseDifference = offenseRating - 1.00;
        double finalYards = baseYards * (1 + offenseDifference);

        if (finalYards < 0) {
            finalYards = 0;
        }

        return finalYards;
    }

    private double applyDefenseImpact(double baseYards, double defenseRating) {

        double defenseDiffernce = defenseRating - 1.00;
        double adjustment = defenseDiffernce * defenseWeight;
        double finalYardage = baseYards * (1 - adjustment);

        if (finalYardage < 1) {
            return 1;
        }
        return finalYardage;
    }

    private String getGameScript() {
        int randomNum = random.nextInt(3);

        if (randomNum == 0) {
            return "PASS_HEAVY";
        } else if (randomNum == 1) {
            return "RUN_HEAVY";
        }

        else {
            // Placeholder so method can compile later:
            return "BALANCED";

        }
    }

    private double applyGamescriptImpact(double yards, String gameScript, String position) {
        if (gameScript.equalsIgnoreCase("PASS_HEAVY")) {
            if (position.equalsIgnoreCase("QB")
                    || (position.equalsIgnoreCase("WR"))
                    || (position.equalsIgnoreCase("TE"))) {
                yards *= 1.15;

            } else if (position.equalsIgnoreCase("RB")) {
                yards *= 0.90;
            }

        }

        else if (gameScript.equalsIgnoreCase("RUN_HEAVY")) {
            if (position.equalsIgnoreCase("QB")
                    || (position.equalsIgnoreCase("WR"))
                    || (position.equalsIgnoreCase("TE"))) {
                yards *= 0.90;

            } else if (position.equalsIgnoreCase("RB")) {
                yards *= 1.15;
            }
        }
        return yards;
    }

    private void createWeeklyMatchups(ArrayList<Player> players) {
        weeklyMatchups.clear();
        ArrayList<String> uniqueNames = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            String currentPlayersTeamName = currentPlayer.getPlayersTeam();

            if (!uniqueNames.contains(currentPlayersTeamName)) {
                uniqueNames.add(currentPlayersTeamName);
            }
        }

        System.out.println("=== SIMMING 1 WEEK ===");
        Collections.shuffle(uniqueNames);
        System.out.println("Random Team Order: " + uniqueNames);
        for (int j = 0; j < uniqueNames.size(); j += 2) {
            if (j + 1 < uniqueNames.size()) {
                String teamA = uniqueNames.get(j);
                String teamB = uniqueNames.get(j + 1);

                weeklyMatchups.put(teamA, teamB);
                weeklyMatchups.put(teamB, teamA);

                System.out.println("Team A: " + teamA + " vs " + teamB + " :TeamB");
            } else {
                String byeWeek = uniqueNames.get(j);
                weeklyMatchups.put(byeWeek, "BYE");
                System.out.println(byeWeek + " has a BYE week");
            }
        }
    }

    private double calculateTouchdownChance(double yardsGained, double defenseRating) {

        /*
         * 0.80 = weak defense
         * 1.00 = average defense
         * 1.20 = strong defense
         */

        double chance = .15;

        if (yardsGained >= 150) {
            chance += 0.15;
        } else if (yardsGained >= 100) {
            chance += 0.10;
        } else if (yardsGained >= 50) {
            chance += 0.05;
        }

        if (defenseRating >= 1.10) {
            chance -= 0.05;
        } else if (defenseRating <= .90) {
            chance += 0.05;
        }

        if (chance < 0.01) {
            chance = 0.01;
        } else if (chance > 0.75) {
            chance = 0.75;
        }
        return chance;
    }

    private boolean touchdownHappened(double chance) {

        double touchdownRoll = random.nextDouble();

        if (touchdownRoll < chance) {
            return true;
        } else {
            return false;
        }
    }

    private void simulatePlayerWeek(Player player, double defenseRating, String gameScript) {

        String currentPlayersPosition = player.getPlayersPosition();

        if (currentPlayersPosition.equalsIgnoreCase("QB")) {

            double passingYards = getRandomYards(0, 400);
            double offenseRating = teamPassingOffenseRatings.get(player.getPlayersTeam());

            passingYards = applyOffenseImpact(passingYards, offenseRating);
            passingYards = applyGamescriptImpact(passingYards, gameScript, currentPlayersPosition);
            passingYards = applyDefenseImpact(passingYards, defenseRating);

            double touchdownChance = calculateTouchdownChance(passingYards, defenseRating);

            if (touchdownHappened(touchdownChance)) {
                player.addTouchdown();
            }

            player.addPassingYards(passingYards);

        } else if (currentPlayersPosition.equalsIgnoreCase("RB")) {

            double rushingYards = getRandomYards(20, 160);
            double offenseRating = teamRushingOffenseRatings.get(player.getPlayersTeam());

            rushingYards = applyOffenseImpact(rushingYards, offenseRating);
            rushingYards = applyGamescriptImpact(rushingYards, gameScript, currentPlayersPosition);
            rushingYards = applyDefenseImpact(rushingYards, defenseRating);

            double rushingTouchdownChance = calculateTouchdownChance(rushingYards, defenseRating);

            if (touchdownHappened(rushingTouchdownChance)) {
                player.addTouchdown();
            }

            player.addRunningYards(rushingYards);

        } else if (currentPlayersPosition.equalsIgnoreCase("WR")
                || currentPlayersPosition.equalsIgnoreCase("TE")) {

            double receivingYardage = getRandomYards(10, 200);
            double offenseRating = teamRecevingOffenseRatings.get(player.getPlayersTeam());

            receivingYardage = applyOffenseImpact(receivingYardage, offenseRating);
            receivingYardage = applyGamescriptImpact(receivingYardage, gameScript, currentPlayersPosition);
            receivingYardage = applyDefenseImpact(receivingYardage, defenseRating);

            double touchdownChance = calculateTouchdownChance(receivingYardage, defenseRating);

            if (touchdownHappened(touchdownChance)) {
                player.addTouchdown();
            }

            player.addReceivingYards(receivingYardage);

        } else if (currentPlayersPosition.equalsIgnoreCase("OL")) {

            System.out.println(player.getFullName() + " helped blocking this week");

        } else {

            System.out.println(player.getFullName() + " has a unkown position");

        }
    }
}