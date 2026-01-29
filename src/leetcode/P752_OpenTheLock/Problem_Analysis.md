# 752. Open the Lock / Mở Khóa

## Problem Description / Mô tả bài toán
You have a lock with four circular wheels. Each wheel has 10 slots: `0` to `9`. The wheels can rotate in both directions. The lock starts at `0000`.
Bạn có một ổ khóa có bốn bánh xe hình tròn. Mỗi bánh xe có 10 rãnh: từ `0` đến `9`. Các bánh xe có thể xoay theo cả hai hướng. Ổ khóa bắt đầu ở `0000`.

You are given a list of `deadends`. If the lock displays any code in `deadends`, the wheels will stop turning.
Bạn được cung cấp một danh sách các "điểm chết" (`deadends`). Nếu ổ khóa hiển thị bất kỳ mã nào trong `deadends`, các bánh xe sẽ ngừng quay.

Return the minimum number of turns to reach the `target` code, or -1 if impossible.
Trả về số lượt xoay tối thiểu để đạt được mã `target`, hoặc -1 nếu không thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Breadth First Search (BFS) / Tìm kiếm theo Chiều rộng
Since we need the "minimum" number of turns, BFS is the ideal algorithm for exploring levels.
Vì chúng ta cần số lượt xoay "tối thiểu", BFS là thuật toán lý tưởng để khám phá các cấp độ.

1. Each state is a 4-digit string.
2. From each state, there are 8 possible next states (each of the 4 wheels can move up or down).
3. Use a `Set` for `deadends` and a `Set` for `visited`.
4. If the initial state `0000` is a deadend, return -1.

### Complexity / Độ phức tạp
- **Time**: O(A^D + N) where A is alphabet size (10), D is number of wheels (4), and N is deadends size.
- **Space**: O(A^D + N).

---

## Analysis / Phân tích

### Approach: State-Space BFS
Generate all possible wheel rotations. Use BFS to find the shortest path while avoiding deadends.
Tạo ra tất cả các trường hợp xoay bánh xe khả thi. Sử dụng BFS để tìm đường đi ngắn nhất đồng thời tránh các điểm chết.

---
