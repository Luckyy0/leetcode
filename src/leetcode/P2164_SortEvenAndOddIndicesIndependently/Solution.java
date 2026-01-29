package leetcode.P2164_SortEvenAndOddIndicesIndependently;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        Collections.sort(even); // Ascending
        Collections.sort(odd, Collections.reverseOrder()); // Descending

        int[] res = new int[nums.length];
        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                res[i] = even.get(e++);
            else
                res[i] = odd.get(o++);
        }
        return res;
    }
}
