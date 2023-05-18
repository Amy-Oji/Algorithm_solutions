import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    /**
     * You are given two strings: order and s.
     * All the characters of order are unique and were sorted in some custom order previously.
     *
     * Permute the characters of s so that they match the order that order was sorted.
     * More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
     *
     * Return any permutation of s that satisfies this property.


     * Example 1:
     *
     * Input: order = "cba", s = "abcd"
     * Output: "cbad"
     * Explanation:
     * "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
     * Since "d" does not appear in order,
     * it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.


     * Example 2:
     *
     * Input: order = "cbafg", s = "abcd"
     * Output: "cbad"
     * **/
    public static String customSortString(String order, String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(char c: s.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        for(char c: order.toCharArray()){
            if (frequencyMap.containsKey(c)) {
                int count = frequencyMap.get(c);
                while (count > 0) {
                    result.append(c);
                    count--;
                }
                frequencyMap.remove(c);
            }
        }

        for(char c : frequencyMap.keySet()){
            int count = frequencyMap.get(c);
            while (count > 0) {
                result.append(c);
                count--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String order = "alx";
        String s = "oltxa";
        System.out.println(customSortString(order, s));
    }
}
