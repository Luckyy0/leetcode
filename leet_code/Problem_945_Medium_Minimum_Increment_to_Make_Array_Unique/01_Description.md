# Result for Minimum Increment to Make Array Unique
# *Kết quả cho bài toán Tăng tối thiểu để Mảng trở nên Duy nhất*

## Description
## *Mô tả*

You are given an integer array `nums`. In one move, you can pick an index `i` where `0 <= i < nums.length` and increment `nums[i]` by `1`.
*Bạn được cho một mảng số nguyên `nums`. Trong một bước, bạn có thể chọn một chỉ số `i` trong đó `0 <= i < nums.length` và tăng `nums[i]` thêm `1`.*

Return *the minimum number of moves to make every value in* `nums` *unique*.
*Trả về *số bước di chuyển tối thiểu để làm cho mọi giá trị trong* `nums` *trở nên duy nhất*.*

The test cases are generated so that the answer fits in a 32-bit integer.
*Các trường hợp thử nghiệm được tạo sao cho câu trả lời phù hợp với số nguyên 32 bit.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,2,2]
**Output:** 1
**Explanation:** After 1 move, the array could be [1, 2, 3].

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [3,2,1,2,1,7]
**Output:** 6
**Explanation:** After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^5`
*   `0 <= nums[i] <= 10^5`
