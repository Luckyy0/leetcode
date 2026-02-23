package leet_code.Problem_412_Easy_Fizz_Buzz;

import java.util.*;

public class Solution_Simple {

    /**
     * Classic Fizz Buzz problem.
     * Time: O(N), Space: O(1).
     * 
     * Bài toán Fizz Buzz kinh điển.
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean div3 = (i % 3 == 0);
            boolean div5 = (i % 5 == 0);

            if (div3 && div5) {
                res.add("FizzBuzz");
            } else if (div3) {
                res.add("Fizz");
            } else if (div5) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Simple solution = new Solution_Simple();
        System.out.println("Result 15: " + solution.fizzBuzz(15));
    }
}
