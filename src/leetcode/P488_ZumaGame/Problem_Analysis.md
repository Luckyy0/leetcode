# 488. Zuma Game / Trò Chơi Zuma

## Problem Description / Mô tả bài toán
You are playing a variation of the Zuma game. You have a row of balls on the table, colored blue 'B', yellow 'Y', white 'W', red 'R', and green 'G'. You also have several balls in your hand.
Bạn đang chơi một biến thể của trò chơi Zuma. Bạn có một hàng các quả bóng trên bàn, với các màu xanh lam 'B', vàng 'Y', trắng 'W', đỏ 'R' và xanh lá cây 'G'. Bạn cũng có một số quả bóng trong tay.

Each time, you choose a ball from your hand and insert it into the row (including the endpoints). Then, if there is a group of three or more balls of the same color touching, those balls will be removed. This process continues until no more balls can be removed.
Mỗi lần, bạn chọn một quả bóng từ tay mình và chèn nó vào hàng (bao gồm cả các đầu mút). Sau đó, nếu có một nhóm gồm ba quả bóng trở lên cùng màu chạm nhau, những quả bóng đó sẽ bị loại bỏ. Quá trình này tiếp tục cho đến khi không còn quả bóng nào có thể bị loại bỏ.

Find the minimum number of balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, return -1.
Hãy tìm số lượng bóng tối thiểu bạn phải chèn để loại bỏ tất cả các quả bóng trên bàn. Nếu bạn không thể loại bỏ tất cả các quả bóng, hãy trả về -1.

### Example 1:
```text
Input: board = "WRRBBW", hand = "RB"
Output: -1
Explanation: WRRBBW -> WRRRBBW -> WBBW -> WBBBW -> WW -> WWW -> empty. No, this is not possible with the hand.
Actually example says -1.
```

## Constraints / Ràng buộc
- `1 <= board.length <= 16`
- `1 <= hand.length <= 5`
- `board` and `hand` consist of characters 'R', 'Y', 'B', 'G', and 'W'.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / BFS with State Management / Quay lui / BFS với Quản lý Trạng thái
This is a shortest path problem in a state space graph. A state is defined by `(current_board, current_hand)`.
Given notice the constraints: `board.length <= 16` and `hand.length <= 5`. The small hand size suggests we can explore all possibilities.

Algorithm:
1. Simplify the board after each insertion by recursively removing triplets.
2. Use BFS or DFS with Memoization to explore states.
3. State: `(board, sorted_hand_string)`.
4. In each state, try inserting each ball from the hand into every possible position in the board.
   - **Optimization**: Only insert a ball of color `C` into a position where there's already a ball of color `C`. (Heuristic).
   - Or even better, try all positions but prune heavily.

### Complexity / Độ phức tạp
- **Time**: Expontential, but constrained by small input sizes.
- **Space**: O(States) for memoization.

---

## Analysis / Phân tích

### Approach: Recursive Search with Board Reduction

**Algorithm**:
1.  Implement `removeGroups(board)` method.
2.  DFS with current hand.
3.  Memoize results.

---
