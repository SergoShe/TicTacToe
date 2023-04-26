import java.util.ArrayList;
import java.util.stream.IntStream;

public class AIHard extends Player {

    public AIHard(String name, Sign sign) {
        super(name, sign);
    }

    @Override
    public Position move(Board board) {
        int bestScore = Integer.MIN_VALUE;
        ArrayList<Integer> bestMoves = new ArrayList<>();
        for (int freeCell : findFreeCells(board.getTable())) {
            Position currentPos = new Position(freeCell);
            board.setSign(currentPos, getSign());
            int score = minimax(board, freeCell, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
            board.setSign(currentPos, Sign.SIGN_EMPTY);
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

    private int minimax(Board board, int currentMove, int alpha, int beta, boolean isMaximizing) {
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
                    board.setSign(currentPos, getSign());
                    int score = minimax(board, freeCell, alpha, beta, false);
                    board.setSign(currentPos, Sign.SIGN_EMPTY);
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
                    board.setSign(currentPos, (getSign() == Sign.SIGN_X) ? Sign.SIGN_O : Sign.SIGN_X);
                    int score = minimax(board, freeCell, alpha, beta, true);
                    board.setSign(currentPos, Sign.SIGN_EMPTY);
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

    private int[] findFreeCells(Sign[][] table) {
        return IntStream.range(0, table.length)
                .boxed()
                .flatMap(row -> IntStream.range(0, table[row].length)
                        .filter(column -> table[row][column] == Sign.SIGN_EMPTY)
                        .mapToObj(column -> row * table.length + column + 1))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
