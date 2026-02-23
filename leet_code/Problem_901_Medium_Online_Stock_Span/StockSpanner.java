package leet_code.Problem_901_Medium_Online_Stock_Span;

import java.util.*;

/**
 * Problem 901: Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 */
public class StockSpanner {

    // Stack to store pairs of (price, span)
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    /**
     * Calculates the span of the current price efficiently.
     * Strategy: Monotonic Stack with Span Aggregation.
     * 
     * @param price Current price.
     * @return Span.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng một ngăn xếp đơn điệu (Monotonic Stack) để lưu các cặp
     *         (giá, span).
     *         2. Mục tiêu là tìm chuỗi liên tiếp các ngày trước đó có giá <= giá
     *         hôm nay.
     *         3. Khi một giá mới đến:
     *         - Khởi tạo span của nó là 1 (chính nó).
     *         - Kiểm tra đỉnh ngăn xếp: Nếu giá ở đỉnh <= giá hiện tại, nghĩa là
     *         chuỗi liên tiếp của giá ở đỉnh cũng thuộc về chuỗi liên tiếp của giá
     *         hiện tại.
     *         - Cộng dồn span của phần tử đỉnh vào span hiện tại, sau đó loại bỏ
     *         phần tử đỉnh.
     *         - Lặp lại cho đến khi ngăn xếp rỗng hoặc gặp giá lớn hơn.
     *         4. Đẩy cặp (giá hiện tại, span đã tính) vào ngăn xếp.
     */
    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[] { price, span });
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println("Next 100: " + stockSpanner.next(100)); // 1
        System.out.println("Next 80: " + stockSpanner.next(80)); // 1
        System.out.println("Next 60: " + stockSpanner.next(60)); // 1
        System.out.println("Next 70: " + stockSpanner.next(70)); // 2 (60, 70)
        System.out.println("Next 60: " + stockSpanner.next(60)); // 1
        System.out.println("Next 75: " + stockSpanner.next(75)); // 4 (60, 70, 60, 75)
        System.out.println("Next 85: " + stockSpanner.next(85)); // 6 (100 is > 85, so stop)
    }
}
