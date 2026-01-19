# 55. Jump Game / Trò Chơi Nhảy

## Problem Description / Mô tả bài toán
You are given an integer array `nums`. You are initially positioned at the array's **first index**.
Bạn được cho một mảng số nguyên `nums`. Ban đầu bạn đứng tại **chỉ số đầu tiên** của mảng.

Each element in the array represents your maximum jump length at that position.
Mỗi phần tử trong mảng biểu thị độ dài nhảy tối đa của bạn tại vị trí đó.

Return `true` if you can reach the last index, or `false` otherwise.
Trả về `true` nếu bạn có thể đến được chỉ số cuối cùng, hoặc `false` nếu ngược lại.

### Example 1:
```text
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

### Example 2:
```text
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^5`

---

## Analysis / Phân tích

### Approach: Greedy / Tham Lam
- **Idea**: Track the furthest index we can reach (`farthest`).
- **Ý tưởng**: Theo dõi chỉ số xa nhất mà chúng ta có thể đạt được (`farthest`).
- **Algorithm**:
    - Initialize `farthest = 0`.
    - Loop `i` from 0 to `nums.length - 1`:
        - If `i > farthest`, we are stuck. Cannot reach `i`. Return `false`.
        - Update `farthest = max(farthest, i + nums[i])`.
        - If `farthest >= nums.length - 1`, return `true` early.
    - Return `true` (if loop finishes successfully).
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[0]` -> true (already at last index).
2.  **Zero Start**: `[0, 1]` -> false.
