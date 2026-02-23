# Result for Short Encoding of Words
# *Kết quả cho bài toán Mã hóa ngắn cho các từ*

## Description
## *Mô tả*

A **valid encoding** of an array of `words` is any reference string `s` and array of indices `indices` such that:
*Một **mã hóa hợp lệ** của một mảng `words` là một chuỗi tham chiếu `s` và một mảng các chỉ số `indices` sao cho:*

*   `s.length == indices.length`
*   The reference string `s` ends with the `'#'` character.
*   For each index `indices[i]`, the substring of `s` starting from `indices[i]` and up to (but not including) the next `'#'` character is equal to `words[i]`.
*   *Với mỗi chỉ số `indices[i]`, chuỗi con của `s` bắt đầu từ `indices[i]` cho đến ký tự `'#'` tiếp theo khớp với `words[i]`.*

Given an array of `words`, return *the **length of the shortest reference string `s`** possible of any **valid encoding** of `words`*.
*Cho một mảng `words`, trả về *độ dài của chuỗi tham chiếu `s` **ngắn nhất có thể** của bất kỳ mã hóa hợp lệ nào của `words`*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["time", "me", "bell"]
**Output:** 10
**Explanation:** A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is "time".
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is "me".
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is "bell".

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["t"]
**Output:** 2
**Explanation:** A valid encoding would be s = "t#" and indices = [0].

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 2000`
*   `1 <= words[i].length <= 7`
*   `words[i]` consists of lowercase English letters.
