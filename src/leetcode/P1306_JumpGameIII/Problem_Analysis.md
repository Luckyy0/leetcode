# 1306. Jump Game III / Trò chơi Nhảy III

## Problem Description / Mô tả bài toán
Array `arr`, start index `start`.
From index `i`, can jump to `i + arr[i]` or `i - arr[i]`.
Can reach any index with value 0?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS
Graph problem. Indices are nodes. Edges `i -> i + arr[i]` and `i -> i - arr[i]`.
Find if any node `v` with `arr[v] == 0` is reachable from `start`.
Use visited array to avoid cycles.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Breadth-First Search
Treat the indices as graph nodes. Start a BFS from the `start` index. At each visited index `i`, check if `arr[i] == 0`. If so, return true. Otherwise, try to visit neighbors `i + arr[i]` and `i - arr[i]` if they are within bounds and not yet visited. Use a `visited` array (or modify `arr` values to negative) to keep track. If the queue becomes empty without finding a 0, return false.
Coi các chỉ số như các nút đồ thị. Bắt đầu BFS từ chỉ số `start`. Tại mỗi chỉ số đã truy cập `i`, kiểm tra xem `arr[i] == 0` hay không. Nếu có, trả về true. Nếu không, hãy thử truy cập các hàng xóm `i + arr[i]` và `i - arr[i]` nếu chúng nằm trong giới hạn và chưa được truy cập. Sử dụng mảng `visited` (hoặc sửa đổi giá trị `arr` thành số âm) để theo dõi. Nếu hàng đợi trở nên trống rỗng mà không tìm thấy số 0, trả về false.

---
