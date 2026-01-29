# 1311. Get Watched Videos by Your Friends / Xem Video Được Bạn bè Xem

## Problem Description / Mô tả bài toán
Given friends graph (adjacency list), `id`, `level`.
Find friends at exact `level` distance from `id`.
Aggregate videos watched by these friends (`watchedVideos[friend_id]`).
Sort by frequency (ascending) then alphabetically.
Return list of videos.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS Level Traversal
1. BFS starting from `id`. Find all nodes at distance `level`.
   - Use `visited` set.
   - Stop when depth == level.
2. Collect videos from all target nodes.
3. Count frequencies.
4. Sort using custom comparator.

### Complexity / Độ phức tạp
- **Time**: O(N + E + V log V). N people, E friends, V total videos found.
- **Space**: O(N + V).

---

## Analysis / Phân tích

### Approach: BFS then Sorting
Perform a Breadth-First Search (BFS) starting from `id` to find all friends at exactly distance `level`. Use a `visited` array to keep track of visited friends and avoid cycles. Once the target level is reached, collect all videos watched by friends at this level. Use a hash map to count the frequency of each video. Finally, sort the videos based on frequency (ascending) and then lexicographically, and return the result.
Thực hiện Tìm kiếm theo Chiều rộng (BFS) bắt đầu từ `id` để tìm tất cả bạn bè ở chính xác khoảng cách `level`. Sử dụng mảng `visited` để theo dõi bạn bè đã truy cập và tránh chu kỳ. Khi đạt đến cấp độ mục tiêu, hãy thu thập tất cả các video được xem bởi bạn bè ở cấp độ này. Sử dụng bản đồ băm để đếm tần suất của mỗi video. Cuối cùng, sắp xếp các video dựa trên tần suất (tang dần) và sau đó theo thứ tự từ điển, và trả về kết quả.

---
