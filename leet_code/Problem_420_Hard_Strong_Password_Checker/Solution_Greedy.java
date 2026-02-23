package leet_code.Problem_420_Hard_Strong_Password_Checker;

import java.util.*;

public class Solution_Greedy {

    /**
     * Calculates the minimum steps to make a password strong.
     * Handles length < 6, 6-20, and > 20 using greedy strategy for triplets.
     * Time: O(N), Space: O(N).
     * 
     * Tính toán số bước tối thiểu để làm cho mật khẩu mạnh.
     * Xử lý các trường hợp độ dài < 6, 6-20, và > 20 bằng chiến lược tham lam.
     */
    public int strongPasswordChecker(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                hasLower = true;
            else if (Character.isUpperCase(c))
                hasUpper = true;
            else if (Character.isDigit(c))
                hasDigit = true;
        }

        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        // Find all repeating blocks of length >= 3
        List<Integer> lengths = new ArrayList<>();
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && password.charAt(j) == password.charAt(i))
                j++;
            int len = j - i;
            if (len >= 3)
                lengths.add(len);
            i = j;
        }

        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        } else if (n <= 20) {
            int replaceNeeded = 0;
            for (int len : lengths)
                replaceNeeded += len / 3;
            return Math.max(replaceNeeded, missingTypes);
        } else {
            int deleteCount = n - 20;
            int replaceNeeded = 0;
            int[] mod = new int[3];

            for (int len : lengths) {
                replaceNeeded += len / 3;
                if (len % 3 == 0)
                    mod[0]++;
                else if (len % 3 == 1)
                    mod[1]++;
            }

            // Priority 1: Use 1 delete to save 1 replace for blocks len%3 == 0
            int d = deleteCount;
            int used0 = Math.min(d, mod[0]);
            replaceNeeded -= used0;
            d -= used0;

            // Priority 2: Use 2 deletes to save 1 replace for blocks len%3 == 1
            // Each block in mod[1] can contribute many 3s, but we only target
            // the initial remainder here. Actually, it's safer to say each
            // item in mod[1] can potentially save 1.
            int used1 = Math.min(d, mod[1] * 2);
            replaceNeeded -= used1 / 2;
            d -= used1;

            // Priority 3: Use 3 deletes to save 1 replace for any remaining triplets
            replaceNeeded -= d / 3;

            return deleteCount + Math.max(replaceNeeded, missingTypes);
        }
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: "a" -> 5 (need 5 inserts)
        System.out.println("Result 'a': " + solution.strongPasswordChecker("a"));

        // Test Case 2: "1337C0d3" -> 0 (already strong)
        System.out.println("Result '1337C0d3': " + solution.strongPasswordChecker("1337C0d3"));

        // Test Case 3: "aaa111" -> 2 (replace one 'a' and one '1')
        System.out.println("Result 'aaa111': " + solution.strongPasswordChecker("aaa111"));
    }
}
