import java.util.Arrays;

public class HasUniqueChars {

    /**
     * From CodeWars: https://www.codewars.com/kata/553e8b195b853c6db4000048/java
     *
     * Write a program to determine if a string contains only unique characters.
     * Return true if it does and false otherwise.
     *
     * The string may contain any of the 128 ASCII characters.
     * Characters are case-sensitive, e.g. 'a' and 'A' are considered different characters.
     * **/

//solution 1
    public static boolean hasUniqueCharacters(String str) {

        boolean[] charArray = new boolean[128];

        for(int i =0; i<str.length(); i++){

            int charValue = str.charAt(i);
            if(charArray[charValue]){
                return false; // Duplicate character found
            }
            charArray[charValue] = true;
        }
        return true; // No duplicate characters found
    }
// solution 2
    public static boolean hasUniqueCharacters2(String s) {
        return s.chars().distinct().count() == s.length();
    }

    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() == nums.length;
    }

    public static void main(String[] args) {
        System.out.println(hasUniqueCharacters2("zacdt"));
    }

}
