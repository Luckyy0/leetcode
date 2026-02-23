# Result for Sum of Subsequence Widths
# *Kết quả cho bài toán Tổng Độ rộng của các Dãy con*

## Description
## *Mô tả*

The **width** of a sequence is the difference between the maximum and minimum element in the sequence.
* **Độ rộng** của một dãy là hiệu giữa phần tử lớn nhất và phần tử nhỏ nhất trong dãy.*

Given an array of integers `nums`, return *the sum of the **widths** of all the non-empty subsequences of `nums`*. Since the answer may be very large, return it **modulo** `10^9 + 7`.
*Cho một mảng các số nguyên `nums`, hãy trả về *tổng của các **độ rộng** của tất cả các dãy con không rỗng của `nums`*. Vì câu trả lời có thể rất lớn, hãy trả về nó **modulo** `10^9 + 7`.*

A **subsequence** is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, `[3,6,2,7]` is a subsequence of `[0,3,1,6,2,2,7]`.
*Một **dãy con** là một dãy có thể được tạo ra từ một mảng bằng cách xóa một số hoặc không xóa phần tử nào mà không thay đổi thứ tự của các phần tử còn lại. Ví dụ, `[3,6,2,7]` là một dãy con của `[0,3,1,6,2,2,7]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [2,1,3]
**Output:** 6
**Explanation:** The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [2]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `1 <= nums[i] <= 10^5`
