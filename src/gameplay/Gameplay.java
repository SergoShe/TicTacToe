package gameplay;

import initializer.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gameplay {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Board board = new Board();
    private final Score score = new Score();
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Gameplay(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }


    public void startGame() throws IOException {
        Player currentPlayer = firstPlayer;
        boolean isEndGame = false;
        while (!isEndGame) {
            board.initTable();
            boolean isGameOver = false;
            while (!isGameOver) {
                System.out.println("\nTurn: " + currentPlayer.getName() + " (" + currentPlayer.getSign().getValue() + ")");
                System.out.println("Current:");
                board.printTable();
                currentPlayer.setLastPosition(move(currentPlayer));
                if (checking(currentPlayer)) {
                    isGameOver = true;
                } else {
                    currentPlayer = changePlayer(currentPlayer);
                }
            }
            score.showScore();
            boolean isContinue = false;
            while (!isContinue) {
                System.out.println("Make a choiсe:");
                System.out.println("1.Continue game\n0.Exit");
                GameMode mode = GameMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (mode) {
                    case CONTINUE -> {
                        if (score.getTotal() % 2 == 0) {
                            currentPlayer = firstPlayer;
                            firstPlayer.setSign(Sign.SIGN_X);
                            secondPlayer.setSign(Sign.SIGN_O);
                        } else {
                            currentPlayer = secondPlayer;
                            firstPlayer.setSign(Sign.SIGN_O);
                            secondPlayer.setSign(Sign.SIGN_X);
                        }
                        isContinue = true;
                    }
                    case EXIT -> {
                        isEndGame = true;
                        isContinue = true;
                    }
                    default -> System.out.println("Enter incorrect command. Try again");
                }
            }
        }
    }

    private Position move(Player player) throws IOException {
        Position position = player.move(board);
        board.setSign(position, player.getSign());
        return position;
    }

    private Player changePlayer(Player currentPlayer) {
        return currentPlayer == firstPlayer ? secondPlayer : firstPlayer;
    }

    private boolean checking(Player player) {
        if (board.checkWin(player.getLastTurn())) {
            switch (player.getName()) {
                case "Player 1" -> {
                    score.incrementPlayer1();
                    System.out.println("Player 1 win!");
                }
                case "Player 2" -> {
                    score.incrementPlayer2();
                    System.out.println("Player 2 win!");
                }
            }
            return true;
        } else if (board.getCountEmpty() == 0) {
            score.incrementDraw();
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

}
