# Result for Non-decreasing Array
# *Kết quả cho bài toán Mảng Không giảm*

## Description
## *Mô tả*

Given an array `nums` with `n` integers, your task is to check if it could become non-decreasing by modifying **at most one element**.
*Cho một mảng `nums` gồm `n` số nguyên, nhiệm vụ của bạn là kiểm tra xem nó có thể trở thành mảng không giảm bằng cách sửa đổi **tối đa một phần tử** hay không.*

We define an array is non-decreasing if `nums[i] <= nums[i + 1]` holds for every `i` (0-indexed) such that `(0 <= i <= n - 2)`.
*Chúng ta định nghĩa một mảng là không giảm nếu `nums[i] <= nums[i + 1]` đúng với mọi `i` (0-indexed) sao cho `(0 <= i <= n - 2)`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,2,3]
**Output:** true
**Explanation:** You could modify the first 4 to 1 to get a non-decreasing array [1,2,3].

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [4,2,1]
**Output:** false
**Explanation:** You cannot get a non-decreasing array by modifying at most one element.

---

## Constraints:
## *Ràng buộc:*

*   `n == nums.length`
*   `1 <= n <= 10^4`
*   `-100^5 <= nums[i] <= 10^5`
