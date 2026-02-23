# Result for Target Sum
# *Kết quả cho bài toán Tổng Mục tiêu*

## Description
## *Mô tả*

You are given an integer array `nums` and an integer `target`.
*Bạn được cho một mảng số nguyên `nums` và một số nguyên `target`.*

You want to build an expression out of nums by adding one of the symbols `'+'` and `'-'` before each integer in nums and then concatenate all the integers.
*Bạn muốn xây dựng một biểu thức từ `nums` bằng cách thêm một trong các ký hiệu `'+'` và `'-'` trước mỗi số nguyên trong `nums` và sau đó nối tất cả các số nguyên lại.*

*   For example, if `nums = [2, 1]`, you can add a `'+'` before `2` and a `'-'` before `1` and concatenate them to build the expression `"+2-1"`.
    *Ví dụ: nếu `nums = [2, 1]`, bạn có thể thêm `'+'` trước `2` và `'-'` trước `1` và nối chúng để tạo biểu thức `"+2-1"`.*

Return the number of different expressions that you can build, which evaluates to `target`.
*Trả về số lượng biểu thức khác nhau mà bạn có thể xây dựng, có giá trị bằng `target`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,1,1,1,1], target = 3`
**Output:** `5`
**Explanation:** There are 5 ways to assign symbols to make the sum of nums be 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1], target = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 20`
*   `0 <= nums[i] <= 1000`
*   `0 <= sum(nums[i]) <= 1000`
*   `-1000 <= target <= 1000`
