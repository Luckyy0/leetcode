# Result for Convert to Base -2
# *Kết quả cho bài toán Chuyển đổi sang Cơ số -2*

## Description
## *Mô tả*

Given an integer `n`, return *a binary string representing its representation in base* `-2`.
*Cho một số nguyên `n`, trả về một chuỗi nhị phân đại diện cho biểu diễn của nó ở cơ số `-2`.*

**Note** that the returned string should not have leading zeros unless the string is `"0"`.
*Lưu ý rằng chuỗi trả về không được có các số 0 ở đầu trừ khi bản thân chuỗi chính xác là `"0"`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 2
**Output:** "110"
**Explanation:** `(-2)^2 + (-2)^1 = 4 - 2 = 2`
*Giải thích: Đổi ngược lại, ta có `1*(-2)^2 + 1*(-2)^1 + 0 = 4 - 2 + 0 = 2`.*

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3
**Output:** "111"
**Explanation:** `(-2)^2 + (-2)^1 + (-2)^0 = 4 - 2 + 1 = 3`
*Giải thích: `1*(-2)^2 + 1*(-2)^1 + 1*(-2)^0 = 4 - 2 + 1 = 3`.*

## Example 3:
## *Ví dụ 3:*

**Input:** n = 4
**Output:** "100"
**Explanation:** `(-2)^2 = 4`
*Giải thích: `1*(-2)^2 + 0 + 0 = 4`.*

---

## Constraints:
## *Ràng buộc:*

*   `0 <= n <= 10^9`
