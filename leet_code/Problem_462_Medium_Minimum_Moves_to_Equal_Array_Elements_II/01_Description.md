# Result for Minimum Moves to Equal Array Elements II
# *Kết quả cho bài toán Số bước di chuyển Tối thiểu để Làm bằng các Phần tử II*

## Description
## *Mô tả*

Given an integer array `nums` of size `n`, return *the minimum number of moves required to make all array elements equal*.
*Cho một mảng số nguyên `nums` có kích thước `n`, hãy trả về *số bước di chuyển tối thiểu cần thiết để làm cho tất cả các phần tử trong mảng bằng nhau*.*

In one move, you can increment or decrement an element of the array by `1`.
*Trong một bước di chuyển, bạn có thể tăng hoặc giảm một phần tử của mảng thêm `1`.*

Test cases are designed so that the answer will fit in a **32-bit** integer.
*Các trường hợp kiểm thử được thiết kế sao cho đáp án sẽ nằm trong phạm vi một số nguyên **32-bit**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3]`
**Output:** `2`
**Explanation:** Only two moves are needed (each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,10,2,9]`
**Output:** `16`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= nums.length <= 10^5`
*   `-10^9 <= nums[i] <= 10^9`
