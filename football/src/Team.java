public class Team {
    
    private final static String Owner = "Rodger Goodell";
    private final String teamName;
    private final int offensiveOverall;
    private final int defensiveOverall;
    private final int specialTeamsOverall;
    private final String homeStadiumLocation;
    // order it goes in: team name, offensive overall, defensive overall, special teams overall, home stadium location
    public Team(String teamName, int offensiveOverall, int defensiveOverall, int specialTeamsOverall, String homeStadiumLocation) {
        this.teamName = teamName;
        this.offensiveOverall = offensiveOverall;
        this.defensiveOverall = defensiveOverall;
        this.specialTeamsOverall = specialTeamsOverall;
        this.homeStadiumLocation = homeStadiumLocation;
    }

    //just simple get and setters for a simple return output
    // of the teams object we ARE going to hardcode and Create
    public String getTeamName() {
        return teamName;
    }

    public int getOffesnsiveOverall() {
        return offensiveOverall;
    }

    public int getDefensiveOverall() {
        return defensiveOverall;
    }

    public int getSpecialTeamsOverall() {
        return specialTeamsOverall;
    }

    public String getHomeStadiumLocation() {
        return homeStadiumLocation;
    }
}
