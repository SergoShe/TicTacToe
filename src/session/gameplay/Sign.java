package session.gameplay;

public enum Sign {
    SIGN_X('X'),
    SIGN_O('O'),
    SIGN_EMPTY('*');

    private final char value;

    Sign(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}