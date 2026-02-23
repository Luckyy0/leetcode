# Analysis for 3Sum
# *Phân tích cho bài toán Tổng 3 Số*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer array `nums`. *Mảng số nguyên `nums`.*
*   **Output:** List of List of Integers (Unique triplets). *Danh sách các Danh sách Số nguyên (Các bộ ba duy nhất).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `N <= 3000`. $O(N^2)$ is acceptable ($9 \times 10^6$).
*   $O(N^3)$ (Brute force) is too slow ($\approx 2.7 \times 10^{10}$).

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sorting + Two Pointers
### *Hướng tiếp cận: Sắp xếp + Hai Con Trỏ*

*   **Intuition:** Sort the array first. Fix one element `nums[i]`, then use two pointers `left` and `right` to find two other numbers that sum to `-nums[i]`.
    *Ý tưởng: Sắp xếp mảng trước. Cố định một phần tử `nums[i]`, sau đó dùng hai con trỏ `left` và `right` để tìm hai số khác có tổng bằng `-nums[i]`.*
*   **Handling Duplicates:**
    *   Sort helps skipping duplicates easily.
    *   After processing `nums[i]`, skip same values for `i`.
    *   Whenever `sum == 0`, move `left` and `right` past duplicates.

*   **Algorithm Steps:**
    1.  Sort `nums`.
    2.  Iterate `i` from `0` to `n-3`.
        *   If `i > 0` and `nums[i] == nums[i-1]`, continue (No duplicates).
        *   `target = -nums[i]`. `left = i + 1`, `right = n - 1`.
        *   While `left < right`:
            *   `current = nums[left] + nums[right]`.
            *   If `current == target`:
                *   Add `[nums[i], nums[left], nums[right]]` to result.
                *   Skip duplicates for `left` and `right`.
                *   `left++`, `right--`.
            *   Else if `current < target`: `left++`.
            *   Else: `right--`.
    3.  Return result.

*   **Complexity:**
    *   Time: $O(N^2)$.
    *   Space: $O(1)$ or $O(N)$ depending on sort needed. (Since we need `List<List<Integer>>` return, space for output is needed).

*   **Custom Implementation:** Since we cannot use `java.util.Arrays.sort`, we will implement **QuickSort** or similar. Since we cannot use `List`, but the return type is usually `List<List<Integer>>` in LeetCode, I will stick to arrays or a basic custom list structure just for the solution file structure, but the standard LeetCode signature returns List. Wait, user said "Minimal Custom Implementation: Tự viết class/struct cho cấu trúc dữ liệu cần thiết". So I will define a custom `IntList` and `ListOfIntList`.

### Dry Run
### *Chạy thử*
`[-1, 0, 1, 2, -1, -4]` -> Sorted: `[-4, -1, -1, 0, 1, 2]`.
1.  `i=0 (-4)`. Target 4. L=-1, R=2. Sum 1 < 4. L++... No solution.
2.  `i=1 (-1)`. Target 1. L=2(-1), R=5(2). Sum 1. Found `[-1, -1, 2]`. L moves to `0`.
3.  `i=2 (-1)`. Skip (duplicate).
4.  `i=3 (0)`. Target 0. L=4(1), R=5(2). Sum 3 > 0. R--.
...
