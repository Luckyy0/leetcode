# 294. Flip Game II / Trò Chơi Lật II

## Problem Description / Mô tả bài toán
You are playing a Flip Game with your friend.
Bạn đang chơi Trò chơi Lật với bạn của mình.

You are given a string `currentState` that contains only `'+'` and `'-'`. You and your friend take turns to flip two **consecutive** `"++"` into `"--"`. The game ends when a person can no longer make a move, and therefore the other person will be the winner.
Bạn được cung cấp một chuỗi `currentState` chỉ chứa `'+'` và `'-'`. Bạn và bạn của bạn thay phiên nhau lật hai `"++"` **liên tiếp** thành `"--"`. Trò chơi kết thúc khi một người không thể thực hiện nước đi nữa, và do đó người kia sẽ là người chiến thắng.

Return `true` if the starting player can **guarantee a win**, and `false` otherwise.
Trả về `true` nếu người chơi bắt đầu có thể **đảm bảo chiến thắng**, và `false` nếu ngược lại.

### Example 1:
```text
Input: currentState = "++++"
Output: true
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
```

### Example 2:
```text
Input: currentState = "+"
Output: false
```

## Constraints / Ràng buộc
- `1 <= currentState.length <= 60`
- `currentState[i]` is either `'+'` or `'-'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking with Memoization (Minimax) / Quay Lui có Ghi Nhớ
Can I win?
- I can win if there exists **any** valid move such that the opponent **cannot** win from the resulting state.
- `canWin(s)`:
    - Try all moves `s -> next_s`.
    - If `!canWin(next_s)` for any move, then return `true`.
    - If for all moves, opponent wins (`canWin(next_s)` is true), then I lose -> return `false`.

**Memoization**:
- `Map<String, Boolean>` memo.
- Key: state string.
- Value: can win/lose.

### Complexity / Độ phức tạp
- **Time**: Exponential without memo, but much better with memo. Number of states is roughly proportional to different configurations. For N=60, still high but many states unreachable.
- **Space**: O(N) recursion.

---

## Analysis / Phân tích

### Approach: Memoized Digraph Search
1.  Check memo.
2.  Iterate moves.
3.  Recurse.
4.  Cache and return.

---
