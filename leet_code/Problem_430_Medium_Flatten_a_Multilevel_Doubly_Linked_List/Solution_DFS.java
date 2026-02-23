package leet_code.Problem_430_Medium_Flatten_a_Multilevel_Doubly_Linked_List;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}

public class Solution_DFS {

    /**
     * Flattens a multilevel doubly linked list.
     * Uses an iterative approach with DFS logic (link recursion).
     * Time: O(N), Space: O(1) beyond stack.
     * 
     * Làm phẳng danh sách liên kết đôi đa cấp.
     * Sử dụng phương pháp lặp với logic DFS.
     */
    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            // Case: Node has a child
            if (curr.child != null) {
                Node nextTemp = curr.next;

                // Flatten child branch
                Node childHead = flatten(curr.child);

                // Connect curr to child head
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null; // Important!

                // Find tail of child branch to link with nextTemp
                Node tail = childHead;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Link tail to nextTemp
                if (nextTemp != null) {
                    tail.next = nextTemp;
                    nextTemp.prev = tail;
                }
            }
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Construct Test List: 1-2-3-4
        // child of 3: 7-8
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n7.next = n8;
        n8.prev = n7;

        n3.child = n7;

        Node flatHead = solution.flatten(n1);

        // Print
        System.out.print("Flattened: ");
        Node temp = flatHead;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
