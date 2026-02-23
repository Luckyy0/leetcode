# Analysis for Text Justification
# *Phân tích cho bài toán Căn Lề Văn Bản*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of words, integer `maxWidth`. *Mảng các từ, số nguyên `maxWidth`.*
*   **Output:** List of formatted lines. *Danh sách các dòng đã định dạng.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Greedy packing: as many words as possible.
*   Fully justified: distribute spaces evenly, extra spaces on the left.
*   Last line: left-justified.
*   Single word lines: left-justified.
*   *Đóng gói tham lam: nhiều từ nhất có thể.*
*   *Căn đều hoàn toàn: phân bổ khoảng trắng đều, khoảng trắng thừa ở bên trái.*
*   *Dòng cuối cùng: căn lề trái.*
*   *Dòng chỉ có một từ: căn lề trái.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Simulation with Boundary Logic
### *Hướng tiếp cận: Mô phỏng với Logic Ranh giới*

*   **Intuition:** Iterate through the words and keep track of the current line's words and total length. When adding another word exceeds `maxWidth`, format the current line.
*   *Ý tưởng: Duyệt qua các từ và theo dõi các từ của dòng hiện tại và tổng độ dài. Khi thêm một từ khác vượt quá `maxWidth`, hãy định dạng dòng hiện tại.*

*   **Algorithm Steps:**
    1.  `left = 0`.
    2.  While `left < words.length`:
        *   Find `right`: find the last word that fits in the line from `left`.
        *   `count = right - left`.
        *   Calculate `totalSpaces`: `maxWidth - sumOfWordLengths`.
        *   **Case 1: Last line or Single word line:**
            *   Append words with 1 space between, then pad remaining spaces at the end.
        *   **Case 2: Middle line with multiple words:**
            *   `spacesBetween = totalSpaces / (count - 1)`.
            *   `extraSpaces = totalSpaces % (count - 1)`.
            *   Append words. For the first `extraSpaces` slots, add `spacesBetween + 1`. For the rest, add `spacesBetween`.
        *   Update `left = right`.

*   **Complexity:**
    *   Time: $O(N \cdot maxWidth)$ where $N$ is number of words.
    *   Space: $O(N \cdot maxWidth)$ for the result.

### Dry Run
### *Chạy thử*
`words = ["This", "is", "an", "example"], maxWidth = 16`
1. Line 1: "This", "is", "an". Sum = 4+2+2=8. Total spaces = 16-8=8.
2. 2 slots. `8 / 2 = 4`. `8 % 2 = 0`.
3. Result: `"This" + "    " + "is" + "    " + "an"` -> length 16.
4. Line 2: "example". Sum = 7. Last line.
5. Result: `"example" + "         "`.
---
*Việc xử lý các trường hợp đặc biệt (dòng cuối, dòng một từ) là phần khó nhất.*
Handling special cases (last line, single word line) is the trickiest part.
