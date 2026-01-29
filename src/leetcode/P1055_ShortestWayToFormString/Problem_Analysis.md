# 1055. Shortest Way to Form String / Cách Ngắn nhất để Tạo Chuỗi

## Problem Description / Mô tả bài toán
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
Một chuỗi con của một chuỗi là một chuỗi mới được hình thành từ chuỗi ban đầu bằng cách xóa một số (có thể không có) ký tự mà không làm xáo trộn vị trí tương đối của các ký tự còn lại.

Given two strings `source` and `target`, return the minimum number of subsequences of `source` such that their concatenation equals `target`. If the task is impossible, return -1.
Cho hai chuỗi `source` và `target`, hãy trả về số lượng tối thiểu các chuỗi con của `source` sao cho phép nối của chúng bằng `target`. Nếu nhiệm vụ là không thể, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Matching / Precomputed Next Occurrence / Khớp Tham lam / Tính toán trước Lần xuất hiện Tiếp theo
We want to greedily match as much of `source` as possible to `curr_target_suffix`.
Basically, iterate through `target`. For each character `c`, find the first occurrence of `c` in `source` *after* current `source_index`.
If not found after, wrap around (increment count, set `source_index` to new position).

Optimized:
Precompute `next[i][char]` for `source`.
`next[i][c]` = index of first occurrence of `c` at or after `i`.

### Complexity / Độ phức tạp
- **Time**: O(T), where T is target length (with O(S) preprocessing).
- **Space**: O(S).

---

## Analysis / Phân tích

### Approach: Cyclic Greedy Match
Greedily consume matching characters from the source to build the target. Iterate through the target string, moving a pointer through the source string. Whenever the pointer reaches the end of the source without finding the next target character, "reset" the pointer to the beginning of the source (effectively using another copy/subsequence) and increment the subsequences count.
Tiêu thụ tham lam các ký tự khớp từ nguồn để xây dựng đích. Lặp qua chuỗi đích, di chuyển một con trỏ qua chuỗi nguồn. Bất cứ khi nào con trỏ đến cuối nguồn mà không tìm thấy ký tự đích tiếp theo, hãy "đặt lại" con trỏ về đầu nguồn (về cơ bản là sử dụng một bản sao/chuỗi con khác) và tăng số lượng chuỗi con.

---
