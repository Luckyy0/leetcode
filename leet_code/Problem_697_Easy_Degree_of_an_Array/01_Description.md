# Result for Degree of an Array
# *Kết quả cho bài toán Bậc của một Mảng*

## Description
## *Mô tả*

Given a non-empty array of non-negative integers `nums`, the **degree** of this array is defined as the maximum frequency of any one of its elements.
*Cho một mảng các số nguyên không âm không rỗng `nums`, **bậc** của mảng này được định nghĩa là tần suất xuất hiện lớn nhất của bất kỳ một phần tử nào trong đó.*

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.
*Nhiệm vụ của bạn là tìm độ dài nhỏ nhất có thể của một mảng con (liên tục) của `nums`, có cùng bậc với `nums`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,2,3,1]
**Output:** 2
**Explanation:** 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1] has degree 2, length 5.
[1, 2, 2, 3] has degree 2, length 4.
[2, 2, 3, 1] has degree 2, length 4.
[1, 2, 2] has degree 2, length 3.
[2, 2, 3] has degree 2, length 3.
[2, 2] has degree 2, length 2.
The shortest length is 2.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,2,3,1,4,2]
**Output:** 6
**Explanation:** 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, which has length 6.

---

## Constraints:
## *Ràng buộc:*

*   `nums.length` will be between 1 and 50,000.
*   `nums[i]` will be an integer between 0 and 49,999.
