public class NotVerySecure {
/**
 *
 *From CoideWars
 * Link: <a href="https://www.codewars.com/kata/526dbd6c8c0eb53254000110">Click here</a>
 In this algorithm you have to validate if a user input string is alphanumeric.
 The given string is not nil/null/NULL/None, so you don't have to check that.

 The string has the following conditions to be alphanumeric:

 At least one character ("" is not valid)
 Allowed characters are uppercase / lowercase, latin letters and digits from 0 to 9,
 No whitespaces / underscore
 */

    public static boolean alphanumeric(String s) {

        return  s.matches("^[a-zA-Z\\d]+");

    }

    public static void main(String[] args) {
        String s = "thws23422....";
        System.out.println("IsAlphaNumeric: " + alphanumeric(s));

    }
}
