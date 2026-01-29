# 841. Keys and Rooms / Chìa khóa và các Phòng

## Problem Description / Mô tả bài toán
There are `n` rooms and you start in room `0`. Each room has a list of keys to other rooms.
Có `n` phòng và bạn bắt đầu tại phòng `0`. Mỗi phòng có một danh sách các chìa khóa dẫn đến các phòng khác.

Can you visit all the rooms?
Bạn có thể truy cập tất cả các phòng không?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) / Tìm kiếm theo Chiều sâu
This is a reachability problem in a directed graph.
Đây là bài toán về khả năng tiếp cận trong một đồ thị có hướng.

Algorithm:
1. Initialize a `visited` boolean array.
2. Perform DFS starting from room 0.
3. For the current room, iterate through all keys found.
4. If a key belongs to an unvisited room, visit it recursively.
5. After DFS, check if `visited` array contains any `false`.

### Complexity / Độ phức tạp
- **Time**: O(N + E) where N is rooms and E is total keys.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive traversal
Explore the room graph starting from the initial point. Every key discovered unlocks a potential new path. The goal is to verify if every node in the graph is part of the connected component starting at 0.
Khám phá đồ thị các phòng bắt đầu từ điểm ban đầu. Mỗi chìa khóa được phát hiện sẽ mở ra một con đường tiềm năng mới. Mục tiêu là xác minh xem mọi nút trong đồ thị có thuộc thành phần liên thông bắt đầu từ 0 hay không.

---
