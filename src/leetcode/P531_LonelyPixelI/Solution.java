package leetcode.P531_LonelyPixelI;

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count 'B' in each row and column
        // Đếm 'B' trong mỗi hàng và cột
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;
        // Check for lonely pixels
        // Kiểm tra các điểm ảnh cô đơn
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
