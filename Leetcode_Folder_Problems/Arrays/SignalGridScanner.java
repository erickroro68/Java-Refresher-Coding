public class SignalGridScanner {

    public static void main(String[] args) {

        String[][] zoneMap = {
            {"E", "S", "E", "E"},
            {"E", "E", "E", "E"},
            {"S", "S", "E", "S"},
            {"E", "E", "S", "E"}
        };

        scanSignals(zoneMap);
    }

    public static void scanSignals(String[][] zoneMap) {

        int overallGlobalSignalCount = 0;

        int rowContainingHighestThreat = 0;

        int highestZoneThreatCount = 0;

        // LOOP THROUGH EACH ROW
        for(int r = 0; r < zoneMap.length; r++) {

            // CREATE current row counter
            int currentZoneSignalCount = 0;

            // LOOP THROUGH EACH COLUMN
            for(int c = 0; c < zoneMap[r].length; c++) {

                // IF CURRENT VALUE IS "S"
                if(zoneMap[r][c].equals("S")) {

                    System.out.println(
                        "SIGNAL FOUND AT: [" + r + " , " + c + "]"
                    );

                    overallGlobalSignalCount++;
                    currentZoneSignalCount++;
                }
            }

            // IF ROW IS CLEAR
            if(currentZoneSignalCount == 0) {

                System.out.println("ROW " + r + " IS CLEAR");
            }

            // IF CURRENT ROW HAS MORE SIGNALS
            if(currentZoneSignalCount > highestZoneThreatCount) {

                // TODO:
                // UPDATE highestZoneThreatCount
                highestZoneThreatCount = currentZoneSignalCount;
                // TODO:
                // UPDATE rowContainingHighestThreat
                rowContainingHighestThreat = r;
            }
        }

        System.out.println();

        System.out.println(
            "ROW " + rowContainingHighestThreat +
            " CONTAINS THE HIGHEST THREAT " + "( REMINDER ITS ZERO INDEXED )"
        );

        System.out.println(
            "TOTAL SIGNALS DETECTED: " +
            overallGlobalSignalCount
        );
    }
}