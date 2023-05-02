package gameplay.difficulty;

import gameplay.Board;
import gameplay.Position;
import gameplay.Sign;

import java.util.Random;
import java.util.stream.IntStream;

public class AIEasy extends Player {

    public AIEasy(String name, Sign sign) {
        super(name, sign);
    }

    @Override
    public Position move(Board board) {
        int[] freeCells = findFreeCells(board.getTable());
        int randomCells = new Random().nextInt(freeCells.length);
        return new Position(freeCells[randomCells]);
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
