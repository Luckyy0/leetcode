package leet_code.Problem_382_Medium_Linked_List_Random_Node;

import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution_Reservoir {

    private ListNode head;
    private Random rand;

    /**
     * Linked List Random Node.
     * Uses Reservoir Sampling for O(1) space.
     * Time: O(N) per call, Space: O(1).
     * 
     * Nút Ngẫu nhiên trong Danh sách Liên kết.
     * Sử dụng Lấy mẫu Hồ chứa để tiết kiệm không gian O(1).
     */
    public Solution_Reservoir(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode curr = head;
        int res = curr.val;
        int i = 1;

        while (curr.next != null) {
            curr = curr.next;
            i++;
            // With probability 1/i, pick the current node
            // Với xác suất 1/i, chọn nút hiện tại
            if (rand.nextInt(i) == 0) {
                res = curr.val;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        Solution_Reservoir solution = new Solution_Reservoir(head);

        System.out.println("Random 1: " + solution.getRandom());
        System.out.println("Random 2: " + solution.getRandom());
        System.out.println("Random 3: " + solution.getRandom());
    }
}
