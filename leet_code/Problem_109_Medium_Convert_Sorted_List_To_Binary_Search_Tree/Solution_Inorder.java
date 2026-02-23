package leet_code.Problem_109_Medium_Convert_Sorted_List_To_Binary_Search_Tree;

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution_Inorder {
    private ListNode currentHead;

    /**
     * Converts a sorted linked list to a height-balanced BST.
     * Uses inorder simulation to achieve O(N) time complexity.
     * Chuyển đổi một danh sách liên kết đã sắp xếp thành một BST cân bằng chiều
     * cao.
     * Sử dụng mô phỏng thứ tự giữa để đạt được độ phức tạp thời gian O(N).
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        // 1. Count the size of the list
        // 1. Đếm kích thước của danh sách
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        this.currentHead = head;
        return buildBST(0, size - 1);
    }

    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        // 2. Build the left subtree recursively
        // 2. Xây dựng cây con bên trái bằng đệ quy
        TreeNode left = buildBST(start, mid - 1);

        // 3. Create the root node using currentHead
        // 3. Tạo nút gốc bằng cách sử dụng currentHead
        TreeNode root = new TreeNode(currentHead.val);
        root.left = left;

        // 4. Advance the currentHead pointer
        // 4. Di chuyển con trỏ currentHead lên phía trước
        currentHead = currentHead.next;

        // 5. Build the right subtree recursively
        // 5. Xây dựng cây con bên phải bằng đệ quy
        root.right = buildBST(mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        Solution_Inorder solution = new Solution_Inorder();

        // Test Case 1: [-10,-3,0,5,9]
        ListNode l1 = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode res1 = solution.sortedListToBST(l1);
        System.out.println("Test Case 1: Root val: " + res1.val); // Expected: 0
        System.out.println("Root left val: " + res1.left.val); // Expected: -3
        System.out.println("Root right val: " + res1.right.val); // Expected: 9 or 5

        // Test Case 2: empty list
        System.out.println("Test Case 2: " + solution.sortedListToBST(null)); // Expected: null
    }
}
