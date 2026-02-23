package leet_code.Problem_302_Hard_Smallest_Rectangle_Enclosing_Black_Pixels;

public class Solution_BinarySearch {

    /**
     * Finds the area of the smallest rectangle enclosing black pixels.
     * Uses Binary Search on projected 1D arrays.
     * Time: O(M log N + N log M), Space: O(1).
     * 
     * Tìm diện tích hình chữ nhật nhỏ nhất bao quanh các điểm ảnh đen.
     * Sử dụng Tìm kiếm Nhị phân trên các mảng 1D được chiếu.
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return 0;

        int m = image.length;
        int n = image[0].length;

        int top = searchRows(image, 0, x, true);
        int bottom = searchRows(image, x + 1, m, false);
        int left = searchCols(image, 0, y, top, bottom, true);
        int right = searchCols(image, y + 1, n, top, bottom, false);

        return (bottom - top) * (right - left);
    }

    // Finds the first row in [low, high) that satisfies condition (has black pixel
    // or not)
    // If 'checkOnes' is true: find first row with a '1'.
    // If 'checkOnes' is false: find first row with NO '1' (all '0').
    // Tìm dòng đầu tiên trong [low, high) thỏa mãn điều kiện
    private int searchRows(char[][] image, int low, int high, boolean checkOnes) {
        while (low < high) {
            int mid = (low + high) / 2;
            boolean hasOne = false;
            for (int j = 0; j < image[0].length; j++) {
                if (image[mid][j] == '1') {
                    hasOne = true;
                    break;
                }
            }
            // Logic:
            // Top (checkOnes=true): range [0, x]. If mid has 1, it might be the top or top
            // is above. High = mid.
            // If mid has 0, top must be below (since black region is connected). Low =
            // mid+1.

            // Bottom (checkOnes=false): range [x+1, m]. If mid has 1, bottom is further
            // down. Low = mid+1.
            // If mid has 0, mid might be the boundary (the first empty row). High = mid.

            if (checkOnes) {
                if (hasOne)
                    high = mid;
                else
                    low = mid + 1;
            } else { // find first zero row
                if (hasOne)
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        return low;
    }

    // Finds the first col in [low, high) that satisfies condition
    // Optimization: We only need to check rows between [top, bottom) for the column
    // scan
    // Tìm cột đầu tiên trong [low, high) thỏa mãn điều kiện
    private int searchCols(char[][] image, int low, int high, int top, int bottom, boolean checkOnes) {
        while (low < high) {
            int mid = (low + high) / 2;
            boolean hasOne = false;
            for (int i = top; i < bottom; i++) {
                if (image[i][mid] == '1') {
                    hasOne = true;
                    break;
                }
            }
            if (checkOnes) {
                if (hasOne)
                    high = mid;
                else
                    low = mid + 1;
            } else {
                if (hasOne)
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1
        char[][] image = {
                { '0', '0', '1', '0' },
                { '0', '1', '1', '0' },
                { '0', '1', '0', '0' }
        };
        // x=0, y=2
        System.out.println("Min Area: " + solution.minArea(image, 0, 2)); // 6
    }
}
