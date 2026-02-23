# Analysis for Minimum Moves to Equal Array Elements II
# *Phân tích cho bài toán Số bước di chuyển Tối thiểu để Làm bằng các Phần tử II*

## 1. Problem Essence & Median as Target
## *1. Bản chất vấn đề & Số trung vị làm Mục tiêu*

### The Challenge
### *Thách thức*
Finding a target value $X$ such that the sum of absolute differences $\sum |nums[i] - X|$ is minimized. This is a classic statistical problem.

### Strategy: Median Selection
### *Chiến lược: Lựa chọn Số trung vị*

1.  **Mean vs. Median:** 
    - The **Mean** (Average) minimizes the sum of *squared* differences ($L_2$ norm).
    - The **Median** minimizes the sum of *absolute* differences ($L_1$ norm).
2.  **Why Median?**
    - Imagine two points $A$ and $B$. To minimize $|A-X| + |B-X|$, $X$ can be anywhere in between $[A, B]$.
    - For $n$ points, if we sort them, the optimal $X$ must be at the middle. If $X$ is moved away from the median, the distance to half of the points decreases while the distance to the other half increases by more (if $n$ is odd) or the same (if $n$ is even).
3.  **Algorithm:**
    - Sort the array.
    - Select the middle element as the target `median = nums[n/2]`.
    - Sum the absolute differences: `res += Math.abs(num - median)`.

---

## 2. Approach: Sorting and Summation
## *2. Hướng tiếp cận: Sắp xếp và Tính tổng*

### Logic
### *Logic*
(See above). Sorting the array allows us to quickly find the median in $O(N \log N)$. Once the target is found, a single pass calculates the total moves.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Mathematical Optimality:** Directly uses the property of $L_1$ minimization.
    *Tính tối ưu toán học: Sử dụng trực tiếp đặc tính của cực tiểu hóa chuẩn L1.*
*   **Robustness:** Handles outliers better than the mean approach.
    *Sự bền bỉ: Xử lý các giá trị ngoại lai tốt hơn cách tiếp cận dùng giá trị trung bình.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ for sorting.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(1)$ (or $O(\log N)$ for sorting stack).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 10, 2, 9]`
1. Sorted: `[1, 2, 9, 10]`.
2. Median (at `index 2` or `1`): Let's pick `nums[2] = 9` (or `2`).
3. If `X = 2`:
   - `|1-2| + |2-2| + |9-2| + |10-2| = 1 + 0 + 7 + 8 = 16`.
4. If `X = 9`:
   - `|1-9| + |2-9| + |9-9| + |10-9| = 8 + 7 + 0 + 1 = 16`.
Result: 16.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Select the median as the target value.
*Chọn số trung vị làm giá trị mục tiêu.*
---
*Trong cuộc sống, để hài lòng tất cả mọi người, ta không chọn điểm trung bình (mean) vì nó dễ bị kéo lệch bởi những kẻ cực đoan (outliers). Thay vào đó, ta chọn số trung vị (median) — người đứng ở vị trí cân bằng nhất trong đám đông. Sự thấu hiểu từ trung tâm sẽ dẫn đến tổng nỗ lực điều chỉnh (sum of moves) là nhỏ nhất. Công bằng không phải là cào bằng, mà là tìm thấy trung điểm của sự thấu cảm.*
In life, to please everyone, we do not choose the average (mean) because it is easily distorted by the extremists (outliers). Instead, we choose the median (median) — the person standing in the most balanced position in the crowd. Understanding from the center will lead to the smallest total adjustment effort (sum of moves). Justice is not to be equal, but to find the midpoint of empathy.
