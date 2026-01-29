package leetcode.P1861_RotatingTheBox;

public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Apply gravity to each row
        for (int i = 0; i < m; i++) {
            int target = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    target = j - 1;
                } else if (box[i][j] == '#') {
                    if (target > j) {
                        box[i][target] = '#';
                        box[i][j] = '.';
                    }
                    target--;
                }
                // if '.', do nothing, target remains ready for next '#'
            }
        }

        // Rotate 90 degrees clockwise
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }

        return result;
    }
}
