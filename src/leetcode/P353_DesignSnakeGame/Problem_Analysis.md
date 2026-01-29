# 353. Design Snake Game / Thiết Kế Trò Chơi Rắn Săn Mồi

## Problem Description / Mô tả bài toán
Design a **Snake game** that is played on a device with screen size `height x width`. Play the game online if you are not familiar with the game.
Thiết kế trò chơi Rắn săn mồi...

The snake is initially positioned at the top left corner `(0, 0)` with length 1 unit.
Con rắn ban đầu ở vị trí `(0, 0)` với độ dài 1.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score become `length + 1` and `score + 1`, respectively. The snake moves from the current position to a new adjacent position in the directions 'U', 'D', 'L', or 'R'.
Bạn được cung cấp danh sách vị trí thức ăn...

When the snake moves to a new position, the tail moves 1 unit forward unless the snake eats food, in which case the tail stays in place (snake grows).
Movement rules:
1.  Snake eats food if head moves to food pos.
2.  Game over if snake hits boundaries.
3.  Game over if snake hits itself.

Return score after each move. Return -1 if game over.

### Example 1:
```text
Input:
["SnakeGame", "move", "move", "move", "move", "move", "move"]
[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
Output:
[null, 0, 0, 1, 1, 2, -1]
```

## Constraints / Ràng buộc
- `1 <= width, height <= 10^4`
- `1 <= food.length <= 50`
- `food[i].length == 2`
- `food[i]` and snake positions are within bounds.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Deque + HashSet / Hàng Đợi Hai Đầu + Tập Hợp
We need to track the snake's body coordinates to check for self-collision.
A `Deque` (LinkedList) stores the body coordinates in order `[tail, ..., head]`.
A `HashSet` stores the encoded body coordinates for O(1) collision check.
Collision Check:
- Head moves to new pos.
- If not food: Tail moves (remove from Deque and Set).
- Check if new Head is in bounds.
- Check if new Head is in Set (Collision).
    - Note: If tail moved, it's removed from set BEFORE checking head collision. So chasing tail is valid.
- If valid: Add new Head to Deque and Set.
- If food: Tail doesn't move. Score++. Consume food index.

Coordinate Encoding: `row * width + col`. (Unique ID).

### Complexity / Độ phức tạp
- **Time**: O(1) per move.
- **Space**: O(Score) or O(W*H).

---

## Analysis / Phân tích

### Approach: Deque and Set

**Algorithm**:
1.  `Deque<Integer> body`. `Set<Integer> bodySet`.
2.  `food[][]`. `foodIndex`. `width, height`. `score`.
3.  `move(direction)`:
    - Calc new head.
    - Check bounds. Return -1 if fail.
    - Check collision logic (Tail handling).
    - Update structures.

---
