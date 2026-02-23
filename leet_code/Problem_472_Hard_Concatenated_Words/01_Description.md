# Result for Concatenated Words
# *Kết quả cho bài toán Chuỗi nối tiếp*

## Description
## *Mô tả*

Given an array of strings `words` (**without duplicates**), return *all the **concatenated words** in the given list of* `words`.
*Cho một mảng các chuỗi `words` (**không trùng lặp**), hãy trả về *tất cả các **từ nối tiếp** trong danh sách* `words` *đã cho*.*

A **concatenated word** is defined as a string that is comprised entirely of at least two shorter words in the given array.
*Một **từ nối tiếp** được định nghĩa là một chuỗi được tạo thành hoàn toàn bởi ít nhất hai từ ngắn hơn trong mảng đã cho.*

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]`
**Output:** `["catsdogcats","dogcatsdog","ratcatdogcat"]`
**Explanation:** "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["cat","dog","catdog"]`
**Output:** `["catdog"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 10^4`
*   `1 <= words[i].length <= 30`
*   `words` consists of only lowercase English letters.
*   All the strings of `words` are **unique**.
*   `1 <= sum(words[i].length) <= 10^5`
