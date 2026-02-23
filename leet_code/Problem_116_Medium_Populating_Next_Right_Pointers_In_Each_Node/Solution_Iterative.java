package leet_code.Problem_116_Medium_Populating_Next_Right_Pointers_In_Each_Node;

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
     * Populates each next pointer to point to its next right node.
     * This implementation uses constant extra space O(1).
     * 
     * Điền vào mỗi con trỏ next để trỏ đến nút bên phải tiếp theo.
     * Bản triển khai này sử dụng không gian bổ sung hằng số O(1).
     */
    public Node connect(Node root) {
        if (root == null)
            return null;

        // Start with the top level
        // Bắt đầu với tầng trên cùng
        Node leftmost = root;

        // While there is a next level to process
        // Trong khi vẫn còn tầng tiếp theo để xử lý
        while (leftmost.left != null) {

            // Traverse the current level and link children of the next level
            // Duyệt qua tầng hiện tại và liên kết các nút con của tầng tiếp theo
            Node head = leftmost;
            while (head != null) {

                // CONNECTION 1: Nodes with the same parent
                // KẾT NỐI 1: Các nút có cùng cha
                head.left.next = head.right;

                // CONNECTION 2: Nodes with different parents (cousins)
                // KẾT NỐI 2: Các nút có cha khác nhau (anh chị em họ)
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Move to the next node in the current level
                // Di chuyển đến nút tiếp theo trong tầng hiện tại
                head = head.next;
            }

            // Move to the leftmost node of the next level
            // Di chuyển đến nút ngoài cùng bên trái của tầng tiếp theo
            leftmost = leftmost.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Constructing a perfect binary tree
        // 1 -> 2, 3
        // 2 -> 4, 5
        // 3 -> 6, 7
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, n6, n7, null);
        Node root = new Node(1, n2, n3, null);

        solution.connect(root);

        // Basic verification
        System.out.println("Node 4 next is 5: " + (n4.next == n5)); // Expected: true
        System.out.println("Node 5 next is 6: " + (n5.next == n6)); // Expected: true
        System.out.println("Node 2 next is 3: " + (n2.next == n3)); // Expected: true
    }
}
