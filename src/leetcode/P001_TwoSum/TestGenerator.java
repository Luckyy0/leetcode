package leetcode.P001_TwoSum;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class TestGenerator {
    public static void main(String[] args) {
        String filePath = "src/leetcode/P001_TwoSum/tests.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            Random rand = new Random();
            for (int i = 0; i < 50; i++) {
                int length = rand.nextInt(10) + 2; // Length 2 to 11
                int[] nums = new int[length];
                Set<Integer> used = new HashSet<>();

                // Generate distinct numbers to avoid ambiguity for simple generation
                for (int j = 0; j < length; j++) {
                    int val;
                    do {
                        val = rand.nextInt(201) - 100; // -100 to 100
                    } while (used.contains(val));
                    nums[j] = val;
                    used.add(val);
                }

                // Pick two distinct indices
                int idx1 = rand.nextInt(length);
                int idx2 = rand.nextInt(length);
                while (idx1 == idx2) {
                    idx2 = rand.nextInt(length);
                }

                int target = nums[idx1] + nums[idx2];
                int minIdx = Math.min(idx1, idx2);
                int maxIdx = Math.max(idx1, idx2);

                // Write nums
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < length; j++) {
                    sb.append(nums[j]);
                    if (j < length - 1)
                        sb.append(",");
                }
                writer.write(sb.toString() + "\n");

                // Write target
                writer.write(target + "\n");

                // Write expected
                writer.write(minIdx + "," + maxIdx + "\n");
            }
            System.out.println("Generated 50 test cases in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
