# 787. Cheapest Flights Within K Stops / Các Chuyến bay Rẻ nhất Trong vòng K Điểm dừng

## Problem Description / Mô tả bài toán
There are `n` cities connected by some number of flights. You are given an array `flights` where `flights[i] = [fromi, toi, pricei]`.
Có `n` thành phố được kết nối bởi một số chuyến bay. Bạn được cung cấp một mảng `flights` trong đó `flights[i] = [fromi, toi, pricei]`.

Now given all the cities and flights, together with starting city `src` and the destination `dst`, your task is to find the cheapest price from `src` to `dst` with at most `k` stops. If there is no such route, return `-1`.
Bây giờ, cho tất cả các thành phố và chuyến bay, cùng với thành phố xuất phát `src` và điểm đến `dst`, nhiệm vụ của bạn là tìm mức giá rẻ nhất từ `src` đến `dst` với tối đa `k` điểm dừng. Nếu không có lộ trình như vậy, hãy trả về `-1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bellman-Ford or BFS / Bellman-Ford hoặc BFS
This is a shortest path problem with a constraint on the number of edges.
Đây là bài toán tìm đường đi ngắn nhất với ràng buộc về số lượng cạnh.

Algorithm (Bellman-Ford variant):
1. Maintain a `dist` array representing the cost to each city.
2. Perform `k + 1` relaxations. In each iteration, use a copy of the previous `dist` result to avoid using more than one edge per step.
`cost[step][v] = min(cost[step-1][v], cost[step-1][u] + weight(u, v))`

### Complexity / Độ phức tạp
- **Time**: O(K * E) where E is the number of flights.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Restricted Bellman-Ford
Because we can have at most K stops (meaning K+1 flight segments), we can strictly control the distance updates per relaxation. This naturally limits the path length as required.
Bởi vì chúng ta có thể có tối đa K điểm dừng (nghĩa là K+1 chặng bay), chúng ta có thể kiểm soát chặt chẽ các bản cập nhật khoảng cách sau mỗi lần nới lỏng. Điều này tự nhiên giới hạn độ dài đường đi theo yêu cầu.

---
