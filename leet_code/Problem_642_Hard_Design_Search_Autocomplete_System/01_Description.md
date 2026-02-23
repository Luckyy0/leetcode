# Result for Design Search Autocomplete System
# *Kết quả cho bài toán Thiết kế Hệ thống Gợi ý Tìm kiếm*

## Description
## *Mô tả*

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character `'#'`). For each character they type **except '#'**, you need to return the **top 3** historical hot sentences that have the same prefix as the part of the sentence already typed.
*Thiết kế một hệ thống gợi ý tìm kiếm (autocomplete) cho công cụ tìm kiếm. Người dùng có thể nhập một câu (ít nhất một từ và kết thúc bằng ký tự đặc biệt `'#'`). Đối với mỗi ký tự họ nhập **ngoại trừ '#'**, bạn cần trả về **3 câu phổ biến nhất** trong lịch sử có cùng tiền tố với phần câu đã nhập.*

The hotness for a sentence is defined by the number of times a user typed the exactly same sentence before. The conditions for the top 3 hot sentences are:
*Độ phổ biến (hotness) của một câu được xác định bởi số lần người dùng đã nhập chính xác câu đó trước đây. Các điều kiện cho 3 câu phổ biến nhất là:*

1.  The hotness is defined by the times the user types the sentence. A sentence with high hotness is higher than a sentence with low hotness.
    *   *Độ phổ biến được xác định bởi số lần người dùng nhập câu đó. Câu có độ phổ biến cao hơn sẽ đứng trước câu có độ phổ biến thấp hơn.*
2.  If two sentences have the same hotness, the historical hot sentence with smaller ASCII-code order should be listed first.
    *   *Nếu hai câu có cùng độ phổ biến, câu có thứ tự mã ASCII nhỏ hơn (thứ tự từ điển) sẽ được liệt kê trước.*
3.  If less than 3 hot sentences exist, then return as many as you can.
    *   *Nếu có ít hơn 3 câu phổ biến tồn tại, hãy trả về nhiều nhất có thể.*

When the user types `'#'`, it means the sentence is finished. At this time, you should save the whole sentence typed as a historical sentence in your system and update its frequency.
*Khi người dùng nhập `'#'`, điều đó có nghĩa là câu đã kết thúc. Lúc này, bạn nên lưu toàn bộ câu đã nhập dưới dạng một câu lịch sử trong hệ thống của mình và cập nhật tần suất của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:**
`AutocompleteSystem(["i love you", "island", "ironman", "i love leetcode"], [5, 3, 2, 2])`
The system have have four sentences and their corresponding times.
`input('i')` -> Output: `["i love you", "island", "i love leetcode"]`
`input(' ')` -> Output: `["i love you", "i love leetcode"]`
`input('a')` -> Output: `[]`
`input('#')` -> Output: `[]`

---

## Constraints:
## *Ràng buộc:*

*   The input sentence will always end with `'#'`.
*   The frequency of a historical sentence is a positive integer.
*   The system should be case-sensitive.
*   Maximum number of sentences is 100, maximum length is 100.
