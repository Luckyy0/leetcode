# Result for Verifying an Alien Dictionary
# *Kết quả cho bài toán Xác minh Từ điển Người ngoài hành tinh*

## Description
## *Mô tả*

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different `order`. The `order` of the alphabet is some permutation of lowercase letters.
*Trong một ngôn ngữ của người ngoài hành tinh, ngạc nhiên thay, họ cũng sử dụng các chữ cái tiếng Anh viết thường, nhưng có thể theo một `thứ tự` khác. `Thứ tự` của bảng chữ cái là một hoán vị nào đó của các chữ cái viết thường.*

Given a sequence of `words` written in the alien language, and the `order` of the alphabet, return `true` if and only if the given `words` are sorted lexicographically in this alien language.
*Cho một chuỗi các `từ` được viết bằng ngôn ngữ người ngoài hành tinh và `thứ tự` của bảng chữ cái, hãy trả về `true` khi và chỉ khi các `từ` đã cho được sắp xếp theo thứ tự từ điển trong ngôn ngữ này.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
**Output:** true
**Explanation:** As 'h' comes before 'l' in this language, then the sequence is sorted.

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
**Output:** false
**Explanation:** As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

## Example 3:
## *Ví dụ 3:*

**Input:** words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
**Output:** false
**Explanation:** The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 100`
*   `1 <= words[i].length <= 20`
*   `order.length == 26`
*   All characters in `words[i]` and `order` are English lowercase letters.
