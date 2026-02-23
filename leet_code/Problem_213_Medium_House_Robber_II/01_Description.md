# Result for House Robber II
# *Kết quả cho bài toán Kẻ trộm nhà II*

## Description
## *Mô tả*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are **arranged in a circle**. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and **it will automatically contact the police if two adjacent houses were broken into on the same night**.
*Bạn là một kẻ trộm chuyên nghiệp đang lên kế hoạch trộm các ngôi nhà dọc theo một con phố. Mỗi ngôi nhà có chứa một số tiền nhất định. Tất cả các ngôi nhà ở nơi này được **sắp xếp theo một vòng tròn**. Điều đó có nghĩa là ngôi nhà đầu tiên là hàng xóm của ngôi nhà cuối cùng. Trong khi đó, các ngôi nhà liền kề có hệ thống an ninh được kết nối, và **nó sẽ tự động liên hệ với cảnh sát nếu hai ngôi nhà liền kề bị đột nhập trong cùng một đêm**.*

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight without alerting the police*.
*Cho một mảng số nguyên `nums` đại diện cho số tiền của mỗi ngôi nhà, hãy trả về *số tiền tối đa bạn có thể trộm tối nay mà không đánh động cảnh sát***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,3,2]`
**Output:** `3`
**Explanation:** You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,3,1]`
**Output:** `4`
**Explanation:** Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,2,3]`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 100`
*   `0 <= nums[i] <= 1000`
