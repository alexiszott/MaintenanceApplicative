package trivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// REFACTOR ME
public class Game implements IGame {
    List<Player> players = new ArrayList<>();

    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    enum Categories {
        POP("Pop"),
        SCIENCE("Science"),
        SPORTS("Sports"),
        ROCK("Rock");

        private final String stringValue;

        Categories(final String s) {
            stringValue = s;
        }

        public String toString() {
            return stringValue;
        }
    }

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + (i));
        }
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private boolean isInPenaltyBox() {
        return getCurrentPlayer().isInPenaltyBox();
    }

    public void roll(int roll) {
        Player player = getCurrentPlayer();

        System.out.println(player.getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(player.getPlayerName() + " is getting out of the penalty box");

                playerMove(roll);
            } else {
                System.out.println(player.getPlayerName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            playerMove(roll);
        }
    }

    private void playerMove(int roll) {
        Player player = getCurrentPlayer();

        player.place = player.getPlace() + roll;

        if (player.place > 12) player.place = player.place - 12;

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + player.place);

        System.out.println("The category is " + currentCategory());

        players.set(currentPlayer, player);
        askQuestion();
    }

    private void askQuestion() {
        switch (currentCategory()) {
            case "Pop":
                System.out.println(popQuestions.removeFirst());
                break;
            case "Science":
                System.out.println(scienceQuestions.removeFirst());
                break;
            case "Sports":
                System.out.println(sportsQuestions.removeFirst());
                break;
            default:
                System.out.println(rockQuestions.removeFirst());
                break;
        }
    }

    private String currentCategory() {
        int place = getCurrentPlayer().getPlace();
        switch (place % 4) {
            case 0: return Categories.POP.toString();
            case 1: return Categories.SCIENCE.toString();
            case 2: return Categories.SPORTS.toString();
            default: return Categories.ROCK.toString();
        }
    }

    public boolean handleCorrectAnswer() {
        if (!isInPenaltyBox() || isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            getCurrentPlayer().purse++;
            System.out.println(players.get(currentPlayer)
                    + " now has "
                    + getCurrentPlayer().purse
                    + " Gold Coins.");

            nextPlayer();
            return didPlayerWin();
        }
        nextPlayer();
        return didPlayerWin();
    }

    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        getCurrentPlayer().inPenaltyBox = true;

        nextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(getCurrentPlayer().purse == 6);
    }
}
