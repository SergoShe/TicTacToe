package session;

public class Score {
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private int drawScore = 0;

    /*public void incrementFirstPlayer() {
        firstPlayerScore++;
    }

    public void incrementSecondPlayer() {
        secondPlayerScore++;
    }

    public void incrementDraw() {
        drawScore++;
    }*/

    public void incrementScore(Winner winner){
        switch (winner) {
            case FIRST_PLAYER -> firstPlayerScore++;
            case SECOND_PLAYER -> secondPlayerScore++;
            case DRAW -> drawScore++;
        }
    }
    public int getTotal() {
        return firstPlayerScore + secondPlayerScore + drawScore;
    }

    public void showScore() {
        System.out.println("Player 1: " + firstPlayerScore + " Draw: " + drawScore + " Player 2: " + secondPlayerScore);
    }

}
