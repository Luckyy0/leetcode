# Analysis for 4Sum
# *Phân tích cho bài toán Tổng 4 Số*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`, `target`. *Mảng `nums`, `target`.*
*   **Output:** List of quadruplets. *Danh sách các bộ bốn.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `N` up to 200. $O(N^3)$ is $8 \times 10^6$, which is acceptable.
    *`N` lên tới 200. $O(N^3)$ là $8 \times 10^6$, chấp nhận được.*
*   **Overflow:** Sum of four numbers can exceed 32-bit integer range since elements are up to $10^9$. We must use `long` for sum calculation.
    ***Tràn số:** Tổng của bốn số có thể vượt quá phạm vi số nguyên 32-bit vì các phần tử lên tới $10^9$. Chúng ta phải dùng `long` để tính tổng.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sorting + n-2 loops + Two Pointers
### *Hướng tiếp cận: Sắp xếp + n-2 vòng lặp + Hai Con Trỏ*

*   **Intuition:** Sort. Fix `i`. Fix `j`. Use Two Pointers `left`, `right`.
    *Ý tưởng: Sắp xếp. Cố định `i`. Cố định `j`. Sử dụng Hai Con Trỏ `left`, `right`.*
*   **Logic:**
    *   Sort `nums`.
    *   Loop `i` from `0` to `n-4`.
    *   Loop `j` from `i+1` to `n-3`.
    *   `l = j + 1`, `r = n - 1`.
    *   Calculate `sum = (long)nums[i] + nums[j] + nums[l] + nums[r]`.
    *   Check `sum` vs `target`.

*   **Handling Duplicates:**
    *   `if (i > 0 && nums[i] == nums[i-1]) continue`.
    *   `if (j > i+1 && nums[j] == nums[j-1]) continue`.
    *   Inside pointer loop, skip matches.

*   **Optimization (Pruning):**
    *   If `nums[i] + ...` is too large (`> target`), break.
    *   If `nums[i] + ...` is too small (`< target`), continue.

*   **Complexity:**
    *   Time: $O(N^3)$.
    *   Space: $O(1)$ (output excluded).

### Dry Run
### *Chạy thử*
`[1, 0, -1, 0, -2, 2]`. Sorted: `[-2, -1, 0, 0, 1, 2]`. Target 0.
1.  `i=0 (-2)`.
    *   `j=1 (-1)`. Target = 0 - (-2) - (-1) = 3. `l=2 (0)`, `r=5 (2)`. Sum=2 < 3. `l++`.
    *   ...
(Standard 4Sum logic).
