# Result for Sentence Screen Fitting
# *Kết quả cho bài toán Lắp câu vào Màn hình*

## Description
## *Mô tả*

Given a `rows x cols` screen and a sentence represented by a list of strings, return *the number of times the given sentence can be fitted on the screen*.
*Cho một màn hình kích thước `rows x cols` và một câu được đại diện bởi một danh sách các chuỗi, hãy trả về *số lần câu đó có thể được lắp vừa trên màn hình*.*

When a word does not fit on the current line, it must start on the next line. A single space must separate every two adjacent words on the same line.
*Khi một từ không vừa trên dòng hiện tại, nó phải bắt đầu ở dòng tiếp theo. Một khoảng trắng duy nhất phải phân tách hai từ cạnh nhau trên cùng một dòng.*

## Example 1:
## *Ví dụ 1:*

**Input:** `rows = 2, cols = 8, sentence = ["hello", "world"]`
**Output:** `1`
**Explanation:**
line 1: `hello   `
line 2: `world   `
The character `-` means an empty space on the screen.

## Example 2:
## *Ví dụ 2:*

**Input:** `rows = 3, cols = 6, sentence = ["a", "bcd", "e"]`
**Output:** `2`
**Explanation:**
line 1: `a bcd `
line 2: `e a   `
line 3: `bcd e `

## Constraints:
## *Ràng buộc:*

*   `1 <= rows, cols <= 10^4`
*   `1 <= sentence.length <= 100`
*   `1 <= sentence[i].length <= 10`
