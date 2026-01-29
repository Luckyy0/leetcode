package leetcode.P386_LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 386: Lexicographical Numbers
     * Approach: Iterative DFS Simulation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) extra
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result.add(curr);

            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr >= n) {
                    curr /= 10;
                }
                curr++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 13 -> [1,10,11,12,13,2,3,4,5,6,7,8,9]
        System.out.println("n=13: " + solution.lexicalOrder(13));

        // 2 -> [1,2]
        System.out.println("n=2: " + solution.lexicalOrder(2));
    }
}
