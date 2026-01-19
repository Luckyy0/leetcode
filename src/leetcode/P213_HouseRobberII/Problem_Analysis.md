# 213. House Robber II / Kẻ Trộm Nhà II

## Problem Description / Mô tả bài toán
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are **arranged in a circle**. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and **it will automatically contact the police if two adjacent houses were broken into on the same night**.
Bạn là một kẻ trộm chuyên nghiệp đang lên kế hoạch trộm các ngôi nhà dọc theo một con phố. Mỗi ngôi nhà có một lượng tiền nhất định. Tất cả các ngôi nhà ở nơi này được **sắp xếp thành một vòng tròn**. Điều đó có nghĩa là ngôi nhà đầu tiên là hàng xóm của ngôi nhà cuối cùng. Trong khi đó, các ngôi nhà liền kề có hệ thống an ninh kết nối, và **nó sẽ tự động liên lạc với cảnh sát nếu hai ngôi nhà liền kề bị trộm trong cùng một đêm**.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight **without alerting the police**.
Cho một mảng số nguyên `nums` đại diện cho số tiền của mỗi ngôi nhà, hãy trả về số tiền tối đa bạn có thể trộm đêm nay **mà không làm báo động cảnh sát**.

### Example 1:
```text
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
```

### Example 2:
```text
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount = 1 + 3 = 4.
```

### Example 3:
```text
Input: nums = [1,2,3]
Output: 3
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Circular Dependency Breaking / Phá vỡ Phụ thuộc Vòng
The only difference from House Robber I is the circular arrangement.
Since the first and last houses are neighbors, we cannot rob BOTH.
This leaves us with two disjoint cases:
1.  **Rob Houses `0` to `n-2`**: Implicitly excludes the last house.
2.  **Rob Houses `1` to `n-1`**: Implicitly excludes the first house.

We calculate the maximum profit for both linear sub-problems and take the maximum.

`Result = max(RobLinear(0, n-2), RobLinear(1, n-1))`

---

## Analysis / Phân tích

### Approach: Linear DP Reduction

**Algorithm**:
1.  If `n == 1`, return `nums[0]`.
2.  Function `robLinear(start, end)`:
    - Same as House Robber I logic.
    - `prev`, `curr`.
    - Loop from `start` to `end`.
3.  Return `max(robLinear(0, n-2), robLinear(1, n-1))`.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Two passes of O(N).
- **Space**: O(1) - Constant variables.

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: Must handle separately (ranges would be invalid or overlap weirdly).
2.  **n = 2**: `max(nums[0], nums[1])`.
3.  **n = 3**: `max(nums[0], nums[1], nums[2])` since neighbors restrict 2 houses.
