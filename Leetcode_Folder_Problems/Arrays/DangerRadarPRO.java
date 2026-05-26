public class DangerRadarPRO {
// 1. Count ALL traps "T"  USE IF STATEMENT
// 2. Print EXACT coordinates of every trap  USE STRING COCATION aka "row + col"
// 3. Print WHICH ROW contains the most traps      USE BOOLEAN set to FALSE

//     Example Output
// TRAP FOUND AT: [0][2]
// TRAP FOUND AT: [2][0]
// TRAP FOUND AT: [2][2]

// ROW 2 HAS THE MOST TRAPS

// TOTAL TRAPS: 3

public static void main(String[] args) {

        String[][] map = {
            {"T", "T", "T"},
            {"E", "SAFE", "E"},
            {"T", "T", "E"}
        };

        scanMap(map);
    }

    public static void scanMap(String[][] map) {

        int totalTraps = 0;

        int mostTrapRow = 0;
        int highestTrapCount = 0;

        // TODO:
        // LOOP THROUGH ROWS
        for(int r =0; r < map.length; r++) {

            int currentRowTrapCount = 0;

            for(int c = 0; c < map[r].length; c++) {

                // TODO:
                // IF CURRENT VALUE IS "T"
                if(map[r][c].equals("T")) {
                    // TODO:
                    // PRINT COORDINATES
                    System.out.println("Found a Trap at cordinates: [" + r + "] , [" + c + "]");
                    // TODO:
                    // INCREMENT:
                    // totalTraps
                    // currentRowTrapCount
                    totalTraps++;
                    currentRowTrapCount++;
                }
            }

            if(currentRowTrapCount > highestTrapCount) {
                highestTrapCount = currentRowTrapCount;
                mostTrapRow = r;
            }

        }

        System.out.println();
        System.out.println("ROW " + mostTrapRow + " HAS THE MOST TRAPS");
        System.out.println("TOTAL TRAPS: " + totalTraps);
    }
}
