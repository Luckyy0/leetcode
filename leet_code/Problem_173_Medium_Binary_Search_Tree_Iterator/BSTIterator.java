package leet_code.Problem_173_Medium_Binary_Search_Tree_Iterator;

import java.util.Stack;

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

public class BSTIterator {

    // Stack to store the path and simulate in-order traversal
    // Ngăn xếp để lưu trữ đường đi và mô phỏng phép duyệt thứ tự giữa
    private final Stack<TreeNode> stack;

    /**
     * Initializes the iterator with the root of the BST.
     * Starts by pushing all left children.
     * 
     * Khởi tạo bộ lặp với gốc của BST.
     * Bắt đầu bằng cách đẩy tất cả các con bên trái vào ngăn xếp.
     */
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }

    /**
     * @return the next smallest element
     *         Trả về phần tử nhỏ nhất tiếp theo
     */
    public int next() {
        TreeNode node = stack.pop();

        // After visiting the node, process its right subtree
        // Sau khi truy cập nút, xử lý cây con bên phải của nó
        if (node.right != null) {
            pushAllLeft(node.right);
        }

        return node.val;
    }

    /**
     * @return whether we have a next smallest element
     *         Trả về liệu có còn phần tử nhỏ nhất tiếp theo không
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper: Pushes the current node and all its descending left nodes onto the
    // stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        // Constructing tree: [7, 3, 15, null, null, 9, 20]
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15, new TreeNode(9), new TreeNode(20));

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next()); // return 3
        System.out.println(bSTIterator.next()); // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 20
        System.out.println(bSTIterator.hasNext()); // return False
    }
}
