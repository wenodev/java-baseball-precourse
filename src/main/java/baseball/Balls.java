package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> values;

    public Balls(int... ints) {
        List<Integer> numbers = mapToList(ints);
        this.values = mapToBalls(numbers);
    }

    private List<Ball> mapToBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i=0; i<numbers.size(); i++){
            balls.add(new Ball(i+1, numbers.get(i)));
        }
        return balls;
    }

    private List<Integer> mapToList(int[] ints) {
        List<Integer> numbers = new ArrayList<>();
        for (int i : ints){
            numbers.add(i);
        }
        return numbers;
    }

    public List<Ball> getValues() {
        return values;
    }
}
