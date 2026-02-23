# Analysis for Next Permutation
# *Phân tích cho bài toán Hoán Vị Tiếp Theo*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`. *Mảng `nums`.*
*   **Output:** Void (In-place modification). *Void (Sửa đổi tại chỗ).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `N` up to 100.
*   $O(N)$ time preferred. $O(1)$ space required.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Single Pass with Reversal
### *Hướng tiếp cận: Một Lần Duyệt Với Đảo Ngược*

*   **Intuition:**
    1.  Find the first pair from the right where `nums[i] < nums[i+1]`. This `i` indicates the pivot point where we can increase the sequence.
        *Tìm cặp đầu tiên từ bên phải mà `nums[i] < nums[i+1]`. `i` này chỉ ra điểm chốt nơi chúng ta có thể tăng chuỗi.*
    2.  If no such `i` exists, the array is decreasing (last permutation). Reverse it to smallest.
        *Nếu không có `i` như vậy, mảng đang giảm dần (hoán vị cuối cùng). Đảo ngược nó về nhỏ nhất.*
    3.  If `i` is found, find the smallest element in the subarray `nums[i+1:]` that is greater than `nums[i]`. Let this be at index `j`.
        *Nếu tìm thấy `i`, tìm phần tử nhỏ nhất trong mảng con `nums[i+1:]` lớn hơn `nums[i]`. Gọi đây là tại chỉ số `j`.*
    4.  Swap `nums[i]` and `nums[j]`.
    5.  Reverse the subarray `nums[i+1:]` (which is currently in decreasing order) to make it increasing (lexicographically smallest suffix).
        *Đảo ngược mảng con `nums[i+1:]` (hiện đang theo thứ tự giảm dần) để làm cho nó tăng dần (hậu tố nhỏ nhất về mặt từ điển).*

*   **Algorithm Steps:**
    1.  `i = n - 2`. While `i >= 0` and `nums[i] >= nums[i+1]`, `i--`.
    2.  If `i >= 0`:
        *   `j = n - 1`. While `nums[j] <= nums[i]`, `j--`.
        *   Swap `nums[i]`, `nums[j]`.
    3.  Reverse `nums` from `i + 1` to `n - 1`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1, 2, 3]`
1.  `i`: Compare 2 and 3. `2 < 3`. Stop at `i=1` (val 2).
2.  `j`: From right. `3 > 2`. Stop at `j=2` (val 3).
3.  Swap `nums[1]` (2) and `nums[2]` (3). `[1, 3, 2]`.
4.  Reverse `nums[2:]`. Single element. `[1, 3, 2]`. Result correct.

`[3, 2, 1]`
1.  `i`: compare 2,1 (no), 3,2 (no). `i` becomes -1.
2.  Reverse `0` to end. `[1, 2, 3]`. Correct.
