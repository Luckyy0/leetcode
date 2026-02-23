# Analysis for Merge Sorted Array
# *Phân tích cho bài toán Hợp Nhất Mảng Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two sorted arrays `nums1` and `nums2`, and their lengths `m` and `n`. *Hai mảng đã sắp xếp `nums1` và `nums2`, và độ dài của chúng `m` và `n`.*
*   **Output:** `nums1` is modified in-place to contain the merged sorted result. *`nums1` được sửa đổi tại chỗ để chứa kết quả đã hợp nhất và được sắp xếp.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `nums1` has enough space to hold both arrays (`m + n`).
*   In-place modification required.
*   Time complexity target: $O(m + n)$.
*   *`nums1` có đủ không gian để chứa cả hai mảng (`m + n`).*
*   *Yêu cầu sửa đổi tại chỗ.*
*   *Mục tiêu độ phức tạp thời gian: $O(m + n)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Three Pointers (From Right to Left)
### *Hướng tiếp cận: Ba con trỏ (Từ Phải sang Trái)*

*   **Logic:**
    1.  Normally, we merge from left to right, but that would require extra space to avoid overwriting elements in `nums1`.
    2.  Instead, start from the end of both arrays and fill `nums1` from back to front. Since the end of `nums1` is empty (filled with `0`), we can fill it without extra space.
    3.  Use three pointers: `p1` at index `m-1` of `nums1`, `p2` at index `n-1` of `nums2`, and `p` at index `m+n-1` of `nums1`.
    4.  Compare `nums1[p1]` and `nums2[p2]`. Put the larger one at `nums1[p]` and move the corresponding pointers.

*   **Algorithm Steps:**
    1.  Initialize `p1 = m - 1`, `p2 = n - 1`, `p = m + n - 1`.
    2.  While `p2 >= 0`:
        *   If `p1 >= 0` and `nums1[p1] > nums2[p2]`:
            *   `nums1[p] = nums1[p1]`.
            *   `p1--`.
        *   Else:
            *   `nums1[p] = nums2[p2]`.
            *   `p2--`.
        *   `p--`.

*   **Complexity:**
    *   Time: $O(m + n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3`
1. `p1 = 2` (val 3), `p2 = 2` (val 6), `p = 5`.
2. `6 > 3`: `nums1[5] = 6`, `p2 = 1, p = 4`.
3. `5 > 3`: `nums1[4] = 5`, `p2 = 0, p = 3`.
4. `3 > 2`: `nums1[3] = 3`, `p1 = 1, p = 2`.
5. `2 == 2`: `nums1[2] = 2`, `p2 = -1, p = 1`.
Iteration stops since `p2 < 0`.
Result: `[1, 2, 2, 3, 5, 6]`.
---
*Việc đi từ phải sang trái là một kỹ thuật thông minh để tiết kiệm không gian bộ nhớ khi thao tác trên mảng đã sắp xếp.*
Going from right to left is a smart technique to save memory space when working on sorted arrays.
