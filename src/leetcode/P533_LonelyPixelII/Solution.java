package leetcode.P533_LonelyPixelII;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length;
        int n = picture[0].length;

        int[] colCount = new int[n];
        Map<String, Integer> rowMap = new HashMap<>();

        // Count 'B' in each column and map row strings to their frequency
        // Đếm 'B' trong mỗi cột và ánh xạ chuỗi hàng với tần suất của chúng
        for (int i = 0; i < m; i++) {
            int rowBCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    colCount[j]++;
                    rowBCount++;
                }
                sb.append(picture[i][j]);
            }
            if (rowBCount == target) {
                String rowStr = sb.toString();
                rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
            }
        }

        int result = 0;
        // Iterate through the row patterns that have exactly 'target' black pixels
        // Lặp qua các mẫu hàng có chính xác 'target' pixel đen
        for (String rowStr : rowMap.keySet()) {
            // Check if there are exactly 'target' rows with this pattern
            // Kiểm tra xem có chính xác 'target' hàng với mẫu này không
            if (rowMap.get(rowStr) == target) {
                // For each column where this row has a 'B'
                // Với mỗi cột mà hàng này có một 'B'
                for (int j = 0; j < n; j++) {
                    if (rowStr.charAt(j) == 'B' && colCount[j] == target) {
                        result += target;
                    }
                }
            }
        }

        return result;
    }
}
