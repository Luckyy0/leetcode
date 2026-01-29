# 1023. Camelcase Matching / Khớp Camelcase

## Problem Description / Mô tả bài toán
Given an array of strings `queries` and a string `pattern`, return a boolean array where `answer[i]` is true if `queries[i]` matches `pattern`.
Cho một mảng các chuỗi `queries` và một chuỗi `pattern`, hãy trả về một mảng boolean trong đó `answer[i]` là true nếu `queries[i]` khớp với `pattern`.

A query matches `pattern` if we can insert lowercase letters into the pattern so that it equals the query.
Một truy vấn khớp với `pattern` nếu chúng ta có thể chèn các chữ cái thường vào pattern sao cho nó bằng với truy vấn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
Algorithm:
1. For each `query`:
   - `ptrPattern = 0`.
   - Iterate characters `c` in `query`:
     - If `ptrPattern < pattern.length` and `c == pattern[ptrPattern]`:
       - `ptrPattern++`.
     - Else if `c` is **uppercase**:
       - Mismatch! Return false (cannot insert uppercase or skip existing uppercase).
   - Return `ptrPattern == pattern.length`.

### Complexity / Độ phức tạp
- **Time**: O(N * L), where N is number of queries, L is average length.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Subsequence Validation with Capital Constraints
Verify if the pattern is a subsequence of the query. While iterating through the query string, ensure that any "extra" characters (not part of the pattern match) are strictly lowercase. If an unmatched uppercase letter appears, the CamelCase structure is violated.
Xác minh xem mẫu có phải là một chuỗi con của truy vấn hay không. Trong khi lặp qua chuỗi truy vấn, hãy đảm bảo rằng mọi ký tự "thừa" (không phải là một phần của kết quả khớp mẫu) hoàn toàn là chữ thường. Nếu một chữ cái viết hoa không khớp xuất hiện, cấu trúc CamelCase bị vi phạm.

---
