package leet_code.Problem_331_Medium_Verify_Preorder_Serialization_Of_A_Binary_Tree;

public class Solution_Counter {

    /**
     * Verifies if string is valid preorder.
     * Use Slot Counting method.
     * Time: O(N), Space: O(1) (if processing string directly, O(N) for split).
     * 
     * Xác minh xem chuỗi có phải là preorder hợp lệ không.
     * Sử dụng phương pháp Đếm Khe.
     */
    public boolean isValidSerialization(String preorder) {
        int slots = 1;

        for (int i = 0; i < preorder.length(); i++) {
            // Check current availability
            if (slots <= 0)
                return false;

            // If current char is comma, skip
            if (preorder.charAt(i) == ',') {
                continue;
            }

            // Check if it's a number or '#'
            if (preorder.charAt(i) == '#') {
                // Null node consumes 1 slot
                slots--;
            } else {
                // Read the full number
                while (i < preorder.length() && preorder.charAt(i) != ',') {
                    i++;
                }
                // Backtrack one step because the loop increments i
                i--; // Next loop iteration i++ will process the comma (skipped by continue) or end

                // Non-null node consumes 1 slot, adds 2 slots -> net +1
                // slots = slots - 1 + 2 = slots + 1
                slots--; // Consumed
                slots += 2; // Produced
            }
        }

        return slots == 0;
    }

    public static void main(String[] args) {
        Solution_Counter solution = new Solution_Counter();

        // Test Case 1
        String s1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println("Valid 1: " + solution.isValidSerialization(s1)); // true

        // Test Case 2
        String s2 = "1,#";
        System.out.println("Valid 2: " + solution.isValidSerialization(s2)); // false

        // Test Case 3
        String s3 = "9,#,#,1";
        System.out.println("Valid 3: " + solution.isValidSerialization(s3)); // false
    }
}
