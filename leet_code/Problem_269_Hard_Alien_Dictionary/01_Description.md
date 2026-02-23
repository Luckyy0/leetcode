# Result for Alien Dictionary
# *Kết quả cho bài toán Từ điển Người ngoài hành tinh*

## Description
## *Mô tả*

There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
*Có một ngôn ngữ mới của người ngoài hành tinh sử dụng bảng chữ cái tiếng Anh. Tuy nhiên, thứ tự giữa các chữ cái thì bạn không biết.*

You are given a list of strings `words` from the alien language's dictionary, where the strings in `words` are **sorted lexicographically** by the rules of this new language.
*Bạn được cung cấp một danh sách các chuỗi `words` từ từ điển của ngôn ngữ người ngoài hành tinh, trong đó các chuỗi trong `words` được **sắp xếp theo thứ tự từ điển** theo các quy tắc của ngôn ngữ mới này.*

Return *a string of the unique letters in the new alien language sorted in **lexicographically increasing order** by the new language's rules. If there is no solution, return* `""`. *If there are multiple solutions, return **any of them**.*
*Trả về *một chuỗi các chữ cái duy nhất trong ngôn ngữ người ngoài hành tinh mới được sắp xếp theo **thứ tự từ điển tăng dần** theo các quy tắc của ngôn ngữ mới. Nếu không có giải pháp, hãy trả về* `""`. *Nếu có nhiều giải pháp, hãy trả về **bất kỳ giải pháp nào trong số đó**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["wrt","wrf","er","ett","rftt"]`
**Output:** `"wertf"`

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["z","x"]`
**Output:** `"zx"`

## Example 3:
## *Ví dụ 3:*

**Input:** `words = ["z","x","z"]`
**Output:** `""`
**Explanation:** The order is invalid, so return `""`.

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 100`
*   `1 <= words[i].length <= 100`
*   `words[i]` consists of only lowercase English letters.
