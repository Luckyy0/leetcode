package leet_code.Problem_234_Easy_Palindrome_Linked_List;

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

public class Solution_TwoPointers {

    /**
     * Checks if a linked list is a palindrome.
     * Uses O(N) time and O(1) space by reversing the second half.
     * 
     * Kiểm tra xem danh sách liên kết có phải là đối xứng hay không.
     * Sử dụng O(N) thời gian và O(1) không gian bằng cách đảo ngược nửa sau.
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the middle of the linked list
        // 1. Tìm điểm giữa của danh sách liên kết
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        // 2. Đảo ngược nửa sau
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // 3. Compare the two halves
        // 3. So sánh hai nửa
        // We copy secondHalf to restore the list later (optional but good practice)
        // Chúng ta copy secondHalf để khôi phục danh sách sau này (tùy chọn nhưng là
        // thực hành tốt)
        ListNode p2 = secondHalf;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (firstHalf.val != p2.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            p2 = p2.next;
        }

        // 4. Restore the list (Optional)
        // 4. Khôi phục danh sách (Tùy chọn)
        reverseList(secondHalf);

        return isPalindrome;
    }

    // Helper to reverse linked list
    // Hàm bổ trợ để đảo ngược danh sách liên kết
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [1,2,2,1]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("Is Palindrome 1: " + solution.isPalindrome(head1));

        // Test Case 2: [1,2]
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println("Is Palindrome 2: " + solution.isPalindrome(head2));
    }
}
