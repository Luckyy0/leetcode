# 45. Jump Game II / Trò Chơi Nhảy II

## Problem Description / Mô tả bài toán
You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.
Bạn được cho một mảng số nguyên `nums` có chỉ số bắt đầu từ 0 với độ dài `n`. Ban đầu bạn đứng tại `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:
Mỗi phần tử `nums[i]` biểu thị độ dài nhảy tối đa về phía trước từ chỉ số `i`. Nói cách khác, nếu bạn đang ở `nums[i]`, bạn có thể nhảy đến bất kỳ `nums[i + j]` nào trong đó:
- `0 <= j <= nums[i]`
- `i + j < n`

Return the minimum number of jumps to reach `nums[n - 1]`. The test cases are generated such that you can reach `nums[n - 1]`.
Trả về số lần nhảy tối thiểu để đến được `nums[n - 1]`. Các trường hợp kiểm tra được tạo sao cho bạn có thể đến được `nums[n - 1]`.

### Example 1:
```text
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

### Example 2:
```text
Input: nums = [2,3,0,1,4]
Output: 2
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 1000`
- It is guaranteed that you can reach `nums[n - 1]`.

---

## Analysis / Phân tích

### Approach: Greedy / Tham Lam
- **Idea**: We want to make the locally optimal choice to reach the farthest point.
- **Ý tưởng**: Chúng ta muốn đưa ra lựa chọn tối ưu cục bộ để đạt đến điểm xa nhất.
- **Algorithm**:
    - `jumps`: Number of jumps made.
    - `currentEnd`: The end of the range that we can reach with the current number of jumps.
    - `farthest`: The farthest point that we can reach from the current range.
    - Iterate through the array. Update `farthest` = `max(farthest, i + nums[i])`.
    - If we reach `currentEnd`, it means we need another jump to go further. Increment `jumps` and update `currentEnd` to `farthest`.
    - Stop when `currentEnd >= n - 1`.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

### Approach 2: DP / Quy Hoạch Động
- **Idea**: `dp[i]` = min jumps to reach `i`.
- **Time Complexity**: O(n^2). Slow.

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[0]` -> 0 jumps.
2.  **Unreachable**: Problem guarantees reachability.
3.  **Large Jumps**: `[n, 1, 1...]` -> 1 jump.
