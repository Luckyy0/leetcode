# Analysis for Permutations II
# *Phân tích cho bài toán Hoán Vị II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums` (may contain duplicates). *Mảng `nums` (có thể chứa các phần tử trùng lặp).*
*   **Output:** List of unique permutations. *Danh sách các hoán vị duy nhất.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `nums.length` up to 8.
*   Duplicates handling is required.
*   *Độ dài của `nums` lên tới 8.*
*   *Cần xử lý các phần tử trùng lặp.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking with Sorting and Pruning
### *Hướng tiếp cận: Quay lui với Sắp xếp và Cắt tỉa*

*   **Intuition:** Sort the array first. During backtracking, if the current element is the same as the previous one and the previous one hasn't been used yet in this level, skip it to avoid duplicate permutations.
*   *Ý tưởng: Sắp xếp mảng trước. Trong quá trình quay lui, nếu phần tử hiện tại giống với phần tử trước đó và phần tử trước đó chưa được sử dụng trong cấp độ này, hãy bỏ qua nó để tránh các hoán vị trùng lặp.*

*   **Algorithm Steps:**
    1.  Sort `nums`.
    2.  Use a `used` boolean array.
    3.  `backtrack(...)`:
        *   If count matches length, add to results.
        *   For each element:
            *   If `used[i]`, continue.
            *   **Pruning:** If `i > 0 && nums[i] == nums[i-1] && !used[i-1]`, continue. (This prevents picking the second '1' if the first '1' was available but not picked).
            *   Pick, Recurse, Backtrack.

*   **Complexity:**
    *   Time: $O(n \cdot n!)$.
    *   Space: $O(n)$.

### Dry Run
### *Chạy thử*
`nums = [1, 1, 2]` (sorted)
1.  Empty.
2.  Pick `idx 0 (1)`: `[1]`.
    *   Pick `idx 1 (1)`: `[1, 1]`.
        *   Pick `idx 2 (2)`: `[1, 1, 2]`. Result: `[[1, 1, 2]]`.
3.  Backtrack to `[1]`.
    *   `idx 2 (2)`: `[1, 2]`.
        *   Pick `idx 1 (1)`: `[1, 2, 1]`. Result: `[..., [1, 2, 1]]`.
4.  Backtrack to empty.
    *   Pick `idx 1 (1)`: `nums[1] == nums[0]` and `used[0]` is false. **SKIP**.
    *   Pick `idx 2 (2)`: `[2]`.
        *   Pick `idx 0 (1)`: `[2, 1]`.
            *   Pick `idx 1 (1)`: `[2, 1, 1]`. Result: `[..., [2, 1, 1]]`.
Done.
