# Result for Split Array With Same Average
# *Kết quả cho bài toán Chia mảng với trung bình cộng bằng nhau*

## Description
## *Mô tả*

You are given an integer array `nums`.
*Bạn được cho một mảng số nguyên `nums`.*

You should move each element of `nums` into one of the two arrays `A` and `B` such that `A` and `B` are non-empty, and `average(A) == average(B)`.
*Bạn nên chuyển mỗi phần tử của `nums` vào một trong hai mảng `A` và `B` sao cho `A` và `B` không rỗng và `average(A) == average(B)`.*

Return `true` if it is possible to achieve that condition, and `false` otherwise.
*Trả về `true` nếu có thể đạt được điều kiện đó, và `false` nếu ngược lại.*

**Note:** The average of an array is the sum of its elements divided by its length.
*Lưu ý: Trung bình của một mảng là tổng các phần tử chia cho độ dài của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,3,4,5,6,7,8]
**Output:** true
**Explanation:** 
A = [1, 4, 5, 8], average(A) = 4.5
B = [2, 3, 6, 7], average(B) = 4.5

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [3,1]
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 30`
*   `0 <= nums[i] <= 10^4`
