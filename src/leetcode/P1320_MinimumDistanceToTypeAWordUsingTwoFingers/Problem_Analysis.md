# 1320. Minimum Distance to Type a Word Using Two Fingers / Khoảng cách Tối thiểu để Nhập một Từ bằng Hai Ngón tay

## Problem Description / Mô tả bài toán
Keyboard layout QWERTY or specific?
"Keyboard:
A B C D E F
G H I J K L
M N O P Q R
S T U V W X
Y Z"
(6 chars per row).
Type `word` using two fingers.
Start fingers at any position (cost 0 to place initial).
Distance: Manhattan distance on grid.
Min total distance.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
We type characters one by one.
State must track positions of both fingers.
`dp[i][finger1][finger2]`?
`i`: index of character to type (0 to N-1).
One finger MUST be at `word[i-1]` (previous char). Why? Because we just typed it.
So state simplifies: `dp[i][other_finger]`.
`i`: current index of character we just typed. One finger is at `word[i]`.
`other_finger`: position of the other finger (can be anywhere, or one of previous chars).
Actually, `other_finger` is the position of the finger that DID NOT type `word[i]`.
Previous state `dp[i-1][other]`. The typed char was `word[i-1]`.
Current char `c = word[i]`.
Transitions:
1. Finger at `word[i-1]` moves to `c`. The `other` finger stays at `other`.
   Cost: `dist(word[i-1], c)`.
   New state: `dp[i][other]`.
2. Finger at `other` moves to `c`. The finger at `word[i-1]` stays.
   Cost: `dist(other, c)`.
   New state: `dp[i][word[i-1]]`.

Base case: `i=0`.
We type `word[0]`.
Finger 1 types `word[0]`. Finger 2 can be anywhere (or "hovering").
"You may start ... at any location". So cost to first char is 0.
But what about the other finger? It is still "hovering".
Special value for "hovering" (e.g. 26). Dist from hovering is 0.
Actually, for first char, cost is 0.
State `dp[i][other]` = min cost after typing `word[i]`, with second finger at `other`.

### Complexity / Độ phức tạp
- **Time**: O(N * 27). N is word length.
- **Space**: O(27) (optimized).

---

## Analysis / Phân tích

### Approach: DP with One Finger State
Let `dp[i][other]` be the minimum distance after typing `word[i]`, where one finger is at `word[i]` and the other finger is at `other` (0-25 represents 'A'-'Z', 26 represents hovering/initial state).
Iterate `i` from 0 to `n-1`. Let `curr = word[i]` and `prev = word[i-1]` (if `i > 0`).
For each possible `other` position:
- Transition 1: The finger at `prev` moves to `curr`. Cost adds `dist(prev, curr)`. New other is `other`.
- Transition 2: The finger at `other` moves to `curr`. Cost adds `dist(other, curr)`. New other is `prev`.
For `i=0`, cost is 0, and one finger is at `word[0]`, other is hovering (26).
Coordinate calculation: `r = char / 6`, `c = char % 6`.
Distance function `dist(a, b)`: if `a` or `b` is 26 (hovering), return 0. Else Manhattan.
Sử dụng `dp[i][other]` là khoảng cách tối thiểu sau khi nhập `word[i]`, trong đó một ngón tay ở `word[i]` và ngón tay kia ở `other` (0-25 đại diện cho 'A'-'Z', 26 đại diện cho trạng thái lơ lửng/ban đầu).
Lặp lại `i` từ 0 đến `n-1`. Đặt `curr = word[i]` và `prev = word[i-1]` (nếu `i > 0`).
Đối với mỗi vị trí `other` có thể:
- Chuyển đổi 1: Ngón tay tại `prev` di chuyển đến `curr`. Chi phí thêm `dist(prev, curr)`. `new_other` là `other`.
- Chuyển đổi 2: Ngón tay tại `other` di chuyển đến `curr`. Chi phí thêm `dist(other, curr)`. `new_other` là `prev`.

---
