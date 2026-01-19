# 198. House Robber / Kẻ Trộm Nhà

## Problem Description / Mô tả bài toán
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.
Bạn là một kẻ trộm chuyên nghiệp đang lên kế hoạch trộm các ngôi nhà dọc theo một con phố. Mỗi ngôi nhà có một lượng tiền nhất định, ràng buộc duy nhất ngăn cản bạn trộm tất cả là các ngôi nhà liền kề có hệ thống an ninh kết nối và **nó sẽ tự động liên lạc với cảnh sát nếu hai ngôi nhà liền kề bị trộm trong cùng một đêm**.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight **without alerting the police**.
Cho một mảng số nguyên `nums` đại diện cho số tiền của mỗi ngôi nhà, hãy trả về số tiền tối đa bạn có thể trộm đêm nay **mà không làm báo động cảnh sát**.

### Example 1:
```text
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount = 1 + 3 = 4.
```

### Example 2:
```text
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1). Total amount = 2 + 9 + 1 = 12.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming / Quy hoạch động
For each house `i`, we have two choices:
1.  **Rob house `i`**: We cannot rob house `i-1`. The total money is `nums[i] + max_robbed_at(i-2)`.
2.  **Don't rob house `i`**: The total money is `max_robbed_at(i-1)`.

**State Definition**:
`dp[i]` = Maximum money robbed up to house `i`.

**Transition**:
`dp[i] = max(dp[i-1], nums[i] + dp[i-2])`

**Optimization**:
We only need the last two states (`dp[i-1]` and `dp[i-2]`), so we can use two variables to achieve O(1) space.
Chúng ta chỉ cần hai trạng thái cuối cùng, vì vậy chúng ta có thể sử dụng hai biến để đạt được không gian O(1).

---

## Analysis / Phân tích

### Approach: Dynamic Programming (Space Optimized)

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass.
- **Space**: O(1) - two tracking variables.

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: Rob the only house.
2.  **n = 2**: Rob the house with more money.
3.  **All zeros**: Result is 0.
4.  **Increasing/Decreasing values**: Handled correctly by DP.
