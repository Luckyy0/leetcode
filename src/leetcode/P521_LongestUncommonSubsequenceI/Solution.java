package leetcode.P521_LongestUncommonSubsequenceI;

public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findLUSlength("aba", "cdc")); // 3
        System.out.println(sol.findLUSlength("aaa", "aaa")); // -1
    }
}
