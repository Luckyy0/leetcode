# 1345. Jump Game IV / Trò chơi Nhảy IV

## Problem Description / Mô tả bài toán
Array `arr`. Start `0`. Target `n-1`.
Moves from `i`:
- `i + 1`
- `i - 1`
- `j` where `arr[i] == arr[j]` (jump to any index with same value).
Min steps.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS
Graph edges:
- `i -> i+1`
- `i -> i-1`
- `i -> indices_of_value[arr[i]]`
Total nodes N.
Edges might be many if many duplicates (e.g. all same values -> N^2 edges).
Optimization:
When visiting a value `v` for the first time, add ALL indices with value `v` to queue.
Then CLEAR the list of indices for `v`.
Why? Because all nodes with value `v` satisfy `arr[i] == arr[j]`. Once we reach ANY node with value `v`, we can reach ALL other nodes with value `v` in 1 step via the graph property (actually all are connected to each other).
If we reach value `v` again later, we don't need to check these edges again (already visited or in queue).
This reduces edges to O(N).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Optimized BFS
Pre-process the array to store indices for each value in a Map `val -> list<index>`.
Perform BFS starting from index 0. Maintain a `visited` array.
When extracting `u` from queue:
- Check `u-1`, `u+1`. If valid and unvisited, push to queue.
- Check all indices `v` such that `arr[v] == arr[u]`. Push unvisited ones. **Critical**: After iterating, clear the list in the Map for this value to prevent re-processing and O(N^2) behavior.
- Stop when reaching `n-1`.
Xử lý trước mảng để lưu trữ các chỉ số cho mỗi giá trị trong Map `val -> list<index>`.
Thực hiện BFS bắt đầu từ chỉ số 0. Duy trì mảng `visited`.
Khi trích xuất `u` từ hàng đợi:
- Kiểm tra `u-1`, `u+1`. Nếu hợp lệ và chưa được truy cập, đẩy vào hàng đợi.
- Kiểm tra tất cả các chỉ số `v` sao cho `arr[v] == arr[u]`. Đẩy các chỉ số chưa được truy cập. **Quan trọng**: Sau khi lặp lại, hãy xóa danh sách trong Bản đồ cho giá trị này để ngăn xử lý lại và hành vi O(N^2).
- Dừng lại khi đạt đến `n-1`.

---
