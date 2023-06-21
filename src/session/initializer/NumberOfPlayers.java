package session.initializer;

import java.util.HashMap;
import java.util.Map;

public enum NumberOfPlayers {
    ONE_PLAYER(1),
    TWO_PLAYERS(2);

    private final int value;
    private static final Map<Integer, NumberOfPlayers> map = new HashMap<>();

    NumberOfPlayers(int value) {
        this.value = value;
    }

    static {
        for (NumberOfPlayers mode : NumberOfPlayers.values()) {
            map.put(mode.getValue(), mode);
        }
    }

    public static NumberOfPlayers valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong number of players mode");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}