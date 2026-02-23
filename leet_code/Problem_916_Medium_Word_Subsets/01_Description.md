# Result for Word Subsets
# *Kết quả cho bài toán Tập hợp Con từ của Từ*

## Description
## *Mô tả*

You are given two string arrays `words1` and `words2`.
*Bạn được cho hai mảng chuỗi `words1` và `words2`.*

A string `b` is a **subset** of string `a` if every letter in `b` occurs in `a` including multiplicity.
*Một chuỗi `b` là một **tập con** của chuỗi `a` nếu mọi chữ cái trong `b` đều xuất hiện trong `a` bao gồm cả số lần lặp lại.*

*   For example, `"wrr"` is a subset of `"warrior"` but is not a subset of `"world"`.
    *   *Ví dụ, `"wrr"` là tập con của `"warrior"` nhưng không phải là tập con của `"world"`.*

A string `a` from `words1` is **universal** if for every string `b` in `words2`, `b` is a subset of `a`.
*Một chuỗi `a` từ `words1` là **phổ quát** nếu đối với mọi chuỗi `b` trong `words2`, `b` là một tập con của `a`.*

Return *an array of all the **universal** strings in `words1`*. You may return the answer in **any order**.
*Hãy trả về *một mảng của tất cả các chuỗi **phổ quát** trong `words1`*. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
**Output:** ["facebook","google","leetcode"]

## Example 2:
## *Ví dụ 2:*

**Input:** words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
**Output:** ["apple","google","leetcode"]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words1.length, words2.length <= 10^4`
*   `1 <= words1[i].length, words2[i].length <= 10`
*   `words1[i]` and `words2[i]` consist only of lowercase English letters.
*   All the strings of `words1` are **unique**.
