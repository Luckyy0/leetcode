# 815. Bus Routes / Các Tuyến xe buýt

## Problem Description / Mô tả bài toán
You are given an array `routes` where `routes[i]` is a list of stops that the `ith` bus travels in a cycle.
Bạn được cung cấp một mảng `routes` trong đó `routes[i]` là một danh sách các điểm dừng mà xe buýt thứ `i` đi qua theo một chu trình.

Given a `source` stop and a `target` stop, return the least number of buses you must take to travel from `source` to `target`. If it is impossible, return -1.
Cho một điểm dừng `source` và một điểm dừng `target`, hãy trả về số lượng xe buýt ít nhất bạn phải đi để di chuyển từ `source` đến `target`. Nếu không thể, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Breadth First Search (BFS) / Tìm kiếm theo Chiều rộng
We want the "minimum number of buses", so BFS is ideal.
Chúng ta muốn "số lượng xe buýt tối thiểu", vì vậy BFS là lựa chọn lý tưởng.

Graph representation:
- Each bus route is a node.
- Two nodes (routes) are connected if they share at least one common stop.
- Or, use stops as entry points.

Algorithm:
1. Map each stop to all bus routes that pass through it.
2. Use a queue to store `(stop, busCount)`. Initial: `source` stop with count 0.
3. Queue stores which *bus* you take next (to avoid re-visiting stops).
4. `visitedStops` and `visitedBuses` to prevent cycles.

### Complexity / Độ phức tạp
- **Time**: O(Σ routes[i].length).
- **Space**: O(Σ routes[i].length).

---

## Analysis / Phân tích

### Approach: Route-based BFS
Rather than stepping from stop to stop, we step from bus to bus. When you board a bus, you can reach all stops on its route. This reduces the number of edges to explore.
Thay vì đi từng điểm dừng, chúng ta đi từng xe buýt. Khi bạn lên một chiếc xe buýt, bạn có thể đến tất cả các điểm dừng trên lộ trình của nó. Điều này làm giảm số lượng cạnh cần khám phá.

---
