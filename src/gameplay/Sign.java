package gameplay;

import java.util.HashMap;
import java.util.Map;

public enum Sign {
    SIGN_X('X'),
    SIGN_O('O'),
    SIGN_EMPTY('*');

    private final char value;
    private static final Map<Character, Sign> map = new HashMap<>();

    Sign(char value) {
        this.value = value;
    }

    static {
        for (Sign mode : Sign.values()) {
            map.put(mode.value, mode);
        }
    }

    public static Sign valueOf(char value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong game difficulty mode");
        }
        return map.get(value);
    }

    public char getValue() {
        return value;
    }
}
