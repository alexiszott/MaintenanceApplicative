package trivia;

public class Player {

    String playerName;
    int place;
    int purse;
    boolean inPenaltyBox;

    Player(String name){
        playerName = name;
        place = 0;
        purse = 0;
        inPenaltyBox = false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlace() {
        return place;
    }

    public int getPurse() {
        return purse;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
}
