import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class coinToss { 

    private static final Random RANDOM_TOSS_RESULT = new Random();
    private static final Logger LOGGER = Logger.getLogger(coinToss.class.getName());

    // Away team calls the toss (NFL rules). Returns the team that won.
    public static Team tossCoin(Team homeTeam, Team awayTeam) {
        int coinTossResult = RANDOM_TOSS_RESULT.nextInt(2); // 0 = heads, 1 = tails
        int awayTeamCoinTossCall = RANDOM_TOSS_RESULT.nextInt(2);   // away team randomly calls heads or tails

        // We need human-readable words ("Heads"/"Tails") to show in logs, but our two variables above
        // only hold numbers (0 or 1). This line converts that number into a word using the TERNARY OPERATOR.
        // The ternary operator is a shorthand if/else written as: (condition) ? valueIfTrue : valueIfFalse
        // So here: IF awayTeamCoinTossCall equals 0, store "Heads" in callStr, ELSE store "Tails".
        // We use String as the type because "Heads" and "Tails" are text, not numbers.
        String callStr = (awayTeamCoinTossCall == 0) ? "Heads" : "Tails";

        // Same idea as the line above — convert the coin flip result number into a readable word.
        // coinTossResult is 0 or 1 (randomly generated), so we map 0 → "Heads" and 1 → "Tails".
        // We need this as a separate variable because the call and the result are two different things.
        String resultStr = (coinTossResult == 0) ? "Heads" : "Tails";

        // LOGGER.log() writes a message to the console/log output so we can see what happened.
        // Level.INFO means it's a normal informational message (not a warning or error).
        // The string "{0}" and "{1}" are PLACEHOLDERS — Java will swap them out for real values at runtime.
        // new Object[]{...} is an array that holds the values to plug into those placeholders, in order:
        //   {0} gets replaced by awayTeam.getTeamName() — the away team's name (a method call on the Team object)
        //   {1} gets replaced by callStr — the word "Heads" or "Tails" we just built above
        // We use this placeholder style (instead of + to join strings) because LOGGER handles it more efficiently.

        //third paramter for LOGGER.log is giving us the away team and then printing that to show us whose picking first
        LOGGER.log(Level.INFO, "{0} calls {1}...", new Object[]{awayTeam.getTeamName(), callStr});

        // Same logging pattern as above, but this time we are reporting what the coin actually landed on.
        // Only one placeholder {0} is needed here, so we don't need an Object array — just pass resultStr directly.
        
        //third parameter for LOGGER.log is giving us the result of the coin toss and printing that to show us what the coin landed on
        LOGGER.log(Level.INFO, "The coin lands on {0}!", resultStr);

        // Now we decide who WON. Again using the ternary operator as a one-line if/else:
        // IF awayTeamCoinTossCall (what the away team called) equals coinTossResult (what the coin landed on),
        // THEN the away team guessed correctly → awayTeam wins, ELSE homeTeam wins.
        // The result is stored as type Team because the winner IS a Team object (not just a name or number).
        Team winner = (awayTeamCoinTossCall == coinTossResult) ? awayTeam : homeTeam;

        // Log the winner's name. winner.getTeamName() calls the getTeamName() method on whichever
        // Team object was assigned to winner above. This is how you reach inside an object to get its data.
        LOGGER.log(Level.INFO, "{0} wins the toss!", winner.getTeamName());

        // return sends the winner Team object BACK to wherever tossCoin() was called from.
        // The method signature says "public static Team tossCoin(...)" — the word Team there is the
        // RETURN TYPE, which means this method MUST hand back a Team object. This line fulfills that promise.
        return winner;
    }
}
