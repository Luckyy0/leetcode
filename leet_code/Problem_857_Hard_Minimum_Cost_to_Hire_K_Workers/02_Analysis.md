# Analysis for Minimum Cost to Hire K Workers
# *Phân tích cho bài toán Chi phí Tối thiểu để Thuê K Công nhân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to select $K$ workers and pay them proportionally to their quality. The "ratio" of pay-to-quality must be the same for all $K$ workers. Crucially, every worker's total pay must be greater than or equal to their `wage`.
*Chúng ta cần chọn $K$ công nhân và trả lương tỷ lệ thuận với chất lượng của họ. "Tỷ lệ" tiền lương trên chất lượng phải giống nhau cho tất cả $K$ công nhân. Quan trọng nhất, tổng lương của mỗi công nhân phải lớn hơn hoặc bằng `wage` của họ.*

This implies that for a set of $K$ workers, the ratio used must be the **maximum** individual ratio `wage[i] / quality[i]` among the selected group.
*Điều này ngụ ý rằng đối với một nhóm $K$ công nhân, tỷ lệ được sử dụng phải là giá trị **lớn nhất** trong các tỷ lệ cá nhân `wage[i] / quality[i]` thuộc nhóm được chọn.*

---

## 2. Strategy: Greedy with Max-Heap
## *2. Chiến lược: Tham lam với Hàng đợi ưu tiên (Max-Heap)*

### Key Formula
### *Công thức chính*
If the group ratio is $R$, then $TotalCost = R \cdot \sum (quality_{included})$. To minimize this, we want to minimize $R$ and/or the sum of qualities.
*Nếu tỷ lệ của nhóm là $R$, thì $TotalCost = R \cdot \sum (chất lượng_{trong\_nhóm})$. Để tối thiểu hóa điều này, chúng ta muốn tối thiểu hóa $R$ và/hoặc tổng chất lượng.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate over potential Ratios:** Calculate the ratio `wage/quality` for each worker and sort them by this ratio.
    *   **Duyệt qua các tỷ lệ tiềm năng:** Tính tỷ lệ `wage/quality` cho mỗi công nhân và sắp xếp họ theo tỷ lệ này.*

2.  **Maintaining Top K Qualities:** Use a Max-Heap to store the qualities of the workers currently under consideration.
    *   **Duy trì K chất lượng hàng đầu:** Sử dụng Max-Heap để lưu trữ chất lượng của các công nhân hiện đang được xem xét.*

3.  **The Greedy Step:**
    - Iterate through the sorted workers (by ratio).
    - For each worker, add their quality to the Max-Heap and update the `currentQualitySum`.
    - If the heap size exceeds $K$, remove the largest quality (to keep the sum small).
    - If the heap size is exactly $K$, the current worker defines the ratio $R$, and the current cost is $R \cdot currentQualitySum$. Update the global `minCost`.
    *   **Bước Tham lam:** Duyệt qua các công nhân đã được sắp xếp (theo tỷ lệ). Với mỗi công nhân, thêm chất lượng của họ vào Max-Heap và cập nhật `currentQualitySum`. Nếu kích thước heap vượt quá $K$, hãy loại bỏ chất lượng lớn nhất (để giữ cho tổng nhỏ). Nếu kích thước heap chính xác là $K$, công nhân hiện tại sẽ xác định tỷ lệ $R$ và chi phí hiện tại là $R \cdot currentQualitySum$. Cập nhật `minCost` toàn cục.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    int n = quality.length;
    double[][] workers = new double[n][2];
    for (int i = 0; i < n; i++) {
        workers[i][0] = (double) wage[i] / quality[i];
        workers[i][1] = (double) quality[i];
    }
    
    // Sort by ratio ascending
    Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
    
    PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    double minCost = Double.MAX_VALUE;
    double qualitySum = 0;
    
    for (double[] worker : workers) {
        qualitySum += worker[1];
        maxHeap.offer(worker[1]);
        if (maxHeap.size() > k) {
            qualitySum -= maxHeap.poll();
        }
        if (maxHeap.size() == k) {
            minCost = Math.min(minCost, qualitySum * worker[0]);
        }
    }
    return minCost;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ for sorting the ratios plus $O(N \log K)$ for heap operations.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ cho việc sắp xếp các tỷ lệ và $O(N \log K)$ cho các thao tác trên heap.*
*   **Space Complexity:** $O(N)$ for storing worker info and $O(K)$ for the heap.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu thông tin công nhân và $O(K)$ cho heap.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting by ratio ensures that for each step $i$, the ratio of the $i$-th worker is sufficient to cover all previous workers currently in the heap.
*Sắp xếp theo tỷ lệ đảm bảo rằng đối với mỗi bước $i$, tỷ lệ của công nhân thứ $i$ đủ để chi trả cho tất cả các công nhân trước đó hiện có trong heap.*
