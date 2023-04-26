import java.util.HashMap;
import java.util.Map;

public enum AIdifficulty {
    EASY(1),
    HARD(2);

    private final int value;
    private static final Map<Integer, AIdifficulty> map = new HashMap<>();

    AIdifficulty(int value) {
        this.value = value;
    }

    static {
        for (AIdifficulty mode : AIdifficulty.values()) {
            map.put(mode.value, mode);
        }
    }

    public static AIdifficulty valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong game difficulty mode");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
