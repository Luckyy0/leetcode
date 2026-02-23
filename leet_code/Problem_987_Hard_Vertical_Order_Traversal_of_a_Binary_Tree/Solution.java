package leet_code.Problem_987_Hard_Vertical_Order_Traversal_of_a_Binary_Tree;

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
 * Problem 987: Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class Solution {

    // Helper class to store node details: row, col, and value
    class Point {
        int row, col, val;

        Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    /**
     * Calculates the vertical order traversal of a binary tree.
     * Strategy: DFS Traversal + Custom Sorting.
     * 
     * @param root The root of the binary tree.
     * @return List of lists containing node values grouped by column.
     * 
     *         Tóm tắt chiến lược:
     *         1. Gán tọa độ (row, col) cho mỗi nút trong cây. Gốc ở (0, 0).
     *         - Con trái: (row + 1, col - 1)
     *         - Con phải: (row + 1, col + 1)
     *         2. Quét toàn bộ cây (dùng DFS hoặc BFS) để thu thập tất cả các nút
     *         cùng tọa độ của chúng.
     *         Lưu mỗi nút thành một object `Point(row, col, val)` vào một danh sách
     *         lớn `points`.
     *         3. Sắp xếp danh sách `points` dựa trên 3 tiêu chí theo mức độ ưu
     *         tiên:
     *         - Cột (col) tăng dần (từ trái sang phải).
     *         - Hàng (row) tăng dần (từ trên xuống dưới) nếu cùng cột.
     *         - Giá trị (val) tăng dần nếu cùng cả hàng và cột.
     *         4. Sau khi đã sắp xếp, duyệt qua danh sách và nhóm các giá trị có
     *         cùng cột (col) lại với nhau.
     *         5. Trả về cấu trúc danh sách lồng nhau nhận được.
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> points = new ArrayList<>();

        // Step 1 & 2: DFS to collect all nodes with their coordinates
        dfs(root, 0, 0, points);

        // Step 3: Sort the collected points
        Collections.sort(points, (p1, p2) -> {
            if (p1.col != p2.col) {
                return Integer.compare(p1.col, p2.col); // Sort by column
            } else if (p1.row != p2.row) {
                return Integer.compare(p1.row, p2.row); // Sort by row
            } else {
                return Integer.compare(p1.val, p2.val); // Sort by value
            }
        });

        // Step 4: Group by column
        List<List<Integer>> ans = new ArrayList<>();
        if (points.isEmpty())
            return ans;

        int currCol = points.get(0).col;
        List<Integer> currList = new ArrayList<>();

        for (Point p : points) {
            if (p.col == currCol) {
                currList.add(p.val);
            } else {
                // When column changes, add current list to answer and start a new one
                ans.add(currList);
                currCol = p.col;
                currList = new ArrayList<>();
                currList.add(p.val);
            }
        }

        // Add the last collected list
        ans.add(currList);

        return ans;
    }

    private void dfs(TreeNode node, int row, int col, List<Point> points) {
        if (node == null) {
            return;
        }

        // Add current node to list
        points.add(new Point(row, col, node.val));

        // Recurse left and right
        dfs(node.left, row + 1, col - 1, points);
        dfs(node.right, row + 1, col + 1, points);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Result: " + sol.verticalTraversal(root1));
        // Result: [[9], [3, 15], [20], [7]]
    }
}
