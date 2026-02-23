# Result for House Robber
# *Kết quả cho bài toán Kẻ trộm nhà*

## Description
## *Mô tả*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.
*Bạn là một kẻ trộm chuyên nghiệp đang lên kế hoạch trộm các ngôi nhà dọc theo một con phố. Mỗi ngôi nhà có chứa một số tiền nhất định, ràng buộc duy nhất ngăn bạn trộm tất cả các ngôi nhà là các ngôi nhà liền kề có hệ thống an ninh được kết nối và **nó sẽ tự động liên hệ với cảnh sát nếu hai ngôi nhà liền kề bị đột nhập trong cùng một đêm**.*

Given an integer array `nums` representing the amount of money of each house, return *the maximum amount of money you can rob tonight without alerting the police*.
*Cho một mảng số nguyên `nums` đại diện cho số tiền của mỗi ngôi nhà, hãy trả về *số tiền tối đa bạn có thể trộm tối nay mà không đánh động cảnh sát***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3,1]`
**Output:** `4`
**Explanation:** Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [2,7,9,3,1]`
**Output:** `12`
**Explanation:** Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob = 2 + 9 + 1 = 12.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 100`
*   `0 <= nums[i] <= 400`
