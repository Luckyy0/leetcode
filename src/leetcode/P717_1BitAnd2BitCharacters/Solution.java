package leetcode.P717_1BitAnd2BitCharacters;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        // Traverse until before the last bit
        // Duyệt cho đến trước bit cuối cùng
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2; // Skip 2 bits
            } else {
                i += 1; // Skip 1 bit
            }
        }

        // If we reach exactly n-1, it means the last bit was treated as a single char
        // Nếu chúng ta đạt được chính xác n-1, điều đó có nghĩa là bit cuối cùng được
        // coi là một ký tự duy nhất
        return i == n - 1;
    }
}
