# Result for Add Bold Tag in String
# *Kết quả cho bài toán Thêm Thẻ In đậm vào Chuỗi*

## Description
## *Mô tả*

You are given a string `s` and a list of strings `words`.
*Bạn được cho một chuỗi `s` và một danh sách các chuỗi `words`.*

You should add a closed pair of bold tag `<b>` and `</b>` to wrap the substrings in `s` that exist in `words`.
*Bạn nên thêm một cặp thẻ in đậm đóng mở `<b>` và `</b>` để bao bọc các chuỗi con trong `s` tồn tại trong `words`.*

If two such substrings overlap, you should wrap them together with only one pair of closed bold-tag. If two such substrings are consecutive, you should also wrap them together.
*Nếu hai chuỗi con như vậy chồng lấp nhau, bạn nên bao bọc chúng lại với nhau chỉ bằng một cặp thẻ in đậm. Nếu hai chuỗi con như vậy nằm liên tiếp, bạn cũng nên bao bọc chúng lại với nhau.*

Return the string `s` after adding the bold tags.
*Trả về chuỗi `s` sau khi thêm các thẻ in đậm.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abcxyz123", words = ["abc","123"]
**Output:** "<b>abc</b>xyz<b>123</b>"

## Example 2:
## *Ví dụ 2:*

**Input:** s = "aaabbcc", words = ["aaa","aab","bc"]
**Output:** "<b>aaabbc</b>c"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `0 <= words.length <= 100`
*   `1 <= words[i].length <= 1000`
*   `s` and `words[i]` consist of English letters and digits.
*   All the values of `words` are **unique**.
