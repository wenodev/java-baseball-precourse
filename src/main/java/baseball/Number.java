package baseball;

import java.util.Objects;

public class Number {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final String INVALID_VALUE_MESSAGE = "숫자는 1 이상 9 이하여야 합니다.";

    private final int value;

    public Number(int value) {
        if (!(value >=  MIN_VALUE && value <= MAX_VALUE)){
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
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}