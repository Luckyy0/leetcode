package leetcode.P1374_GenerateAStringWithCharactersThatHaveOddCounts;

import java.util.Arrays;

class Solution {
    public String generateTheString(int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        if (n % 2 == 0) {
            arr[n - 1] = 'b';
        }
        return new String(arr);
    }
}
