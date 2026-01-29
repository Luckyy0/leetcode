package leetcode.P708_InsertIntoASortedCircularLinkedList;

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            // Case 1: Standard gap
            // Trường hợp 1: Khoảng trống tiêu chuẩn
            if (curr.val <= insertVal && insertVal <= curr.next.val) {
                break;
            }

            // Case 2: Wrap-around point (end of sorted cycle)
            // Trường hợp 2: Điểm vòng lại (kết thúc chu kỳ đã sắp xếp)
            if (curr.val > curr.next.val) {
                if (insertVal >= curr.val || insertVal <= curr.next.val) {
                    break;
                }
            }

            curr = curr.next;
        }

        // Insert after curr
        // Chèn vào sau curr
        curr.next = new Node(insertVal, curr.next);
        return head;
    }
}
