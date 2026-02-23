# Analysis for Super Egg Drop
# *Phân tích cho bài toán Thả Trứng Siêu đẳng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given `k` eggs and `n` floors, find the minimum number of moves required to determine the highest safe floor `f` in the worst case.
*Cho `k` quả trứng và `n` tầng, tìm số bước di chuyển tối thiểu cần thiết để xác định tầng an toàn cao nhất `f` trong trường hợp xấu nhất.*

### KEY INSIGHT
### *Nhận xét quan trọng*
Instead of calculating "minimum moves for `n` floors" (which is slow $O(KN^2)$), we can invert the problem: **"Given `m` moves and `k` eggs, what is the maximum number of floors we can check?"**
*Thay vì tính "số bước tối thiểu cho `n` tầng" (vốn chậm $O(KN^2)$), chúng ta có thể đảo ngược vấn đề: **"Cho `m` bước và `k` quả trứng, số tầng tối đa chúng ta có thể kiểm tra là bao nhiêu?"***

---

## 2. Strategy: Reversal + Dynamic Programming
## *2. Chiến lược: Đảo ngược + Quy hoạch động*

### Recurrence Relation
### *Hệ thức truy hồi*
Let `dp[m][k]` be the maximum number of floors checkable with `m` moves and `k` eggs.
Suppose we drop an egg. Two outcomes are possible:
1.  **Egg Breaks:** We use 1 move and 1 egg. We can check `dp[m-1][k-1]` floors below.
2.  **Egg Survives:** We use 1 move and keep `k` eggs. We can check `dp[m-1][k]` floors above.
3.  **Current Floor:** Plus the floor we just tested.

So, `dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1`.
*Gọi `dp[m][k]` là số tầng tối đa kiểm tra được với `m` bước và `k` trứng. Ném trứng: 1. Vỡ: Kiểm tra được `dp[m-1][k-1]` tầng dưới. 2. Không vỡ: Kiểm tra được `dp[m-1][k]` tầng trên. 3. Cộng thêm tầng hiện tại. Vậy `dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1`.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize DP:** Create an array `dp` of size `k + 1` filled with 0.
    *   **Khởi tạo DP:** Tạo mảng `dp` kích thước `k + 1` điền số 0.*

2.  **Iterate Moves:** Increment total moves `m` starting from 1.
    *   **Duyệt số bước:** Tăng tổng số bước `m` bắt đầu từ 1.*

3.  **Update DP:** For each move, update `dp` array backwards from `k` down to 1:
    - `dp[i] = dp[i] + dp[i-1] + 1`.
    *   **Cập nhật DP:** Với mỗi bước, cập nhật mảng `dp` ngược từ `k` về 1.*

4.  **Check Condition:** If `dp[k] >= n`, then `m` is the answer. Return `m`.
    *   **Kiểm tra điều kiện:** Nếu `dp[k] >= n`, thì `m` là đáp án. Trả về `m`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int superEggDrop(int k, int n) {
    int[] dp = new int[k + 1];
    int m = 0;
    while (dp[k] < n) {
        m++;
        for (int i = k; i >= 1; i--) {
            dp[i] = dp[i] + dp[i - 1] + 1;
        }
    }
    return m;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot M)$, where $M$ is the answer (number of moves). In the worst case ($K=1$), $M=N$. In the best case ($K$ large), $M \approx \log_2 N$. Since $N=10000$, this is extremely fast.
    *   **Độ phức tạp thời gian:** $O(K \cdot M)$. Với $K=1$, $M=N$. Với $K$ lớn, $M \approx \log_2 N$. Rất nhanh.*
*   **Space Complexity:** $O(K)$ for the DP array.
    *   **Độ phức tạp không gian:** $O(K)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Inverting the problem from "minimize cost for fixed input" to "maximize output for fixed cost" is a powerful technique for optimization problems involving monotonic functions.
*Đảo ngược vấn đề từ "tối thiểu hóa chi phí cho đầu vào cố định" sang "tối đa hóa đầu ra cho chi phí cố định" là một kỹ thuật mạnh mẽ cho các bài toán tối ưu hóa liên quan đến các hàm đơn điệu.*
