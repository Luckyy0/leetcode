# Result for Maximize Sum Of Array After K Negations
# *Kết quả cho bài toán Tối đa hóa tổng mảng sau K lần đảo dấu*

## Description
## *Mô tả*

Given an integer array `nums` and an integer `k`, modify the array in the following way:
*Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy sửa đổi mảng theo cách sau:*

*   choose an index `i` and replace `nums[i]` with `-nums[i]`.
    *   *chọn một chỉ số `i` và thay thế `nums[i]` bằng `-nums[i]`.*

You should apply this process exactly `k` times. You may choose the same index `i` multiple times.
*Bạn phải áp dụng quá trình này đúng `k` lần. Bạn có thể chọn cùng một chỉ số `i` nhiều lần.*

Return *the largest possible sum of the array after modifying it in this way*.
*Trả về tổng lớn nhất có thể của mảng sau khi sửa đổi theo cách này.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,2,3], k = 1
**Output:** 5
**Explanation:** Choose index 1 and nums becomes [4,-2,3].
*Giải thích: Chọn chỉ số 1 và nums trở thành [4,-2,3].*

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [3,-1,0,2], k = 3
**Output:** 6
**Explanation:** Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
*Giải thích: Chọn các chỉ số (1, 2, 2) và nums trở thành [3,1,0,2].*

## Example 3:
## *Ví dụ 3:*

**Input:** nums = [2,-3,-1,5,-4], k = 2
**Output:** 13
**Explanation:** Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
*Giải thích: Chọn các chỉ số (1, 4) và nums trở thành [2,3,-1,5,4].*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-100 <= nums[i] <= 100`
*   `1 <= k <= 10^4`
