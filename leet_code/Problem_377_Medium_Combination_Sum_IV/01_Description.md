# Result for Combination Sum IV
# *Kết quả cho bài toán Tổng Tổ hợp IV*

## Description
## *Mô tả*

Given an array of **distinct** integers `nums` and a target integer `target`, return *the number of possible combinations that add up to `target`*.
*Cho một mảng các số nguyên **khác biệt** `nums` và một số nguyên mục tiêu `target`, hãy trả về *số lượng các tổ hợp khả thi có tổng bằng `target`*.*

The test cases are generated so that the answer can fit in a **32-bit** integer.
*Các trường hợp kiểm thử được tạo ra sao cho câu trả lời nằm gọn trong một số nguyên **32-bit**.*

**Note:** Different sequences are counted as different combinations. (This effectively means we are looking for the number of **permutations** that sum to target).
**Lưu ý:** Các trình tự khác nhau được tính là các tổ hợp khác nhau. (Điều này thực chất có nghĩa là chúng ta đang tìm kiếm số lượng **hoán vị** có tổng bằng target).

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3], target = 4`
**Output:** `7`
**Explanation:**
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [9], target = 3`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 200`
*   `1 <= nums[i] <= 1000`
*   All the elements of `nums` are **unique**.
*   `1 <= target <= 1000`
