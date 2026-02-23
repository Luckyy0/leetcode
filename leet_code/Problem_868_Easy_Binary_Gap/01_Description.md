# Result for Binary Gap
# *Kết quả cho bài toán Khoảng cách Nhị phân*

## Description
## *Mô tả*

Given a positive integer `n`, find and return *the **longest distance** between any two **adjacent** `1`'s in the binary representation of `n`*. If there are no two adjacent `1`'s, return `0`.
*Cho một số nguyên dương `n`, hãy tìm và trả về *khoảng cách **dài nhất** giữa bất kỳ hai số `1` **liền kề** nào trong biểu diễn nhị phân của `n`*. Nếu không có hai số `1` liền kề nào, hãy trả về `0`.*

Two `1`'s are **adjacent** if there are only `0`'s separating them (possibly no `0`'s). The **distance** between two `1`'s is the absolute difference between their bit positions. For example, the two `1`'s in `"1001"` have a distance of 3.
*Hai số `1` được gọi là **liền kề** nếu chỉ có các số `0` ngăn cách chúng (có thể không có số `0` nào). **Khoảng cách** giữa hai số `1` là giá trị tuyệt đối của hiệu giữa các vị trí bit của chúng. Ví dụ, hai số `1` trong "1001" có khoảng cách là 3.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 22
**Output:** 2
**Explanation:** 22 in binary is "10110".
The first adjacent pair of 1's is at index 0 and index 2 (counting from right, but usually we consider from MSB or LSB consistently).
- 10110: The 1s are at positions 4, 2, and 1.
- Adjacent pairs: (4, 2) has distance 2; (2, 1) has distance 1.
The maximum distance is 2.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 8
**Output:** 0
**Explanation:** 8 in binary is "1000".
There aren't any adjacent pairs of 1's in the binary representation of 8, so we return 0.

## Example 3:
## *Ví dụ 3:*

**Input:** n = 5
**Output:** 2
**Explanation:** 5 in binary is "101".
The only adjacent pair of 1's is at index 0 and index 2 with distance 2.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^9`
