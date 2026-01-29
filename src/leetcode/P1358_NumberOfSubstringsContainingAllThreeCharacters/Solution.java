package leetcode.P1358_NumberOfSubstringsContainingAllThreeCharacters;

class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int res = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // At this point, [left, right] is INVALID.
            // But [left-1, right] WAS valid.
            // And all [0...right], [1...right], ..., [left-1...right] are valid.
            // Number of such start indices is 'left'.
            res += left;
        }

        return res;
    }
}
