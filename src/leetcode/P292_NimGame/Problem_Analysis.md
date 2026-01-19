# 292. Nim Game / Trò Chơi Nim

## Problem Description / Mô tả bài toán
You are playing the following Nim Game with your friend:
Bạn đang chơi Trò chơi Nim sau với bạn của mình:

- Initially, there is a heap of stones on the table. (Ban đầu, có một đống đá trên bàn).
- You and your friend will alternate taking turns, and you go first. (Bạn và bạn của bạn sẽ luân phiên nhau, và bạn đi trước).
- On each turn, the person whose turn it is will remove 1 to 3 stones from the heap. (Mỗi lượt, người chơi lấy 1 đến 3 viên đá).
- The one who removes the last stone is the winner. (Người lấy viên đá cuối cùng là người chiến thắng).

Given `n`, the number of stones in the heap, return `true` if you can win the game assuming both you and your friend play optimally, otherwise return `false`.
Cho `n`, số lượng đá, trả về `true` nếu bạn có thể thắng, ngược lại `false`.

### Example 1:
```text
Input: n = 4
Output: false
Explanation: These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes 1 stone, including the last stone. Your friend wins.
In all outcomes, your friend wins.
```

### Example 2:
```text
Input: n = 1
Output: true
```

### Example 3:
```text
Input: n = 2
Output: true
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Game Theory (Mathematical Induction)
- `n = 1`: You take 1. Win.
- `n = 2`: You take 2. Win.
- `n = 3`: You take 3. Win.
- `n = 4`: You take 1, opponent takes 3. You take 2, opp takes 2. You take 3, opp takes 1. Opponent always wins.
- `n = 5`: You take 1 -> leaves 4 for opponent (Opponent loses at 4). You Win.
- `n = 6`: You take 2 -> leaves 4. You Win.
- `n = 7`: You take 3 -> leaves 4. You Win.
- `n = 8`: Whatever you take (1,2,3), leaves (7,6,5). In all these states, Opponent can force a win. You Lose.

Pattern: Win if `n % 4 != 0`. Lose if `n % 4 == 0`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Modulo

**Algorithm**:
1.  Return `n % 4 != 0`.

---
