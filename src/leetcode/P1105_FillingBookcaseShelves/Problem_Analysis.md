# 1105. Filling Bookcase Shelves / Lấp đầy Kệ Sách

## Problem Description / Mô tả bài toán
You are given an array `books`, where `books[i] = [thickness, height]`.
We place these books in order onto bookcase shelves. shelves have width `shelfWidth`.
Each book must go on the current shelf or start a new shelf.
The height of a shelf is the maximum height of the books on it.
Minimize the total height of the bookcase.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i]` = min height to place first `i` books.
To compute `dp[i]`:
Try placing last `j` books on the current shelf (where `1 <= j` and total width <= `shelfWidth`).
`dp[i] = min(dp[i-j] + max(height[i-j+1...i]))`.

Algorithm:
1. `dp[0] = 0`.
2. Loop `i` from 1 to `n`.
3. Loop `j` backwards from `i` down to 1.
   - Track `currentWidth` and `maxHeight`.
   - If `currentWidth <= shelfWidth`:
     - `dp[i] = min(dp[i], dp[j-1] + maxHeight)`.
   - Else break.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linear DP with Lookback
Solve for the minimum height for the first $i$ books. For each $i$, consider all valid configurations for the *last* shelf ending at book $i$. This involves trying to place book $i$ alone, book $i-1$ and $i$ together, etc., as long as the total width fits. Add the height of this last shelf to the optimal solution for the remaining prefix.
Giải cho chiều cao tối thiểu cho $i$ cuốn sách đầu tiên. Đối với mỗi $i$, hãy xem xét tất cả các cấu hình hợp lệ cho kệ *cuối cùng* kết thúc tại cuốn sách $i$. Điều này liên quan đến việc thử đặt cuốn sách $i$ một mình, cuốn sách $i-1$ và $i$ cùng nhau, v.v., miễn là tổng chiều rộng phù hợp. Thêm chiều cao của kệ cuối cùng này vào giải pháp tối ưu cho tiền tố còn lại.

---
