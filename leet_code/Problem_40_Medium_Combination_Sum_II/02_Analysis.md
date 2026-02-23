# Analysis for Combination Sum II
# *Phân tích cho bài toán Tổng Các Tổ Hợp II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of integers `candidates`, integer `target`. *Mảng các số nguyên `candidates`, số nguyên mục tiêu `target`.*
*   **Output:** List of lists of integers. *Danh sách các danh sách số nguyên.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Each candidate can be used only once. *Mỗi ứng viên chỉ có thể được sử dụng một lần.*
*   `candidates` can have duplicates. *`candidates` có thể có các giá trị trùng lặp.*
*   The output must not have duplicate combinations. *Kết quả không được có các tổ hợp trùng lặp.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS) with Sorting
### *Hướng tiếp cận: Quay lui (DFS) với Sắp xếp*

*   **Intuition:** Sort the array first. During backtracking, if we encounter the same number at the same recursion level, skip it to avoid duplicate combinations.
    *Ý tưởng: Sắp xếp mảng trước. Trong quá trình quay lui, nếu chúng ta bắt gặp cùng một số ở cùng một cấp độ đệ quy, hãy bỏ qua nó để tránh các tổ hợp trùng lặp.*
*   **Algorithm Steps:**
    1.  Sort `candidates`.
    2.  `backtrack(index, currentTarget, currentCombination)`:
        *   Base case: If `currentTarget == 0`, add `currentCombination` to results.
        *   Base case: If `currentTarget < 0`, return.
        *   Loop `i` from `index` to `candidates.length - 1`:
            *   **Crucial Step:** If `i > index` and `candidates[i] == candidates[i-1]`, skip this iteration (prevents duplicates at same level).
            *   Add `candidates[i]` to `currentCombination`.
            *   `backtrack(i + 1, currentTarget - candidates[i], currentCombination)`.
            *   Remove `candidates[i]` (backtrack).

*   **Complexity:**
    *   Time: $O(2^N)$, where $N$ is the length of `candidates`. Sorting takes $O(N \log N)$.
    *   Space: $O(N)$ for recursion stack.

### Dry Run
### *Chạy thử*
`candidates = [10,1,2,7,6,1,5], target = 8`
1.  Sorted: `[1, 1, 2, 5, 6, 7, 10]`
2.  Start with first 1: `[1]`. target=7.
3.  Next is second 1: `[1, 1]`. target=6.
4.  Try 2, 5... eventually find `[1, 1, 6]`.
5.  Backtrack to level 1. Skip the second 1 because `candidates[1] == candidates[0]`.
6.  Try 2: `[1, 2, 5]`.
... and so on.
Final results: `[[1,1,6], [1,2,5], [1,7], [2,6]]`
