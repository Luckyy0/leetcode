package leet_code.Problem_426_Medium_Convert_BST_to_Sorted_Doubly_Linked_List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution_Inorder {

    private Node first = null;
    private Node last = null;

    /**
     * Converts a BST to a sorted circular doubly linked list in-place.
     * Uses inorder traversal.
     * Time: O(N), Space: O(H).
     * 
     * Chuyển đổi BST thành danh sách liên kết đôi vòng có thứ tự tại chỗ.
     * Sử dụng duyệt inorder.
     */
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        helper(root);

        // Link the first and last node to make it circular
        // Liên kết nút đầu và nút cuối để tạo thành vòng
        last.right = first;
        first.left = last;

        return first;
    }

    private void helper(Node node) {
        if (node == null)
            return;

        // Step 1: Left
        helper(node.left);

        // Step 2: Current Node
        if (last != null) {
            // Link current node with previous one
            last.right = node;
            node.left = last;
        } else {
            // Keep track of the first node
            first = node;
        }
        last = node;

        // Step 3: Right
        helper(node.right);
    }

    public static void main(String[] args) {
        Solution_Inorder solution = new Solution_Inorder();

        // Construct Test Tree: 4 -> (L: 2 -> (L: 1, R: 3), R: 5)
        Node root = new Node(4);
        root.left = new Node(2, new Node(1), new Node(3));
        root.right = new Node(5);

        Node head = solution.treeToDoublyList(root);

        // Print linked list to verify (1 cycle)
        System.out.print("Result Circular List: ");
        if (head != null) {
            Node curr = head;
            do {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } while (curr != head);
        }
        System.out.println();
    }
}
