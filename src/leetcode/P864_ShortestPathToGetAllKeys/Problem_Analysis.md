# 864. Shortest Path to Get All Keys / Đường đi Ngắn nhất để lấy Tất cả Chìa khóa

## Problem Description / Mô tả bài toán
You are given an `m x n` grid `grid`. 'a', 'b', ... are keys, 'A', 'B', ... are locks. '@' is your starting point. You can't pass a lock without its key.
Bạn được cấp một lưới `m x n` `grid`. 'a', 'b', ... là các chìa khóa, 'A', 'B', ... là các ổ khóa. '@' là điểm xuất phát của bạn. Bạn không thể đi qua ổ khóa nếu không có chìa khóa tương ứng.

Return the minimum number of moves to collect all keys. If impossible, return -1.
Hãy trả về số bước di chuyển tối thiểu để thu thập tất cả các chìa khóa. Nếu không thể, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS with State (Bitmask) / BFS với Trạng thái (Mặt nạ Bit)
The state is `(row, col, keyMask)`.
Trạng thái là `(hàng, cột, mặt nạ chìa khóa)`.

Algorithm:
1. Count the number of total keys `K`.
2. Initial state: `(startR, startC, 0)`.
3. Perform BFS.
4. For each move:
   - If it's a key 'a'-'f', update `keyMask`: `newMask = keyMask | (1 << (c - 'a'))`.
   - If it's a lock 'A'-'F', check if we have the key: `(keyMask >> (c - 'A')) & 1`.
   - If `newMask == (1 << K) - 1`, return steps.

### Complexity / Độ phức tạp
- **Time**: O(M * N * 2^K) where K is number of keys (up to 6).
- **Space**: O(M * N * 2^K).

---

## Analysis / Phân tích

### Approach: Augmented State BFS
Standard BFS is insufficient because the same grid location can be revisited with different sets of keys. By including the key inventory in the state, we allow the search to correctly identify progress and cycles.
BFS tiêu chuẩn là không đủ vì cùng một vị trí trong lưới có thể được truy cập lại với các bộ chìa khóa khác nhau. Bằng cách đưa bảng kiểm kê chìa khóa vào trạng thái, chúng ta cho phép tìm kiếm xác định chính xác tiến trình và các chu trình.

---
