package leet_code.Problem_800_Easy_Similar_RGB_Color;

public class Solution {

    /**
     * Finds the most similar shorthand RGB color.
     * Strategy: Optimize each component (R, G, B) independently.
     * Time: O(1), Space: O(1).
     */
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");

        // Process R, G, B components (each 2 chars)
        for (int i = 1; i < 7; i += 2) {
            sb.append(getClosestShorthand(color.substring(i, i + 2)));
        }

        return sb.toString();
    }

    private String getClosestShorthand(String hex) {
        int target = Integer.parseInt(hex, 16);
        int bestVal = -1;
        int minDistance = Integer.MAX_VALUE;

        // There are only 16 shorthand components: 00, 11, 22, ..., ff
        for (int i = 0; i < 16; i++) {
            // A shorthand component XX is basically i * 16 + i = i * 17
            int currentVal = i * 17;
            int distance = (target - currentVal) * (target - currentVal);

            if (distance < minDistance) {
                minDistance = distance;
                bestVal = i;
            }
        }

        // Convert the best shorthand value back to a 2-digit hex string (XX)
        String res = Integer.toHexString(bestVal);
        return res + res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.similarRGB("#09d175")); // Expected "#11ee66" per example? Wait.
        // Actually, my manual calculation for 11ee66 was higher dist than 00cc77.
        // Let's see what the code output is.
        // 0x09 = 9. 0x00=0 (9^2=81), 0x11=17 (8^2=64). So 11 is closer to 09.
        // 0xd1 = 13*16+1 = 209. 0xcc=12*17=204 (5^2=25), 0xdd=13*17=221 (12^2=144). So
        // cc is closer to d1.
        // 0x75 = 7*16+5 = 117. 0x66=6*17=102 (15^2=225), 0x77=7*17=119 (2^2=4). So 77
        // is closer to 75.
        // Correct result for #09d175 should be #11cc77?
        // Example 1 output is #11ee66. This is VERY strange.
        // Maybe the example explanation had a typo in the string or I misread the hex
        // letters.
        // "09d175" ... 11ee66.
        // 0x09 -> 0x11 (target 9, cand 17). dist 8.
        // 0xd1 -> 0xee? target 209, cand 238. dist 29.
        // 11cc77 would be much closer.

        System.out.println("Result 2: " + sol.similarRGB("#4e8862")); // Expected "#558866"
    }
}
