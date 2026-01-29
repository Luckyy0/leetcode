# 604. Design Compressed String Iterator / Thiết Kế Trình Lặp Chuỗi Nén

## Problem Description / Mô tả bài toán
Design and implement a data structure for a compressed string iterator. It should support the following operations: `next` and `hasNext`.
Thiết kế và triển khai cấu trúc dữ liệu cho trình lặp chuỗi nén. Nó nên hỗ trợ các hoạt động sau: `next` và `hasNext`.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
Chuỗi nén đã cho sẽ ở dạng mỗi chữ cái theo sau là một số nguyên dương đại diện cho số lượng chữ cái này tồn tại trong chuỗi không nén ban đầu.

- `next()` - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
- `hasNext()` - Judge whether there is any letter needs to be uncompressed.

### Example 1:
```text
Input: "L1e2t1C1o1d1e1"
Output: returns 'L', 'e', 'e', 't', 'C', 'o', 'd', 'e' sequentially.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Queue / Linear Scan / Hàng Đợi / Quét Tuyến Tính
We iterate through the compressed string. It consists of `Char` + `Count`.
Use variables to store:
- `currentChar`: The character currently being served.
- `remainingCount`: How many times `currentChar` is left to be returned.
- `index`: Current position in the compressed string.

Algorithm for `next()`:
- If `remainingCount > 0`, decrement and return `currentChar`.
- If `remainingCount == 0`:
  - Check `hasNext()`. If false, return ' '.
  - Read next char from string at `index`.
  - Read next number from string starting `index + 1`.
  - Update `currentChar`, `remainingCount`, `index`.
  - Decrement `remainingCount` and return `currentChar`.

### Complexity / Độ phức tạp
- **Time**: O(1) per call avg.
- **Space**: O(1) (storage of index and string ref).

---

## Analysis / Phân tích

### Approach: Lazy Parsing

**Algorithm**:
1.  Store string reference and pointer.
2.  Store current active character and its remaining count.
3.  On `next`:
    - If count > 0, return char.
    - Else, parse next segment (Char + Number). Update state.
4.  Handle end of string gracefully.

---
