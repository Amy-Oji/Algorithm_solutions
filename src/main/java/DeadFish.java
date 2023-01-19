
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DeadFish {
    public Map<String, Integer> meiii (String name) {
        return null;
    }

    /**
     * algorithm on codewars
     * link: <a href="https://www.codewars.com/kata/51e0007c1f9378fa810002a9/train/java">Click here</a>
     *
     * Write a simple parser that will parse and run Deadfish.
     *
     * Deadfish has 4 commands, each 1 character long:
     *
     * i - increments the value (initially 0)
     * d - decrements the value
     * s - squares the value
     * o - outputs the value into the return array
     * Invalid characters should be ignored.
     *
     * Example: Deadfish.parse("iiisdoso") = new int[] {8, 64};
     */


//  first solution
//  using if statements
    public static int[] parse(String data) {

        ArrayList<Integer> result = new ArrayList<>();

        int value = 0;

        String[] arr = data.split("");

        for (String s : arr) {
            if (s.equals("i")) {
                value++;
            }
            if (s.equals("d")) {
                value--;
            }
            if (s.equals("s")) {
                value *= value;
            }
            if (s.equals("o")) {
                result.add(value);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

// second solution
// using switch statements
    public static int[] parse2(String data) {
        int value = 0;
        List<Integer> result = new ArrayList<>();
        for(char letter : data.toCharArray()) {
            switch (letter) {
                case 'i' -> value++;
                case 'd' -> value--;
                case 's' -> value *= value;
                case 'o' -> result.add(value);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        System.out.println("Parse === " + Arrays.toString(parse("iisisdosoensndeoiu")));

        System.out.println("Parse2 === " + Arrays.toString(parse2("iisisdosoensndeoiu")));
    }

}
