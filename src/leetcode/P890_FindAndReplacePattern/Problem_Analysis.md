# 890. Find and Replace Pattern / Tìm và Thay thế theo Mẫu

## Problem Description / Mô tả bài toán
Given a list of strings `words` and a string `pattern`, return a list of words that match the `pattern`.
Cho một danh sách các chuỗi `words` và một chuỗi `pattern`, hãy trả về danh sách các từ khớp với `pattern`.

A word matches the pattern if there exists a permutation of letters `p` such that after replacing every letter `x` in the pattern with `p(x)`, we get the word.
Một từ khớp với mẫu nếu tồn tại một hoán vị của các chữ cái `p` sao cho sau khi thay thế mỗi chữ cái `x` trong mẫu bằng `p(x)`, chúng ta được từ đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bijection Check / Kiểm tra Ánh xạ hai chiều
Matching a pattern is equivalent to checking if there's a 1-to-1 mapping between the characters of `word` and `pattern`.
Khớp một mẫu tương đương với việc kiểm tra xem có ánh xạ 1-1 giữa các ký tự của `word` và `pattern` hay không.

Algorithm:
For each word:
1. Use two Maps (or arrays of size 26) to store mappings in both directions.
2. For each index `i`:
   - `c1 = word[i]`, `c2 = pattern[i]`.
   - If a mapping already exists for either but points to a different character, it's NOT a match.
   - Else, create/store mapping.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where N is words and L is word length.
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: Two-Way Mapping Consistency
Validate the structural similarity by ensuring a unique correspondence between character sets. A single failure in the bilateral mapping indicates that the word's character distribution does not mirror the pattern.
Xác minh tính tương đồng về cấu trúc bằng cách đảm bảo có sự tương ứng duy nhất giữa các tập hợp ký tự. Một lỗi duy nhất trong ánh xạ hai bên cho thấy phân bổ ký tự của từ không mô phỏng chính xác mẫu.

---
