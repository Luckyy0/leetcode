# 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence / Kiểm tra Xem một Từ có Xuất hiện Như là Tiền tố của Bất kỳ Từ nào trong Câu hay không

## Problem Description / Mô tả bài toán
Sentence `sentence`, string `searchWord`.
Return index (1-based) of word where `searchWord` is a prefix.
Return -1 if none.
Return MIN index if multiple.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Split
Split `sentence` by space.
Check `word.startsWith(searchWord)`.

### Complexity / Độ phức tạp
- **Time**: O(N * L).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linear Scan
Split sentence into words. Iterate and check prefix requirement.
Tách câu thành các từ. Lặp lại và kiểm tra yêu cầu tiền tố.

---
