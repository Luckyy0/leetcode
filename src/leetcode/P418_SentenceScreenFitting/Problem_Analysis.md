# 418. Sentence Screen Fitting / Sắp Xếp Câu Trên Màn Hình

## Problem Description / Mô tả bài toán
Given a `rows x cols` screen and a sentence represented by a list of strings, return the number of times the given sentence can be fitted on the screen.
Cho một màn hình kích thước `rows x cols` và một câu văn được biểu diễn bằng một danh sách các chuỗi, hãy trả về số lần mà câu văn đó có thể được sắp xếp trên màn hình.

Guidelines:
1. A word cannot be split into two lines.
2. The order of words in the sentence must be preserved.
3. Two consecutive words in a line must be separated by a single space.

### Example 1:
```text
Input: rows = 2, cols = 8, sentence = ["hello", "world"]
Output: 1
Explanation:
hello---
world---
(The character '-' means an empty space on the screen).
```

### Example 2:
```text
Input: rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
Output: 2
Explanation:
a-bcd-
e-a---
bcd-e-
```

## Constraints / Ràng buộc
- `1 <= rows, cols <= 10^4`
- `1 <= sentence.length <= 100`
- `1 <= sentence[i].length <= 10`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with String Offsets / Mô phỏng với Offset chuỗi
A simple simulation word-by-word might be too slow given `rows, cols` up to $10^4$. We need a more efficient way to track how many characters are placed.

1. Create a single string `s` from the sentence, joined by spaces, and adding a trailing space: `"hello world "`. Let `L` be the length of `s`.
2. Maintain a `start` variable representing the total number of characters placed on the screen across all rows (in an imaginary infinite string `s + s + s ...`).
3. For each row:
   - "Jump" `cols` characters forward: `start += cols`.
   - Now check the character at `start % L`:
     - If it's a space (`s.charAt(start % L) == ' '`), the line fits perfectly or ends within a space. Increment `start` to skip the space for the next line.
     - If it's not a space, we might be cutting a word. Move `start` backward until we find a space (the end of the previous word). After finding the space, increment `start` to move to the beginning of the word that will start the next line.
4. Finally, the number of sentences is `start / L`.

### Complexity / Độ phức tạp
- **Time**: O(rows + L) where L is the length of the joined sentence string. In the worst case of moving backward, we move at most the length of the longest word per row.
- **Space**: O(L) to store the joined string.

---

## Analysis / Phân tích

### Approach: String Mapping

**Algorithm**:
1.  Join sentence: `s = String.join(" ", sentence) + " "`.
2.  Iterate through rows and adjust `start`.

---
