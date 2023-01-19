import java.util.Arrays;

public class PrintOddNums {


   /**
    *  Solve using Java: Given two integers, l and r,
    *  print all the odd numbers between l and r (l and r inclusive).
    *
    *  It has 2 parameters:
    *   1. An integer, I, denoting the left part of the range.
    *   2. An integer, r, denoting the right part of the range.
    *
    *     The function must return an array of
    *     integers denoting the odd numbers between l and
    *     r.
    * */


    public static int[] oddNumbers(int l, int r) {
        // create an array to store the odd numbers
        int[] oddNumbers = new int[(r - l ) ];

        // index for the oddNumbers array
        int index = 0;

        // loop through the range
        for (int i = l; i <= r; i++) {
            // check if the current number is odd
            if (i % 2 != 0) {
                oddNumbers[index] = i; // add the odd number to the array
                index++;
            }
        }

        return oddNumbers;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(oddNumbers(2, 5)));
    }

}
