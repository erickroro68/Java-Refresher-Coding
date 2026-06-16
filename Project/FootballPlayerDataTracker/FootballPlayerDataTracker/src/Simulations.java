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
    }

    private void initializeTeamRatings(ArrayList<Player> playersList) {

        for (int i = 0; i < playersList.size(); i++) {
            Player currentPlayer = playersList.get(i);
            String currentPlayersTeamName = currentPlayer.getPlayersTeam();

            if (!teamPassingOffenseRatings.containsKey(currentPlayersTeamName)) {
                teamPassingOffenseRatings.put(currentPlayersTeamName, 1.00);
            }

            if (!teamRecevingOffenseRatings.containsKey(currentPlayersTeamName)) {
                teamRecevingOffenseRatings.put(currentPlayersTeamName, 1.00);
            }

            if (!teamRushingOffenseRatings.containsKey(currentPlayersTeamName)) {
                teamRushingOffenseRatings.put(currentPlayersTeamName, 1.00);
            }

            if (!teamDefenseRatings.containsKey(currentPlayersTeamName)) {
                teamDefenseRatings.put(currentPlayersTeamName, 1.00);
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
        // TODO: Initialize team ratings before simulation starts.
        // This calls the private helper method.
        // initializeTeamRatings(playersList);

        // TODO: Print a debug message after ratings are initialized.
        // Example: "Team ratings initialized."

        // TODO: Later, create random weekly matchups.
        // createWeeklyMatchups(playersList);

        // TODO: Create one gameScript for the week.
        // This happens once before the loop.
        // Example options:
        // PASS_HEAVY
        // RUN_HEAVY
        // BALANCED

        // TODO: Loop through playersList.
        for (int i = 0; i < playersList.size(); i++) {

            // TODO: Inside the loop, grab one Player object.

            // TODO: Get this player's team name.

            // TODO: Later, use weeklyMatchups to find this player's opponent team.

            // TODO: Later, get opponent defense rating from teamDefenseRating map.

            // TODO: Send that player, defenseRating, and gameScript
            // into simulatePlayerWeek().
        }

        // TODO: Later, after the loop,
        // update offense ratings and defense ratings.
    }

    private double getRandomYards(double min, double max) {
        // TODO:
        // Return a random double between min and max.

        // Placeholder so method can compile later:
        return 0;
    }

    private double getDefenseRating() {
        // TODO:
        // Return a random defense rating.
        // Suggested range:
        // 0.80 = weak defense
        // 1.00 = average defense
        // 1.20 = strong defense

        // Placeholder so method can compile later:
        return 1.0;
    }

    private double applyDefenseImpact(double baseYards, double defenseRating) {
        // TODO:
        // Use defenseRating and defenseWeight to change baseYards.

        // TODO thinking:
        // If defenseRating > 1.0, yards should go down.
        // If defenseRating < 1.0, yards should go up.
        // defenseWeight controls how strong the effect is.

        // Placeholder so method can compile later:
        return baseYards;
    }

    private String getGameScript() {
        // Randomly return one of these:
        int randomNum = random.nextInt(3);
        // PASS_HEAVY
        // RUN_HEAVY
        // BALANCED
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
}