package session.player.bot;

import session.gameplay.Board;
import session.gameplay.Position;
import session.gameplay.Sign;
import session.player.AIBot;

import java.util.Random;

public class AIEasy extends AIBot {

    public AIEasy(String name) {
        super(name);
    }

    @Override
    public Position move(Board board, Sign sign) {
        int[] freeCells = findFreeCells(board.getTable());
        int randomCells = new Random().nextInt(freeCells.length);
        return new Position(freeCells[randomCells]);
    }
}