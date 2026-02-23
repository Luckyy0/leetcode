package leet_code.Problem_117_Medium_Populating_Next_Right_Pointers_In_Each_Node_II;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution_Iterative {

    /**
     * Populates each next pointer to point to its next right node for any binary
     * tree.
     * Uses a dummy node to maintain O(1) space.
     * 
     * Điền vào mỗi con trỏ next cho bất kỳ cây nhị phân nào.
     * Sử dụng nút giả để duy trì không gian O(1).
     */
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node curr = root;

        while (curr != null) {
            // Dummy node to start the next level list
            // Nút giả để bắt đầu danh sách tầng tiếp theo
            Node dummy = new Node(0);
            Node tail = dummy;

            // Traverse the current level
            // Duyệt qua tầng hiện tại
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                // Move across the current level using its next pointers
                // Di chuyển ngang qua tầng hiện tại bằng các con trỏ next
                curr = curr.next;
            }

            // Move to the beginning of the next level
            // Di chuyển đến điểm bắt đầu của tầng tiếp theo
            curr = dummy.next;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Constructing an irregular binary tree
        // 1 -> 2, 3
        // 2 -> 4, 5
        // 3 -> null, 7
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, null, n7, null);
        Node root = new Node(1, n2, n3, null);

        solution.connect(root);

        // Verification
        System.out.println("Node 5 next is 7: " + (n5.next == n7)); // Expected: true
        System.out.println("Node 2 next is 3: " + (n2.next == n3)); // Expected: true
        System.out.println("Node 4 next is 5: " + (n4.next == n5)); // Expected: true
    }
}
