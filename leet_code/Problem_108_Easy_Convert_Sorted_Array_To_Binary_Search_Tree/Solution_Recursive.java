package leet_code.Problem_108_Easy_Convert_Sorted_Array_To_Binary_Search_Tree;

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

public class Solution_Recursive {

    /**
     * Converts a sorted array to a height-balanced BST.
     * Uses a recursive divide-and-conquer approach.
     * Chuyển đổi một mảng đã sắp xếp thành một BST cân bằng chiều cao.
     * Sử dụng phương pháp chia để trị đệ quy.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        // Base case: segment is empty
        // Trường hợp cơ sở: phân đoạn trống
        if (left > right) {
            return null;
        }

        // Always pick the middle element as the root
        // Luôn chọn phần tử ở giữa làm nút gốc
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        // Xây dựng đệ quy các cây con bên trái và bên phải
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [-10,-3,0,5,9]
        int[] nums1 = { -10, -3, 0, 5, 9 };
        TreeNode res1 = solution.sortedArrayToBST(nums1);
        System.out.println("Test Case 1: Root val: " + res1.val); // Expected: 0
        System.out.println("Root left: " + res1.left.val); // Expected: -10 or -3
        System.out.println("Root right: " + res1.right.val); // Expected: 5 or 9

        // Test Case 2: [1,3]
        int[] nums2 = { 1, 3 };
        TreeNode res2 = solution.sortedArrayToBST(nums2);
        System.out.println("Test Case 2: Root val: " + res2.val); // Expected: 1 or 3
    }
}
