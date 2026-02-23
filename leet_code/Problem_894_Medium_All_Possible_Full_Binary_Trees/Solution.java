package leet_code.Problem_894_Medium_All_Possible_Full_Binary_Trees;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Problem 894: All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */
public class Solution {

    // Memoization map to store results for subtree sizes
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    /**
     * Returns all possible full binary trees with n nodes.
     * Strategy: Recursion with Memoization.
     * 
     * @param n Number of nodes.
     * @return List of roots.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một cây nhị phân đầy đủ phải có số lượng nút là số LẺ. Nếu N chẵn,
     *         trả về list rỗng.
     *         2. Nếu N = 1, chỉ có 1 cây duy nhất (1 rễ).
     *         3. Với N > 1, cây bao gồm Rễ, Cây con Trái có L nút và Cây con Phải
     *         có R nút.
     *         Ta có: L + R + 1 = N (1 là rễ). -> L + R = N - 1.
     *         4. L và R cũng phải là số lẻ.
     *         5. Duyệt qua tất cả các giá trị lẻ có thể của L (từ 1 đến N-2).
     *         Lấy danh sách các cây con trái (kích thước L) và cây con phải (kích
     *         thước N-1-L).
     *         6. Kết hợp từng cặp cây con trái và phải để tạo thành một cây mới.
     *         7. Lưu kết quả vào memo để tránh tính toán lại.
     */
    public List<TreeNode> allPossibleFBT(int n) {
        // Full binary trees must have odd number of nodes
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        // Base case: single node
        if (n == 1) {
            List<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }

        // Return memoized result if available
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        // Iterate through all possible sizes for the left subtree
        // Left size must be odd: 1, 3, 5, ..., n-2
        for (int l = 1; l < n; l += 2) {
            int r = n - 1 - l;

            // Generate all left and right subtrees recursively
            List<TreeNode> leftTrees = allPossibleFBT(l);
            List<TreeNode> rightTrees = allPossibleFBT(r);

            // Combine each left tree with each right tree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<TreeNode> res1 = sol.allPossibleFBT(7);
        System.out.println("Count for N=7: " + res1.size()); // 5

        List<TreeNode> res2 = sol.allPossibleFBT(3);
        System.out.println("Count for N=3: " + res2.size()); // 1
    }
}
