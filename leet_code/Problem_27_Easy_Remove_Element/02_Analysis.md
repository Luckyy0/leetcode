# Analysis for Remove Element
# *Phân tích cho bài toán Xóa Phần Tử*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`, integer `val`. *Mảng `nums`, số nguyên `val`.*
*   **Output:** Integer `k`. *Số nguyên `k`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 100. Very small.
*   $O(N)$ time, $O(1)$ space.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Pointers
### *Hướng tiếp cận: Hai Con Trỏ*

*   **Intuition:** Iterate with `i`. Maintain a pointer `k` (or `writer`) that indicates where the valid elements should be written.
    *Ý tưởng: Duyệt với `i`. Duy trì một con trỏ `k` (hoặc `writer`) chỉ định nơi các phần tử hợp lệ nên được ghi.*
*   **Algorithm Steps:**
    1.  `k = 0`.
    2.  Loop `i` from 0 to `nums.length - 1`:
        *   If `nums[i] != val`:
            *   `nums[k] = nums[i]`.
            *   `k++`.
    3.  Return `k`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[3, 2, 2, 3]`, `val = 3`.
1.  `i=0` (3). Equal to val. Skip.
2.  `i=1` (2). Not equal. `nums[0] = 2`. `k=1`. Array `[2, 2, 2, 3]`.
3.  `i=2` (2). Not equal. `nums[1] = 2`. `k=2`. Array `[2, 2, 2, 3]`.
4.  `i=3` (3). Equal. Skip.
Return 2.
