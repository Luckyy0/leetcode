# 1451. Rearrange Words in a Sentence / Sắp xếp lại Các Từ trong một Câu

## Problem Description / Mô tả bài toán
String `text`. Valid sentence (words space separated, first uppercase, others lower).
Rearrange words by length increasing. Stable sort (original order if same length).
Format first word uppercase, others lower.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stable Sort
Split `text` into words. Store with original index (or rely on stable sort).
Sort based on length.
Join. Capitalize first char of result, lower others.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Sorting with Custom Comparator
ToLowercase the whole string (except wait, original casing might be mixed? "First letter is uppercase. Text is space-separated words... lower case English letters". So only first letter of SENTENCE is upper).
Convert sentence to lower case first. Split into array.
Sort using comparator: `a.length() - b.length()`. Since `Arrays.sort` for objects is stable, this preserves original order for equal lengths.
Note: "first letter of new sentence is upper".
So: `split(" ")`. Lowercase first word (since it might have been upper). Other words are already lower.
Sort.
Join.
Uppercase first char of joined string.
Lưu ý: `Arrays.sort` là ổn định.
Chuyển đổi câu thành chữ thường trước. Tách thành mảng.
Sắp xếp.
Nối.
Viết hoa chữ cái đầu tiên của chuỗi đã nối.

---
