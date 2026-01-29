# 422. Valid Word Square / Hình Vuông Từ Hợp Lệ

## Problem Description / Mô tả bài toán
Given an array of strings `words`, return `true` if it forms a valid **word square**.
Cho một mảng các chuỗi `words`, hãy trả về `true` nếu nó tạo thành một **hình vuông từ** hợp lệ.

A sequence of strings forms a valid word square if the `k-th` row and `k-th` column read the same string, where `0 <= k < max(numRows, numCols)`.
Một chuỗi các chuỗi tạo thành một hình vuông từ hợp lệ nếu hàng thứ `k` và cột thứ `k` đọc giống hệt nhau, với `0 <= k < max(số hàng, số cột)`.

### Example 1:
```text
Input: words = ["abcd","bnrt","crmy","dtye"]
Output: true
Explanation:
Row 0: "abcd", Col 0: "abcd"
Row 1: "bnrt", Col 1: "bnrt"
Row 2: "crmy", Col 2: "crmy"
Row 3: "dtye", Col 3: "dtye"
All rows and columns match.
```

### Example 2:
```text
Input: words = ["abcd","bnrt","crm","dt"]
Output: true
Explanation:
Row 0: "abcd", Col 0: "abcd"
Row 1: "bnrt", Col 1: "bnrt"
Row 2: "crm", Col 2: "crm"
Row 3: "dt", Col 3: "dt"
```

### Example 3:
```text
Input: words = ["ball","area","read","lady"]
Output: false
```

## Constraints / Ràng buộc
- `1 <= words.length <= 500`
- `1 <= words[i].length <= 500`
- `words[i]` consists of only lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Symmetry Check / Kiểm tra tính đối xứng
A valid word square is essentially a matrix that is symmetric about its main diagonal. The `j-th` character of the `i-th` word (row `i`, column `j`) must be equal to the `i-th` character of the `j-th` word (row `j`, column `i`).

Critical points:
1. Since rows can have different lengths, we must carefully check bounds before accessing characters.
2. If row `i` has a character at column `j`, then row `j` must exist, and row `j` must have a character at column `i`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) where N is the total number of characters in all words.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Grid Character Matching

**Algorithm**:
1.  Loop through each word `i`.
2.  Loop through each character `j` in word `i`.
3.  Check if `j >= words.size()` or `i >= words[j].length()`.
4.  Check if `words[i].charAt(j) == words[j].charAt(i)`.

---
