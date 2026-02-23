# Result for Complement of Base 10 Integer
# *Kết quả cho bài toán Bù của số nguyên cơ số 10*

## Description
## *Mô tả*

The **complement** of an integer is the integer you get when you flip all the `0`'s to `1`'s and all the `1`'s to `0`'s in its binary representation.
*Số **bù** của một số nguyên là số nguyên bạn nhận được khi lật tất cả các số `0` thành số `1` và tất cả các số `1` thành số `0` trong biểu diễn nhị phân của nó.*

*   For example, The integer `5` is `"101"` in binary and its **complement** is `"010"` which is the integer `2`.
    *   *Ví dụ, Số nguyên `5` trong hệ nhị phân là `"101"` và **số bù** của nó là `"010"`, tức là số nguyên `2`.*

Given an integer `n`, return *its complement*.
*Cho một số nguyên `n`, hãy trả về phần bù của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 5
**Output:** 2
**Explanation:** 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
*Giải thích: 5 là "101" biểu diễn nhị phân, dạng bù "010", khi đổi ra cơ số 10 là số 2.*

## Example 2:
## *Ví dụ 2:*

**Input:** n = 7
**Output:** 0
**Explanation:** 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
*Giải thích: 7 là mã nhị phân "111", dạng bù là "000", tính ra số 10 là 0.*

## Example 3:
## *Ví dụ 3:*

**Input:** n = 10
**Output:** 5
**Explanation:** 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
*Giải thích: 10 là mã nhị phân "1010", dạng bù là "0101", tính ra số 10 là 5.*

---

## Constraints:
## *Ràng buộc:*

*   `0 <= n < 10^9`

**Note:** This question is the same as 476: [https://leetcode.com/problems/number-complement/](https://leetcode.com/problems/number-complement/)
*Lưu ý: Câu hỏi này y hệt bài số 476 trên leetcode.*
