# 1147. Longest Chunked Palindrome Decomposition / Phân rã Palindrome Phân mảnh Dài nhất

## Problem Description / Mô tả bài toán
Return the largest possible `k` such that there exists `a_1, a_2, ..., a_k` such that:
- Each `a_i` is a non-empty string;
- Their concatenation `a_1 + a_2 + ... + a_k` is equal to `text`;
- For all `1 <= i <= k`,  `a_i = a_{k+1-i}`.
Basically, decompose string into palindrome chunks.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach / Recursive Matching / Cách tiếp cận Tham lam / Khớp Đệ quy
Find the shortest prefix `text[0...i]` that matches the suffix `text[n-1-i...n-1]`.
If found, we have 2 chunks (`a1` and `ak`).
Recurse on the middle part. Result += 2.
If no prefix equals suffix (except the whole string), then result += 1 (the remaining middle part is one chunk).
Base case: empty string -> 0.

Why Greedy works:
Suppose we pick a longer match first.
`P ... P` vs `p ... p`.
If `P = p + mid + p`, then `P` has structure inside.
It is proven that picking the shortest matching prefix/suffix pair first is optimal.

Algorithm:
1. `L = 0`, `R = n`.
2. Loop while `L < R`:
   - Iterate length `len` from 1 to `(R-L)/2`.
   - if `text[L...L+len] == text[R-len...R]`:
     - Found match. `res += 2`, `L += len`, `R -= len`. Break loop to restart `len`.
   - If loop finishes without match:
     - `res++`. Break (middle part is 1 chunk).

### Complexity / Độ phức tạp
- **Time**: O(N^2) (string comparisons). O(N) with Rolling Hash.
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Greedy Parsing
Iteratively search for the shortest non-empty prefix that is identical to the corresponding suffix. Once a match is found, count both chunks (2), remove them from the string, and repeat the process on the remaining central substring. If no such proper prefix exists, the entire remainder counts as one chunk (1). This greedy strategy is optimal for maximizing the count `k`.
Tìm kiếm lặp lại tiền tố không rỗng ngắn nhất giống hệt với hậu tố tương ứng. Khi tìm thấy một kết quả khớp, hãy đếm cả hai phân đoạn (2), xóa chúng khỏi chuỗi và lặp lại quá trình trên chuỗi con trung tâm còn lại. Nếu không tồn tại tiền tố thích hợp như vậy, toàn bộ phần còn lại được tính là một phân đoạn (1). Chiến lược tham lam này là tối ưu để tối đa hóa số lượng `k`.

---
