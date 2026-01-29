# 994. Rotting Oranges / Cam thối

## Problem Description / Mô tả bài toán
You are given an `m x n` `grid` where:
- `0`: Empty cell.
- `1`: Fresh orange.
- `2`: Rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Mỗi phút, bất kỳ quả cam tươi nào nằm cạnh (4 hướng) một quả cam thối đều sẽ bị thối.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If impossible, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-source BFS / BFS Đa nguồn
Algorithm:
1. Count total fresh oranges.
2. Put all initial rotten oranges into a `Queue`.
3. Perform BFS (layer by layer).
   - In each step, for each rotten orange, infect its fresh neighbors.
   - Decrement fresh orange count.
   - Increment timer.
4. If fresh orange count == 0, return time. Else return -1.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Batch Contagion simulation
Model the rot as an expanding wavefront starting from multiple sources. By using BFS, we ensure that the spread is tracked minute-by-minute, allowing us to find the exact moment of total contamination or confirm its impossibility.
Mô phỏng sự thối rữa như một làn sóng mở rộng bắt đầu từ nhiều nguồn. Bằng cách sử dụng BFS, chúng ta đảm bảo rằng sự lây lan được theo dõi từng phút, cho phép chúng ta tìm thấy thời điểm chính xác của việc thối rữa hoàn toàn hoặc xác nhận tính không thể của nó.

---
