package baseball;

public class Position {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 3;
    private static final String INVALID_VALUE_MESSAGE = "위치값은 1 이상 3 이하여야 합니다.";

    private final int value;

    public Position(int value) {
        if (!(value >= MIN_VALUE && value <= MAX_VALUE)){
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
