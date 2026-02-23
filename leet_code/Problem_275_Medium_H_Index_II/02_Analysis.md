# Analysis for H-Index II
# *Phân tích cho bài toán H-Index II*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm nhị phân*

### The Sorted Input
### *Đầu vào đã sắp xếp*
Array is sorted ascending: `[0, 1, 3, 5, 6]`. $N=5$.
We want max `h` such that `h` papers have `citations >= h`.
In a sorted array, if we pick index `i`, then `citations[i]` is the "lowest" citation count among the `N - i` papers from `i` to `end`.
So, the number of papers with at least `citations[i]` citations is `N - i`.
We want to find the largest `N - i` such that `citations[i] >= N - i`.

Let `h = N - i`. We check `citations[i] >= h`.

### Strategy
### *Chiến lược*
We want the *first* index `i` (from left) such that `citations[i] >= N - i`.
Why first? Because `N - i` (the count) decreases as `i` increases. We want to maximize `N - i`, so we want to minimize `i`.
This suggests **Binary Search**.

---

## 2. Approach: Binary Search
## *2. Hướng tiếp cận: Tìm kiếm nhị phân*

### Logic
### *Logic*
1.  `low = 0`, `high = n - 1`. `ans = 0`.
2.  While `low <= high`:
    - `mid = low + (high - low) / 2`.
    - `count = n - mid`. (Number of papers from mid to end).
    - If `citations[mid] >= count`:
        - Potential answer found. The count `count` is a valid h-index candidate.
        - But we want to maximize `count`, which means minimizing `mid`.
        - Try left: `high = mid - 1`.
        - Store `n - mid` as potential result. (Actually, if `citations[mid] >= count`, then `mid` satisfies constraint, so `count` is valid. A smaller `mid` would give larger `count` but might violate condition).
    - Else (`citations[mid] < count`):
        - `citations` too small. Need larger citations -> move right.
        - `low = mid + 1`.
3.  Return `n - low`.
    - Wait, verifying edge cases.
    - If all fail: `low` becomes `n`. `n - n = 0`. Correct.
    - If `citations[mid] >= n - mid`, we record it and move left.
    - Actually, `n - low` works perfectly.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Data:** Allows skipping linear scan.
    *Dữ liệu đã sắp xếp: Cho phép bỏ qua quét tuyến tính.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *Độ phức tạp thời gian: $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[0, 1, 3, 5, 6]`. $N=5$.
1.  `low=0, high=4`. `mid=2` (val=3).
    - `count = 5 - 2 = 3`.
    - `citations[2] (3) >= 3`. Valid. Try smaller `mid`.
    - `high = 1`.
2.  `low=0, high=1`. `mid=0` (val=0).
    - `count = 5 - 0 = 5`.
    - `citations[0] (0) < 5`. Invalid. Need larger vals.
    - `low = 1`.
3.  `low=1, high=1`. `mid=1` (val=1).
    - `count = 5 - 1 = 4`.
    - `citations[1] (1) < 4`. Invalid.
    - `low = 2`.
4.  `low` (2) > `high` (1). Break.
Result: `N - low` = `5 - 2 = 3`.

Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Binary Search on Answer pattern.
*Mẫu Tìm kiếm Nhị phân trên Kết quả tiêu chuẩn.*
---
*Khi mọi thứ đã vào trật tự (sorted), việc tìm vị trí của mình (h-index) trở nên nhanh chóng và rõ ràng hơn. Trật tự mang lại tốc độ.*
When things are in order (sorted), finding one's place (h-index) becomes faster and clearer. Order brings speed.
