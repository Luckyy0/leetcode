# Result for Expressive Words
# *Kết quả cho bài toán Từ biểu cảm*

## Description
## *Mô tả*

Sometimes people repeat letters to represent extra feeling. For example:
- `"hello" -> "heeellooo"`
- `"hi" -> "hiii"`

*Đôi khi mọi người lặp lại các chữ cái để thể hiện thêm cảm xúc.*

In these strings like `"heeellooo"`, we have groups of adjacent letters that are all the same: `"h"`, `"eee"`, `"ll"`, `"ooo"`.
*Trong các chuỗi này, chúng ta có các nhóm ký tự giống nhau đứng cạnh nhau.*

We are given a query string `s` and a list of query words `words`. A query word is **stretchy** if it can be made to be `s` by extending some groups to be length 3 or more.
*Cho một chuỗi `s` và danh sách các từ `words`. Một từ là **stretchy** nếu nó có thể biến thành `s` bằng cách kéo dài các nhóm ký tự để đạt độ dài ít nhất là 3.*

For example, a group of "e" of length 1 can be extended to length 3 (by adding two "e"s), but it cannot be extended to length 2. (A group can only be extended if the final length is at least 3).
*Ví dụ, một nhóm "e" độ dài 1 có thể kéo dài thành 3, nhưng không thể thành 2. (Một nhóm chỉ được kéo dài nếu độ dài cuối cùng ít nhất là 3).*

Return *the number of query words that are **stretchy***.
*Trả về số lượng từ trong danh sách là **stretchy**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "heeellooo", words = ["hello", "hi", "helo"]
**Output:** 1
**Explanation:** 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We cannot extend "helo" to get "heeellooo" because the group "ll" has length 2 in "heeellooo".

## Example 2:
## *Ví dụ 2:*

**Input:** s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length, words.length <= 100`
*   `1 <= words[i].length <= 100`
*   `s` and `words[i]` consist of lowercase English letters.
