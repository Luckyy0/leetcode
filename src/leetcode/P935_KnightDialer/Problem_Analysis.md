# 935. Knight Dialer / Bàn phím Hiệp sĩ

## Problem Description / Mô tả bài toán
A chess knight can jump on a phone dialpad.
Một quân mã cờ vua có thể nhảy trên bàn phím điện thoại.
Dialpad:
1 2 3
4 5 6
7 8 9
* 0 #

Given an integer `n`, return the number of distinct phone numbers of length `n` we can dial with the knight. Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / State Transition / Quy hoạch Động / Chuyển trạng thái
Define the possible moves from each key:
- 0: [4, 6]
- 1: [6, 8]
- 2: [7, 9]
- 3: [4, 8]
- 4: [0, 3, 9]
- 5: []
- 6: [0, 1, 7]
- 7: [2, 6]
- 8: [1, 3]
- 9: [2, 4]

Algorithm:
1. `dp[i][j]` = number of phone numbers of length `i` ending at digit `j`.
2. Transition: `dp[i][j] = sum(dp[i-1][prev])` where `prev` can jump to `j`.
3. Use space optimization since `dp[i]` only depends on `dp[i-1]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Transition Matrix DP
Model the problem as a walk on a graph where nodes are digits and edges are valid knight moves. By iteratively applying the transition rules, we propagate the count of valid sequences through each possible terminal digit.
Mô hình hóa bài toán như một bước đi trên đồ thị, trong đó các nút là những chữ số và các cạnh là những nước đi hợp lệ của quân mã. Bằng cách áp dụng lặp đi lặp lại các quy tắc chuyển đổi, chúng ta truyền đi số lượng các chuỗi hợp lệ qua từng chữ số kết thúc có thể.

---
