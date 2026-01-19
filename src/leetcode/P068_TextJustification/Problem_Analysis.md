# 68. Text Justification / Căn Chỉnh Văn Bản

## Problem Description / Mô tả bài toán
Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.
Cho một mảng các chuỗi `words` và chiều rộng `maxWidth`, định dạng văn bản sao cho mỗi dòng có chính xác `maxWidth` ký tự và được căn đều (trái và phải).

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.
Bạn nên đóng gói các từ theo phương pháp tham lam; tức là, đóng gói càng nhiều từ càng tốt trong mỗi dòng. Thêm các khoảng trắng `' '` khi cần thiết sao cho mỗi dòng có chính xác `maxWidth` ký tự.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
Các khoảng trắng thừa giữa các từ nên được phân phối đều nhất có thể. Nếu số lượng khoảng trắng trên một dòng không chia hết cho các từ, các khoảng trống bên trái sẽ được gán nhiều khoảng trắng hơn các khoảng trống bên phải.

For the last line of text, it should be left-justified, and no extra space is inserted between words.
Đối với dòng văn bản cuối cùng, nó nên được căn trái và không chèn thêm khoảng trắng giữa các từ.

### Example 1:
```text
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

## Constraints / Ràng buộc
- `1 <= words.length <= 300`
- `1 <= words[i].length <= 20`
- `words[i]` consists of only English letters and symbols.
- `1 <= maxWidth <= 100`
- `words[i].length <= maxWidth`

---

## Analysis / Phân tích

### Approach: Greedy Pack + Calculation / Đóng Gói Tham Lam + Tính Toán
- **Idea**: Process words one by one. Maintain a `currentLine` list.
- **Ý tưởng**: Xử lý từng từ một. Duy trì một danh sách `currentLine`.
- **Steps**:
    1.  Check if adding `word` fits in `maxWidth` (considering 1 space between words).
    2.  If fits, add to `currentLine`.
    3.  If not fits, process `currentLine`:
        - Calculate `totalSpaces` needed = `maxWidth - sum(lengths)`.
        - **If Last Line or Single Word**: Left justify. Append words with " " then fill rest with spaces.
        - **Else**: Distribute `totalSpaces` among `gaps = numWords - 1`.
            - `spacePerGap = totalSpaces / gaps`.
            - `extraSpaces = totalSpaces % gaps`.
            - Fill gaps, adding 1 extra space to the first `extraSpaces` gaps.
    4.  Add current `word` to next line.
    5.  Handle the **last line** specifically (Left Justify).
- **Time Complexity**: O(n), where n is total characters.
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **Single Word Line**: Handle as left justified.
2.  **Last Line**: Handle left justification.
3.  **Exact Fit**: Spaces distribute evenly or zero extra.
