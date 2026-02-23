package leet_code.Problem_138_Medium_Copy_List_With_Random_Pointer;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution_Interweaving {

    /**
     * Constructs a deep copy of a linked list with random pointers.
     * Uses the interweaving technique for O(N) time and O(1) extra space.
     * 
     * Xây dựng bản sao sâu của một danh sách liên kết với các con trỏ ngẫu nhiên.
     * Sử dụng kỹ thuật đan xen để đạt thời gian O(N) và không gian bổ sung O(1).
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Phase 1: Create copy nodes and insert them after original nodes
        // Giai đoạn 1: Tạo các nút sao chép và chèn chúng sau các nút gốc
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Phase 2: Link random pointers for the copied nodes
        // Giai đoạn 2: Liên kết các con trỏ ngẫu nhiên cho các nút sao chép
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // The copy's random should point to the copy of original's random
                // Con trỏ random của bản sao trỏ đến bản sao của random gốc
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Phase 3: Separate the lists
        // Giai đoạn 3: Tách các danh sách
        Node original = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;

        while (original != null) {
            original.next = original.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            original = original.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        Solution_Interweaving solution = new Solution_Interweaving();

        // Create a simple list: 1 -> 2, and 1.random -> 2, 2.random -> 2
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;

        Node clonedHead = solution.copyRandomList(n1);

        // Verification
        System.out.println("Node 1 val: " + clonedHead.val); // 1
        System.out.println("Node 2 val: " + clonedHead.next.val); // 2
        System.out.println("Node 1 random points to val: " + clonedHead.random.val); // 2
        System.out.println("Independence check: " + (clonedHead != n1)); // true
    }
}
