# Analysis for Largest Sum of Averages
# *Phân tích cho bài toán Tổng các trung bình cộng lớn nhất*

## 1. Problem Essence & Optimal Substructure
## *1. Bản chất vấn đề & Cấu trúc con tối ưu*

### The Challenge
### *Thách thức*
We need to partition an array into $1$ to $K$ contiguous subarrays such that the sum of their averages is maximized. This is a classic optimization problem on a sequence, where the choice of splitting point at any step depends on the remaining elements and the remaining number of allowed partitions.
*Chúng ta cần chia một mảng thành từ $1$ đến $K$ mảng con liên tiếp sao cho tổng trung bình cộng của chúng là lớn nhất. Đây là một bài toán tối ưu hóa cổ điển trên một chuỗi, nơi việc lựa chọn điểm chia tại bất kỳ bước nào phụ thuộc vào các phần tử còn lại và số lượng mảng con còn lại được phép.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch động*

### DP State Definition
### *Định nghĩa trạng thái DP*
Let `dp[i][k]` be the maximum score achievable by partitioning the first `i` elements into exactly `k` subarrays.
*Gọi `dp[i][k]` là điểm số lớn nhất có thể đạt được bằng cách chia `i` phần tử đầu tiên thành đúng `k` mảng con.*

### Recurrence Relation
### *Công thức truy hồi*
To calculate `dp[i][k]`, we can look at all possible positions `j` (where `k-1 <= j < i`) for the last partition's start.
*Để tính `dp[i][k]`, chúng ta có thể xem xét tất cả các vị trí `j` khả thi (nơi `k-1 <= j < i`) cho điểm bắt đầu của mảng con cuối cùng.*

$$dp[i][k] = \max_{k-1 \le j < i} \{ dp[j][k-1] + \text{average}(nums[j \dots i-1]) \}$$

### Preprocessing
### *Tiền xử lý*
To calculate the average of a subarray `nums[j...i-1]` quickly, we can precompute the **prefix sums** of the array.
`average(nums[j...i-1]) = (prefixSum[i] - prefixSum[j]) / (i - j)`.
*Để tính trung bình cộng của mảng con `nums[j...i-1]` nhanh chóng, ta tính trước **tổng tiền tố (prefix sums)** của mảng.*

### Base Case
### *Trường hợp cơ bản*
- `dp[i][1]` is simply the average of the first `i` elements: `prefixSum[i] / i`.
*`dp[i][1]` đơn giản là trung bình cộng của `i` phần tử đầu tiên.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public double largestSumOfAverages(int[] nums, int k) {
    int n = nums.length;
    double[][] dp = new double[n + 1][k + 1];
    double[] sum = new double[n + 1];
    
    // Prefix sums
    for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
    
    // Base case: 1 group
    for (int i = 1; i <= n; i++) dp[i][1] = sum[i] / i;
    
    // DP for groups from 2 to k
    for (int groups = 2; groups <= k; groups++) {
        for (int i = 1; i <= n; i++) {
            // j is the end of the previous (groups-1) parts
            for (int j = groups - 1; j < i; j++) {
                double avgLast = (sum[i] - sum[j]) / (i - j);
                dp[i][groups] = Math.max(dp[i][groups], dp[j][groups - 1] + avgLast);
            }
        }
    }
    
    return dp[n][k];
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot N^2)$, where $N$ is the array length and $K$ is the number of partitions. With $N=100, K=100$, this is $100^3 = 1,000,000$, which is very efficient.
    *   **Độ phức tạp thời gian:** $O(K \cdot N^2)$, với $N$ là độ dài mảng và $K$ là số lượng phân đoạn. Với $N=100, K=100$, mất khoảng 1,000,000 phép tính.*
*   **Space Complexity:** $O(K \cdot N)$ for the DP table. Can be optimized to $O(N)$ because the current state `groups` only depends on `groups-1`.
    *   **Độ phức tạp không gian:** $O(K \cdot N)$ cho bảng DP. Có thể tối ưu xuống $O(N)$ vì trạng thái của `groups` chỉ phụ thuộc vào `groups-1`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `nums = [9,1,2,3,9], k = 3`
1. `dp[i][1]` (Averages for 1 group):
   - [9]: 9.0
   - [9,1]: 5.0
   - [9,1,2]: 4.0
2. `dp[i][2]` (Averages for 2 groups):
   - `dp[2][2] = dp[1][1] + avg(1) = 9 + 1 = 10`
   - `dp[5][2]`...
3. `dp[n][3]` finally finds the split `[9], [1,2,3], [9]` giving `9 + 2 + 9 = 20`.
**Result:** 20.0

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Dynamic Programming is the ideal choice for this partitioning problem due to its optimal substructure. Using prefix sums allows $O(1)$ calculation of subarray averages, leading to an overall efficient $O(K \cdot N^2)$ solution.
*Quy hoạch động là lựa chọn lý tưởng cho bài toán phân chia này nhờ cấu trúc con tối ưu của nó. Việc sử dụng tổng tiền tố cho phép tính trung bình cộng mảng con trong $O(1)$, dẫn đến giải pháp $O(K \cdot N^2)$ cực kỳ hiệu quả.*
