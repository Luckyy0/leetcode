# Analysis for Baseball Game
# *Phân tích cho bài toán Trận bóng chày*

## 1. Problem Essence & Stack Simulation
## *1. Bản chất vấn đề & Mô phỏng Ngăn xếp*

### The Challenge
### *Thách thức*
We need to maintain a history of scores where operations depend on previous entries. Specifically, calculating a sum of the last two or doubling the last value requires access to the most recent items, which perfectly fits the LIFO (Last-In, First-Out) behavior.
*Chúng ta cần duy trì một lịch sử điểm số, nơi các thao tác phụ thuộc vào các mục trước đó. Cụ thể, việc tính tổng của hai giá trị cuối hoặc gấp đôi giá trị cuối yêu cầu quyền truy cập vào các mục gần đây nhất, điều này hoàn toàn phù hợp với hành vi LIFO (Vào sau, Ra trước).*

---

## 2. Strategy: Stack-based Processing
## *2. Chiến lược: Xử lý dựa trên Ngăn xếp*

A **Stack** or a dynamically resizing **List** is ideal for tracking the valid scores in the record.
*Một **Ngăn xếp** (Stack) hoặc một **Danh sách** (List) là lý tưởng để theo dõi các điểm số hợp lệ.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** Create an empty stack `scores`.
    * **Khởi tạo:** Tạo một ngăn xếp `scores` trống.*

2.  **Iterate through operations:**
    * **Duyệt qua các thao tác:** *
    - **If Integer `x`:** Parse and push to `scores`.
    - **If `'+'`:** Peek at the top (last score) and the one below it (second to last), sum them, and push the sum.
    - **If `'D'`:** Peek at the top, multiply by 2, and push the result.
    - **If `'C'`:** Pop the top element from `scores`.

3.  **Final Sum:** After all operations, sum all elements remaining in the stack.
    * **Tổng cuối cùng:** Sau tất cả các thao tác, cộng tất cả các phần tử còn lại trong ngăn xếp.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Access Pattern:** The `'+'` and `'D'` operations only look at the most recent scores, making stack operations like `peek()` and `pop()` extremely efficient.
    * **Mô thức truy cập:** Thao tác `'+'` và `'D'` chỉ nhìn vào các điểm số gần nhất, giúp các thao tác ngăn xếp như `peek()` và `pop()` cực kỳ hiệu quả.*
*   **Safety:** The problem guarantees that for `'+'`, `'D'`, and `'C'`, the required historical data will always exist.
    * **An toàn:** Bài toán đảm bảo rằng các dữ liệu lịch sử cần thiết sẽ luôn tồn tại.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of operations. We process each operation once, each taking $O(1)$ time. 
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ in the worst case to store all numeric scores in the stack.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Operations:** ["5", "2", "C", "D", "+"]
1. "5": Stack = [5].
2. "2": Stack = [5, 2].
3. "C": Pop 2. Stack = [5].
4. "D": 2 * 5 = 10. Stack = [5, 10].
5. "+": 5 + 10 = 15. Stack = [5, 10, 15].
**Total:** 5 + 10 + 15 = 30.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Stack is the de-facto data structure for records with "undo" (`'C'`) or "context-dependent" (`'+'`, `'D'`) operations. It simplifies the logic from tracking complex indices to simple pointer management.
*Ngăn xếp là cấu trúc dữ liệu mặc định cho các bản ghi có thao tác "hoàn tác" (`'C'`) hoặc thao tác "phụ thuộc ngữ cảnh" (`'+'`, `'D'`).*
---
*Mọi cuộc chơi (Game) đều cần một bản ghi công bằng (Record). Trong thế giới của bóng chày kỳ lạ (Baseball Game), mỗi con số không chỉ là hiện tại, mà còn là nền tảng cho sự cộng dồn (Sum) và sự khuếch đại (Double). Dữ liệu dạy ta rằng bằng cách lưu giữ lịch sử một cách ngăn nắp (Stack), ta có thể chấp nhận cả những sai lầm (Cancel) và tiến tới kết quả cuối cùng với sự chính xác tuyệt đối.*
Every game (Game) needs an honest record (Record). In the world of the strange baseball (Baseball Game), every number is not just the present, but also the foundation for accumulation (Sum) and amplification (Double). Data teaches us that by keeping history neatly (Stack), we can accept even mistakes (Cancel) and advance to the final result with absolute precision.
