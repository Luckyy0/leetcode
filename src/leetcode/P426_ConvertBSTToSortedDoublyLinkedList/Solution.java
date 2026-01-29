package leetcode.P426_ConvertBSTToSortedDoublyLinkedList;

public class Solution {

    public static class Node {
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

    private Node first = null;
    private Node last = null;

    /**
     * Problem 426: Convert BST to Sorted Doubly Linked List
     * Approach: In-order Traversal
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        inorder(root);

        // Make it circular
        last.right = first;
        first.left = last;

        return first;
    }

    private void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);

        if (last != null) {
            // link the previous node (last) with the current node
            last.right = node;
            node.left = last;
        } else {
            // this is the smallest node
            first = node;
        }
        last = node;

        inorder(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // root = [4,2,5,1,3]
        Node root = new Node(4,
                new Node(2, new Node(1), new Node(3)),
                new Node(5));

        Node head = solution.treeToDoublyList(root);

        // Print the list to verify (1-2-3-4-5)
        System.out.print("Sorted List: ");
        Node curr = head;
        if (curr != null) {
            do {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } while (curr != head);
        }
        System.out.println();
    }
}
