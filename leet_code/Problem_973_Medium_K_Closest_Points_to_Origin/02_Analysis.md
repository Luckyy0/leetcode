# Analysis for K Closest Points to Origin
# *Phân tích cho bài toán K Điểm Gần Gốc Tọa độ Nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find `k` points from an array of size `N` that are closest to `(0,0)`.
*Tìm k điểm gần gốc tọa độ nhất từ mảng kích thước N.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Distance is $\sqrt{x^2 + y^2}$. Monotonically increasing with $x^2 + y^2$.
- We can sort by $x^2 + y^2$.
- $N$ up to $10^4$, $K$ up to $N$.
- Sorting takes $O(N \log N)$.
- Using a Max Heap (PriorityQueue) of size $K$ takes $O(N \log K)$.
  - Keep the smallest $K$ elements. If current is smaller than max in heap, replace max.
- QuickSelect (Hoare's Selection Algorithm) takes $O(N)$ on average.
- For $N=10^4$, even $O(N \log N)$ is perfectly fine. `Arrays.sort` with custom Comparator is the simplest and very fast in Java (Dual-Pivot Quicksort).
- Let's implement `Arrays.sort` for clarity and sufficiently good performance.
- Or Max Heap to be fancy and potentially slightly faster if $K \ll N$. But generally sort is good.
- Let's use `Arrays.sort` directly on the points array with a lambda comparator.
*Khoảng cách đơn điệu với tổng bình phương. Sắp xếp mảng theo $x^2 + y^2$ hoặc dùng Max Heap kích thước K. QuickSelect là O(N) trung bình.*

---

## 2. Strategy: Sorting
## *2. Chiến lược: Sắp xếp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort:** Use `Arrays.sort` on `points` array.
    *   **Sắp xếp:** Dùng `Arrays.sort`.*
2.  **Comparator:** `(p1, p2) -> (p1.x^2 + p1.y^2) - (p2.x^2 + p2.y^2)`.
    *   **Bộ so sánh:** So sánh tổng bình phương.*
3.  **Slice:** Return first `K` elements using `Arrays.copyOfRange`.
    *   **Cắt:** Trả về K phần tử đầu.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort based on squared Euclidean distance
        Arrays.sort(points, (a, b) -> Integer.compare(
            a[0] * a[0] + a[1] * a[1], 
            b[0] * b[0] + b[1] * b[1]
        ));
        
        // Return first k elements
        return Arrays.copyOfRange(points, 0, k);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(\log N)$ or $O(N)$ depending on sort implementation (stack space).
    *   **Độ phức tạp không gian:** $O(\log N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting is the most straightforward approach. For strict $O(N)$ requirements, QuickSelect could be used, but built-in sort is highly optimized.
*Sắp xếp là cách tiếp cận trực tiếp nhất. QuickSelect có thể đạt O(N) nhưng sort có sẵn đã được tối ưu hóa rất tốt.*
