# 1054. Distant Barcodes / Mã vạch Cách xa

## Problem Description / Mô tả bài toán
In a warehouse, there is a row of barcodes, where the `i-th` barcode is `barcodes[i]`.
Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue or Max Frequency Fill / Hàng đợi Ưu tiên hoặc Điền Tần suất Tối đa
Algorithm:
1. Count frequencies of each barcode.
2. Sort barcodes by frequency (most frequent first).
3. Fill the `res` array at indices `0, 2, 4, ...` with the most frequent element.
4. When `2k >= n`, wrap around to `1, 3, 5, ...`.

Why this works?
If the most frequent element has count `C`, and `C <= (N+1)/2`, we can always place them at `0, 2, ...`. The gaps are filled by other elements. Since max frequency constraint holds, duplicates won't touch.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N) if we use bucket sort for counting.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Interleaved Filling
Determine the frequency of each number. Fill the array positions with the most frequent numbers first, placing them at even indices (0, 2, 4...) to maximize distance. Once the end is reached, wrap around to odd indices (1, 3, 5...). This strategy ensures that the most common elements are spaced out enough to prevent adjacency.
Xác định tần suất của mỗi số. Điền vào các vị trí mảng với các số thường xuyên nhất trước, đặt chúng ở các chỉ số chẵn (0, 2, 4...) để tối đa hóa khoảng cách. Khi đến cuối, quay lại các chỉ số lẻ (1, 3, 5...). Chiến lược này đảm bảo rằng các phần tử phổ biến nhất được dãn cách đủ để ngăn chặn sự liền kề.

---
