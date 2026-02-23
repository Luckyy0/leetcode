# Analysis for K-th Smallest Prime Fraction
# *Phân tích cho bài toán Phân số Nguyên tố Nhỏ thứ K*

## 1. Problem Essence & Sorted Matrix
## *1. Bản chất vấn đề & Ma trận Đã sắp xếp*

### The Challenge
### *Thách thức*
We have a sorted array `A`. Fractions are `A[i]/A[j]` with `i < j`.
Since `A` is sorted, for a fixed `j`, as `i` increases, `A[i]/A[j]` increases.
For a fixed `i`, as `j` increases, `A[i]/A[j]` decreases.
*Chúng ta có mảng đã sắp xếp `A`. Các phân số là `A[i]/A[j]` với `i < j`. Vì `A` đã sắp xếp, với `j` cố định, khi `i` tăng, phân số tăng. Với `i` cố định, khi `j` tăng, phân số giảm.*

We can view this as selecting the k-th smallest element from $N$ sorted lists (rows).
Row `i`: `A[0]/A[i]`, `A[1]/A[i]`, ... `A[i-1]/A[i]`. (Increasing order).
Total elements: $N(N-1)/2$.
*Ta có thể xem đây là việc chọn phần tử nhỏ thứ k từ N danh sách đã sắp xếp.*

---

## 2. Strategy: Binary Search on Value or Priority Queue
## *2. Chiến lược: Tìm kiếm Nhị phân trên Giá trị hoặc Hàng đợi Ưu tiên*

### Method 1: Priority Queue (Max Heap or Min Heap)
### *Phương pháp 1: Hàng đợi Ưu tiên*

Since $N \le 1000$, $N^2$ is $10^6$. We can't generate all.
But we can use a Min-Heap of size $N$ to merge sorted lists.
- Push first element of each "row" `j`: `A[0]/A[j]`. (Smallest for denominator `A[j]`).
- Pop min.
- If popped `A[i]/A[j]`, push next `A[i+1]/A[j]`.
- Do this $k$ times.
- Complexity: $O(K \log N)$. Since $K$ can be $O(N^2)$, worst case $O(N^2 \log N)$.
*Dùng Min-Heap kích thước N. Đẩy phần tử đầu tiên của mỗi "hàng" `j`: `A[0]/A[j]`. Lấy min, rồi đẩy phần tử tiếp theo `A[i+1]/A[j]`. Độ phức tạp $O(K \log N)$.*

### Method 2: Binary Search on Value (Optimal)
### *Phương pháp 2: Tìm kiếm Nhị phân trên Giá trị (Tối ưu)*

Search space: `[0, 1]`.
Check function `count(x)`: How many fractions $\le x$?
- For each `i`, find largest `j` such that `A[i]/A[j] <= x`? Or given sorted structure:
- For each `i`, we need `A[i] / A[j] <= x` -> `A[j] >= A[i] / x`.
- As `i` increases, `A[i]` increases. We can use two pointers to count.
- Complexity: $O(N \log(1/\epsilon))$. Very fast.
*Không gian tìm kiếm: `[0, 1]`. Hàm `count(x)`: đếm bao nhiêu phân số $\le x$. Dùng hai con trỏ hoặc Binary search trong check function.*

Let's refine `count(x)` using Two Pointers (or sliding window):
We want `A[i]/A[j] <= x`.
Iterate `i` from `0` to `n-1`. Find smallest `j` such that `A[i]/A[j] <= x`.
Wait, usually we fix `j` (denominator)?
If we fix `j`, we want `A[i] <= x * A[j]`. Since `A[i]` is increasing, `i` goes from 0 up to some index.
Specifically: `count(mid)`:
For `i = 0`, find max `j` ... No.
Iterate `i` from 0. `j` starts from `1`.
Actually, iterate `i` (numerator index). find smallest index `j` (`> i`) such that `A[i]/A[j] <= mid`.
Since `A[j]` increases with `j`, fraction decreases.
Algorithm:
Iterate `i` from `0` to `n-2`.
Find strictly smallest `j` such that `A[i]/A[j] <= mid`. Since `A[j]` is sorted, if `A[i]/A[j] <= mid`, then for all `k > j`, `A[i]/A[k] < A[i]/A[j] <= mid`.
So count adds `n - j`.
Keep `j` moving.

Actually simpler: Loop `i` from 0. `j` starts from whatever.
Actually even simpler standard sliding window:
Count pairs `(i, j)` with `i < j` and `A[i]/A[j] <= mid`.
Fix `i`: need `A[j] >= A[i]/mid`. Since `A` sorted, `j` is a suffix.
Fix `j`: need `A[i] <= mid * A[j]`. `i` is a prefix.
Let's fix `j` (denominator) from `1` to `n-1`.
`i` moves from `0` upwards.
While `A[i] <= mid * A[j]`, `i` increases.
Count adds `i`. (Indices `0` to `i-1` are valid numerators for denominator `j`).
This is $O(N)$ check.
Total time $O(N \log C)$.

### Code Logic Preview (Binary Search)
### *Xem trước Logic Mã (Tìm kiếm Nhị phân)*

```java
public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    double low = 0, high = 1.0;
    while (high - low > 1e-9) {
        double mid = (low + high) / 2;
        int[] res = count(arr, mid);
        if (res[0] < k) low = mid;
        else high = mid; // Wait, we might not hit exact K. We find smallest mid that gives >= k?
                         // The problem asks for exact fraction.
                         // Binary search on value converges to the value. 
                         // To get p, q: inside count(), keep track of max fraction <= mid.
    }
    return bestFraction;
}
```

Wait, Priority Queue logic is easier to implement and $K \le N(N-1)/2$. With $N=1000$, $K$ up to $5 \cdot 10^5$. $K \log N$ is approx $5 \cdot 10^5 \cdot 10 \approx 5 \cdot 10^6$ ops. Feasible (10-20ms).
Binary Search is $O(N \cdot 50) \approx 5 \cdot 10^4$ ops. Much faster.
Let's stick to **Binary Search** for "Optimal". Or Priority Queue for "Simplicity" if K is small. But K is large.
However, for generic K, PQ is acceptable. Let's use Priority Queue because it directly gives the pair without floating point precision issues (though doubles are fine here).
Wait, constraints: $N=1000$. $O(K \log N)$ may TLE if implementation is heavy.
Actually the BS solution is superior.
We need to return the fraction `p/q`.
During the check `count(mid)`, we can track the maximum fraction that satisfies the condition ($\le mid$).
If `count == k`? Not necessarily. We want the K-th smallest. With BS, `low` and `high` converge to the K-th value. The `max_fraction <= mid` observed in the valid check will be our answer.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log(\text{Range}/\epsilon))$.
    *   **Độ phức tạp thời gian:** $O(N \log(\text{Range}/\epsilon))$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Arr:** `[1, 2, 3, 5]`, K=3
Sorted fractions: `1/5 (0.2), 1/3 (0.33), 2/5 (0.4), 1/2 (0.5), 3/5 (0.6), 2/3 (0.66)`. 3rd is `2/5`.
BS `mid = 0.5`.
- j=1 (2): `1 <= 0.5*2` (1<=1). i becomes 1. Count += 1. Max so far `1/2`.
- j=2 (3): `1 <= 1.5` -> i=1. `2 <= 1.5` No. Count += 1. Max so far `1/2`.
- j=3 (5): `1 <= 2.5`. `2 <= 2.5`. `3 <= 2.5` No. i=2. Count += 2. Max `2/5`.
Total count: 4. Max `1/2`.
Count 4 >= K(3). Try smaller. `high = 0.5`.
BS `mid = 0.25`.
- Count will be smaller.
Eventually converges to `0.4` region. The `max fraction <= mid` tracked when we have count $\ge$ K might tricky?
Actually, we want smallest mid such that count(mid) >= K.
For that mid, the max fraction $\le$ mid is the answer.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Binary Search on value is very efficient. Track the "closest" fraction to `mid` during the counting process to retrieve the answer.
*Tìm kiếm Nhị phân trên giá trị rất hiệu quả. Theo dõi phân số "gần nhất" với `mid` trong quá trình đếm để lấy câu trả lời.*
