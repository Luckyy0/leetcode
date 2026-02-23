package leet_code.Problem_205_Easy_Isomorphic_Strings;

public class Solution_IndexMapping {

    /**
     * Determines if two strings are isomorphic.
     * Uses integer values of characters as indices to track the last seen
     * positions.
     * Time: O(N), Space: O(1) (size of ASCII 256).
     * 
     * Xác định xem hai chuỗi có đẳng cấu hay không.
     * Sử dụng giá trị nguyên của ký tự làm chỉ số để theo dõi các vị trí xuất hiện
     * gần nhất.
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check if the last seen index of both characters matches.
            // If they are isomorphic, they must have appeared at the same indices
            // previously.
            // Kiểm tra xem chỉ số xuất hiện gần nhất của cả hai ký tự có khớp không.
            // Nếu chúng đẳng cấu, chúng phải đã xuất hiện tại cùng các chỉ số trước đó.
            if (m1[c1] != m2[c2]) {
                return false;
            }

            // Update index. We use i + 1 to distinguish from default 0 (not seen yet)
            // Cập nhật chỉ số. Sử dụng i + 1 để phân biệt với mặc định 0 (chưa thấy)
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_IndexMapping solution = new Solution_IndexMapping();

        // Test Case 1: egg, add -> True
        System.out.println("egg, add: " + solution.isIsomorphic("egg", "add"));

        // Test Case 2: foo, bar -> False
        System.out.println("foo, bar: " + solution.isIsomorphic("foo", "bar"));

        // Test Case 3: paper, title -> True
        System.out.println("paper, title: " + solution.isIsomorphic("paper", "title"));
    }
}
