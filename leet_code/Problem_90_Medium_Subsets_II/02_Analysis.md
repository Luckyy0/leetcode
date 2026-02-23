# Analysis for Subsets II
# *Phân tích cho bài toán Tập Con II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums` with potential duplicates. *Mảng `nums` có thể có các phần tử trùng lặp.*
*   **Output:** Power set without duplicate subsets. *Tập hợp lũy thừa không có các tập con trùng lặp.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 10.
*   Must handle duplicates to avoid duplicate subsets.
*   *Độ dài lên đến 10.*
*   *Phải xử lý các phần tử trùng lặp để tránh các tập con trùng lặp.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sorting + Backtracking
### *Hướng tiếp cận: Sắp xếp + Quay lui*

*   **Logic:**
    1.  Sort the array first. Sorting brings duplicate elements together, making it easier to skip them.
    2.  Use backtracking to explore all possible subsets.
    3.  During backtracking, if the current element is the same as the previous element at the same recursion level (`i > start && nums[i] == nums[i-1]`), skip it to avoid generating duplicate subsets.

*   **Algorithm Steps:**
    1.  Sort `nums`.
    2.  `backtrack(result, current, start)`:
        *   Add `current` to `result`.
        *   Loop `i` from `start` to `nums.length - 1`:
            *   If `i > start` and `nums[i] == nums[i-1]`, logic: `continue`.
            *   Add `nums[i]` to `current`.
            *   `backtrack(result, current, i + 1)`.
            *   Remove `nums[i]` from `current`.
    3.  Return `result`.

*   **Complexity:**
    *   Time: $O(N \cdot 2^N)$.
    *   Space: $O(N)$ for recursion stack.

### Dry Run
### *Chạy thử*
`nums = [1, 2, 2]`
1. `[]`
2. Level 0: Start with `1`. `[1]`.
   - Level 1: Start with `2` (index 1). `[1, 2]`.
     - Level 2: Start with `2` (index 2). `[1, 2, 2]`.
   - Level 1: Skip `2` (index 2) because `nums[2] == nums[1]`.
3. Level 0: Start with `2` (index 1). `[2]`.
   - Level 1: Start with `2` (index 2). `[2, 2]`.
4. Level 0: Skip `2` (index 2).
Result: `[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]`.
---
*Việc sắp xếp mảng là bước chuẩn bị quan trọng nhất để dễ dàng loại bỏ sự trùng lặp.*
Sorting the array is the most important preparation step to easily eliminate duplicates.
