package baseball;

public class NumberUtils {
    public static int toInt(String str, int index) {
        return Integer.parseInt(String.valueOf(str.charAt(index)));
    }
}
