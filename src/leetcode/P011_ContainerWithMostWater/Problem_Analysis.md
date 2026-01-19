# 11. Container With Most Water / Thùng Chứa Nhiều Nước Nhất

## Problem Description / Mô tả bài toán
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i-th` line are `(i, 0)` and `(i, height[i])`.
Bạn được cho một mảng số nguyên `height` có độ dài `n`. Có `n` đường thẳng đứng được vẽ sao cho hai điểm cuối của đường thứ `i` là `(i, 0)` và `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.
Tìm hai đường thẳng sao cho cùng với trục x tạo thành một thùng chứa có thể chứa nhiều nước nhất.

Return the maximum amount of water a container can store.
Trả về lượng nước tối đa mà thùng chứa có thể lưu trữ.

**Notice** that you may not slant the container.
**Lưu ý** rằng bạn không được nghiêng thùng chứa.

### Example 1:
```text
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```

### Example 2:
```text
Input: height = [1,1]
Output: 1
```

## Constraints / Ràng buộc
- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

---

## Analysis / Phân tích

### Approach 1: Brute Force / Vét cạn
- **Idea**: Check every pair of lines `(i, j)`.
- **Ý tưởng**: Kiểm tra mọi cặp đường thẳng `(i, j)`.
- **Area Formula**: `min(height[i], height[j]) * (j - i)`.
- **Time Complexity**: O(n^2).
- **Space Complexity**: O(1).

### Approach 2: Two Pointers (Greedy) / Hai Con Trỏ (Tham lam)
- **Idea**: Start with the widest container (`left = 0`, `right = n - 1`).
- **Ý tưởng**: Bắt đầu với thùng chứa rộng nhất (`left = 0`, `right = n - 1`).
- **Logic**:
    - Calculate area: `min(height[left], height[right]) * (right - left)`.
    - To maximize area, we need to find a taller line.
    - If `height[left] < height[right]`, moving `right` in won't help because breadth decreases and height remains limited by `left`. So we move `left` forward to hope for a taller line.
    - Else, move `right` backward.
- **Why it works**: By eliminating the shorter line, we are ruling out states that definitely cannot be the maximum (shorter height * smaller width < current area).
- **Time Complexity**: O(n). Single pass.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Two lines**: `[1, 1]` -> 1.
2.  **Descending**: `[5, 4, 3, 2, 1]` -> Check max area carefully.
3.  **Ascending**: `[1, 2, 3, 4, 5]`.
