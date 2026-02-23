package leet_code.Problem_832_Easy_Flipping_an_Image;

import java.util.Arrays;

public class Solution {

    /**
     * Flips the image horizontally and then inverts it.
     * Strategy: Iterate through each row and use two pointers to process symmetry.
     * Time: O(N^2), Space: O(1).
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                // If elements at symmetric positions are the same,
                // reversing them doesn't change anything, so we just invert them both.
                // If they are different, reversing and inverting them results in the same
                // values.
                // Example: [1, 0] -> Reverse: [0, 1] -> Invert: [1, 0] (No change)
                if (image[i][left] == image[i][right]) {
                    int invertedValue = image[i][left] ^ 1;
                    image[i][left] = invertedValue;
                    image[i][right] = invertedValue;
                }

                left++;
                right--;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] img1 = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 1, 1 } };
        int[][] res1 = sol.flipAndInvertImage(img1);
        for (int[] r : res1)
            System.out.println(Arrays.toString(r));
        // Expect: [1, 0, 0], [0, 1, 0], [1, 1, 0]
    }
}
