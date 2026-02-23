# Result for Minimum Moves to Equal Array Elements
# *Kết quả cho bài toán Số lượng Bước di chuyển Tối thiểu để Làm bằng các Phần tử trong Mảng*

## Description
## *Mô tả*

Given an integer array `nums` of size `n`, return *the minimum number of moves required to make all array elements equal*.
*Cho một mảng số nguyên `nums` có kích thước `n`, hãy trả về *số lượng bước di chuyển tối thiểu cần thiết để làm cho tất cả các phần tử trong mảng bằng nhau*.*

In one move, you can **increment** `n - 1` elements of the array by `1`.
*Trong một bước di chuyển, bạn có thể **tăng** `n - 1` phần tử của mảng thêm `1`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3]`
**Output:** `3`
**Explanation:** Only three moves are needed (each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,1,1]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= nums.length <= 10^5`
*   `-10^9 <= nums[i] <= 10^9`
*   The answer is guaranteed to fit in a **32-bit** integer.
