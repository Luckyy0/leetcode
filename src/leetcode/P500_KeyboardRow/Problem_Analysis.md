# 500. Keyboard Row / Hàng Bàn Phím

## Problem Description / Mô tả bài toán
Given an array of strings `words`, return the words that can be typed using letters of only one row of American keyboard.
Cho một mảng các chuỗi `words`, hãy trả về các từ có thể được gõ chỉ bằng các chữ cái thuộc một hàng duy nhất trên bàn phím Hoa Kỳ.

- **First row**: "qwertyuiop"
- **Second row**: "asdfghjkl"
- **Third row**: "zxcvbnm"

### Example 1:
```text
Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
```

## Constraints / Ràng buộc
- `1 <= words.length <= 20`
- `1 <= words[i].length <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Set-based Membership Checking / Kiểm tra tập hợp
We can assign a row index to each character of the alphabet. For a word to be valid, all of its characters must have the same row index.

Algorithm:
1. Pre-calculate a mapping `char -> rowIndex` for all letters.
2. For each `word` in `words`:
   - Get the row index of the first character.
   - For all subsequent characters:
     - If their row index is different from the first one, the word is invalid. Break.
   - If the loop completes, add the word to the result list.

### Complexity / Độ phức tạp
- **Time**: O(Total number of characters in all words).
- **Space**: O(1) for the row mapping.

---

## Analysis / Phân tích

### Approach: Linear Scan with Reference Mapping

**Algorithm**:
1.  Map 26 letters to Rows 0, 1, 2.
2.  Iterate each word.
3.  Check row consistency.

---
