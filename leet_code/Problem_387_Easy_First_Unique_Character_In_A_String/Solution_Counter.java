package leet_code.Problem_387_Easy_First_Unique_Character_In_A_String;

public class Solution_Counter {

    /**
     * Finds the index of the first unique character.
     * Uses two-pass frequency counting.
     * Time: O(N), Space: O(1).
     * 
     * Tìm chỉ số của ký tự duy nhất đầu tiên.
     * Sử dụng đếm tần suất với hai lần duyệt.
     */
    public int firstUniqChar(String s) {
        int[] counts = new int[26];

        // Pass 1: Count frequency
        // Lần duyệt 1: Đếm tần suất
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // Pass 2: Find first with count == 1
        // Lần duyệt 2: Tìm ký tự đầu tiên có số lượng bằng 1
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_Counter solution = new Solution_Counter();

        // Test Case 1: leetcode -> 0
        System.out.println("Result 'leetcode': " + solution.firstUniqChar("leetcode"));

        // Test Case 2: loveleetcode -> 2
        System.out.println("Result 'loveleetcode': " + solution.firstUniqChar("loveleetcode"));

        // Test Case 3: aabb -> -1
        System.out.println("Result 'aabb': " + solution.firstUniqChar("aabb"));
    }
}
