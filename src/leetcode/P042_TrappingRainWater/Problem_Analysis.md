# 42. Trapping Rain Water / Hứng Nước Mưa

## Problem Description / Mô tả bài toán
Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.
Cho `n` số nguyên không âm biểu thị bản đồ độ cao trong đó chiều rộng của mỗi thanh là `1`, hãy tính lượng nước mà nó có thể hứng được sau khi trời mưa.

### Example 1:
```text
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

### Example 2:
```text
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Constraints / Ràng buộc
- `n == height.length`
- `1 <= n <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

---

## Analysis / Phân tích

### Approach 1: Two Pointers (Optimal) / Hai Con Trỏ (Tối Ưu)
- **Idea**: For any bar `i`, the water it can trap is determined by `min(max_left, max_right) - height[i]`. We can calculate this on the fly.
- **Ý tưởng**: Đối với bất kỳ thanh `i` nào, lượng nước mà nó có thể hứng được được xác định bởi `min(max_left, max_right) - height[i]`. Chúng ta có thể tính toán điều này một cách trực tiếp.
- **Algorithm**:
    1.  Initialize `left = 0`, `right = n - 1`.
    2.  `left_max = 0`, `right_max = 0`.
    3.  While `left < right`:
        - If `height[left] < height[right]`:
            - If `height[left] >= left_max`, update `left_max`.
            - Else `ans += left_max - height[left]`.
            - `left++`.
        - Else:
            - If `height[right] >= right_max`, update `right_max`.
            - Else `ans += right_max - height[right]`.
            - `right--`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

### Approach 2: Dynamic Programming / Quy Hoạch Động
- **Idea**: Pre-calculate `left_max` and `right_max` arrays.
- **Ý tưởng**: Tính toán trước các mảng `left_max` và `right_max`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: 0.
2.  **Ascending/Descending**: No water trapped.
3.  **V-Shape**: Water trapped in middle.
