# 344. Reverse String / Đảo Ngược Chuỗi

## Problem Description / Mô tả bài toán
Write a function that reverses a string. The input string is given as an array of characters `s`.
Viết một hàm đảo ngược một chuỗi. Chuỗi đầu vào được đưa ra dưới dạng một mảng các ký tự `s`.

You must do this by modifying the input array **in-place** with `O(1)` extra memory.
Bạn phải làm điều này bằng cách sửa đổi mảng đầu vào **tại chỗ** với bộ nhớ thêm `O(1)`.

### Example 1:
```text
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

### Example 2:
```text
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s[i]` is a printable ascii character.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers / Hai Con Trỏ
Swap characters at `left` and `right` indices. Move inward.
Stop when `left >= right`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers Swap

**Algorithm**:
1.  `l = 0`, `r = len - 1`.
2.  While `l < r`:
    - Swap `s[l]` and `s[r]`.
    - `l++`, `r--`.

---
