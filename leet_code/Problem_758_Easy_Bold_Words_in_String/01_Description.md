# Result for Bold Words in String
# *Kết quả cho bài toán Từ In đậm trong Chuỗi*

## Description
## *Mô tả*

Given an array of keywords `words` and a string `s`, make all appearances of all keywords `words[i]` in `s` bold. Any letters between `<b>` and `</b>` tags become bold.
*Cho một mảng các từ khóa `words` và một chuỗi `s`, hãy in đậm tất cả các lần xuất hiện của tất cả các từ khóa `words[i]` trong `s`. Bất kỳ ký tự nào nằm giữa thẻ `<b>` và `</b>` đều trở nên in đậm.*

The returned string should use the least number of tags possible, and the tags should form a valid combination.
*Chuỗi trả về nên sử dụng ít thẻ nhất có thể, và các thẻ phải tạo thành một tổ hợp hợp lệ.*

For example, given that `words = ["ab", "bc"]` and `s = "aabcd"`, we should return `"a<b>abc</b>d"`. Note that returning `"a<b>a<b>b</b>c</b>d"` would use more tags, so it is incorrect.
*Ví dụ, nếu `words = ["ab", "bc"]` và `s = "aabcd"`, ta nên trả về `"a<b>abc</b>d"`. Lưu ý rằng trả về `"a<b>a<b>b</b>c</b>d"` sẽ sử dụng nhiều thẻ hơn, vì vậy nó là không chính xác.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["ab","bc"], s = "aabcd"
**Output:** "a<b>abc</b>d"
**Explanation:** 
- "ab" appears at index 1: "a**ab**cd"
- "bc" appears at index 2: "aa**bc**d"
- Merged interval [1, 3] covering indices 1, 2, 3 ("abc").

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["cc","cb","b","d"], s = "cccd" // Hypothetical
**Output:** "<b>cccd</b>" ? No wait.
Actually standard example:
words = ["ab", "bc"], s = "aabcd" -> "a<b>abc</b>d".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 500`
*   `0 <= words.length <= 50`
*   `1 <= words[i].length <= 10`
*   `s` and `words[i]` consist of lowercase English letters.
