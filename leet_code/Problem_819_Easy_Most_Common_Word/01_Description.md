# Result for Most Common Word
# *Kết quả cho bài toán Từ phổ biến nhất*

## Description
## *Mô tả*

Given a string `paragraph` and a string array of banned words `banned`, return *the most frequent word that is not banned*. It is **guaranteed** there is at least one word that is not banned, and that the answer is **unique**.
*Cho một chuỗi `paragraph` và một mảng chuỗi các từ bị cấm `banned`, trả về *từ xuất hiện nhiều nhất mà không bị cấm*. Đảm bảo có ít nhất một từ không bị cấm và câu trả lời là **duy nhất**.*

The words in `paragraph` are **case-insensitive** and the answer should be returned in **lowercase**.
*Các từ trong `paragraph` **không phân biệt chữ hoa chữ thường** và kết quả trả về phải ở dạng **chữ thường**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
**Output:** "ball"
**Explanation:** 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive, that punctuation is ignored (even if adjacent to words, such as "ball,"), and that "hit" isn't the answer even though it occurs more because it is banned.

## Example 2:
## *Ví dụ 2:*

**Input:** paragraph = "a.", banned = []
**Output:** "a"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= paragraph.length <= 1000`
*   Paragraph consists of English letters, space, or one of the symbols: `"!?',;."`.
*   `0 <= banned.length <= 100`
*   `1 <= banned[i].length <= 10`
*   `banned[i]` consists of lowercase English letters.
