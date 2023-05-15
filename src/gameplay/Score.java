package gameplay;

public class Score {
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private int scoreDraw = 0;

    public void incrementPlayer1() {
        scorePlayer1++;
    }

    public void incrementPlayer2() {
        scorePlayer2++;
    }

    public void incrementDraw() {
        scoreDraw++;
    }

    public int getTotal() {
        return scorePlayer1 + scorePlayer2 + scoreDraw;
    }

    public void showScore() {
        System.out.println("Player 1: " + scorePlayer1 + " Draw: " + scoreDraw + " Player 2: " + scorePlayer2);
    }

}
