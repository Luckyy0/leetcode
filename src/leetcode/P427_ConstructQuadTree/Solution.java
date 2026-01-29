package leetcode.P427_ConstructQuadTree;

public class Solution {

    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean _val, boolean _isLeaf) {
            this.val = _val;
            this.isLeaf = _isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            this.val = _val;
            this.isLeaf = _isLeaf;
            this.topLeft = _topLeft;
            this.topRight = _topRight;
            this.bottomLeft = _bottomLeft;
            this.bottomRight = _bottomRight;
        }
    }

    /**
     * Problem 427: Construct Quad Tree
     * Approach: Divide and Conquer (Recursion)
     * 
     * Time Complexity: O(N^2 * log N)
     * Space Complexity: O(log N) recursion depth
     */
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length - 1, grid.length - 1);
    }

    private Node build(int[][] grid, int r1, int c1, int r2, int c2) {
        if (isUniform(grid, r1, c1, r2, c2)) {
            return new Node(grid[r1][c1] == 1, true);
        }

        int midR = r1 + (r2 - r1) / 2;
        int midC = c1 + (c2 - c1) / 2;

        Node node = new Node(true, false);
        node.topLeft = build(grid, r1, c1, midR, midC);
        node.topRight = build(grid, r1, midC + 1, midR, c2);
        node.bottomLeft = build(grid, midR + 1, c1, r2, midC);
        node.bottomRight = build(grid, midR + 1, midC + 1, r2, c2);

        return node;
    }

    private boolean isUniform(int[][] grid, int r1, int c1, int r2, int c2) {
        int val = grid[r1][c1];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // grid = [[0,1],[1,0]]
        int[][] grid1 = { { 0, 1 }, { 1, 0 } };
        Node root1 = solution.construct(grid1);
        System.out.println("Root isLeaf: " + root1.isLeaf); // false
        System.out.println("TL val: " + root1.topLeft.val); // false (0)
        System.out.println("TR val: " + root1.topRight.val); // true (1)
    }
}
