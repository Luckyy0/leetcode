# 678. Valid Parenthesis String / Chuỗi Dấu ngoặc Hợp lệ

## Problem Description / Mô tả bài toán
Given a string `s` containing only three types of characters: `(`, `)` and `*`, return `true` if `s` is **valid**.
Cho một chuỗi `s` chỉ chứa ba loại ký tự: `(`, `)` và `*`, hãy trả về `true` nếu `s` là **hợp lệ**.

The following rules define a **valid** string:
- Any left parenthesis `(` must have a corresponding right parenthesis `)`.
- Any right parenthesis `)` must have a corresponding left parenthesis `(`.
- Left parenthesis `(` must go before the corresponding right parenthesis `)`.
- `*` could be treated as a single right parenthesis `)` or a single left parenthesis `(` or an empty string `""`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Tracking / Theo dõi Tham lam
Since `*` can be multiple things, we can track the range of possible open left parenthesis counts `[min_open, max_open]`.
Vì `*` có thể là nhiều thứ, chúng ta có thể theo dõi phạm vi của các số lượng dấu ngoặc trái mở có thể có `[min_open, max_open]`.

- `(`: Both `min_open` and `max_open` increase.
- `)`: Both decrease.
- `*`: `min_open` decreases (acts as `)`), `max_open` increases (acts as `(`).

We must ensure:
1. `max_open >= 0` always. (Too many closed brackets).
2. `min_open` is clamped to 0. (Can't have negative brackets).
3. `min_open == 0` at the end. (All items can be balanced).

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Range Counter
By treating `*` as a flexible choice, we avoid complex backtracking. If at any point the most optimistic count (`max_open`) is negative, the string is impossible. If at the end the most pessimistic count (`min_open`) is 0, a valid assignment exists.
Bằng cách coi `*` là một lựa chọn linh hoạt, chúng ta tránh được việc quay lui (backtracking) phức tạp. Nếu tại bất kỳ thời điểm nào, số lượng lạc quan nhất (`max_open`) bị âm, chuỗi đó là không thể. Nếu cuối cùng số lượng bi quan nhất (`min_open`) là 0, thì tồn tại một cách gán hợp lệ.

---
