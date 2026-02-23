package leet_code.Problem_558_Medium_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

public class Solution_Recursive {

    /**
     * Returns a Quad-Tree representing the logical OR of two Quad-Trees.
     * Strategy: Recursive merging with leaf consolidation.
     * Time: O(N), Space: O(H).
     */
    public Node intersect(Node quadTree1, Node quadTree2) {
        // Base case: quadTree1 is a leaf
        if (quadTree1.isLeaf) {
            // If quadTree1 is all 1s (true), result of (True OR anything) is True
            if (quadTree1.val)
                return quadTree1;
            // If quadTree1 is all 0s (false), result of (False OR Anything) is Anything
            return quadTree2;
        }

        // Similarly if quadTree2 is a leaf
        if (quadTree2.isLeaf) {
            if (quadTree2.val)
                return quadTree2;
            return quadTree1;
        }

        // Both are internal nodes: Recurse for each child
        Node tL = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tR = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bL = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bR = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        // Check if all four newly formed children are leaves and have the same value
        if (tL.isLeaf && tR.isLeaf && bL.isLeaf && bR.isLeaf &&
                tL.val == tR.val && tR.val == bL.val && bL.val == bR.val) {
            return new Node(tL.val, true, null, null, null, null);
        }

        // Otherwise, return internal node
        return new Node(false, false, tL, tR, bL, bR);
    }
}
