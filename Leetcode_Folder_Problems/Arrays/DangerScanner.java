public class DangerScanner {

    public static void main(String[] args) {
        //making a 2D array called "map"
        String[][] map = {
            {"E", "E", "T"},
            {"E", "E", "E"},
            {"T", "E", "T"}
        };
        //putting our trapCount amount that is returned
        //  from our scanMap method into a Integer named totalTrap which acts as a counter  
        int totalTraps = scanMap(map);
        //printing the fina Integer from the counter variable
        System.out.println("\nTOTAL TRAPS: " + totalTraps);
    }

    public static int scanMap(String[][] map) {
        //made a integer name trapCount which acts ass a counter place holder that we will return at the end of the method
        int trapCount = 0;
        //this is our outer loop for loop going through all rows we are given
        for (int rows = 0; rows < map.length; rows++) {
            //making a boolean called detection set to false and cahnges to true for the following if statement                                                                          
            boolean detection = false;

            //oour inner for loop goign through each colum in the secified row we are at based on our outside FOR loop
            for (int col = 0; col < map[rows].length; col++) {
                // IF statement that when is TRUE when the specified indexx we are at is .equal() to "T" or Trap
                if(map[rows][col].equals("T")) {
                    //incrementing our trapCount integer after the if statement above is true
                    trapCount++;
                    //changing our detection flag to true whe the IF statement is true
                    detection = true;
                }
            }

            // WHEN a row has a trap it returns a warning message
            if(detection == true) {
            System.out.println("TRAP FOUND WARNING");    
            }
        }
        // returns the updated trapCount after each incrementation 
        return trapCount;
    }
}