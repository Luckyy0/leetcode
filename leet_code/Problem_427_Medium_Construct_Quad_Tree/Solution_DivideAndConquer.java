package leet_code.Problem_427_Medium_Construct_Quad_Tree;

class Node {
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

public class Solution_DivideAndConquer {

    /**
     * Constructs a Quad Tree from an n x n grid.
     * Uses Divide and Conquer approach.
     * Time: O(N^2), Space: O(log N).
     * 
     * Xây dựng Cây Tứ phân từ một lưới n x n.
     * Sử dụng phương pháp Chia để Trị.
     */
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int r, int c, int len) {
        if (isAllSame(grid, r, c, len)) {
            return new Node(grid[r][c] == 1, true);
        }

        int half = len / 2;
        Node node = new Node();
        node.isLeaf = false;
        node.val = true; // Any value is okay

        node.topLeft = build(grid, r, c, half);
        node.topRight = build(grid, r, c + half, half);
        node.bottomLeft = build(grid, r + half, c, half);
        node.bottomRight = build(grid, r + half, c + half, half);

        return node;
    }

    private boolean isAllSame(int[][] grid, int r, int c, int len) {
        int val = grid[r][c];
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (grid[i][j] != val)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_DivideAndConquer solution = new Solution_DivideAndConquer();

        // 2x2 grid all 1s
        int[][] g1 = { { 1, 1 }, { 1, 1 } };
        Node root1 = solution.construct(g1);
        System.out.println("Result 1: isLeaf=" + root1.isLeaf + ", val=" + root1.val);

        // 2x2 grid mixed
        int[][] g2 = { { 1, 1 }, { 0, 1 } };
        Node root2 = solution.construct(g2);
        System.out.println("Result 2: isLeaf=" + root2.isLeaf + ", topLeftLeaf=" + root2.topLeft.isLeaf);
    }
}
