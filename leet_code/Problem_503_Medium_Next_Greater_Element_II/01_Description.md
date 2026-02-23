# Result for Next Greater Element II
# *Kết quả cho bài toán Phần tử Lớn hơn Tiếp theo II*

## Description
## *Mô tả*

Given a **circular integer array** `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`), return *the **next greater number** for every element in* `nums`.
*Cho một **mảng số nguyên vòng** `nums` (tức là phần tử tiếp theo của `nums[nums.length - 1]` là `nums[0]`), hãy trả về ***số lớn hơn tiếp theo** cho mỗi phần tử trong* `nums`.*

The **next greater number** of a number `x` is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return `-1` for this number.
***Số lớn hơn tiếp theo** của một số `x` là số lớn hơn đầu tiên nằm sau nó theo thứ tự duyệt trong mảng, nghĩa là bạn có thể tìm kiếm theo vòng tròn để tìm số lớn hơn tiếp theo của nó. Nếu không tồn tại, trả về `-1` cho số này.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,1]`
**Output:** `[2,-1,2]`
**Explanation:** The first 1's next greater number is 2. 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,3,4,3]`
**Output:** `[2,3,4,-1,4]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^9 <= nums[i] <= 10^9`
