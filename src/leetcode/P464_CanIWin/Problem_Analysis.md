# 464. Can I Win / Tôi Có Thể Thắng Không

## Problem Description / Mô tả bài toán
In the "100 game", two players take turns adding, to a running total, any integer from `1` to `10`. The player who first causes the running total to reach or exceed `100` wins.
Trong trò chơi "100", hai người chơi thay phiên nhau cộng thêm bất kỳ số nguyên nào từ `1` đến `10` vào tổng số. Người chơi nào đầu tiên làm cho tổng số đạt hoặc vượt quá `100` sẽ thắng.

What if we change the game so that players **cannot** re-use integers?
Điều gì sẽ xảy ra nếu chúng ta thay đổi trò chơi sao cho người chơi **không thể** sử dụng lại các số nguyên đã dùng?

Given two integers `maxChoosableInteger` and `desiredTotal`, return `true` if the first player can force a win, otherwise, return `false`. Assume both players play optimally.
Cho hai số nguyên `maxChoosableInteger` và `desiredTotal`, hãy trả về `true` nếu người chơi đầu tiên có thể ép chiến thắng, ngược lại trả về `false`. Giả sử cả hai người chơi đều chơi một cách tối ưu.

### Example 1:
```text
Input: maxChoosableInteger = 10, desiredTotal = 11
Output: false
Explanation: No matter which integer the first player chooses (1 to 10), the second player can win.
```

### Example 2:
```text
Input: maxChoosableInteger = 10, desiredTotal = 0
Output: true
```

## Constraints / Ràng buộc
- `1 <= maxChoosableInteger <= 20`
- `0 <= desiredTotal <= 300`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mini-Max with Bitmask Memoization / Mini-max với Ghi nhớ Mặt nạ bit
This is a game theory problem. Since the integers cannot be reused and the maximum `maxChoosableInteger` is 20, we can represent the state of available integers using a **bitmask** of length 20.

Algorithm:
1. Corner cases:
   - If `desiredTotal <= 0`, first player wins immediately (`true`).
   - If sum of all integers `[1, maxChoosableInteger]` is less than `desiredTotal`, no one can win (`false`).
2. Use a recursive function `canWin(mask, currentTotal)`:
   - `mask` represents the set of integers already chosen.
   - If the state `mask` has been seen before, return the stored result.
   - Iterate through each integer `i` from 1 to `maxChoosableInteger`:
     - If `i` is not used (bit `i-1` in `mask` is 0):
       - If `i + currentTotal >= desiredTotal`, the current player wins (`return true`).
       - If `!canWin(mask | (1 << (i-1)), currentTotal + i)`, it means the next player will lose, so the current player wins (`return true`).
   - If no move leads to a win, return `false`.
3. Memoize the results using `Boolean[]` or `byte[]` index by `mask`. There are $2^{20} \approx 10^6$ states.

### Complexity / Độ phức tạp
- **Time**: O(2^N * N) where N is `maxChoosableInteger`.
- **Space**: O(2^N) for memoization.

---

## Analysis / Phân tích

### Approach: Recursive Game Search with State Memoization

**Algorithm**:
1.  Initialize bitmask.
2.  DFS with pruning.
3.  Check all possible moves for the current player.

---
