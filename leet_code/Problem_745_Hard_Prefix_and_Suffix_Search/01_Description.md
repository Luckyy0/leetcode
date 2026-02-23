# Result for Prefix and Suffix Search
# *Kết quả cho bài toán Tìm kiếm Tiền tố và Hậu tố*

## Description
## *Mô tả*

Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.
*Thiết kế một từ điển đặc biệt chứa một số từ và hỗ trợ tìm kiếm các từ trong đó bằng tiền tố và hậu tố.*

Implement the `WordFilter` class:
*   `WordFilter(string[] words)` Initializes the object with the `words` in the dictionary.
*   `f(string prefix, string suffix)` Returns *the index of the word in the dictionary*, which has the prefix `prefix` and the suffix `suffix`. If there is more than one valid index, return **the largest** of them. If there is no such word in the dictionary, return `-1`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
**Output:** [null, 0]
**Explanation:** 
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix "a" and suffix "e".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 15000`
*   `1 <= words[i].length <= 10`
*   `1 <= prefix.length, suffix.length <= 10`
*   `words[i]`, `prefix` and `suffix` consist of lower-case English letters only.
*   At most `15000` calls will be made to the function `f`.
