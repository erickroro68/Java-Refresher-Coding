import java.util.*;

public class footballTracker {
    private ArrayList<Player> playersList = new ArrayList<>();

    public footballTracker() {
        playersList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        playersList.add(player);
    }

    public void viewPlayers() {
        for (int i = 0; i < playersList.size(); i++) {
            Player currentPlayer = playersList.get(i);
            System.out.println("| | " + (i + 1) + ") " + currentPlayer.getLastName() + " ||");
            System.out.println();
        }
    }

    public void viewPlayerStats(int userInputIntChoice) {
        System.out.println("Enter a Integer of the Players stats you want to Look At: ");
        int inputIndex = userInputIntChoice - 1;
        Player selectedPlayer = playersList.get(inputIndex);
        selectedPlayer.printAllStats();
    }

    public Player searchByLastName(String usersLastNameChoice) {
        for (int i = 0; i < playersList.size(); i++) {
            Player selectedPlayer = playersList.get(i);

            if (selectedPlayer.getLastName().equalsIgnoreCase(usersLastNameChoice)) {
                return selectedPlayer;
            }
                 
         

        }

        return null;
    
    }

}
