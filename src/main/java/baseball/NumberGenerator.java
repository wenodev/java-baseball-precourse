package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_NUMBERS_SIZE = 3;


    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        do {
            int number = Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
            addNotDuplicateNumber(numbers, number);
        } while (numbers.size() < MAX_NUMBERS_SIZE);
        return numbers;
    }

    private void addNotDuplicateNumber(List<Integer> numbers, int number) {
        if (!numbers.contains(number)){
            numbers.add(number);
        }
    }
}
