# Analysis for Min Stack
# *Phân tích cho bài toán Ngăn xếp tối thiểu*

## 1. Problem Essence & Structural Trade-offs
## *1. Bản chất vấn đề & Sự đánh đổi cấu trúc*

### The Challenge of O(1) Minimum
### *Thử thách về phần tử nhỏ nhất O(1)*
A standard stack (Last-In First-Out) naturally supports `push`, `pop`, and `top` in $O(1)$. However, finding the minimum element usually requires $O(N)$ by traversing the whole stack.
*Một ngăn xếp tiêu chuẩn tự nhiên hỗ trợ các thao tác `push`, `pop`, và `top` trong $O(1)$. Tuy nhiên, việc tìm phần tử nhỏ nhất thường yêu cầu $O(N)$ bằng cách duyệt qua toàn bộ ngăn xếp.*

To achieve $O(1)$ for `getMin()`, we must maintain auxiliary information about the minimum element at **every level** of the stack.
*Để đạt được $O(1)$ cho `getMin()`, chúng ta phải duy trì thông tin bổ trợ về phần tử nhỏ nhất tại **mọi cấp độ** của ngăn xếp.*

---

## 2. Approach: The Two-Stack Solution
## *2. Hướng tiếp cận: Giải pháp Hai ngăn xếp*

The most common and robust approach is to use two parallel stacks.
*Hướng tiếp cận phổ biến và mạnh mẽ nhất là sử dụng hai ngăn xếp song song.*

### How it works:
### *Cách thức hoạt động:*
1.  **`dataStack`**: Stores the actual data pushed by the user.
2.  **`minStack`**: Stores the minimum element encountered so far.
    - When pushing a value `x`:
        - Always push `x` to `dataStack`.
        - If `minStack` is empty OR `x` is less than or equal to the current top of `minStack`, push `x` to `minStack`.
    - When popping:
        - If the value being popped from `dataStack` is the same as the current top of `minStack`, pop from `minStack` as well.
        - Always pop from `dataStack`.

### Why this works?
### *Tại sao giải pháp này hiệu quả?*
The `minStack` effectively records the history of the "current minimum". Each entry in `minStack` corresponds to a state of the `dataStack`. When we remove the current minimum from the `dataStack`, the previous minimum is still safely at the top of the `minStack`.
*`minStack` ghi lại lịch sử của "giá trị nhỏ nhất hiện tại". Mỗi mục trong `minStack` tương ứng với một trạng thái của `dataStack`. Khi chúng ta loại bỏ giá trị nhỏ nhất hiện tại khỏi `dataStack`, giá trị nhỏ nhất trước đó vẫn nằm an toàn trên đỉnh của `minStack`.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Speed:** All functions are pure $O(1)$ operations (no loops, no searching).
    *Tốc độ: Tất cả các hàm đều là thao tác $O(1)$ thuần túy (không vòng lặp, không tìm kiếm).*
*   **Simplicity:** Using built-in `Stack` or `LinkedList` as the underlying container makes the code very readable and less prone to errors compared to manual array management.
    *Sự đơn giản: Sử dụng `Stack` hoặc `LinkedList` có sẵn làm bộ chứa bên dưới giúp mã rất dễ đọc và ít lỗi hơn so với việc tự quản lý mảng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for all operations (`push`, `pop`, `top`, `getMin`).
    *Độ phức tạp thời gian: $O(1)$ cho tất cả các thao tác.*
*   **Space Complexity:** $O(N)$. We use an additional stack that can grow up to the same size as the data stack (in the worst case where elements are pushed in non-increasing order).
    *Độ phức tạp không gian: $O(N)$. Chúng ta sử dụng một ngăn xếp bổ sung có thể tăng lên cùng kích thước với ngăn xếp dữ liệu.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Operations:** `push(-2)`, `push(0)`, `push(-3)`, `getMin()`, `pop()`, `getMin()`

1.  `push(-2)`: `data: [-2], min: [-2]`
2.  `push(0)`: `data: [-2, 0], min: [-2]` (0 > -2, don't push to min)
3.  `push(-3)`: `data: [-2, 0, -3], min: [-2, -3]` (-3 is the new min)
4.  `getMin()`: Peek `minStack` -> **-3**.
5.  `pop()`: Pop `dataStack`. It's -3. Since matches `minStack.peek()`, pop `minStack`.
    - `data: [-2, 0], min: [-2]`
6.  `getMin()`: Peek `minStack` -> **-2**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Min Stack is a foundational problem for understanding how to enhance a standard data structure to support auxiliary queries. There is a variation that uses only **one stack** by storing the difference between the current value and the current minimum, but that's much harder to read and prone to integer overflow. The two-stack solution is the preferred industry standard for its clarity and safety.
*Ngăn xếp tối thiểu là bài toán nền tảng để hiểu cách nâng cao một cấu trúc dữ liệu tiêu chuẩn nhằm hỗ trợ các truy vấn bổ trợ. Có một biến thể chỉ sử dụng **một ngăn xếp** bằng cách lưu trữ sự khác biệt giữa giá trị hiện tại và giá trị nhỏ nhất hiện tại, nhưng cách đó khó đọc hơn nhiều và dễ bị tràn số nguyên. Giải pháp hai ngăn xếp là tiêu chuẩn ngành được ưu tiên vì sự rõ ràng và an toàn.*
---
*Luôn có một tấm gương phản chiếu những gì nhỏ bé nhất, ngay cả khi những thứ khổng lồ đang che lấp mọi tầm nhìn.*
There is always a mirror reflecting the smallest things, even when giants block all vision.
