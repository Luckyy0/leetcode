# Analysis for Online Stock Span
# *Phân tích cho bài toán Nhịp độ Chứng khoán Trực tuyến*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
For each incoming price, find the number of consecutive days (including today, going backward) where the price was $\le$ today's price.
*Với mỗi giá cổ phiếu mới, tìm số ngày liên tiếp (bao gồm cả hôm nay, lùi về quá khứ) mà giá nhỏ hơn hoặc bằng giá hôm nay.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We need to find the **Previous Greater Element**.
- If today's price is $P$, we want to find the nearest previous day with price $> P$. The span is the difference in indices.
- However, since prices come in a stream, we can maintain a **Monotonic Stack** of `(price, span)` pairs.
- When a new price comes in:
  - If it's greater than the price at the top of the stack, it means the top element is part of the current span (it's smaller). We can pop it and add its span to the current span.
  - Repeat until we find a price greater than the current price or the stack is empty.
  - Push the current price and its calculate span onto the stack.
*Chúng ta cần tìm **Phần tử Lớn hơn Trước đó**. Nếu giá hôm nay là $P$, ta muốn tìm ngày gần nhất trước đó có giá $> P$. Nhịp độ là hiệu số chỉ số. Tuy nhiên, vì giá đến theo luồng, ta có thể duy trì một **Ngăn xếp Đơn điệu** các cặp `(giá, nhịp độ)`. Khi có giá mới: Nếu nó lớn hơn giá ở đỉnh ngăn xếp, nghĩa là phần tử đỉnh là một phần của nhịp độ hiện tại (nhỏ hơn). Ta lấy nó ra và cộng nhịp độ của nó vào nhịp độ hiện tại. Lặp lại cho đến khi gặp giá lớn hơn hoặc ngăn xếp rỗng. Đẩy giá hiện tại và nhịp độ đã tính vào ngăn xếp.*

---

## 2. Strategy: Monotonic Stack
## *2. Chiến lược: Ngăn xếp Đơn điệu*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Stack:** Store pairs `int[]{price, span}`.
    *   **Khởi tạo Ngăn xếp:** Lưu các cặp `int[]{price, span}`.*

2.  **Next(price):**
    - `span = 1` (Current day counts as 1).
    - While stack is not empty AND `stack.peek()[0] <= price`:
        - `span += stack.pop()[1]`.
        - Asking "Why add spans?" because the popped element already "absorbed" the spans of elements smaller than *it* before it. So its span represents a contiguous block of smaller elements. By adding it, we extend our current block.
    - Push `{price, span}` to stack.
    - Return `span`.
    *   **Next(price):** `span = 1`. Trong khi ngăn xếp không rỗng VÀ giá đỉnh <= giá hiện tại: `span += stack.pop()[1]`. Tại sao cộng span? Vì phần tử bị pop đã đại diện cho một khối các phần tử nhỏ hơn liền kề. Đẩy `{price, span}` vào ngăn xếp. Trả về `span`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ amortized per call. Each element is pushed once and popped at most once.
    *   **Độ phức tạp thời gian:** $O(1)$ trung bình cho mỗi lần gọi. Mỗi phần tử được đẩy vào một lần và lấy ra tối đa một lần.*
*   **Space Complexity:** $O(N)$ in the worst case (e.g., decreasing prices).
    *   **Độ phức tạp không gian:** $O(N)$ trong trường hợp xấu nhất (giá giảm dần).*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using the span aggregation technique within the monotonic stack avoids needing to store indices explicitly or traverse backwards manually.
*Sử dụng kỹ thuật cộng dồn nhịp độ trong ngăn xếp đơn điệu giúp tránh phải lưu chỉ số hoặc duyệt ngược thủ công.*
