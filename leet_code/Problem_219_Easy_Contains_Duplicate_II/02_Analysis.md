# Analysis for Contains Duplicate II
# *Phân tích cho bài toán Chứa bản sao II*

## 1. Problem Essence & Sliding Window
## *1. Bản chất vấn đề & Cửa sổ trượt*

### The Question
### *Câu hỏi*
Is there any pair `(i, j)` such that `nums[i] == nums[j]` AND `j - i <= k`?
*Có cặp `(i, j)` nào sao cho `nums[i] == nums[j]` VÀ `j - i <= k` không?*

### The Concept
### *Khái niệm*
This means we only care about duplicates within a "window" of size `k`.
We can use a **Sliding Window** or just a **HashMap/HashSet** that stores recent elements.
*Điều này có nghĩa là chúng ta chỉ quan tâm đến các bản sao trong một "cửa sổ" có kích thước `k`.*

---

## 2. Approach: HashSet (Sliding Window)
## *2. Hướng tiếp cận: HashSet (Cửa sổ trượt)*

### Logic
### *Logic*
1.  Initialize a `Set`.
2.  Iterate `i` from 0 to `n`:
    - If `i > k`, remove `nums[i - k - 1]` from the Set (Element fell out of window).
    - If `nums[i]` is in Set, return `true`.
    - Add `nums[i]` to Set.
3.  If loop finishes, return `false`.

### Storage Check
### *Kiểm tra bộ nhớ*
The Set will contain at most `k + 1` elements.
*Set sẽ chứa tối đa `k + 1` phần tử.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Fixed Space:** Space usage is bounded by `O(min(N, K))`.
    *Không gian cố định: Bị giới hạn bởi `O(min(N, K))`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each element is added and removed at most once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(min(N, K))$.
    *Độ phức tạp không gian: $O(min(N, K))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [1,2,3,1], k = 3`

1.  i=0 (1). Set: `{1}`.
2.  i=1 (2). Set: `{1, 2}`.
3.  i=2 (3). Set: `{1, 2, 3}`.
4.  i=3 (1).
    - Window size check: `3 > 3? No`. (Wait, condition is remove `i-k-1` if `i > k`).
    - `i=3`. `i > k` is False (3 > 3). No remove.
    - Set contains 1? **Yes**. Return True.

**Input:** `nums = [1,2,3,1,2,3], k = 2`

1.  i=0 (1). Set `{1}`.
2.  i=1 (2). Set `{1, 2}`.
3.  i=2 (3). Set `{1, 2, 3}`.
4.  i=3 (1).
    - `i > k` (3 > 2). Remove `nums[3-2-1] = nums[0] = 1`. Set `{2, 3}`.
    - Set contains 1? No. Add 1. Set `{1, 2, 3}`.
    ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is the standard "Fixed Size Sliding Window" problem using a Set. It is slightly more optimized than just storing indices in a Map because we limit the Set size to `k`, keeping operations fast and memory low.
*Đây là bài toán "Cửa sổ trượt kích thước cố định" tiêu chuẩn sử dụng Set. Nó tối ưu hơn Map vì giới hạn kích thước Set ở `k`, giữ tốc độ nhanh và bộ nhớ thấp.*
---
*Ký ức có hạn (k), những gì đã trôi qua quá lâu sẽ bị lãng quên để nhường chỗ cho hiện tại.*
Memory is limited (k), what has passed too long ago will be forgotten to make room for the present.
