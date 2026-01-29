# 1244. Design A Leaderboard / Thiết kế Bảng xếp hạng

## Problem Description / Mô tả bài toán
Design `Leaderboard` class.
- `addScore(playerId, score)`: Update score.
- `top(K)`: Sum of top K scores.
- `reset(playerId)`: Reset score to 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap + Sort / TreeMap
1. Store scores: `Map<Integer, Integer>`.
2. `top(K)`: Get all values, sort descending, pick top K.
   - O(N log N).
3. `reset`: remove from map.

Optimization:
Use `TreeMap` (score -> count) to optimize `top(K)`? No, `TreeMap` doesn't handle sum efficiently unless augmented.
If `K` is small or `N` is small, straightforward sort is fine.
Constraints: `n` calls. `N` players.
If N is large and K small, can use Heap.

### Complexity / Độ phức tạp
- **Time**: `top(K)` is O(N log K) or O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: HashMap for Scores
Use a `HashMap` to store the score for each player (`playerId -> score`).
- `addScore`: Update the map. If the player exists, add to existing score; otherwise, insert.
- `reset`: Set score to 0 or remove from map.
- `top(K)`: Extract all scores from the map, sort them in descending order (or use a PriorityQueue/Min-Heap of size K), and sum the top K values. Given typical constraints, sorting is efficient enough.
Sử dụng `HashMap` để lưu điểm cho mỗi người chơi (`playerId -> score`).
- `addScore`: Cập nhật bản đồ. Nếu người chơi tồn tại, thêm vào điểm hiện có; nếu không, chèn.
- `reset`: Đặt điểm thành 0 hoặc xóa khỏi bản đồ.
- `top(K)`: Trích xuất tất cả điểm từ bản đồ, sắp xếp chúng theo thứ tự giảm dần (hoặc sử dụng PriorityQueue/Min-Heap có kích thước K), và tính tổng K giá trị hàng đầu. Với các ràng buộc điển hình, việc sắp xếp đủ hiệu quả.

---
