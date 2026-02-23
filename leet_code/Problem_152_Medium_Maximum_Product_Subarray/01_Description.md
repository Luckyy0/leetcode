# Result for Maximum Product Subarray
# *Kết quả cho bài toán Dãy con có tích lớn nhất*

## Description
## *Mô tả*

Given an integer array `nums`, find a **subarray** that has the largest product, and return *the product*.
*Cho một mảng số nguyên `nums`, hãy tìm một **dãy con** có tích lớn nhất và trả về *tích đó***.*

The test cases are generated so that the answer will fit in a **32-bit** integer.
*Các trường hợp kiểm thử được tạo ra sao cho câu trả lời sẽ vừa với một số nguyên **32-bit***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,3,-2,4]`
**Output:** `6`
**Explanation:** `[2,3]` has the largest product 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [-2,0,-1]`
**Output:** `0`
**Explanation:** The result cannot be 2, because `[-2,-1]` is not a subarray.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 10^4`
*   `-10 <= nums[i] <= 10`
*   The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.
