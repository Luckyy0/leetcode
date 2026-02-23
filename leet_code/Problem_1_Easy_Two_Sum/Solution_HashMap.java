package leet_code.Problem_1_Easy_Two_Sum;

public class Solution_HashMap {

    /**
     * Custom Node class for constraints.
     * Lớp Node tùy chỉnh cho các ràng buộc.
     */
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Minimal HashMap implementation using Chaining.
     * Cài đặt HashMap tối giản sử dụng phương pháp chuỗi.
     */
    static class MyHashMap {
        private final Node[] table; // Array of buckets / Mảng các bucket
        private final int size;

        public MyHashMap(int size) {
            this.size = size;
            this.table = new Node[size];
        }

        /**
         * Hash function.
         * Hàm băm.
         */
        private int hash(int key) {
            // Use absolute value to handle negative numbers
            // Sử dụng giá trị tuyệt đối để xử lý số âm
            return Math.abs(key) % size;
        }

        /**
         * Put key-value pair into the map.
         * Thêm cặp key-value vào bảng.
         */
        public void put(int key, int value) {
            int index = hash(key);
            Node head = table[index];
            Node node = head;

            // Check if key already exists
            // Kiểm tra xem khóa đã tồn tại chưa
            while (node != null) {
                if (node.key == key) {
                    node.value = value; // Update / Cập nhật
                    return;
                }
                node = node.next;
            }

            // Insert at the beginning (O(1))
            // Chèn vào đầu (O(1))
            Node newNode = new Node(key, value, head);
            table[index] = newNode;
        }

        /**
         * Get value by key. Returns -1 if not found.
         * Lấy giá trị theo khóa. Trả về -1 nếu không tìm thấy.
         */
        public int get(int key) {
            int index = hash(key);
            Node node = table[index];
            while (node != null) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1; // Not found / Không tìm thấy
        }
    }

    /**
     * Solves the Two Sum problem using Hash Map (O(N) Time).
     * Giải quyết bài toán Hai Số Tổng sử dụng Bảng Băm (O(N) Thời gian).
     */
    public int[] twoSum(int[] nums, int target) {
        // Size explanation: Use a prime number or roughly 1.5x N to reduce collisions.
        // 10000 is usually fine but let's use 20011 (prime).
        // Giải thích kích thước: Sử dụng số nguyên tố hoặc khoảng 1.5x N để giảm va
        // chạm.
        // 10000 thường ổn nhưng hãy dùng 20011 (số nguyên tố).
        MyHashMap map = new MyHashMap(20011);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists
            // Kiểm tra xem phần bù có tồn tại không
            int index = map.get(complement);
            if (index != -1) {
                // Found solution
                // Tìm thấy giải pháp
                return new int[] { index, i };
            }

            // Add current number to map
            // Thêm số hiện tại vào bảng
            map.put(nums[i], i);
        }

        // Should not reach here based on problem constraints
        // Không nên chạy đến đây dựa trên các ràng buộc bài toán
        return new int[] {};
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1 (HashMap): [" + result1[0] + ", " + result1[1] + "]");

        // Test Case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2 (HashMap): [" + result2[0] + ", " + result2[1] + "]");

        // Test Case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3 (HashMap): [" + result3[0] + ", " + result3[1] + "]");
    }
}
