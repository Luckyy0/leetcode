package basic_code;

public class Merge_two_sorted_link_list_6 {
    public static class ListNode {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode root = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        result.next = (list1 != null) ? list1 : list2;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = Merge_two_sorted_link_list_6.mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
