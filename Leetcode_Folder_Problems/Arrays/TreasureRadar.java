public class TreasureRadar {

    public static void main(String[] args) {

        String[][] map = {
            {"E", "E", "GEM"},
            {"SAFE", "E", "T"},
            {"GEM", "E", "SAFE"}
        };

        scanForGems(map);
    }

    public static void scanForGems(String[][] map) {

        // TODO:
        // LOOP THROUGH ROWS
        for(int r = 0; r < map.length; r++) {
            // TODO:
            // LOOP THROUGH COLUMNS
            for(int c = 0; c < map[r].length; c++) {
                // TODO:
                // IF CURRENT VALUE IS "GEM"
                if(map[r][c].equals("GEM")) {
                    // TODO:
                    // PRINT LOCATION
                    // FORMAT:
                    // GEM FOUND AT: [row][col]
                    System.out.println("GEM FOUND AT INDEX: [" + r + " , " + c + "]");
                }
            }
        }
    }
}