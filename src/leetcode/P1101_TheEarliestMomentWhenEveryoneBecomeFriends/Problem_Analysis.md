# 1101. The Earliest Moment When Everyone Become Friends / Thời điểm Sớm nhất Khi Mọi người Trở thành Bạn bè

## Problem Description / Mô tả bài toán
There are `n` people in a social group labeled from `0` to `n - 1`. You are given an array `logs` where `logs[i] = [timestamp, x, y]` indicates that `x` and `y` become friends at the time `timestamp`.
Có `n` người trong một nhóm xã hội được dán nhãn từ `0` đến `n - 1`. Bạn được cho một mảng `logs` trong đó `logs[i] = [timestamp, x, y]` chỉ ra rằng `x` và `y` trở thành bạn bè tại thời điểm `timestamp`.

Friendship is symmetric and transitive.
Return the earliest time for which every person became acquaintance with every other person. If there is no such earliest time, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find (Disjoint Set Union) / Tìm-Hợp (Tập hợp Không Giao nhau)
We need to connect components until we have only 1 component (size `n`).
Algorithm:
1. Sort `logs` by timestamp.
2. Initialize Union-Find with `n` components.
3. Iterate through `logs`. For `{t, x, y}`:
   - If `find(x) != find(y)`:
     - `union(x, y)`.
     - `count--`.
     - If `count == 1`, return `t`.
4. Return -1.

### Complexity / Độ phức tạp
- **Time**: O(N log N + M alpha(N)), where M is logs length. Sorting dominates.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Sorted Union-Find
Sort the friendship logs chronologically. Process each log to merge the social circles of the two individuals involved. Track the number of disjoint sets (initially N). When the number of sets drops to 1, everyone is connected; return the timestamp of that critical merger.
Sắp xếp các bản ghi nhật ký tình bạn theo thứ tự thời gian. Xử lý từng bản ghi để hợp nhất các vòng kết nối xã hội của hai cá nhân liên quan. Theo dõi số lượng các tập hợp không giao nhau (ban đầu là N). Khi số lượng tập hợp giảm xuống còn 1, mọi người đều được kết nối; trả về dấu thời gian của sự hợp nhất quan trọng đó.

---
