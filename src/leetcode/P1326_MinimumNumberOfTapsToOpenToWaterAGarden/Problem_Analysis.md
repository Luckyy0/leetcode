# 1326. Minimum Number of Taps to Open to Water a Garden / Số lượng Vòi Tối thiểu Cần Mở để Tưới Nước cho Vườn

## Problem Description / Mô tả bài toán
Garden length `n` (0 to n).
`n+1` taps at `0, 1, ..., n`.
`ranges[i]` means tap `i` can water `[i - ranges[i], i + ranges[i]]`.
Min taps to water `[0, n]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Jump Game II / Greedy Interval Covering
Convert taps to intervals `[max(0, i-ranges[i]), min(n, i+ranges[i])]`.
Flatten to array `max_reach[i]` = max endpoint reachable from start point `i`.
Specifically, for each tap covering `[L, R]`, update `max_reach[L] = max(max_reach[L], R)`.
Iterate from 0 to n.
Greedy strategy: At current position `curr`, we want to extend as far right as possible.
Track `max_reach` within current range. Update `curr` to `max_reach` when we step out of current effective range.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Jump Game
This problem can be reduced to "Jump Game II". Create an array `maxReach` where `maxReach[i]` stores the farthest right point reachable by any tap that covers index `i` (specifically starting at covered range `[L, R]`, we set `maxReach[L] = max(maxReach[L], R)`).
Then, perform the greedy jump logic:
Iterate from 0 to `n`. Maintain `currentEnd`, `farthest`, and `taps`.
If `i` reaches `currentEnd`, increment `taps` and update `currentEnd` to `farthest`. If `currentEnd >= n`, we are done. If `farthest <= i` (stuck), return -1.
Bài toán này có thể được rút gọn thành "Jump Game II". Tạo một mảng `maxReach` trong đó `maxReach[i]` lưu trữ điểm xa nhất bên phải có thể truy cập được bởi bất kỳ vòi nào bao phủ chỉ số `i` (cụ thể bắt đầu tại phạm vi được bao phủ `[L, R]`, chúng ta đặt `maxReach[L] = max(maxReach[L], R)`).
Sau đó, thực hiện logic nhảy tham lam:
Lặp lại từ 0 đến `n`. Duy trì `currentEnd`, `farthest` và `taps`.
Nếu `i` đạt đến `currentEnd`, tăng `taps` và cập nhật `currentEnd` thành `farthest`. Nếu `currentEnd >= n`, chúng ta đã hoàn tất. Nếu `farthest <= i` (bị kẹt), trả về -1.

---
