# Result for Sort Transformed Array
# *Kết quả cho bài toán Sắp xếp Mảng đã Biến đổi*

## Description
## *Mô tả*

Given a **sorted** integer array `nums` and three integers `a`, `b` and `c`, apply a quadratic function of the form `f(x) = ax^2 + bx + c` to each element `nums[i]` in the array, and return the array in a **sorted** order.
*Cho một mảng số nguyên đã được **sắp xếp** `nums` và ba số nguyên `a`, `b` và `c`, hãy áp dụng hàm bậc hai có dạng `f(x) = ax^2 + bx + c` cho mỗi phần tử `nums[i]` trong mảng, và trả về mảng theo thứ tự **đã được sắp xếp**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [-4,-2,2,4], a = 1, b = 3, c = 5`
**Output:** `[3,9,15,33]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [-4,-2,2,4], a = -1, b = 3, c = 5`
**Output:** `[-23,-5,1,7]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 200`
*   `-100 <= nums[i], a, b, c <= 100`
*   `nums` is sorted in **ascending** order.

**Follow up:** Could you solve it in $O(n)$ time?
**Câu hỏi mở rộng:** Bạn có thể giải quyết nó trong thời gian $O(n)$ không?
