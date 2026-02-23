# Analysis for Design Circular Deque
# *Phân tích cho bài toán Thiết kế Hàng đợi kép Vòng*

## 1. Problem Essence & Double-Ended Circular Logic
## *1. Bản chất vấn đề & Logic Vòng hai đầu*

### The Challenge
### *Thách thức*
A circular deque (Double-Ended Queue) extends the circular queue by allowing insertions and deletions at both the `front` and the `rear`. The challenge is to manage the wrapping arithmetic correctly for both directions.
*Hàng đợi kép vòng (Deque) mở rộng hàng đợi vòng bằng cách cho phép chèn và xóa ở cả "phía trước" (front) và "phía sau" (rear). Thách thức là quản lý các phép toán số học quay vòng chính xác cho cả hai hướng.*

---

## 2. Strategy: Array with Head and Tail Pointers
## *2. Chiến lược: Mảng với con trỏ Head và Tail*

We can use a fixed-size array and two pointers, `front` and `rear`, to track the boundaries.
*Chúng ta có thể sử dụng một mảng kích thước cố định và hai con trỏ `front` và `rear` để theo dõi các ranh giới.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **State Variables:**
    - `int[] deque`: The storage array.
    - `int k`: Maximum capacity.
    - `int front`: Pointer to the first element's position.
    - `int rear`: Pointer to the *next* available position at the back (or many variations thereof).
    - `int size`: Current number of elements to simplify `isEmpty`/`isFull`.

2.  **Arithmetic for Wrapping:**
    - **Move Front Forward:** `(front + 1) % k`.
    - **Move Front Backward:** `(front - 1 + k) % k`.
    - **Move Rear Forward:** `(rear + 1) % k`.
    - **Move Rear Backward:** `(rear - 1 + k) % k`.

3.  **Operations:**
    - `insertFront`: Move `front` backward, then place value.
    - `insertLast`: Place value at `rear`, then move `rear` forward.
    - `deleteFront`: Move `front` forward.
    - `deleteLast`: Move `rear` backward.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Pointers vs. Size:** Using a `size` variable makes `isEmpty` and `isFull` trivial. Alternatively, you could use a `capacity + 1` array and keep one slot empty to distinguish between full and empty, but `size` is cleaner.
    * **Con trỏ so với Kích thước:** Sử dụng biến `size` làm cho `isEmpty` và `isFull` trở nên tầm thường. Một cách khác là dùng mảng `capacity + 1` và để trống một ô, nhưng dùng `size` gọn gàng hơn.*
*   **Modulo Symmetry:** Adding `k` before taking the modulo when decrementing ensures the result stays positive in languages like Java.
    * **Tính đối xứng Modulo:** Cộng thêm `k` trước khi lấy modulo khi giảm con trỏ đảm bảo kết quả luôn dương trong các ngôn ngữ như Java.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for all operations. Just pointer manipulation and array access.
    * **Độ phức tạp thời gian:** $O(1)$ cho tất cả các thao tác. Chỉ là thao tác con trỏ và truy cập mảng.*
*   **Space Complexity:** $O(k)$ to store the array of size $k$.
    * **Độ phức tạp không gian:** $O(k)$ để lưu trữ mảng kích thước $k$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**k = 3**
1. `insertLast(1)`: `rear=0`, place 1, `rear=1`. Deque: `[1, _, _]`. `size=1`.
2. `insertLast(2)`: `rear=1`, place 2, `rear=2`. Deque: `[1, 2, _]`. `size=2`.
3. `insertFront(3)`: `front=(0-1+3)%3=2`, place 3. Deque: `[1, 2, 3]`. `size=3`.
4. `getRear()`: `(rear-1+3)%3=1`. Value: `deque[1] = 2`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Circular Deques are the backbone of many sliding window problems. Master the `(ptr + k \pm 1) % k` pattern to handle wrap-around flawlessly.
*Hàng đợi kép vòng là xương sống của nhiều bài toán cửa sổ trượt. Hãy thành thạo mô thức `(ptr + k \pm 1) % k` để xử lý việc quay vòng một cách hoàn hảo.*
---
*Sự hai đầu (Double-ended) và tính xoay vòng (Circular) tạo nên một cấu trúc linh hoạt. Trong lập trình, Deque cho phép dữ liệu luân chuyển tự do từ cả hai phía, biến một mảng tĩnh thành một dòng chảy vô hạn. Dữ liệu dạy ta rằng ranh giới chỉ là tương đối khi ta biết cách kết nối điểm cuối (Rear) trở lại điểm đầu (Front).*
The double-ended (Double-ended) and circular (Circular) nature create a flexible structure. In programming, Deque allows data to flow freely from both sides, turning a static array into an infinite flow. Data teaches us that boundaries are only relative when we know how to connect the end (Rear) back to the beginning (Front).
