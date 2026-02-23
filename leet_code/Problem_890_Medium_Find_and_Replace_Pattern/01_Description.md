# Result for Find and Replace Pattern
# *Kết quả cho bài toán Tìm và Thay thế Mẫu*

## Description
## *Mô tả*

Given a list of strings `words` and a string `pattern`, return *a list of* `words[i]` *that match* `pattern`. You may return the answer in **any order**.
*Cho một danh sách các chuỗi `words` và một chuỗi `pattern`, hãy trả về *một danh sách các* `words[i]` *khớp với* `pattern`. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

A word matches the pattern if there exists a permutation of letters `p` so that after replacing every letter `x` in the pattern with `p(x)`, we get the desired word.
*Một từ khớp với mẫu nếu tồn tại một hoán vị các chữ cái `p` sao cho sau khi thay thế mỗi chữ cái `x` trong mẫu bằng `p(x)`, ta nhận được từ mong muốn.*

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
*Hãy nhớ rằng hoán vị của các chữ cái là một song ánh từ các chữ cái đến các chữ cái: mỗi chữ cái ánh xạ đến một chữ cái khác, và không có hai chữ cái nào ánh xạ đến cùng một chữ cái.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
**Output:** ["mee","aqq"]
**Explanation:** 
"mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["a","b","c"], pattern = "a"
**Output:** ["a","b","c"]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= pattern.length <= 20`
*   `1 <= words.length <= 50`
*   `words[i].length == pattern.length`
*   `pattern` and `words[i]` are lowercase English letters.
