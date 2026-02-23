# Result for Add to Array-Form of Integer
# *Kết quả cho bài toán Cộng vào Dạng mảng của Số nguyên*

## Description
## *Mô tả*

The **array-form** of an integer `num` is an array representing its digits in left to right order.
*Dạng **mảng** của một số nguyên `num` là một mảng biểu diễn các chữ số của nó theo thứ tự từ trái sang phải.*

*   For example, for `num = 1321`, the array form is `[1,3,2,1]`.
    *   *Ví dụ, đối với `num = 1321`, dạng mảng là `[1,3,2,1]`.*

Given `num`, the **array-form** of an integer, and an integer `k`, return *the **array-form** of the integer* `num + k`.
*Cho `num`, dạng **mảng** của một số nguyên và một số nguyên `k`, trả về *dạng **mảng** của số nguyên* `num + k`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** num = [1,2,0,0], k = 34
**Output:** [1,2,3,4]
**Explanation:** 1200 + 34 = 1234

## Example 2:
## *Ví dụ 2:*

**Input:** num = [2,7,4], k = 181
**Output:** [4,5,5]
**Explanation:** 274 + 181 = 455

## Example 3:
## *Ví dụ 3:*

**Input:** num = [2,1,5], k = 806
**Output:** [1,0,2,1]
**Explanation:** 215 + 806 = 1021

---

## Constraints:
## *Ràng buộc:*

*   `1 <= num.length <= 10^4`
*   `0 <= num[i] <= 9`
*   `num` does not contain any leading zeros except for the zero itself.
*   `1 <= k <= 10^4`
