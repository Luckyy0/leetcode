# Result for Vowel Spellchecker
# *Kết quả cho bài toán Trình kiểm tra chính tả Nguyên âm*

## Description
## *Mô tả*

Given a `wordlist`, we want to implement a spellchecker that converts a query word into a correct word.
*Cho một `danh sách từ` (wordlist), chúng tôi muốn thực hiện một trình kiểm tra chính tả chuyển đổi một từ truy vấn thành một từ đúng.*

For a given `query` word, the spell checker handles two categories of spelling mistakes:
*Đối với một từ `truy vấn` đã cho, trình kiểm tra chính tả xử lý hai loại lỗi chính tả:*

*   **Capitalization:** If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
    *   *Example:* `wordlist = ["yellow"]`, `query = "YellOw"`: `correct = "yellow"`
    *   *Example:* `wordlist = ["Yellow"]`, `query = "yellow"`: `correct = "Yellow"`
    *   *Example:* `wordlist = ["yellow"]`, `query = "yellow"`: `correct = "yellow"`
    *   **Viết hoa:** *Nếu truy vấn khớp với một từ trong danh sách từ (không phân biệt chữ hoa chữ thường), thì từ truy vấn được trả về với cùng kiểu viết hoa như trong danh sách từ.*
*   **Vowel Errors:** If after replacing the vowels (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`) of the query word with an insensitive vowel placeholder, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
    *   *Example:* `wordlist = ["YellOw"]`, `query = "yollow"`: `correct = "YellOw"`
    *   *Example:* `wordlist = ["YellOw"]`, `query = "yeellow"`: `correct = ""` (no match)
    *   *Example:* `wordlist = ["YellOw"]`, `query = "yllw"`: `correct = ""` (no match)
    *   **Lỗi Nguyên âm:** *Nếu sau khi thay thế các nguyên âm (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`) của từ truy vấn bằng một ký tự giữ chỗ nguyên âm không phân biệt, nó khớp với một từ trong danh sách từ (không phân biệt chữ hoa chữ thường), thì từ truy vấn được trả về với cùng kiểu viết hoa như kết quả khớp trong danh sách từ.*

In addition, the spell checker operates under the following precedence rules:
*Ngoài ra, trình kiểm tra chính tả hoạt động theo các quy tắc ưu tiên sau:*

*   When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
    *   *Khi truy vấn khớp chính xác với một từ trong danh sách từ (phân biệt chữ hoa chữ thường), bạn nên trả về chính từ đó.*
*   When the query matches a word up to capitlization, you should return the first such match in the wordlist.
    *   *Khi truy vấn khớp với một từ về mặt viết hoa, bạn nên trả về kết quả khớp đầu tiên như vậy trong danh sách từ.*
*   When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
    *   *Khi truy vấn khớp với một từ về mặt lỗi nguyên âm, bạn nên trả về kết quả khớp đầu tiên như vậy trong danh sách từ.*
*   If the query has no matches in the wordlist, you should return the empty string.
    *   *Nếu truy vấn không có kết quả khớp nào trong danh sách từ, bạn nên trả về chuỗi rỗng.*

Given some `queries`, return a list of words `answer`, where `answer[i]` is the correct word for `query = queries[i]`.
*Cho một số `truy vấn`, trả về danh sách các từ `answer`, trong đó `answer[i]` là từ đúng cho `truy vấn = queries[i]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
**Output:** ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

## Example 2:
## *Ví dụ 2:*

**Input:** wordlist = ["yellow"], queries = ["YellOw"]
**Output:** ["yellow"]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= wordlist.length, queries.length <= 5000`
*   `1 <= wordlist[i].length, queries[i].length <= 7`
*   `wordlist[i]` and `queries[i]` consist only of English letters.
