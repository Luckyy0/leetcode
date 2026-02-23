package leet_code.Problem_990_Medium_Satisfiability_of_Equality_Equations;

/**
 * Problem 990: Satisfiability of Equality Equations
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class Solution {

    // Union-Find parent array for 26 lowercase English letters
    private int[] parent;

    /**
     * Determines if a set of equations can be satisfied.
     * Strategy: Two-pass Union-Find.
     * 
     * @param equations Array of equation strings.
     * @return True if possible, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Nhận thấy đây là bài toán về tính chất bắc cầu của phép bằng (nếu
     *         a==b và b==c thì a==c).
     *         2. Ta dùng cấu trúc dữ liệu Union-Find (Tập hợp rời rạc) để nhóm các
     *         biến bằng nhau lại thành các tập hợp chung (connected components).
     *         Khởi tạo mảng `parent` kích thước 26, đại diện cho 26 chữ cái từ 'a'
     *         đến 'z'. Ban đầu, mỗi chữ cái tự thuộc về một tập hợp riêng.
     *         3. Lượt 1 (Xử lý các dấu bằng `==`):
     *         Duyệt toàn bộ mảng `equations`. Nếu phương trình là `x==y`, ta hợp
     *         nhất `x` và `y` vào cùng một tập con bằng phương thức `union`.
     *         4. Lượt 2 (Kiểm tra mâu thuẫn bằng các dấu khác `!=`):
     *         Duyệt lại toàn bộ mảng `equations`. Nếu phương trình là `x!=y`, ta
     *         tiến hành kiểm tra xem `x` và `y` có cội nguồn chung hay không bằng
     *         phương thức `find`.
     *         - Nếu `find(x) == find(y)` (chúng đã nằm trong cùng một nhóm do các
     *         dấu `==` quy định trước đó), thì đây là một sự MÂU THUẪN về logic
     *         (vừa bằng nhau, vừa khác nhau). Trả về `false`.
     *         5. Nếu vượt qua mọi bài kiểm tra, nghĩa là hệ phương trình nhất quán,
     *         trả về `true`.
     */
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];

        // Initialize: Every variable points to itself
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Pass 1: Handle equalities (==)
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int var1 = eq.charAt(0) - 'a';
                int var2 = eq.charAt(3) - 'a';
                union(var1, var2);
            }
        }

        // Pass 2: Handle inequalities (!=)
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int var1 = eq.charAt(0) - 'a';
                int var2 = eq.charAt(3) - 'a';
                // Contradiction if the two variables are already in the same set
                if (find(var1) == find(var2)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Find the root parent of a variable with path compression.
     */
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        // Path compression: make the current node point directly to the root
        return parent[i] = find(parent[i]);
    }

    /**
     * Union two sets together.
     */
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.equationsPossible(new String[] { "a==b", "b!=a" })); // false
        System.out.println("Result 2: " + sol.equationsPossible(new String[] { "b==a", "a==b" })); // true
        System.out.println("Result 3: " + sol.equationsPossible(new String[] { "c==c", "b==d", "x!=z" })); // true
    }
}
