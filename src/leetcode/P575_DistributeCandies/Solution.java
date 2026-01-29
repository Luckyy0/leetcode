package leetcode.P575_DistributeCandies;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandies = new HashSet<>();
        for (int type : candyType) {
            uniqueCandies.add(type);
        }

        // Return minimum of unique types and n / 2
        // Trả về mức tối thiểu của các loại duy nhất và n / 2
        return Math.min(uniqueCandies.size(), candyType.length / 2);
    }
}
