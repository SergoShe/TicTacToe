package gameplay;

public class Position {
    private final int pos;

    public Position(int pos) {
        this.pos = pos;
    }

    public int getRow(){
        return (pos - 1) / 3;
    }

    public int getColumn(){
        return (pos - 1) % 3;
    }
}
