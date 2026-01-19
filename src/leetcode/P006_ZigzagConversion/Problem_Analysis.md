# 6. Zigzag Conversion / Chuyển Đổi Zigzag

## Problem Description / Mô tả bài toán
The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility).
Chuỗi `"PAYPALISHIRING"` được viết theo mô hình zigzag trên một số hàng nhất định như sau: (bạn có thể muốn hiển thị mô hình này bằng phông chữ cố định để dễ đọc hơn).

```text
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`.
Và sau đó đọc từng dòng: `"PAHNAPLSIIGYIR"`.

Write the code that will take a string and make this conversion given a number of rows.
Viết mã để thực hiện việc chuyển đổi này với một chuỗi và số hàng cho trước.

### Example 1:
```text
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

### Example 2:
```text
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
```

### Example 3:
```text
Input: s = "A", numRows = 1
Output: "A"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 1000`
- `s` consists of English letters (lower-case and upper-case), ',' and '.'.
- `1 <= numRows <= 1000`

---

## Analysis / Phân tích

### Approach 1: Sort by Row (Simulation) / Sắp xếp theo hàng (Mô phỏng)
- **Idea**: Simulate the process. We can use `min(numRows, len(s))` StringBuilders to represent each row.
- **Ý tưởng**: Mô phỏng quá trình. Chúng ta có thể sử dụng `min(numRows, len(s))` StringBuilder để đại diện cho mỗi hàng.
- We iterate through the string `s`, putting characters into the appropriate row.
- We track the `currentRow` and a `direction` (going down or going up).
- **Time Complexity**: O(n). We visit every character once.
- **Space Complexity**: O(n). We store the string in rows.

### Approach 2: Visit by Row (Mathematical) / Duyệt theo hàng (Toán học)
- **Idea**: Instead of simulation, we can determine exactly which indices belong to row 0, row 1, etc.
- **Ý tưởng**: Thay vì mô phỏng, ta có thể xác định chính xác các chỉ số nào thuộc về hàng 0, hàng 1, v.v.
- The pattern repeats every `cycleLen = 2 * numRows - 2`.
- For row `0`, indices are `k * cycleLen`.
- For row `i` (internal rows), indices are `k * cycleLen + i` and `(k + 1) * cycleLen - i`.
- For row `numRows - 1`, indices are `k * cycleLen + numRows - 1`.
- **Time Complexity**: O(n). We construct the string directly.
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **numRows = 1**: The pattern doesn't zigzag, it's just the original string.
2.  **s.length < numRows**: Characters just fill the first few rows of the first column.
