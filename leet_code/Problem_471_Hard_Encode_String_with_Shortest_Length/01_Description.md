# Result for Encode String with Shortest Length
# *Kết quả cho bài toán Mã hóa Chuỗi với Độ dài Ngắn nhất*

## Description
## *Mô tả*

Given a string `s`, encode it such that its encoded length is the shortest.
*Cho một chuỗi `s`, hãy mã hóa nó sao cho độ dài chuỗi mã hóa là ngắn nhất.*

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times.
*Quy tắc mã hóa là: `k[encoded_string]`, trong đó `encoded_string` bên trong dấu ngoặc vuông được lặp lại chính xác `k` lần.*

Note:
1.  `k` will be a positive integer.
2.  If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is acceptable.
    *Nếu quy trình mã hóa không làm chuỗi ngắn hơn, đừng mã hóa nó. Nếu có nhiều giải pháp, trả về giải pháp nào cũng được.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "aaa"`
**Output:** `"aaa"`
**Explanation:** There is no way to encode it such that it is shorter than the input string, so we do not encode it.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "aaaaa"`
**Output:** `"5[a]"`
**Explanation:** "5[a]" is shorter than "aaaaa" by 1 character.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "aaaaaaaaaa"`
**Output:** `"10[a]"`
**Explanation:** "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".

## Example 4:
## *Ví dụ 4:*

**Input:** `s = "aabcaabcd"`
**Output:** `"2[aabc]d"`
**Explanation:** "aabc" occurs twice, so one answer can be "2[aabc]d".

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 150`
*   `s` consists of only lowercase English letters.
