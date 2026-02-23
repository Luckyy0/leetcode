# Result for Third Maximum Number
# *Kết quả cho bài toán Số lớn thứ Ba*

## Description
## *Mô tả*

Given an integer array `nums`, return *the **third distinct maximum** number in this array*. If the third maximum does not exist, return the **maximum** number.
*Cho một mảng số nguyên `nums`, hãy trả về *số **lớn thứ ba khác biệt** trong mảng này*. Nếu số lớn thứ ba không tồn tại, hãy trả về số **lớn nhất**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [3,2,1]`
**Output:** `1`
**Explanation:**
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2]`
**Output:** `2`
**Explanation:**
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [2,2,3,1]`
**Output:** `1`
**Explanation:**
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-2^31 <= nums[i] <= 2^31 - 1`
