# Result for Special Binary String
# *Kết quả cho bài toán Chuỗi Nhị phân Đặc biệt*

## Description
## *Mô tả*

Special Binary Strings are binary strings with the following two properties:
*   The number of `0`'s is equal to the number of `1`'s.
*   Every prefix of the binary string has at least as many `1`'s as `0`'s.
*Chuỗi Nhị phân Đặc biệt là các chuỗi nhị phân có hai thuộc tính sau:*
*   *Số lượng số `0` bằng số lượng số `1`.*
*   *Mọi tiền tố của chuỗi nhị phân đều có số lượng số `1` ít nhất bằng số lượng số `0`.*

You are given a Special Binary String `s`.
*Bạn được cung cấp một Chuỗi Nhị phân Đặc biệt `s`.*

A move consists of choosing two consecutive, non-empty, special substrings of `s`, and swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)
*Một bước đi bao gồm việc chọn hai chuỗi con đặc biệt liên tiếp, không rỗng của `s`, và hoán đổi chúng. (Hai chuỗi được gọi là liên tiếp nếu ký tự cuối cùng của chuỗi thứ nhất nằm ngay trước ký tự đầu tiên của chuỗi thứ hai).*

Return *the lexicographically largest resulting string possible after any number of moves*.
*Trả về *chuỗi kết quả lớn nhất về mặt từ điển có thể đạt được sau bất kỳ số lần di chuyển nào*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "11011000"
**Output:** "11100100"
**Explanation:**
The strings "10" [0, 2) and "1100" [2, 6) are consecutive special binary strings.
Actually, let's parse:
"11011000"
Prefix counts: 1, 2, 1, 2, 3, 2, 1, 0.
Substrings that are special:
"10" (idx 2-3? No, "10" is special).
The example splits "11011000" into "1100", "10"... wait.
Outer layer: 1...0. Inner: 101100.
Let's see valid decomposition.
Start with "1...". Ends when count is 0.
1(1) 1(2) 0(1) 1(2) 1(3) 0(2) 0(1) 0(0).
Actually, to be consecutive special substrings, we need `S = A + B`.
Can we split `s` into `A+B+...`?
Original: `11011000`.
Substrings:
`11011000` is one huge special string.
Inside: `1` + `101100` + `0`.
Recursively: `101100`.
`10` is special? Yes.
`1100` is special? Yes.
Sequence inside is `10`, `1100`.
Sorted desc: `1100`, `10`.
Combined: `110010`.
Wrap back: `1` + `110010` + `0` = `11100100`.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "10"
**Output:** "10"

---

## Constraints:
## *Ràng buộc:*

*   `s.length <= 50`
*   `s` consists of only `'0'` and `'1'`.
*   `s` is a special binary string.
