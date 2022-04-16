package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        do {
            int number = Randoms.pickNumberInRange(1,9);
            addNotDuplicateNumber(numbers, number);
        } while (numbers.size() < 3);
        return numbers;
    }

    private void addNotDuplicateNumber(List<Integer> numbers, int number) {
        if (!numbers.contains(number)){
            numbers.add(number);
        }
    }
}
