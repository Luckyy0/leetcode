# Result for Search Insert Position
# *Kết quả cho bài toán Tìm Vị Trí Chèn*

## Description
## *Mô tả*

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
*Cho một mảng các số nguyên phân biệt đã sắp xếp và một giá trị đích, trả về chỉ số nếu tìm thấy đích. Nếu không, trả về chỉ số mà nó sẽ được chèn vào theo thứ tự.*

You must write an algorithm with `O(log n)` runtime complexity.
*Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,3,5,6]`, `target = 5`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,3,5,6]`, `target = 2`
**Output:** `1`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,3,5,6]`, `target = 7`
**Output:** `4`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-10^4 <= nums[i] <= 10^4`
*   `nums` contains **distinct** values sorted in **ascending** order.
*   `-10^4 <= target <= 10^4`
