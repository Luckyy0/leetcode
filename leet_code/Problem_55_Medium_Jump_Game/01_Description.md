# Result for Jump Game
# *Kết quả cho bài toán Trò Chơi Nhảy*

## Description
## *Mô tả*

You are given an integer array `nums`. You are initially positioned at the array's **first index**, and each element in the array represents your maximum jump length at that position.
*Bạn được cho một mảng số nguyên `nums`. Ban đầu bạn đứng ở **chỉ số đầu tiên** của mảng, và mỗi phần tử trong mảng đại diện cho độ dài bước nhảy tối đa của bạn tại vị trí đó.*

Return `true` if you can reach the last index, or `false` otherwise.
*Trả về `true` nếu bạn có thể đạt đến chỉ số cuối cùng, ngược lại trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,3,1,1,4]`
**Output:** `true`
**Explanation:** Jump 1 step from index 0 to 1, then 3 steps to the last index.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [3,2,1,0,4]`
**Output:** `false`
**Explanation:** You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `0 <= nums[i] <= 10^5`
