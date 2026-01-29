package leetcode.P558_LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees;

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

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

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        // Base cases: if duplicate nodes OR logic
        // If one is leaf, we decide based on value
        // Nếu một là lá, chúng ta quyết định dựa trên giá trị

        if (quadTree1.isLeaf) {
            // 1 OR X = 1. So if tree1 is True Leaf, return tree1.
            // 0 OR X = X. So if tree1 is False Leaf, return tree2.
            return quadTree1.val ? quadTree1 : quadTree2;
        }

        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        // Recursive step
        // Bước đệ quy
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        // Check if we can merge these 4 nodes into one leaf
        // Kiểm tra xem chúng ta có thể hợp nhất 4 nút này thành một lá không
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
