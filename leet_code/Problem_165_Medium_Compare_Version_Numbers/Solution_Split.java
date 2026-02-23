package leet_code.Problem_165_Medium_Compare_Version_Numbers;

public class Solution_Split {

    /**
     * Compares two version strings.
     * Returns 1 if v1 > v2, -1 if v1 < v2, and 0 otherwise.
     * Time: O(M+N), Space: O(M+N).
     * 
     * So sánh hai chuỗi phiên bản.
     * Trả về 1 nếu v1 > v2, -1 nếu v1 < v2, và 0 nếu bằng nhau.
     */
    public int compareVersion(String version1, String version2) {
        // Split versions into revision arrays using regex for '.'
        // Tách các phiên bản thành mảng các bản sửa đổi (sử dụng biểu thức chính quy
        // cho '.')
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {
            // Treat out-of-bounds revisions as 0
            // Coi các bản sửa đổi ngoài phạm vi là 0
            int val1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int val2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;

            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution_Split solution = new Solution_Split();

        // Test Case 1: "1.2" vs "1.10" -> -1
        System.out.println("Test 1: " + solution.compareVersion("1.2", "1.10"));

        // Test Case 2: "1.01" vs "1.001" -> 0
        System.out.println("Test 2: " + solution.compareVersion("1.01", "1.001"));

        // Test Case 3: "1.0" vs "1.0.0.0" -> 0
        System.out.println("Test 3: " + solution.compareVersion("1.0", "1.0.0.0"));
    }
}
