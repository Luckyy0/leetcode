# 1236. Web Crawler / Trình thu thập Web

## Problem Description / Mô tả bài toán
Ideally simple crawler on a mock `HtmlParser`.
Given `startUrl` and `HtmlParser` interface.
Return list of URLs that belong to same hostname as `startUrl` and are reachable from `startUrl`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS
Standard graph traversal.
1. Extract hostname from `startUrl`.
2. BFS queue. `Set<String>` visited.
3. For each URL, `getUrls()`.
4. If child URL contains same hostname and not visited, add to Q and visited.
5. URL parsing: `string.split("/")[2]` or `URI` class.

### Complexity / Độ phức tạp
- **Time**: O(V + E) where V, E are pages on the same host.
- **Space**: O(V) visited set.

---

## Analysis / Phân tích

### Approach: BFS Crawler
Implement a standard BFS (or DFS). Start with `startUrl`. Extract its hostname. For every URL visited, utilize `htmlParser.getUrls(url)` to discover links. Filter the discovered links: only process and add to the visited set those that share the same hostname as `startUrl` and haven't been visited yet. Helper function `getHostname` is needed.
Triển khai BFS tiêu chuẩn (hoặc DFS). Bắt đầu với `startUrl`. Trích xuất tên máy chủ của nó. Đối với mỗi URL được truy cập, sử dụng `htmlParser.getUrls(url)` để khám phá các liên kết. Lọc các liên kết đã khám phá: chỉ xử lý và thêm vào tập hợp đã truy cập những liên kết có cùng tên máy chủ với `startUrl` và chưa được truy cập. Cần có hàm trợ giúp `getHostname`.

---
