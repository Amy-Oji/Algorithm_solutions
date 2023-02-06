public class ReserveWord {

    /**
     *
     * lonk: https://leetcode.com/problems/reverse-words-in-a-string-iii/
     * Given a string s, reverse the order of characters in each word within a sentence
     * while still preserving whitespace and initial word order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Example 2:
     *
     * Input: s = "God Ding"
     * Output: "doG gniD"
     * **/

    public static String reverseWords(String s) {

        String [] strArr = s.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder sb;

        for (String str : strArr ){
            sb = new StringBuilder(str);
            result.append(sb.reverse().append(" "));

        }
        return result.toString().trim();

    }
    public static void main(String[] args) {
        System.out.println(reverseWords("lets play"));
    }

}
