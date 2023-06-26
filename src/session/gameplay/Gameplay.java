package session.gameplay;

import session.Winner;
import session.player.Player;

import java.io.IOException;

public class Gameplay {
    private final Board board = new Board();
    private final Player XPlayer;
    private final Player OPlayer;

    public Gameplay(Player XPlayer, Player OPlayer) {
        this.XPlayer = XPlayer;
        this.OPlayer = OPlayer;
    }

    public Winner startGame() throws IOException {
        Winner winner = null;
        Player currentPlayer = XPlayer;
        Sign currentSign = Sign.SIGN_X;
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.println("\nTurn: " + currentPlayer.getName() + " (" + currentSign.getValue() + ")");
            System.out.println("Current:");
            board.printTable();
            currentPlayer.setLastPosition(move(currentPlayer, currentSign));
            winner = checking(currentPlayer);
            switch (winner) {
                case FIRST_PLAYER, SECOND_PLAYER, DRAW -> {
                    System.out.println("\nFinal:");
                    board.printTable();
                    isGameOver = true;
                }
                case UNKNOWN -> {
                    currentPlayer = changePlayer(currentPlayer);
                    currentSign = changeSign(currentSign);
                }
            }
        }
        return winner;
    }

    private Sign changeSign(Sign currentSign) {
        return currentSign == Sign.SIGN_X ? Sign.SIGN_O : Sign.SIGN_X;
    }

    private Position move(Player player, Sign sign) throws IOException {
        Position position = player.move(board.clone(), sign);
        board.setSign(position, sign);
        return position;
    }

    private Player changePlayer(Player currentPlayer) {
        return currentPlayer == XPlayer ? OPlayer : XPlayer;
    }

    private Winner checking(Player player) {
        if (board.checkWin(player.getLastPosition())) {
            switch (player.getName()) {
                case "Player 1" -> {
                    System.out.println("Player 1 win!");
                    return Winner.FIRST_PLAYER;
                }
                case "Player 2" -> {
                    System.out.println("Player 2 win!");
                    return Winner.SECOND_PLAYER;
                }
            }
        } else if (board.getCountEmpty() == 0) {
            System.out.println("Draw!");
            return Winner.DRAW;
        }
        return Winner.UNKNOWN;
    }
}