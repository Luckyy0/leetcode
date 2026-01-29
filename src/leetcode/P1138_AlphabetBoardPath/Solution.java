package leetcode.P1138_AlphabetBoardPath;

class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int r = 0, c = 0;

        for (char ch : target.toCharArray()) {
            int rNext = (ch - 'a') / 5;
            int cNext = (ch - 'a') % 5;

            // Move: L U R D
            // Order is important
            // 1. Move Left (always safe)
            while (c > cNext) {
                sb.append('L');
                c--;
            }
            // 2. Move Up (always safe)
            while (r > rNext) {
                sb.append('U');
                r--;
            }
            // 3. Move Right (safe now since we moved U if from z)
            while (c < cNext) {
                sb.append('R');
                c++;
            }
            // 4. Move Down (safe now since we moved L if to z)
            while (r < rNext) {
                sb.append('D');
                r++;
            }

            sb.append('!');
        }
        return sb.toString();
    }
}
