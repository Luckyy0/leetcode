# Analysis for Moving Average from Data Stream
# *Phân tích cho bài toán Trung bình Động từ Luồng Dữ liệu*

## 1. Problem Essence & Sliding Window
## *1. Bản chất vấn đề & Cửa sổ Trượt*

### The Challenge
### *Thách thức*
Maintain a window of fixed size and calculate the sum of elements within it efficiently.
As new data arrives, if the window is full, the oldest element must be removed.

### Strategy: Queue & Running Sum
### *Chiến lược: Hàng đợi & Tổng Cộng dồn*
1.  Use a **Queue** (or a circular buffer/array) to keep track of elements in the current window.
2.  Maintain a `runningSum` variable to store the sum of all elements currently in the queue.
3.  In each `next(val)` call:
    - If the queue has reached its maximum `size`, remove the oldest element from the queue and subtract its value from `runningSum`.
    - Add the new `val` to the queue and update `runningSum`.
    - Calculation: `movingAverage = runningSum / queue.size()`.

---

## 2. Approach: Queue
## *2. Hướng tiếp cận: Hàng đợi*

### Logic
### *Logic*
Using a `Deque` (like `ArrayDeque` or `LinkedList`) or a fixed-size array with pointers to implement a circular buffer. For simplicity and readability, a `Queue` works perfectly.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Efficiency:** Both addition and removal are $O(1)$ operations. The running sum allows $O(1)$ average calculation without re-summing.
    *Hiệu quả O(1): Cả việc thêm và xóa đều là các thao tác $O(1)$. Tổng cộng dồn cho phép tính trung bình $O(1)$ mà không cần tính lại tổng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ per `next()` call.
    *Độ phức tạp thời gian: $O(1)$ cho mỗi lần gọi `next()`.*
*   **Space Complexity:** $O(S)$ where S is the window size.
    *Độ phức tạp không gian: $O(S)$ với S là kích thước cửa sổ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Window Size:** 3
1.  `next(1)`: Queue: [1], sum: 1, avg: 1/1 = 1.0
2.  `next(10)`: Queue: [1, 10], sum: 11, avg: 11/2 = 5.5
3.  `next(3)`: Queue: [1, 10, 3], sum: 14, avg: 14/3 = 4.66
4.  `next(5)`: Queue: [10, 3, 5], 1 was removed. sum: 14-1+5=18, avg: 18/3 = 6.0

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Queue + Running Sum.
*Hàng đợi tiêu chuẩn + Tổng cộng dồn.*
---
*Cuộc sống luôn vận động, chúng ta không thể mang theo tất cả hành lý của quá khứ. Hãy giữ cho cửa sổ tâm hồn luôn tinh giản (fixed size), bỏ đi những gì đã cũ để đón nhận những giá trị mới, và luôn tìm kiếm sự cân bằng (average) trong mọi khoảnh khắc.*
Life is always moving, we cannot carry all the baggage of the past. Keep the window of your soul simple (fixed size), discard what is old to welcome new values, and always seek balance (average) in every moment.
