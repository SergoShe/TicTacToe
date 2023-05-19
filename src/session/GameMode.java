package session;

import java.util.HashMap;
import java.util.Map;

public enum GameMode {
    EXIT(0),
    CONTINUE(1);

    private final int value;
    private static final Map<Integer, GameMode> map = new HashMap<>();

    GameMode(int value) {
        this.value = value;
    }

    static {
        for (GameMode mode : GameMode.values()) {
            map.put(mode.getValue(), mode);
        }
    }

    public static GameMode valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong user mode");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
