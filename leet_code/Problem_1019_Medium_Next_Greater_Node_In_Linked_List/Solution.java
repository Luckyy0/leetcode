package leet_code.Problem_1019_Medium_Next_Greater_Node_In_Linked_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
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

/**
 * Problem 1019: Next Greater Node In Linked List
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class Solution {

    /**
     * Finds the next strictly greater node for each node in a linked list.
     * Strategy: Monotonic Stack + List Flattening (O(N) time & space).
     * 
     * @param head The head of the linked list.
     * @return An array of the next greater values.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Next Greater Element" (Phần tử lớn hơn tiếp theo) là Dạng Toán
     *         Kinh Điển (Khuôn mẫu) của Cấu trúc Dữ liệu "Ngăn Xếp Đơn Điệu"
     *         (Monotonic Stack).
     *         2. Điểm yếu của Linked List là không truy xuất ngược hay nhảy cóc
     *         được Index O(1). Nên bước ĐẦU TIÊN là phải "Dàn phẳng" danh sách
     *         liên kết vào 1 ArrayList (Mảng thường).
     *         3. Cách ngây thơ chạy O(N^2): Tại mỗi vị trí `i`, cho 1 vòng lặp con
     *         chạy cày từ `i+1` tới cuối để chực chờ bắt con Số Lớn Hơn. Chết đứ đừ
     *         vì TLE nếu danh sách toàn Lướt Giảm Dần!
     *         4. Cách Tối Ưu (Monotonic Stack) O(N):
     *         - Tạo 1 mảng Kết quả chuẩn (mặc định các cell = 0 hết).
     *         - Duy trì một cái Cột Ngăn Xếp (Stack). Lưu ý kỹ: ĐỒ VẬT NHÉT VÀO
     *         STACK LÀ "INDEX" (Vị trí i), TỐI KỴ KHÔNG NHÉT GIÁ TRỊ VÀO! (Bởi
     *         vì ta cần tọa độ Index để cập nhật đáp án).
     *         - Lướt mảng i từ đầu tới đích:
     *         + BỐC RA (POP): Nếu Giá Trị Đang Lướt (Tân binh) TO HƠN cái Giá Trị
     *         đứng tại Index nằm trên Đỉnh Cột (Kẻ yếu thế). Tuyệt Vời!
     *         Tân binh chính là "Khắc Tinh Khổng Lồ Kế Tiếp" mà Kẻ yếu thế
     *         kia mòn mỏi ngóng chờ.
     *         Cắn rứt Kẻ yếu thế khỏi Đỉnh Cột (pop), và chép Giá Trị Tân Binh
     *         Vào đúng Ô Index Đáp Án của Kẻ yếu thế! Lặp lại Cú Tát này cho
     *         tất cả những thằng yếu thế dưới Đỉnh tháp.
     *         + ĐẨY VÀO (PUSH): Đánh văng tụi nhỏ bé xong xuôi, thằng Tân binh `i`
     *         tự biết thân phận, cũng lủi thủi leo lên Cột chực chờ 1 ngày đẹp
     *         trời có Gã Bự hơn nó đập nó văng ra.
     *         5. Kết thúc vòng O(N), Những đứa còn thoi thóp nằm sót trên Cột nghĩa
     *         là Vĩnh Viễn Không Bao Giờ bị đập (Không có ai lớn hơn đoạn đuôi).
     *         Kệ thây tụi nó vì Mảng Đáp án vốn dĩ đã khởi tạo = 0 từ đầu rùi!
     */
    public int[] nextLargerNodes(ListNode head) {
        // Biến danh sách liên kết thành Mảng tĩnh bẹt
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int n = list.size();
        // Mảng đáp án toàn phần số 0
        int[] answer = new int[n];

        // Ngăn xếp chứa Index của những kẻ đang chờ Số Bự Hơn xuất hiện
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Giá trị Tân Binh hiện tại
            int currentVal = list.get(i);

            // Xử tử Kẻ Thua Cuộc gác trên Đỉnh Cột
            while (!stack.isEmpty() && currentVal > list.get(stack.peek())) {
                int victimIndex = stack.pop();
                // Gán án tử bự khổng lồ này làm câu trả lời cho Kẻ Thua Cuộc
                answer[victimIndex] = currentVal;
            }

            // Tân Binh gia nhập phái diện chịu trận (chờ phán xét từ những đứa i tiếp theo)
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [2,1,5]
        ListNode head1 = new ListNode(2, new ListNode(1, new ListNode(5)));
        System.out.println("Result 1: " + Arrays.toString(sol.nextLargerNodes(head1))); // expected [5, 5, 0]

        // Test 2: [2,7,4,3,5]
        ListNode head2 = new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5)))));
        System.out.println("Result 2: " + Arrays.toString(sol.nextLargerNodes(head2))); // expected [7, 0, 5, 5, 0]
    }
}
