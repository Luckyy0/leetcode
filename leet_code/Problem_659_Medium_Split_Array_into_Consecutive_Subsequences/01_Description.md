# Result for Split Array into Consecutive Subsequences
# *Kết quả cho bài toán Chia mảng thành các Dãy con Liên tiếp*

## Description
## *Mô tả*

You are given an integer array `nums` that is **sorted in non-decreasing order**.
*Bạn được cho một mảng số nguyên `nums` đã được **sắp xếp theo thứ tự không giảm**.*

Determine if you can split `nums` into one or more **subsequences** such that each subsequence is a **consecutive sequence** (i.e. increments by 1) and has a **length of at least 3**.
*Hãy xác định xem bạn có thể chia `nums` thành một hoặc nhiều **dãy con** sao cho mỗi dãy con là một **dãy liên tiếp** (tức là tăng dần 1 đơn vị) và có **độ dài ít nhất là 3** hay không.*

Return `true` if you can make such a split, or `false` otherwise.
*Hãy trả về `true` nếu bạn có thể thực hiện việc chia như vậy, ngược lại trả về `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,3,3,4,5]
**Output:** true
**Explanation:** nums can be split into the following subsequences:
[1,2,3], [3,4,5]

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3,3,4,4,5,5]
**Output:** true
**Explanation:** nums can be split into the following subsequences:
[1,2,3,4,5], [3,4,5]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-1000 <= nums[i] <= 1000`
*   `nums` is sorted in **non-decreasing** order.
