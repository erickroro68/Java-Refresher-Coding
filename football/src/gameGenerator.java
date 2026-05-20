public class gameGenerator {
    private String announcementCall;
    //use hashmap or logger for announcement of the game and the teams playing in it
    public void generateGame(Team homeTeam, Team awayTeam) {
        //generate the coin toss and determine who won
        Team coinTossWinner = coinToss.tossCoin(homeTeam, awayTeam);
        //generate the announcement of the game and the teams playing in it
        if (coinTossWinner == homeTeam) {
            announcementCall = homeTeam.getTeamName() + " will be receiving the ball first!";
        } else {
            announcementCall = awayTeam.getTeamName() + " will be receiving the ball first!";
        }
    }
    public char[] getAnnouncementCall() {

        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAnnouncementCall'");

    }


    
}
