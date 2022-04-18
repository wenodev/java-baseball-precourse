package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Balls {
    private static final String INVALID_LENGTH_MESSAGE =  "3개의 숫자만 입력해야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE =  "숫자만 입력해야 합니다.";
    private static final int BALLS_SIZE =  3;

    private final List<Ball> values;

    public Balls(List<Integer> numbers) {
        this.values = mapToBalls(numbers);
    }

    public Balls(String strNumbers) {
        List<Integer> numbers = mapToList(strNumbers);
        this.values = mapToBalls(numbers);
    }

    public List<Ball> getValues() {
        return values;
    }

    private List<Integer> mapToList(String strNumbers) {
        validate(strNumbers);
        return Arrays.asList(
                NumberUtils.toInt(strNumbers, 0),
                NumberUtils.toInt(strNumbers, 1),
                NumberUtils.toInt(strNumbers, 2));
    }

    private void validate(String strNumbers) {
        if (strNumbers == null || strNumbers.length() != BALLS_SIZE) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
        try {
            Integer.parseInt(strNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private List<Ball> mapToBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i=0; i<numbers.size(); i++){
            balls.add(new Ball(i+1, numbers.get(i)));
        }
        return balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls = (Balls) o;
        return Objects.equals(values, balls.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
