# 893. Groups of Special-Equivalent Strings / Nhóm các Chuỗi tương đương đặc biệt

## Problem Description / Mô tả bài toán
Two strings are special-equivalent if one can be transformed into the other by swapping characters at even indices or characters at odd indices.
Hai chuỗi được coi là tương đương đặc biệt nếu chuỗi này có thể được biến đổi thành chuỗi kia bằng cách hoán đổi các ký tự ở chỉ số chẵn hoặc các ký tự ở chỉ số lẻ.

Given an array `words`, return the number of groups of special-equivalent strings.
Cho một mảng `words`, hãy trả về số lượng các nhóm chuỗi tương đương đặc biệt.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Positional Multi-set / Tập hợp đa phần theo vị trí
If characters at even indices can be swapped arbitrarily, their positions don't matter, only their counts. Same for odd indices.
Nếu các ký tự ở chỉ số chẵn có thể được hoán đổi tùy ý, vị trí của chúng không quan trọng, chỉ quan trọng số lượng. Đối với các chỉ số lẻ cũng vậy.

Algorithm:
1. For each word, separate it into two multisets: `even_chars` and `odd_chars`.
2. Sort/Represent these multisets as a unique key (e.g., concatenate sorted even list and sorted odd list).
3. Count the number of unique keys using a `HashSet`.

### Complexity / Độ phức tạp
- **Time**: O(N * L log L) or O(N * L).
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Canonical Representation
Define a unique "signature" for each string that remains invariant under valid swaps. By grouping words sharing the same signature, we identify equivalence classes.
Xác định một "chữ ký" duy nhất cho mỗi chuỗi mà không thay đổi theo các phép hoán đổi hợp lệ. Bằng cách nhóm các từ có cùng chữ ký, chúng ta xác định được các lớp tương đương.

---
