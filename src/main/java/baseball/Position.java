package baseball;

import java.util.Objects;

public class Position {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
