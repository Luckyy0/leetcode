package leetcode.P001_TwoSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Problem 1: Two Sum
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * Cho một mảng các số nguyên nums và một số nguyên target, trả về chỉ số của
     * hai số sao cho tổng của chúng bằng target.
     */

    /**
     * Measure 1: Hash Map
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        // Map to store number and its index: Key = number, Value = index
        // Map để lưu số và chỉ số của nó: Key = số, Value = chỉ số
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in map
            // Kiểm tra xem số bù có trong map không
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number and index
            // Lưu số hiện tại và chỉ số
            map.put(nums[i], i);
        }

        // According to problem statement, we can assume exactly one solution, so this
        // line is technically unreachable.
        // Theo đề bài, ta có thể giả định chính xác một giải pháp, nên dòng này về lý
        // thuyết không bao giờ chạy tới.
        return null;
    }

    /**
     * Measure 2: Brute Force (For reference)
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String testFile = "src/leetcode/P001_TwoSum/tests.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(testFile))) {
            String line;
            int testCaseCount = 1;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;

                // Line 1: nums
                String[] numsStr = line.split(",");
                int[] nums = new int[numsStr.length];
                for (int i = 0; i < numsStr.length; i++) {
                    nums[i] = Integer.parseInt(numsStr[i].trim());
                }

                // Line 2: target
                int target = Integer.parseInt(br.readLine().trim());

                // Line 3: expected
                String[] expectedStr = br.readLine().split(",");
                int[] expected = new int[expectedStr.length];
                for (int i = 0; i < expectedStr.length; i++) {
                    expected[i] = Integer.parseInt(expectedStr[i].trim());
                }

                System.out.println("Test Case " + testCaseCount + ":");
                System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);

                int[] result = solution.twoSum(nums, target);
                System.out.println("Output: " + Arrays.toString(result));

                // Sort for comparison as order doesn't matter
                Arrays.sort(result);
                Arrays.sort(expected);

                if (Arrays.equals(result, expected)) {
                    System.out.println("Result: PASS");
                } else {
                    System.out.println("Result: FAIL (Expected " + Arrays.toString(expected) + ")");
                }
                System.out.println("--------------------------------------------------");
                testCaseCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
