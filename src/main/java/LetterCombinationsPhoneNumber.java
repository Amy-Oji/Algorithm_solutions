import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    /**
     *From leetcoded: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     *
     * Letter Combinations of a Phone Number
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     *
     * A mapping of digits to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     * **/

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        generateCombinations(digits, 0, new StringBuilder(), result, phoneMap);
        return result;
    }

    private static void generateCombinations(String digits, int index, StringBuilder current, List<String> result, Map<Character, String> phoneMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            generateCombinations(digits, index + 1, current, result, phoneMap);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        String digits2 = "";
        String digits3 = "2";

        System.out.println(letterCombinations(digits1)); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(digits2)); // Output: []
        System.out.println(letterCombinations(digits3)); // Output: ["a","b","c"]
    }
}
