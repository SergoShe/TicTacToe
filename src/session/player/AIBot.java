package session.player;

import session.gameplay.Board;
import session.gameplay.Position;
import session.gameplay.Sign;

import java.io.IOException;
import java.util.stream.IntStream;

public abstract class AIBot extends Player {
    public AIBot(String name) {
        super(name);
    }

    @Override
    public abstract Position move(Board board, Sign sign) throws IOException;

    protected int[] findFreeCells(Sign[][] table) {
        return IntStream.range(0, table.length)
                .boxed()
                .flatMap(row -> IntStream.range(0, table[row].length)
                        .filter(column -> table[row][column] == Sign.SIGN_EMPTY)
                        .mapToObj(column -> row * table.length + column + 1))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}