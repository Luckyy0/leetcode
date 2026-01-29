# 1057. Campus Bikes / Xe đạp trong Khuôn viên

## Problem Description / Mô tả bài toán
On a campus represented as a 2D grid, there are `n` workers and `m` bikes, with `n <= m`. Each worker and bike is a 2D coordinate at `(x, y)`.
Trên một khuôn viên được biểu diễn dưới dạng lưới 2D, có `n` công nhân và `m` xe đạp, với `n <= m`. Mỗi công nhân và xe đạp là một tọa độ 2D tại `(x, y)`.

We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized types of problems, but specifically we assign based on:
1. Smallest distance.
2. Smallest worker index.
3. Smallest bike index.

Return an array `ans` of length `n`, where `ans[i]` is the bike that the `i-th` worker is assigned to.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting All Pairs / Bucket Sort / Sắp xếp Tất cả các Cặp / Sắp xếp Thùng
We have `n * m` pairs. Max `n, m` is 1000. Pairs ~ $10^6$.
Sorting takes $O(NM \log(NM))$. Bucket sort takes $O(NM)$ since max distance is 2000.

Algorithm:
1. Generate all pairs `(worker, bike, dist)`.
2. Sort pairs by `dist` asc, then `worker` asc, then `bike` asc.
3. Iterate sorted pairs.
4. If worker not assigned and bike not used, assign bike to worker.
5. Track `assigned[worker]` and `used[bike]`.

### Complexity / Độ phức tạp
- **Time**: O(NM log (NM)) or O(NM) with bucket sort.
- **Space**: O(NM).

---

## Analysis / Phân tích

### Approach: Global Priority Assignment
Compute the Manhattan distance for every possible worker-bike pair. Sort these pairs primarily by distance, breaking ties with worker index and then bike index. Iterate through this ordered list, optimistically assigning the first available bike to the first available worker until all workers are served.
Tính khoảng cách Manhattan cho mọi cặp công nhân-xe đạp có thể. Sắp xếp các cặp này chủ yếu theo khoảng cách, phá vỡ các trường hợp hòa nhau bằng chỉ số công nhân và sau đó là chỉ số xe đạp. Lặp qua danh sách đã sắp xếp này, gán xe đạp có sẵn đầu tiên cho công nhân có sẵn đầu tiên một cách lạc quan cho đến khi tất cả công nhân được phục vụ.

---
