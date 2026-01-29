# 743. Network Delay Time / Thời gian Trễ Mạng

## Problem Description / Mô tả bài toán
You are given a network of `n` nodes, labeled from 1 to `n`. You are also given `times`, a list of travel times as directed edges `times[i] = [ui, vi, wi]`.
Bạn được cho một mạng lưới gồm `n` nút, được đánh số từ 1 đến `n`. Bạn cũng được cho `times`, một danh sách thời gian di chuyển dưới dạng các cạnh có hướng `times[i] = [ui, vi, wi]`.

We will send a signal from a given node `k`. Return the minimum time it takes for all the `n` nodes to receive the signal. If it is impossible for all the `n` nodes to receive the signal, return -1.
Chúng ta sẽ gửi một tín hiệu từ một nút `k` cho trước. Hãy trả về thời gian tối thiểu để tất cả `n` nút nhận được tín hiệu. Nếu không thể để tất cả `n` nút nhận được tín hiệu, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dijkstra's Algorithm / Thuật toán Dijkstra
This is a standard single-source shortest path problem on a weighted graph with non-negative weights.
Đây là một bài toán tìm đường đi ngắn nhất từ một nguồn duy nhất tiêu chuẩn trên đồ thị có trọng số không âm.

Algorithm:
1. Use a PriorityQueue to store `(distance, node)`, ordered by distance.
2. Initialize distances to infinity, `dist[k] = 0`.
3. While the queue is not empty, pick the node with the shortest distance and relax its neighbors.

### Complexity / Độ phức tạp
- **Time**: O(E log V) where E is number of edges and V is number of nodes.
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Dijkstra with Min-PriorityQueue
Efficiently explore the shortest paths to all nodes. The result is the maximum value in the final distance array.
Khám phá hiệu quả các đường đi ngắn nhất đến tất cả các nút. Kết quả là giá trị lớn nhất trong mảng khoảng cách cuối cùng.

---
