package initializer.player;

import gameplay.Board;
import gameplay.Position;
import gameplay.Sign;

import java.io.IOException;

public abstract class AIBot extends Player {
    public AIBot(String name, Sign sign) {
        super(name,sign);
    }

    @Override
    public abstract Position move(Board board) throws IOException;
}
