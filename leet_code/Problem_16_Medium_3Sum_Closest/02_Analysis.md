# Analysis for 3Sum Closest
# *Phân tích cho bài toán Tổng 3 Số Gần Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`, Integer `target`. *Mảng `nums`, Số nguyên `target`.*
*   **Output:** Integer (The closest sum). *Số nguyên (Tổng gần nhất).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `N` up to 500. $O(N^2)$ is $250,000$, which is very fast.
    *`N` lên tới 500. $O(N^2)$ là $250,000$, rất nhanh.*
*   $O(N^3)$ is $1.25 \times 10^8$, might be slow but likely acceptable in some languages, but we should aim for $O(N^2)$.
    *$O(N^3)$ là $1.25 \times 10^8$, có thể chậm nhưng có khả năng chấp nhận được ở một số ngôn ngữ, nhưng chúng ta nên nhắm tới $O(N^2)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sorting + Two Pointers
### *Hướng tiếp cận: Sắp xếp + Hai Con Trỏ*

*   **Intuition:** Sort the array. Iterate `i` as the first element. Use `left` and `right` pointers for the remaining two. Calculate `sum`. Check deviation from `target`.
    *Ý tưởng: Sắp xếp mảng. Duyệt `i` là phần tử đầu tiên. Sử dụng con trỏ `left` và `right` cho hai phần tử còn lại. Tính `sum`. Kiểm tra độ lệch so với `target`.*
*   **Update Logic:**
    *   If `Math.abs(sum - target) < Math.abs(closestSum - target)`, update `closestSum`.
    *   If `sum < target`, we need a larger sum, so `left++`.
    *   If `sum > target`, we need a smaller sum, so `right--`.
    *   If `sum == target`, return `sum` immediately (diff is 0).

*   **Algorithm Steps:**
    1.  Sort `nums`.
    2.  `closestSum = nums[0] + nums[1] + nums[2]`.
    3.  Loop `i` from `0` to `n-3`:
        *   `l = i + 1`, `r = n - 1`.
        *   While `l < r`:
            *   `currentSum = nums[i] + nums[l] + nums[r]`.
            *   Compare with `closestSum`. Update if closer.
            *   Move `l` or `r`.
    4.  Return `closestSum`.

*   **Complexity:**
    *   Time: $O(N^2)$.
    *   Space: $O(1)$ (ignoring sort space).

### Dry Run
### *Chạy thử*
`nums = [-1, 2, 1, -4]`, `target = 1`.
Sorted: `[-4, -1, 1, 2]`.
`closest` init: `-4 + -1 + 1 = -4`. Diff: `|-4 - 1| = 5`.
1.  `i=0` (`-4`). `l=1` (`-1`), `r=3` (`2`).
    *   `sum = -4 + -1 + 2 = -3`. Diff: `|-3 - 1| = 4`. Closer than 5. `closest = -3`.
    *   Sum (-3) < Target (1) -> `l` moves to 2 (`1`).
    *   `sum = -4 + 1 + 2 = -1`. Diff: `|-1 - 1| = 2`. Closer than 4. `closest = -1`.
    *   Sum (-1) < Target (1) -> `l` moves to 3 (==r). Loop ends.
2.  `i=1` (`-1`). `l=2` (`1`), `r=3` (`2`).
    *   `sum = -1 + 1 + 2 = 2`. Diff: `|2 - 1| = 1`. Closer than 2. `closest = 2`.
    *   Sum (2) > Target (1) -> `r` moves. Loop ends.
Return 2.
