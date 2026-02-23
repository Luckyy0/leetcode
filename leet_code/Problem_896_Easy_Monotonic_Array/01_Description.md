# Result for Monotonic Array
# *Kết quả cho bài toán Mảng Đơn điệu*

## Description
## *Mô tả*

An array is **monotonic** if it is either monotone increasing or monotone decreasing.
*Một mảng được gọi là **đơn điệu** nếu nó tăng đơn điệu hoặc giảm đơn điệu.*

An array `nums` is monotone increasing if for all `i <= j`, `nums[i] <= nums[j]`.
*Một mảng `nums` là tăng đơn điệu nếu với mọi `i <= j`, `nums[i] <= nums[j]`.*

An array `nums` is monotone decreasing if for all `i <= j`, `nums[i] >= nums[j]`.
*Một mảng `nums` là giảm đơn điệu nếu với mọi `i <= j`, `nums[i] >= nums[j]`.*

Given an integer array `nums`, return `true` *if the given array is monotonic, or* `false` *otherwise*.
*Cho một mảng số nguyên `nums`, hãy trả về `true` *nếu mảng đã cho là đơn điệu, ngược lại trả về* `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,2,3]
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [6,5,4,4]
**Output:** true

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [1,3,2]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `-10^5 <= nums[i] <= 10^5`
