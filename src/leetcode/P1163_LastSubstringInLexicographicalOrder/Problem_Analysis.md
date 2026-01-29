# 1163. Last Substring in Lexicographical Order / Chuỗi con Cuối cùng theo Thứ tự Từ điển

## Problem Description / Mô tả bài toán
Given a string `s`, return the last substring of `s` in lexicographical order.
Cho một chuỗi `s`, trả về chuỗi con cuối cùng của `s` theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Suffix Array Construction / Two Pointers / Xây dựng Mảng Hậu tố / Hai con trỏ
The "last substring" essentially means the suffix that is lexicographically largest.
Why? Because if substring `s[i...j]` is largest, then `s[i...n-1]` must be larger or equal (since it has the same prefix but is longer).
So we just need to find the largest suffix.

Algorithm (Two Pointers):
1. Find max suffix `s[i:]`.
2. Initialize `i = 0`, `j = 1`, `k = 0`.
3. Compare `s[i+k]` and `s[j+k]`.
   - If equal, `k++`.
   - If `s[i+k] < s[j+k]`, `i` is worse than `j`. Move `i`.
     - `i = max(i + k + 1, j)`. Actually `i` becomes `i+k+1`?
     - Or `i` sets to `j`, `j` advances.
     - Better logic: Since we want MAX, if `s[j+k]` is bigger, `j` is a better start candidate than `i`. Also indices `i+1...i+k` are worse candidates than `j` (otherwise we would have switched earlier? Maybe not strictly true but `j` dominates).
     - So `i = i + k + 1`? No. If `s[j+k] > s[i+k]`, then `j` is better. So `i` updates to `j`? But we need to keep searching. 
     - Correct logic: We maintain `i` as the start of the best suffix found so far. `j` searches ahead.
     - If `s[i+k] == s[j+k]`: `k++`.
     - If `s[i+k] < s[j+k]`: `i` is worse. But actually, `s[i...i+k]` is worse than `s[j...j+k]`.
       - So `i` jumps to `max(i + k + 1, j)`. `j = i + 1`. `k = 0`.
       - Wait, if `s[j]` beats `s[i]`, `j` is new candidate. `i=j`, `j=i+1`.
     - If `s[i+k] > s[j+k]`: `j` is worse. `j` jumps to `j + k + 1`. `k = 0`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two-Pointer Suffix Comparison
Identify the lexicographically largest substring, which is guaranteed to be a suffix. Use two pointers, `i` and `j`, starting at 0 and 1, to compare suffixes. Iterate with an offset `k`. If characters at `i+k` and `j+k` differ, update the starting position of the "smaller" suffix to skip past the matching prefix (skipping `k` positions), since no index within that prefix could start a larger suffix. This allows finding the maximal suffix in linear time.
Xác định chuỗi con lớn nhất theo thứ tự từ điển, được đảm bảo là một hậu tố. Sử dụng hai con trỏ, `i` và `j`, bắt đầu từ 0 và 1, để so sánh các hậu tố. Lặp lại với độ lệch `k`. Nếu các ký tự tại `i+k` và `j+k` khác nhau, hãy cập nhật vị trí bắt đầu của hậu tố "nhỏ hơn" để bỏ qua tiền tố khớp (bỏ qua `k` vị trí), vì không có chỉ số nào trong tiền tố đó có thể bắt đầu một hậu tố lớn hơn. Điều này cho phép tìm hậu tố tối đa trong thời gian tuyến tính.

---
