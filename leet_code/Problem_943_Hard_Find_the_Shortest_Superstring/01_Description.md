# Result for Find the Shortest Superstring
# *Kết quả cho bài toán Tìm Siêu chuỗi Ngắn nhất*

## Description
## *Mô tả*

Given an array of strings `words`, return *the smallest string that contains each string in* `words` *as a substring*. If there are multiple valid strings of the smallest length, return **any of them**.
*Cho một mảng các chuỗi `words`, trả về *chuỗi nhỏ nhất chứa mỗi chuỗi trong* `words` *dưới dạng chuỗi con*. Nếu có nhiều chuỗi hợp lệ có cùng độ dài nhỏ nhất, hãy trả về **bất kỳ chuỗi nào trong số đó**.*

You may assume that no string in `words` is a substring of another string.
*Bạn có thể giả định rằng không có chuỗi nào trong `words` là chuỗi con của chuỗi khác.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["alex","loves","leetcode"]
**Output:** "alexlovesleetcode"
**Explanation:** All permutations of "alex","loves","leetcode" would also be accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["catg","ctaagt","gcta","ttca","atgcatc"]
**Output:** "gctaagttcatgcatc"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 12`
*   `1 <= words[i].length <= 20`
*   `words[i]` consists of lowercase English letters.
*   All the strings of `words` are **unique**.
