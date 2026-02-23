# Result for Longest Harmonious Subsequence
# *Kết quả cho bài toán Chuỗi con Hài hòa Dài nhất*

## Description
## *Mô tả*

We define a harmonious array as an array where the difference between its maximum value and its minimum value is **exactly 1**.
*Chúng ta định nghĩa một mảng hài hòa là một mảng mà sự khác biệt giữa giá trị lớn nhất và giá trị nhỏ nhất của nó là **chính xác 1**.*

Given an integer array `nums`, return the length of its longest harmonious **subsequence** among all its possible subsequences.
*Cho một mảng số nguyên `nums`, hãy trả về độ dài của **chuỗi con** hài hòa dài nhất của nó trong số tất cả các chuỗi con có thể có.*

A **subsequence** of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
*Một **chuỗi con** của một mảng là một chuỗi có thể được tạo ra từ mảng đó bằng cách xóa một số hoặc không xóa phần tử nào mà không thay đổi thứ tự của các phần tử còn lại.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,3,2,2,5,2,3,7]
**Output:** 5
**Explanation:** The longest harmonious subsequence is [3,2,2,2,3].

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3,4]
**Output:** 2

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [1,1,1,1]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 104`
*   `-109 <= nums[i] <= 109`
