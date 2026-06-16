public class Player {
    private String name;
    private String playerPosition;
    private String currentTeam;
    private double touchdownCounter;
    private double passingYardAmount;
    private double runningYardAmount;
    private double receivingYardsAmount;
    private double weight;
    private double height;

    public Player(String name, String pos, String team, double playerWeight, double playerHeight) {
        this.name = name;
        this.playerPosition = pos;
        this.currentTeam = team;
        this.height = playerHeight;
        this.weight = playerWeight;
        touchdownCounter = 0;
        runningYardAmount = 0;
        passingYardAmount = 0;
        receivingYardsAmount = 0;
    }

    public void addTouchdown() {
        touchdownCounter++;
        System.out.println("\nTouchdownnn! " + getLastName() + " has: " + getTouchdownAmt() + " TD's \n");
    }

    public void addRunningYards(double rushYards) {
        runningYardAmount += rushYards;
        System.out.println("\n" + getLastName() + " ruusssheddd for " + runningYardAmount + " yards!!!\n");
    }

    public void addPassingYards(double throwYardAmt) {
        passingYardAmount += throwYardAmt;
        System.out.println("\n" + getLastName() + " passed for " + passingYardAmount + " yards!\n");

    }

    public void addReceivingYards(double howFarBallWasCaught) {
        receivingYardsAmount += howFarBallWasCaught;
        System.out.println("\n" + getLastName() + " caught for " + receivingYardsAmount + " Yards!\n");
    }

    public double getTouchdownAmt() {
        return touchdownCounter;
    }

    public double getRushingYardsAmt() {
        return runningYardAmount;
    }

    public double getPassingYards() {
        return passingYardAmount;
    }

    public double getReceivingYards() {
        return receivingYardsAmount;
    }

    public String getLastName() {
        String[] lastName = name.split(" ");

        return lastName[lastName.length - 1];
    }

    public String getFullName() {
        return name;
    }

    public String getPlayersTeam() {
        return currentTeam;
    }

    public String getPlayersPosition() {
        return playerPosition;
    }

    public String getAllStats() {

        return "\n" + getFullName() + "'s Total Stats " + "\n===========================" + "\nPassing Yards: "
                + getPassingYards() + "\nRushing Yards: " + getRushingYardsAmt()
                + "\nReceiving Yards: " + getReceivingYards() + "\n Weight: " + weight + "\nHeight: " + height;
    }

    public void printAllStats() {
        System.out.println(getAllStats());
    }

}
