# Analysis for Most Profit Assigning Work
# *Phân tích cho bài toán Giao việc đạt lợi nhuận tối đa*

## 1. Problem Essence & Greedy Strategy
## *1. Bản chất vấn đề & Chiến lược Tham lam*

### THE CHALLENGE
### *Thách thức*
We need to assign each worker to a job they can handle (difficulty $\le$ capability) that yields the maximum possible profit. Since one job can be done by multiple people, we should always pick the most profitable job that fits within a worker's difficulty limit.
*Chúng ta cần giao cho mỗi công nhân một công việc mà họ có thể làm (độ khó $\le$ năng lực) và đem lại lợi nhuận cao nhất. Vì một việc có thể được làm bởi nhiều người, ta luôn chọn việc có lợi nhuận cao nhất nằm trong giới hạn của công nhân.*

---

## 2. Strategy: Sorting & Two Pointers
## *2. Chiến lược: Sắp xếp & Hai con trỏ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Pair Jobs:** Combine `difficulty` and `profit` into a list of Job objects.
    *   **Ghép cặp công việc:** Kết hợp `difficulty` và `profit` thành một danh sách các đối tượng công việc.*

2.  **Sort Everything:**
    - Sort Jobs by `difficulty`.
    - Sort `worker` capabilities.
    *   **Sắp xếp:** Sắp xếp công việc theo độ khó. Sắp xếp các công nhân theo năng lực.*

3.  **Two Pointers:**
    - Iterate through each sorted `worker`.
    - Use a pointer `i` to traverse sorted `jobs`.
    - As long as `jobs[i].difficulty <= worker[j]`, update the `maxProfit` found so far for this difficulty level.
    - Add `maxProfit` to the total result for the current worker.
    *   **Hai con trỏ:** Duyệt qua từng công nhân đã sắp xếp. Dùng con trỏ `i` để duyệt qua các công việc. Khi `jobs[i].difficulty <= worker[j]`, cập nhật `maxProfit` lớn nhất thấy được. Cộng `maxProfit` vào tổng cho công nhân hiện tại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length;
    int[][] jobs = new int[n][2];
    for (int i = 0; i < n; i++) {
        jobs[i][0] = difficulty[i];
        jobs[i][1] = profit[i];
    }
    
    // Sort jobs by difficulty
    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    // Sort workers
    Arrays.sort(worker);
    
    int totalProfit = 0, i = 0, bestProfit = 0;
    for (int capability : worker) {
        // Find best profit available for this worker's capability
        while (i < n && jobs[i][0] <= capability) {
            bestProfit = Math.max(bestProfit, jobs[i][1]);
            i++;
        }
        totalProfit += bestProfit;
    }
    return totalProfit;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N + M \log M)$, where $N$ is the number of jobs and $M$ is the number of workers. Most of the time is spent on sorting. The two-pointer scan is $O(N + M)$.
    *   **Độ phức tạp thời gian:** $O(N \log N + M \log M)$, chủ yếu là do sắp xếp. Quá trình duyệt hai con trỏ mất $O(N + M)$.*
*   **Space Complexity:** $O(N)$, to store the combined job pairs.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu các cặp công việc.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `jobs: d[2,10], p[10,50]`, `workers: [4,11]`
1. Sorted Jobs: `[(2, 10), (10, 50)]`. Sorted Workers: `[4, 11]`.
2. Worker 4:
   - `jobs[0]` (2 $\le$ 4): `bestProfit = max(0, 10) = 10`.
   - Result += 10.
3. Worker 11:
   - `jobs[1]` (10 $\le$ 11): `bestProfit = max(10, 50) = 50`.
   - Result += 50. Total = 60.
**Result:** 60.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting allows us to use a greedy approach where we only need to scan the job list once across all workers. This is significantly faster than checking every job for every worker.
*Việc sắp xếp cho phép chúng ta sử dụng phương pháp tham lam, nơi ta chỉ cần quét danh sách công việc một lần cho tất cả công nhân. Điều này nhanh hơn nhiều so với việc kiểm tra mọi công việc cho mọi công nhân.*
