# Result for Replace Words
# *Kết quả cho bài toán Thay thế Từ*

## Description
## *Mô tả*

In English, we have a concept called **root**, which can be followed by some other word to form another longer word - let's call this word **derivative**. For example, when the root `"help"` is followed by the word `"ful"`, the derivative `"helpful"` is formed.
*Trong tiếng Anh, chúng ta có một khái niệm gọi là **gốc từ** (root), vốn có thể được theo sau bởi một từ khác để tạo thành một từ dài hơn - hãy gọi từ này là **từ phái sinh** (derivative). Ví dụ, khi gốc từ `"help"` theo sau bởi từ `"ful"`, từ phái sinh `"helpful"` được tạo thành.*

Given a `dictionary` consisting of many **roots** and a `sentence` consisting of words separated by spaces, replace all the derivatives in the sentence with the **root** forming it. If a derivative can be replaced by more than one **root**, replace it with the **root** that has **the shortest length**.
*Cho một `dictionary` gồm nhiều **gốc từ** và một `sentence` gồm các từ cách nhau bởi khoảng trắng, hãy thay thế tất cả các từ phái sinh trong câu bằng **gốc từ** tạo ra nó. Nếu một từ phái sinh có thể được thay thế bằng nhiều hơn một **gốc từ**, hãy thay thế nó bằng **gốc từ có độ dài ngắn nhất**.*

Return the `sentence` after the replacement.
*Trả về `sentence` sau khi đã thay thế.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
**Output:** "the cat was rat by the bat"

## Example 2:
## *Ví dụ 2:*

**Input:** dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
**Output:** "a a b c"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= dictionary.length <= 1000`
*   `1 <= dictionary[i].length <= 100`
*   `dictionary[i]` consists of only lowercase English letters.
*   `1 <= sentence.length <= 10^6`
*   `sentence` consists of only lowercase English letters and spaces.
*   The number of words in `sentence` is in the range `[1, 1000]`.
*   The length of each word in `sentence` is in the range `[1, 1000]`.
*   Every two consecutive words in `sentence` will be separated by exactly one space.
*   `sentence` does not have leading or trailing spaces.
