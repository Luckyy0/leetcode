# Analysis for Minimum Moves to Equal Array Elements
# *Phân tích cho bài toán Số lượng Bước di chuyển Tối thiểu để Làm bằng các Phần tử trong Mảng*

## 1. Problem Essence & Mathematical Equivalence
## *1. Bản chất vấn đề & Sự tương đương Toán học*

### The Challenge
### *Thách thức*
We need to make all elements equal by incrementing $n-1$ elements in each move. Finding which elements to increment in each step is complex. However, there's a simple mathematical trick.

### Strategy: Relative Difference
### *Chiến lược: Sự khác biệt Tương đối*

1.  **Observation:** Increasing $n-1$ elements by 1 is **relatively equivalent** to decreasing exactly 1 element by 1, in terms of reaching a state where everyone is equal.
    - Example: `[1, 2, 3]`.
    - Increase `[1, 2]` $\to$ `[2, 3, 3]`. (Relative difference between 3 and others decreases).
    - This is like taking `[1, 2, 3]` and decreasing `3` $\to$ `[1, 2, 2]`.
2.  **Target State:** To use the minimum number of moves, everyone should be reduced to the **current minimum** value in the array.
3.  **Result:** The total moves is the sum of differences between each element and the minimum element:
    $Moves = \sum_{i=0}^{n-1} (nums[i] - min(nums))$

---

## 2. Approach: Simple Summation
## *2. Hướng tiếp cận: Tổng cộng Đơn giản*

### Logic
### *Logic*
(See above). We just need one pass to find the minimum value and another pass (or the same pass with total sum) to calculate the result.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Simple linear scan.
    *Hiệu quả O(N): Duyệt tuyến tính đơn giản.*
*   **O(1) Space:** only a few variables needed.
    *Không gian O(1): Chỉ cần một vài biến.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of `nums`.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 3]`
1. Min value = 1.
2. Moves:
   - For 1: `1 - 1 = 0`.
   - For 2: `2 - 1 = 1`.
   - For 3: `3 - 1 = 2`.
Total = $0 + 1 + 2 = 3$.
Result: 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Math formula: Sum - n * min.
*Công thức toán học: Tổng - n * min.*
---
*Đôi khi để đạt được sự bình đẳng (equality), ta không nhất thiết phải kéo tất cả mọi người đi lên (increment n-1). Thay vào đó, việc nhìn nhận sự thấu hiểu và nỗ lực điều chỉnh từ những điểm cao nhất (relative decrement) lại mang đến một giải pháp tinh gọn và thanh thoát hơn. Sự thông thái nằm ở việc tìm ra góc nhìn đơn giản nhất cho một vấn đề phức tạp.*
Sometimes to achieve equality (equality), we do not necessarily have to pull everyone up (increment n-1). Instead, perceiving understanding and adjustment efforts from the highest points (relative decrement) brings a more concise and elegant solution. Wisdom lies in finding the simplest perspective for a complex problem.
