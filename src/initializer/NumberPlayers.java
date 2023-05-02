package initializer;

import java.util.HashMap;
import java.util.Map;

public enum NumberPlayers {
    ONE_PLAYER(1),
    TWO_PLAYERS(2);

    private final int value;
    private static final Map<Integer, NumberPlayers> map = new HashMap<>();

    NumberPlayers(int value) {
        this.value = value;
    }

    static {
        for (NumberPlayers mode : NumberPlayers.values()) {
            map.put(mode.value, mode);
        }
    }

    public static NumberPlayers valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong number of players mode");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
