public class TreasureShelf {

    public static void main(String[] args) {
        //making a String array called 'shelf'
        // our String array called 'shelf' contains 5 String values
        String[] shelf = {
            "GEM",
            "EMPTY",
            "KEY",
            "EMPTY",
            "MAP"
        };

        //making a integer called 'coinsAdded' that will  contain
        //  the count of the amount of times we see the String literal called "EMPTY" 
        int coinsAdded = fillShelf(shelf);
        //shows us the integer of the amount of times we see the String "EMPTY"
        System.out.println("COINS ADDED: " + coinsAdded);
        
        System.out.println("\nUpdated Shelf:");

        // PRINT UPDATED ARRAY
        // TODO:
        //have to make a simple for loop becuase we cant just print an array
        for(int i = 0; i < shelf.length; i++) {
            System.out.println(shelf[i]);

        }
        System.out.println("Code Complete");
        
    }

    public static int fillShelf(String[] shelf) {
        //making a integer named count since we havve to return a Integer at the end of method
        int count = 0;

        // LOOP THROUGH ARRAY
        // we are looping through each String using method .length 
        // which loops through each String in our String array called 'shelf'
        for (int i = 0; i < shelf.length; i++) {

            // IF CURRENT VALUE IS "EMPTY"
            // checking each index value using the method .equals 
            // IF the current index value is equal to the literal String named 'EMPTY'
            // then goes to the logic we have inside the If statement
            // TODO:
            if (shelf[i].equals("EMPTY")) {
                //we replace OR swap the index VALUE IF it equals "EMPTY"
                // with 'COIN' instead and adding 1 or incrementing our count value by 1
                shelf[i] = "COIN";
                count++;
            }
            
        
        }
        //returning  the Integer of the amount of times we swaped the index VALUE
        return count;
    }
}