import java.io.IOException;

public abstract class Player {
    private Sign sign;

    private final String name;

    private Position lastPosition;

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    public void setLastPosition(Position position) {
        lastPosition = position;
    }

    public Position getLastTurn() {
        return lastPosition;
    }

    public String getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public abstract Position move(Board board) throws IOException;
}