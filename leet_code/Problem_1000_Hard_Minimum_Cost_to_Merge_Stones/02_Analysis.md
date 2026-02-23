# Analysis for Minimum Cost to Merge Stones
# *Phân tích cho bài toán Chi phí Tối thiểu để Gộp Đá*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum cost to merge $N$ piles of stones into exactly $1$ pile by merging exactly $K$ adjacent piles at a time.
*Tìm chi phí tối thiểu để gộp $N$ đống đá thành chính xác $1$ đống bằng cách gộp đúng $K$ đống liền kề mỗi lượt.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- **Feasibility:** Every time we merge $K$ piles into $1$, the total number of piles decreases by $K - 1$. To reach exactly $1$ pile from $N$ piles, the number of eliminated piles ($N - 1$) must be a multiple of ($K - 1$). If `(N - 1) % (K - 1) != 0`, it is impossible. Return `-1`.
- **Interval Dynamic Programming:** We want to find the optimal way to merge a subarray `stones[i...j]`.
- Let `dp[i][j]` be the minimum cost to merge `stones[i...j]` into its *minimum possible number of piles*.
- What is the minimum possible number of piles for length `L`? It is `(L - 1) % (K - 1) + 1`.
- To compute `dp[i][j]`, we can split the subarray `[i, j]` at some index `mid`. 
- To prevent overlapping states and invalid merges, we restrict the left part `[i, mid]` to be merged into exactly **1 pile**. This means the length of `[i, mid]` must satisfy `(mid - i) % (K - 1) == 0`. So `mid` simply jumps by `K - 1`.
- We find the best `mid`: `dp[i][j] = min(dp[i][mid] + dp[mid + 1][j])`.
- Finally, if the length of the entire `[i, j]` segment can be merged into **1 pile** (i.e., `(j - i) % (K - 1) == 0`), we are forced to perform one final merge on these $K$ resulting piles. The cost of this final merge is the sum of all stones in `stones[i...j]`. We add this sum to `dp[i][j]`.
*Khả năng gộp: Nếu `(N - 1) % (K - 1) != 0` thì không nối thành 1 đống được. Sử dụng Quy hoạch động theo Khoảng vói công thức DP chia khoảng thành 2 phần: phần trái bắt buộc gộp thành 1 đống, phần phải gộp thành số đống tối thiểu. Cuối cùng nếu cả đoạn `[i, j]` đủ điều kiện gộp, cộng thêm tổng nguyên gốc của khoảng.*

---

## 2. Strategy: Interval Dynamic Programming
## *2. Chiến lược: Quy hoạch Động Khoảng*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Check Feasibility:** `if ((n - 1) % (k - 1) != 0) return -1;`
    *   **Kiểm tra tính khả thi:** Nhanh chóng loại trừ bài toán không kết quả.*

2.  **Prefix Sums:** Compute array `prefix` where `prefix[i]` computes the sum of the first `i` stones. This allows $O(1)$ query for the sum of any subarray.
    *   **Mảng Cộng dồn:** Giúp tính tổng các viên đá trên đoạn `[i, j]` trong $O(1)$.*

3.  **Initialize DP Table:** `dp[n][n]` initialized to 0. Length sizes $< K$ cost 0.
    *   **Khởi tạo Bảng DP:** Các đoạn ngắn hơn K thì không tốn chi phí (vì không gộp được).*

4.  **DP Transitions:** 
    - Loop length `len` from `K` to `N`.
    - Loop start index `i` from `0` to `N - len`. End index `j = i + len - 1`.
    - Initialize `dp[i][j] = MAX_VALUE`.
    - Loop `mid = i; mid < j; mid += K - 1`:
      - `dp[i][j] = min(dp[i][j], dp[i][mid] + dp[mid + 1][j])`
    - Condition: `if ((j - i) % (k - 1) == 0)`, it means `[i, j]` forms exactly one pile. The cost of this step is the total stones:
      - `dp[i][j] += prefix[j + 1] - prefix[i]`
    *   **Chuyển đổi DP:** Thuật toán duyệt qua mọi độ dài và chia cắt. Khi tìm thấy giới hạn hợp lệ gộp thành 1 đống, bù trừ chi phí mảng tĩnh.*

5.  **Return Data:** Return `dp[0][N - 1]`.
    *   **Trả về dữ liệu:** Chi phí tối thiểu cho toàn mảng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        int[][] dp = new int[n][n];

        // Loop over lengths
        for (int len = k; len <= n; len++) {
            // Loop over start positions
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // mid jumps by k-1 to ensure left part [i, mid] can be merged into 1 pile
                for (int mid = i; mid < j; mid += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }
                
                // If the entire segment can be merged into 1 pile
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\frac{N^3}{K})$. There are $N^2$ states (subarrays). For each state, we iterate `mid` which jumps by $K-1$, taking about $O(\frac{N}{K})$ steps. Resulting in minimal total computation. Since $N \le 30$, this is less than 30,000 operations, astronomically fast.
    *   **Độ phức tạp thời gian:** $O(\frac{N^3}{K})$. Ở mức siêu thời gian thực với N bé.*
*   **Space Complexity:** $O(N^2)$ for the DP matrix. Memory fits easily into standard cached levels.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Interval DP is unequivocally the best strategy for problems combining consecutive substructures in optimal grouping. Limiting `mid` splits by $K-1$ elegantly solves the overlapping constraints. 
*Quy hoạch động dạng khoảng luôn luôn là lựa chọn hoàn hảo đối với các bài toán yêu cầu gộp cụm tuyến tính liên tiếp. Việc nhảy Mid theo công thức k-1 khéo léo giúp tránh sự chồng chéo trùng lặp khổng lồ.*
