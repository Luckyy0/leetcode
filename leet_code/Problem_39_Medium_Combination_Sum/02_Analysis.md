# Analysis for Combination Sum
# *Phân tích cho bài toán Tổng Các Tổ Hợp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of distinct integers `candidates`, integer `target`. *Mảng các số nguyên phân biệt `candidates`, số nguyên mục tiêu `target`.*
*   **Output:** List of lists of integers. *Danh sách các danh sách số nguyên.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Unlimited use of each candidate. *Sử dụng mỗi ứng viên không giới hạn số lần.*
*   Candidates are distinct. *Các ứng viên là phân biệt.*
*   Small constraints (`candidates.length <= 30`, `target <= 500`) suggest backtracking. *Các ràng buộc nhỏ gợi ý sử dụng quay lui.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS)
### *Hướng tiếp cận: Quay lui (DFS)*

*   **Intuition:** We can explore combinations by either including the current candidate and staying at the same index (since we can reuse it) or skipping the current candidate and moving to the next index.
    *Ý tưởng: Chúng ta có thể khám phá các tổ hợp bằng cách chọn ứng viên hiện tại và ở lại cùng chỉ số (vì chúng ta có thể tái sử dụng nó) hoặc bỏ qua ứng viên hiện tại và di chuyển đến chỉ số tiếp theo.*
*   **Algorithm Steps:**
    1.  Sort the `candidates` array (optional, but helps with pruning).
    2.  `backtrack(index, currentTarget, currentCombination)`:
        *   Base case: If `currentTarget == 0`, we found a valid combination. Add a copy of `currentCombination` to results.
        *   Base case: If `currentTarget < 0` or `index == candidates.length`, stop exploring this path.
        *   Explore including `candidates[index]`:
            *   Add `candidates[index]` to `currentCombination`.
            *   `backtrack(index, currentTarget - candidates[index], currentCombination)`.
            *   Remove `candidates[index]` from `currentCombination` (backtrack).
        *   Explore skipping `candidates[index]`:
            *   `backtrack(index + 1, currentTarget, currentCombination)`.

*   **Complexity:**
    *   Time: $O(2^T)$, where $T$ is the target value. In the worst case, we can have many branches. However, pruning and the nature of the problem make it manageable.
    *   Space: $O(T/min\_candidate)$ for the recursion stack.

### Dry Run
### *Chạy thử*
`candidates = [2,3,6,7], target = 7`
1.  Try 2: [2]. target=5.
2.  Try 2 again: [2,2]. target=3.
3.  Try 2 again: [2,2,2]. target=1.
4.  Try 2 again: [2,2,2,2]. target=-1. Fail.
5.  Backtrack. Try 3 at index 1: [2,2,3]. target=0. **Success! [2,2,3]**
6.  Eventually try 7: [7]. target=0. **Success! [7]**
Final: [[2,2,3], [7]]
