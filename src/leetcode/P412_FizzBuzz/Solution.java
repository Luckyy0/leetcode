package leetcode.P412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 412: Fizz Buzz
     * Approach: Simple Linear Scan
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            boolean div3 = (i % 3 == 0);
            boolean div5 = (i % 5 == 0);

            if (div3 && div5) {
                result.add("FizzBuzz");
            } else if (div3) {
                result.add("Fizz");
            } else if (div5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // n = 15
        System.out.println("n = 15: " + solution.fizzBuzz(15));
    }
}
