# 1316. Distinct Echo Substrings / Các chuỗi con Echo Riêng biệt

## Problem Description / Mô tả bài toán
Echo substring: string which can be written as `A + A` where A is non-empty.
Find number of distinct echo substrings in `text`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Rolling Hash / Set
Iterate length `L` (even). Check all substrings of length `L`.
A substring `S` of length `2k` is echo if `S[0...k-1] == S[k...2k-1]`.
We can iterate `k` from 1 to `N/2`.
For each `i`, check `text[i...i+k-1]` vs `text[i+k...i+2k-1]`.
Use Rolling Hash to compare in O(1).
Store distinct echo substrings (or their hashes) in a Set.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or O(N) if storing hashes.

---

## Analysis / Phân tích

### Approach: Rolling Hash and HashSet
An echo substring is a concatenation of two identical strings `A + A`. Iterate through all possible lengths `len` (1 to N/2). For each starting index `i`, compare the substring `text[i...i+len-1]` with `text[i+len...i+2*len-1]`. Use rolling hash to perform this comparison efficiently (O(1)). If they match, the concatenated string is an echo substring; add its hash (or the string itself) to a HashSet to count distinct ones.
Note: Iterating `len` then `i` might be O(N^2).
Comparing directly without hash is O(N^3).
Rolling hash allows O(N^2).
Be aware of hash collisions. Double hash or large modulo.
Một chuỗi con echo là sự nối của hai chuỗi giống hệt nhau `A + A`. Lặp qua tất cả các độ dài có thể `len` (1 đến N/2). Đối với mỗi chỉ số bắt đầu `i`, so sánh chuỗi con `text[i...i+len-1]` với `text[i+len...i+2*len-1]`. Sử dụng rolling hash để thực hiện so sánh này một cách hiệu quả (O(1)). Nếu chúng khớp nhau, chuỗi nối là một chuỗi con echo; thêm hàm băm của nó (hoặc chính chuỗi đó) vào HashSet để đếm các chuỗi riêng biệt.

---
