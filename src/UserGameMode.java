import java.util.HashMap;
import java.util.Map;

public enum UserGameMode {
    EXIT(0),
    START(1);

    private final int value;
    private static final Map<Integer, UserGameMode> map = new HashMap<>();

    UserGameMode(int value) {
        this.value = value;
    }

    static {
        for (UserGameMode mode : UserGameMode.values()) {
            map.put(mode.value, mode);
        }
    }

    public static UserGameMode valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong user mode");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
