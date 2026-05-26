
public class TreasureCleaner {

    public static void main(String[] args) {

        String[][] map = {
            {"E", "E", "T"},
            {"SAFE", "E", "T"},
            {"T", "E", "SAFE"}
        };
        System.out.println("BEFORE UPDATED MAP: ");
        for(int r = 0; r < map.length; r++) {
            
            for(int c = 0; c < map[r].length; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("NOW after running our method cleanMap: ");
        cleanMap(map);
        
        System.out.println("UPDATED MAP: ");
        // TODO:
        // PRINT UPDATED MAP
        for(int i = 0; i < map.length; i++) {
            for(int c = 0; c < map[i].length; c++) {
                System.out.print(map[i][c] + " ");
            }
            System.out.println();
        }
    }

    public static void cleanMap(String[][] map) {

        int trapsRemoved = 0;
        int safeSpots = 0;

        // TODO:
        for(int rows = 0; rows < map.length; rows++) {

            // TODO:
            // LOOP THROUGH COLUMNS
            for(int col = 0; col < map[rows].length; col++) {
                // TODO:
                // IF CURRENT VALUE IS "T"
                // REPLACE WITH "SAFE"
                // INCREMENT trapsRemoved
                if(map[rows][col].equals("T")) {
                    map[rows][col] = "SAFE";
                    trapsRemoved++;
                }

                else if(map[rows][col].equals("SAFE")) {
                    safeSpots++;
                }
                
            }
        }
        System.out.println("TRAPS REMOVED: " + trapsRemoved);
        System.out.println("SAFE SPOTS: " + safeSpots);
    }
}