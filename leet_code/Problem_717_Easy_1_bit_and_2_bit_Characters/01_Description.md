# Result for 1-bit and 2-bit Characters
# *Kết quả cho bài toán Ký tự 1-bit và 2-bit*

## Description
## *Mô tả*

We have two special characters:
- The first character can be represented by one bit `0`.
- The second character can be represented by two bits (`10` or `11`).

Given a binary array `bits` that ends with `0`, return `true` if the last character must be a one-bit character.
*Chúng ta có hai loại ký tự đặc biệt:*
* - Ký tự thứ nhất được đại diện bởi một bit `0`.*
* - Ký tự thứ hai được đại diện bởi hai bit (`10` hoặc `11`).*

*Cho một mảng nhị phân `bits` kết thúc bằng số `0`, hãy trả về `true` nếu ký tự cuối cùng bắt buộc phải là ký tự một bit.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** bits = [1, 0, 0]
**Output:** true
**Explanation:** The only way to decode it is two-bit character (10) followed by one-bit character (0).
So the last character is one-bit character.

## Example 2:
## *Ví dụ 2:*

**Input:** bits = [1, 1, 1, 0]
**Output:** false
**Explanation:** The only way to decode it is two-bit character (11) followed by two-bit character (10).
So the last character is NOT one-bit character.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= bits.length <= 1000`
*   `bits[i]` is either `0` or `1`.
*   `bits[bits.length - 1]` is always `0`.
