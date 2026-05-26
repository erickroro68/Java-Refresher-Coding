public class TreasureShelf {

    public static void main(String[] args) {

        String[] shelf = {
            "GEM",
            "EMPTY",
            "KEY",
            "EMPTY",
            "MAP"
        };

        int coinsAdded = fillShelf(shelf);

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

        int count = 0;

        // LOOP THROUGH ARRAY

        for (int i = 0; i < shelf.length; i++) {

            // IF CURRENT VALUE IS "EMPTY"
            // TODO:
            if (shelf[i].equals("EMPTY")) {
                shelf[i] = "COIN";
                count++;
            }
            
        
        }
        return count;
    }
}