# 909. Snakes and Ladders / Rắn và Thang

## Problem Description / Mô tả bài toán
You are given an `n x n` integer matrix `board`. A game starts at square 1. You roll a die (1-6) each move.
Bạn được cấp một ma trận số nguyên `n x n` `board`. Trò chơi bắt đầu tại ô số 1. Mỗi nước đi bạn tung một viên xúc sắc (1-6).

If square `S` has a snake or ladder (marked as `board[r][c] != -1`), you must move to the destination indicated by the ladder/snake.
Nếu ô `S` có rắn hoặc thang (được đánh dấu là `board[r][c] != -1`), bạn phải di chuyển đến đích được chỉ định bởi thang/rắn đó.

Return the least number of moves to reach square `n^2`.
Hãy trả về số nước đi ít nhất để đến được ô `n^2`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS on a Graph / BFS trên Đồ thị
This is a shortest path problem in an unweighted graph where each square is a node.
Đây là bài toán tìm đường đi ngắn nhất trong một đồ thị không trọng số, trong đó mỗi ô là một nút.

Algorithm:
1. Map label `1...n^2` to `(r, c)` coordinates. Note the Boustrophedon (zigzag) order.
2. Perform BFS starting from label 1.
3. For each current square `curr`:
   - Try rolls `1` to `6`.
   - `next = curr + roll`.
   - If `next` has a snake/ladder, update `next` to destination.
   - If `next` not visited, add to queue.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Shortest Movement Path
Treat the game board as a state-space network. Using BFS ensures we find the minimal sequence of dice rolls needed to traverse the grid while correctly accounting for the forced jumps provided by snakes and ladders.
Coi bàn cờ giống như một mạng lưới không gian trạng thái. Sử dụng BFS đảm bảo chúng ta tìm thấy trình tự các lần tung xúc sắc tối thiểu cần thiết để đi qua lưới, đồng thời tính toán chính xác các bước nhảy bắt buộc do rắn và thang cung cấp.

---
