# 900. RLE Iterator / Trình lặp RLE

## Problem Description / Mô tả bài toán
Write an iterator that iterates through a run-length encoded (RLE) sequence.
Viết một trình lặp duyệt qua một chuỗi được mã hóa theo độ dài chạy (RLE).

The sequence is given as `[cnt1, val1, cnt2, val2, ...]`.
Chuỗi được cung cấp dưới dạng `[cnt1, val1, cnt2, val2, ...]`.

`next(n)` must exhaust `n` elements and return the last element exhausted.
`next(n)` phải sử dụng hết `n` phần tử và trả về phần tử cuối cùng đã được sử dụng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pointer and Counter tracking / Theo dõi Con trỏ và Bộ đếm
Algorithm:
1. Maintain an index `ptr` to the current `count` in the array.
2. `next(n)`:
   - While `ptr < length`:
     - If `encoding[ptr] >= n`:
       - `encoding[ptr] -= n`.
       - Return `encoding[ptr + 1]`.
     - Else:
       - `n -= encoding[ptr]`.
       - `encoding[ptr] = 0`.
       - `ptr += 2`.
   - If loop ends, return -1.

### Complexity / Độ phức tạp
- **Time**: O(N) total across all calls.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Depletion
Iteratively consume elements from the current run. If the quota exceeds the current run's size, move to the next run and carry over the remaining requirement until either the quota is met or the encoded sequence is exhausted.
Lần lượt tiêu thụ các phần tử từ lần chạy hiện tại. Nếu hạn ngạch vượt quá kích thước của lần chạy hiện tại, hãy chuyển sang lần chạy tiếp theo và mang theo yêu cầu còn lại cho đến khi đáp ứng đủ hạn ngạch hoặc chuỗi mã hóa bị cạn kiệt.

---
