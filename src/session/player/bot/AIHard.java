package session.player.bot;

import session.gameplay.Board;
import session.gameplay.Position;
import session.gameplay.Sign;
import session.player.AIBot;

import java.util.ArrayList;

public class AIHard extends AIBot {

    public AIHard(String name) {
        super(name);
    }

    @Override
    public Position move(Board board, Sign sign) {
        int bestScore = Integer.MIN_VALUE;
        ArrayList<Integer> bestMoves = new ArrayList<>();
        for (int freeCell : findFreeCells(board.getTable())) {
            Position currentPos = new Position(freeCell);
            Board boardClone = board.clone();
            boardClone.setSign(currentPos, sign);
            int score = minimax(boardClone, sign, freeCell, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
            if (score > bestScore) {
                bestScore = score;
                bestMoves.clear();
                bestMoves.add(freeCell);
            } else if (score == bestScore) {
                bestMoves.add(freeCell);
            }
        }
        int randomIndex = (int) (Math.random() * bestMoves.size());
        return new Position(bestMoves.get(randomIndex));
    }

    private int minimax(Board board, Sign sign, int currentMove, int alpha, int beta, boolean isMaximizing) {
        boolean isWin = board.checkWin(new Position(currentMove));
        if (isWin) {
            return isMaximizing ? -10 : 10;
        }
        if (board.getCountEmpty() == 0) {
            return 0;
        }
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            boolean isContinue = true;
            for (int freeCell : findFreeCells(board.getTable())) {
                if (isContinue) {
                    Position currentPos = new Position(freeCell);
                    Board boardClone = board.clone();
                    boardClone.setSign(currentPos, sign);
                    int score = minimax(boardClone, sign, freeCell, alpha, beta, false);
                    bestScore = Math.max(score, bestScore);
                    alpha = Math.max(alpha, score);
                    if (beta <= alpha) {
                        isContinue = false;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            boolean isContinue = true;
            for (int freeCell : findFreeCells(board.getTable())) {
                if (isContinue) {
                    Position currentPos = new Position(freeCell);
                    Board boardClone = board.clone();
                    boardClone.setSign(currentPos, (sign == Sign.SIGN_X) ? Sign.SIGN_O : Sign.SIGN_X);
                    int score = minimax(boardClone, sign, freeCell, alpha, beta, true);
                    bestScore = Math.min(score, bestScore);
                    beta = Math.min(beta, score);
                    if (beta <= alpha) {
                        isContinue = false;
                    }
                }
            }
            return bestScore;
        }
    }
}