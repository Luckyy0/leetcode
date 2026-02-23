# Result for Count of Smaller Numbers After Self
# *Kết quả cho bài toán Đếm số lượng Số nhỏ hơn Phía sau*

## Description
## *Mô tả*

Given an integer array `nums`, return *an integer array* `counts` *where* `counts[i]` *is the number of smaller elements to the right of* `nums[i]`.
*Cho một mảng số nguyên `nums`, trả về *một mảng số nguyên* `counts` *trong đó* `counts[i]` *là số lượng các phần tử nhỏ hơn nằm bên phải của* `nums[i]`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [5,2,6,1]`
**Output:** `[2,1,1,0]`
**Explanation:**
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [-1]`
**Output:** `[0]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [-1,-1]`
**Output:** `[0,0]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-10^4 <= nums[i] <= 10^4`
