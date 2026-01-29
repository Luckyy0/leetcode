# 754. Reach a Number / Chạm đến một Số

## Problem Description / Mô tả bài toán
You are standing at position `0` on an infinite number line. There is a destination at position `target`.
Bạn đang đứng ở vị trí `0` trên một trục số vô hạn. Có một điểm đến tại vị trí `target`.

In each move, you can either go left or right. In the `nth` move (starting from `n = 1`), you take `n` steps.
Trong mỗi nước đi, bạn có thể đi sang trái hoặc sang phải. Trong nước đi thứ `n` (bắt đầu từ `n = 1`), bạn thực hiện `n` bước.

Return the minimum number of steps required to reach the destination `target`.
Trả về số bước tối thiểu cần thiết để đạt đến điểm đến `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Symmetry and Parity / Tính đối xứng và Tính chẵn lẻ
Due to symmetry, we can assume `target = abs(target)`.
Do tính đối xứng, chúng ta có thể giả định `target = abs(target)`.

If we take `k` steps, the total sum is `S = 1 + 2 + ... + k = k(k+1)/2`.
If `S == target`, we need `k` steps.
If `S > target`:
We need to change some steps from `+` to `-`. If we change a step `i` to `-i`, the total sum decreases by `2i`. This means the difference `S - target` must be even.
Chúng ta cần thay đổi một số bước từ `+` thành `-`. Nếu chúng ta đổi một bước `i` thành `-i`, tổng số sẽ giảm đi `2i`. Điều này có nghĩa là hiệu số `S - target` phải là số chẵn.

Algorithm:
1. Increase `k` until `S >= target`.
2. While `(S - target) % 2 != 0`, increment `k` and update `S`.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(target)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Summation with Parity Correction
Find the smallest `k` such that the sum covers the target. If the overflow is odd, the difference cannot be compensated by flipping a single step's sign, so move further.
Tìm `k` nhỏ nhất sao cho tổng bao phủ được mục tiêu. Nếu phần dư là số lẻ, sự khác biệt không thể được bù đắp bằng cách lật dấu của một bước đơn lẻ, vì vậy hãy tiến xa hơn.

---
