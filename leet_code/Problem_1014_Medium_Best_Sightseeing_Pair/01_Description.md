# Result for Best Sightseeing Pair
# *Kết quả cho bài toán Cặp đôi Ngắm cảnh Tốt nhất*

## Description
## *Mô tả*

You are given an integer array `values` where values[i] represents the value of the `i`-th sightseeing spot. Two sightseeing spots `i` and `j` have a **distance** `j - i` between them.
*Bạn được cho một mảng số nguyên `values` trong đó `values[i]` đại diện cho giá trị của điểm ngắm cảnh thứ `i`. Hai điểm ngắm cảnh `i` và `j` có **khoảng cách** `j - i` giữa chúng.*

The score of a pair (`i < j`) of sightseeing spots is `values[i] + values[j] + i - j`: the sum of the values of the sightseeing spots, minus the distance between them.
*Điểm số của một cặp (`i < j`) các điểm ngắm cảnh được tính bằng `values[i] + values[j] + i - j`: tổng giá trị của các điểm ngắm cảnh này, trừ đi khoảng cách giữa chúng.*

Return *the maximum score of a pair of sightseeing spots*.
*Trả về số điểm lớn nhất của một cặp điểm ngắm cảnh.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** values = [8,1,5,2,6]
**Output:** 11
**Explanation:** i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
*Giải thích: Đứng ở điểm số 0 (giá trị 8), nhìn tới điểm số 2 (giá trị 5). Khoảng cách là 2. Điểm số = 8 + 5 - 2 = 11.*

## Example 2:
## *Ví dụ 2:*

**Input:** values = [1,2]
**Output:** 2
**Explanation:** i = 0, j = 1, values[i] + values[j] + i - j = 1 + 2 + 0 - 1 = 2

---

## Constraints:
## *Ràng buộc:*

*   `2 <= values.length <= 5 * 10^4`
*   `1 <= values[i] <= 1000`
