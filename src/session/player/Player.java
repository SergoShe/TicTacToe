package session.player;

import session.gameplay.Board;
import session.gameplay.Position;
import session.gameplay.Sign;

import java.io.IOException;

public abstract class Player {

    private final String name;

    private Position lastPosition;

    public Player(String name) {
        this.name = name;
    }

    public void setLastPosition(Position position) {
        lastPosition = position;
    }

    public Position getLastPosition() {
        return lastPosition;
    }

    public String getName() {
        return name;
    }

    public abstract Position move(Board board, Sign sign) throws IOException;
}