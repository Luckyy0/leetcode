# Result for Range Sum Query - Immutable
# *Kết quả cho bài toán Truy vấn Tổng trong Phạm vi - Bất biến*

## Description
## *Mô tả*

Given an integer array `nums`, handle multiple queries of the following type:
*   Calculate the **sum** of the elements of `nums` between indices `left` and `right` inclusive where `left <= right`.
*Cho một mảng số nguyên `nums`, hãy xử lý nhiều truy vấn thuộc loại sau:*
*   *Tính **tổng** các phần tử của `nums` giữa các chỉ số `left` và `right` bao gồm cả hai, trong đó `left <= right`.*

Implement the `NumArray` class:
*   `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
*   `int sumRange(int left, int right)` Returns the sum of the elements of `nums` between indices `left` and `right` inclusive (i.e. `nums[left] + nums[left + 1] + ... + nums[right]`).
*Triển khai lớp `NumArray`:*
*   *`NumArray(int[] nums)` Khởi tạo đối tượng với mảng số nguyên `nums`.*
*   *`int sumRange(int left, int right)` Trả về tổng các phần tử của `nums` giữa các chỉ số `left` và `right` bao gồm cả hai (tức là `nums[left] + nums[left + 1] + ... + nums[right]`).*

## Example 1:
## *Ví dụ 1:*

**Input**
`["NumArray", "sumRange", "sumRange", "sumRange"]`
`[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]`
**Output**
`[null, 1, -1, -3]`
**Explanation**
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^5 <= nums[i] <= 10^5`
*   `0 <= left <= right < nums.length`
*   At most `10^4` calls will be made to `sumRange`.
