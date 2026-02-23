# Analysis for Minimum Size Subarray Sum
# *Phân tích cho bài toán Tổng mảng con kích thước tối thiểu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Subarray vs Subsequence
### *Mảng con vs Dãy con*
The problem asks for a **subarray** (contiguous elements), not a subsequence. This hints at Sliding Window or Prefix Sum solutions.
*Bài toán yêu cầu **mảng con** (các phần tử liên tiếp), không phải dãy con. Điều này gợi ý giải pháp Cửa sổ trượt hoặc Tổng tiền tố.*

### Positive Integers Only
### *Chỉ số nguyên dương*
This is a crucial constraint. Since all numbers are positive, adding a number always increases the sum, and removing a number always decreases the sum. This monotonicity allows us to use the **Two Pointer (Sliding Window)** technique.
*Vì tất cả các số đều dương, việc thêm một số luôn làm tăng tổng, và việc bớt một số luôn làm giảm tổng. Tính đơn điệu này cho phép sử dụng kỹ thuật **Hai con trỏ (Cửa sổ trượt)**.*

---

## 2. Approach 1: Sliding Window (O(N))
## *2. Hướng tiếp cận 1: Cửa sổ trượt (O(N))*

### Logic
### *Logic*
1.  Initialize `left = 0`, `currentSum = 0`, `minLen = Infinity`.
2.  Iterate `right` from 0 to `n`:
    - Add `nums[right]` to `currentSum`.
    - **While** `currentSum >= target`:
        - We found a valid window! Update `minLen = min(minLen, right - left + 1)`.
        - Try to shrink it from the left to see if we can get a smaller valid window:
            - `currentSum -= nums[left]`.
            - `left++`.
3.  If `minLen` is still Infinity, return 0.

*1. Khởi tạo `left`, `sum`, `minLen`. 2. Duyệt `right`. Cộng vào `sum`. Trong khi `sum >= target`: Cập nhật `minLen`. Thử thu nhỏ cửa sổ từ bên trái bằng cách trừ `nums[left]` và tăng `left`. 3. Trả về kết quả.*

---

## 3. Approach 2: Binary Search on Prefix Sums (O(N log N))
## *3. Hướng tiếp cận 2: Tìm kiếm nhị phân trên Tổng tiền tố (O(N log N))*

Since the numbers are positive, the Prefix Sum array is strictly increasing.
For each index `i`, we want to find the smallest index `j >= i` such that `Prefix[j] - Prefix[i] >= target`.
- `Prefix[j] >= target + Prefix[i]`.
We can use Binary Search to find this `j`.
*Vì các số là dương, mảng Tổng tiền tố tăng dần nghiêm ngặt. Với mỗi `i`, tìm `j` nhỏ nhất sao cho `Prefix[j] >= target + Prefix[i]` bằng Tìm kiếm nhị phân.*

---

## 4. Complexity Analysis (Sliding Window)
## *4. Phân tích độ phức tạp (Cửa sổ trượt)*

*   **Time Complexity:** $O(N)$. Each element is added to the window once (by `right`) and removed at most once (by `left`). Total $2N$ operations.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run (Sliding Window)
## *5. Chạy thử bằng hình ảnh (Cửa sổ trượt)*

**Input:** `target = 7`, `nums = [2, 3, 1, 2, 4, 3]`

1.  `r=0` (2): Sum=2.
2.  `r=1` (3): Sum=5.
3.  `r=2` (1): Sum=6.
4.  `r=3` (2): Sum=8 >= 7. **Valid**. Len=4 `[2,3,1,2]`.
    - Shrink: remove 2. Sum=6 < 7. Left at 1.
5.  `r=4` (4): Sum=10 >= 7. **Valid**.
    - Shrink: remove 3. Sum=7 >= 7. **Valid**. Len=3 `[1,2,4]`.
    - Shrink: remove 1. Sum=6 < 7. Left at 3.
6.  `r=5` (3): Sum=9 >= 7. **Valid**.
    - Shrink: remove 2. Sum=7 >= 7. **Valid**. Len=2 `[4,3]`.
    - Shrink: remove 4. Sum=3 < 7. Left at 5.

**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Minimum Size Subarray Sum is the textbook problem for "Dynamic Sliding Window". The key condition `while (sum >= target)` is what makes the window strictly contract to find the minimum. Remember that if the array contained negative numbers, this approach would fail (we would need a Deque or Prefix Sum + Map).
*Tổng mảng con kích thước tối thiểu là bài toán sách giáo khoa cho "Cửa sổ trượt động". Điều kiện vòng lặp `while` chính là thứ làm cho cửa sổ co lại để tìm giá trị tối thiểu. Hãy nhớ rằng nếu mảng chứa số âm, cách này sẽ sai (cần dùng Deque hoặc Tổng tiền tố + Map).*
---
*Đôi khi ít hơn lại là nhiều hơn. Cửa sổ nhỏ nhất thỏa mãn điều kiện chính là cửa sổ quý giá nhất.*
Sometimes less is more. The smallest window that satisfies the condition is the most precious one.
