package leet_code.Problem_272_Hard_Closest_Binary_Search_Tree_Value_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class Solution_TwoStacks {

    /**
     * Finds k closest values to target.
     * Uses Two Stacks to simulate Predecessor and Successor iterators.
     * Time: O(H + k), Space: O(H).
     * 
     * Tìm k giá trị gần nhất với target.
     * Sử dụng Hai Ngăn xếp để mô phỏng iterator Người tiền nhiệm và Người kế nhiệm.
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();

        // Initialize stacks
        // Khởi tạo các ngăn xếp
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val <= target) {
                pred.push(curr);
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        curr = root;
        while (curr != null) {
            if (curr.val > target) {
                succ.push(curr);
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (k-- > 0) {
            if (succ.isEmpty()) {
                result.add(getNextPred(pred));
            } else if (pred.isEmpty()) {
                result.add(getNextSucc(succ));
            } else {
                double diffPred = Math.abs(pred.peek().val - target);
                double diffSucc = Math.abs(succ.peek().val - target);

                if (diffPred < diffSucc) {
                    result.add(getNextPred(pred));
                } else {
                    result.add(getNextSucc(succ));
                }
            }
        }

        return result;
    }

    // Gets the next predecessor (moving backwards: Root -> Right -> Left...)
    // Predecessor stack stores nodes smaller than target.
    // Logic: Pop current. If it has left child, go to left, then all the way right.
    // Wait, the initialization above just put *potential* predecessors on stack.
    // The standard iterator logic:
    // To move to PREVIOUS smaller value from current node:
    // 1. If has left child: go left, then rightmost.
    // 2. If no left child: pop until we come from a right child.

    // BUT, the stack initialization I used stores the path.
    // Let's stick to standard "Inorder Reverse" iterator logic on the stack.
    private int getNextPred(Stack<TreeNode> stack) {
        TreeNode curr = stack.pop();
        int val = curr.val;

        // Move to the next predecessor: left child, then rightmost
        curr = curr.left;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
        return val;
    }

    private int getNextSucc(Stack<TreeNode> stack) {
        TreeNode curr = stack.pop();
        int val = curr.val;

        // Move to the next successor: right child, then leftmost
        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return val;
    }

    public static void main(String[] args) {
        Solution_TwoStacks solution = new Solution_TwoStacks();

        // Test Case 1: [4,2,5,1,3], 3.714286, k=2 -> [4, 3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Closest K 1: " + solution.closestKValues(root, 3.714286, 2));
    }
}
