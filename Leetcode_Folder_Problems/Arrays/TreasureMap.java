public class TreasureMap {

    public static void main(String[] args) {
        //making a 2d array named 'map'
        // has 3 rows or r    and   3 columns or c
        String[][] map = {
            {"EMPTY", "EMPTY", "GEM"},
            {"KEY", "EMPTY", "MAP"},
            {"GEM", "EMPTY", "EMPTY"}
        };

        //putting the amount of times our count value
        //  increments inside our fillMap method each time we see the String "EMPTY"
        int totalCoins = fillMap(map);

        //print to console that Integer value from above
        System.out.println("TOTAL COINS ADDED: " + totalCoins);

        System.out.println("\nUPDATED MAP:");

        //have to loop through each row and column because we cant just print map 
        // each time it updated
        // outside for loop: starts and row 1 and goes to row 3
        for(int r = 0; r < map.length; r++) {
            // our inside for  loop counting through each column left to right
            //  as our inside for loops goes through each row 
            for(int c = 0; c < map[r].length; c++) {
                // printing our new updated map row and column
                System.out.println(map[r][c]);
            }
        }
        
    }

    public static int fillMap(String[][] map) {

        //since we need to return a Intger we made a Int called count that increments
        // each time we SWAP a specific index VALUE through our nested loops
        int count = 0;

        //going through each row 
        for(int row = 0; row < map.length; row++) {
            // counting each column as we loop through each row doing map[row]
            for(int column = 0; column < map[row].length; column++) {
                // an IF Statement checking if the current looped 
                // index VALUE STRING is .equal to a String "EMPTY" 
                if(map[row][column].equals("EMPTY")) {
                    // if TRUE we then SWAP / REPLACE thatt specfic index VALUE with the string "COIN" 
                    map[row][column] = "COIN";
                    // incrementing our count integer each time we REPLACE a VALUE with "COIN"
                    count++;

                }
            }
        }

        //returns that Integer that tracks each time we SWAP
        return count;
    }
}