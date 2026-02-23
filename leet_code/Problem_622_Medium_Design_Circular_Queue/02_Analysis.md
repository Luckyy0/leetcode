# Analysis for Design Circular Queue
# *Phân tích cho bài toán Thiết kế Hàng đợi Vòng*

## 1. Problem Essence & Circular Logic
## *1. Bản chất vấn đề & Logic Vòng*

### The Challenge
### *Thách thức*
A circular queue (Ring Buffer) allows reusing pre-allocated memory by looping the "end" back to the "beginning". The key is managing the `head` and `tail` pointers across fixed arrays without overwriting valid data.
*Hàng đợi vòng (Bộ đệm vòng) cho phép tái sử dụng bộ nhớ đã cấp phát trước bằng cách lặp "điểm cuối" quay lại "điểm đầu". Chìa khóa là quản lý các con trỏ `head` và `tail` trên các mảng cố định mà không ghi đè lên dữ liệu hợp lệ.*

---

## 2. Strategy: Array with Head and Count
## *2. Chiến lược: Mảng với Head và Count*

There are several ways to implement this. Using an `array`, a `head` index, and a `count` variable is the most straightforward and least error-prone.
*Có nhiều cách để thực hiện việc này. Sử dụng một `mảng`, một chỉ số `head` và một biến `count` là cách trực tiếp nhất và ít gây lỗi nhất.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **State Variables:**
    * **Các biến Trạng thái:** *
    - `int[] queue`: The storage.
    - `int head`: Index of the first element.
    - `int count`: Current number of elements in the queue.
    - `int capacity`: Maximum size ($k$).

2.  **isEmpty / isFull:**
    * **isEmpty / isFull:** *
    - `isEmpty`: `count == 0`
    - `isFull`: `count == capacity`

3.  **enQueue (Insert):**
    * **enQueue (Chèn):** *
    - Check `isFull()`. If true, return `false`.
    - Calculate tail index: `(head + count) % capacity`.
    - Place the new value at `queue[tail]`.
    - Increment `count`.
    - Return `true`.

4.  **deQueue (Remove):**
    * **deQueue (Xóa):** *
    - Check `isEmpty()`. If true, return `false`.
    - Move head: `head = (head + 1) % capacity`.
    - Decrement `count`.
    - Return `true`.

5.  **Front / Rear:**
    * **Front / Rear:** *
    - `Front()`: `queue[head]` if not empty.
    - `Rear()`: `queue[(head + count - 1) % capacity]` if not empty.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Modulo Operator:** The `%` operator is essential for the "wrapping" behavior. It ensures that `(head + count)` or `(head + 1)` always stays within bounds.
    * **Toán tử Chia lấy dư:** Toán tử `%` là thiết yếu cho hành vi "cuộn" vòng. Nó đảm bảo rằng `(head + count)` hoặc `(head + 1)` luôn nằm trong giới hạn.*
*   **Separation of Concerns:** Using a `count` variable simplifies the difference between an "empty" queue and a "full" queue (which both have `head == tail` in some implementations).
    * **Sự tách biệt các mối quan tâm:** Sử dụng biến `count` đơn giản hóa sự khác biệt giữa hàng đợi "trống" và hàng đợi "đầy" (cả hai đều có `head == tail` trong một số cách triển khai khác).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for all operations. Accessing and updating pointers/counts are constant-time operations.
    * **Độ phức tạp thời gian:** $O(1)$ cho tất cả các thao tác. Việc truy cập và cập nhật các con trỏ/bộ đếm là các thao tác trong thời gian hằng số.*
*   **Space Complexity:** $O(k)$ to store the array of size $k$.
    * **Độ phức tạp không gian:** $O(k)$ để lưu trữ mảng có kích thước $k$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**k = 3**
1. enQueue(1): head=0, count=1. Queue: [1, _, _]
2. enQueue(2): head=0, count=2. Queue: [1, 2, _]
3. enQueue(3): head=0, count=3 (Full). Queue: [1, 2, 3]
4. deQueue(): head=(0+1)%3=1, count=2. Queue: [_, 2, 3]
5. enQueue(4): tail=(1+2)%3=0. Queue: [4, 2, 3], head=1, count=3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The key to a bug-free circular buffer is avoiding index calculations that go out of bounds. Always use the modulo of the total capacity. Using a dedicated `count` variable is often cleaner than logic that relies purely on pointer distances.
*Chìa khóa để có một bộ đệm vòng không có lỗi là tránh các phép tính chỉ số vượt quá giới hạn. Luôn sử dụng phép chia lấy dư cho tổng dung lượng. Sử dụng một biến `count` riêng biệt thường sạch sẽ hơn logic chỉ dựa trên khoảng cách con trỏ.*
---
*Vòng lặp (Circular) là biểu tượng của sự vô tận và sự tái tạo. Trong cấu trúc dữ liệu, nó cho phép ta biến một không gian hữu hạn thành một dòng chảy liên tục, nơi cái kết thúc cũng là lúc khởi đầu. Sự tối ưu (Optimization) nằm ở việc không lãng phí bất kỳ ô nhớ nào, biến sự cố định của mảng thành sự linh hoạt của vòng tròn.*
Infinity (Circular) is a symbol of infinity and regeneration. In data structures, it allows us to turn a finite space into a continuous flow, where the ending is also the beginning. Optimization (Optimization) lies in not wasting any memory cells, turning the fixity of an array into the flexibility of a circle.
