# 1242. Web Crawler Multithreaded / Trình thu thập Web Đa luồng

## Problem Description / Mô tả bài toán
Multithreaded version of Web Crawler.
`HtmlParser.getUrls(url)` is blocking and slow. Use multiple threads.
Same host constraint.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Concurrent BFS / ExecutorService
Use a thread pool (e.g. `ConcurrentHashMap` for visited, `BlockingQueue` or just parallel tasks).
Since we don't know explicit graph, BFS layer by layer is good.
Layer 1: Start Url.
Submit parsing tasks for all URLs in current layer.
Wait for all tasks to complete (use `CountDownLatch` or `invokeAll`).
Collect all new URLs found.
Filter duplicates and visited.
Layer 2: New URLs.
Repeat.

### Complexity / Độ phức tạp
- **Time**: Faster than single thread due to I/O overlap.
- **Space**: O(V).

---

## Analysis / Phân tích

### Approach: Parallel BFS
Implement a multi-threaded web crawler using a shared `ConcurrentHashMap` (specifically using `newKeySet`) to track visited URLs and ensure thread safety. Since extracting URLs is the bottleneck, parallelize this operation. A simple approach is BFS level-by-level: collect all URLs at the current depth, submit tasks to an `ExecutorService` (or custom thread pool) to fetch and parse their content in parallel, collect the resulting URLs, filter out observed ones (same-host constraint and already visited), and proceed to the next depth.
Triển khai trình thu thập thông tin web đa luồng bằng cách sử dụng `ConcurrentHashMap` được chia sẻ (cụ thể là sử dụng `newKeySet`) để theo dõi các URL đã truy cập và đảm bảo an toàn cho luồng. Vì việc trích xuất URL là nút cổ chai, hãy song song hóa hoạt động này. Một cách tiếp cận đơn giản là BFS theo từng cấp: thu thập tất cả các URL ở độ sâu hiện tại, gửi các tác vụ đến `ExecutorService` (hoặc nhóm luồng tùy chỉnh) để tìm nạp và phân tích nội dung của chúng song song, thu thập các URL kết quả, lọc ra các URL đã quan sát (cùng máy chủ ràng buộc và đã truy cập), và tiếp tục đến độ sâu tiếp theo.

---
