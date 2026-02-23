# Analysis for Valid Permutations for DI Sequence
# *Phân tích cho bài toán Các Hoán vị Hợp lệ cho Dãy DI*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a string of 'D' (decreasing) and 'I' (increasing) of length $N$, find the number of permutations of $0 \dots N$ that satisfy these relative order constraints.
*Cho một chuỗi gồm 'D' (giảm) và 'I' (tăng) có độ dài $N$, tìm số lượng hoán vị của $0 \dots N$ thỏa mãn các ràng buộc thứ tự tương đối này.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a Dynamic Programming problem.
- When placing the $i$-th number in the permutation (from a set of available numbers), the only thing that matters for the *next* step is the **relative rank** of the current number among the remaining available numbers.
- Let `dp[i][j]` be the number of valid permutations of length `i+1` (using a subset of `i+1` smallest numbers) such that the last element ends with relative rank `j`.
  - Here, `j` means the last element is the `j`-th smallest among the numbers used so far? No, simpler.
  - Better state: `dp[i][j]` is the number of valid sequences for `s[0...i-1]` using `0...i` where the last element is `j`. Wait, relative rank is better.
  - Standard DP state: `dp[i][j]` = number of permutations of size `i+1` satisfying `s[0...i-1]` ending with the element that has rank `j` among `0...i` (where `0 <= j <= i`).
*Đây là bài toán Quy hoạch Động. Khi đặt số thứ $i$, điều quan trọng duy nhất cho bước tiếp theo là **thứ hạng tương đối** của số đó trong các số còn lại. Đặt `dp[i][j]` là số lượng hoán vị hợp lệ độ dài `i+1` thỏa mãn `s[0...i-1]` mà kết thúc bằng phần tử có thứ hạng `j` trong `0...i`.*

---

## 2. Strategy: Dynamic Programming with Prefix Sum Optimization
## *2. Chiến lược: Quy hoạch Động với Tối ưu hóa Tổng tiền tố*

### Recurrence Relation
### *Hệ thức truy hồi*
Consider trying to form a permutation of `0...i`. We just placed `j` as the last element (rank `j` out of `i+1` elements).
- If `s[i-1] == 'D'`: We need the previous element (at `i-1`) to be **greater** than the current element (rank `j`).
  - The previous element must have had rank `k` such that `k >= j`. (Since `j` is now used, effectively it splits the ranks).
  - Actually, `dp[i][j] = sum(dp[i-1][k])` for `k` from `j` to `i-1`.
- If `s[i-1] == 'I'`: We need the previous element to be **smaller**.
  - `dp[i][j] = sum(dp[i-1][k])` for `k` from `0` to `j-1`.

Wait, let's refine the transition logic:
When we insert a new number (conceptually `i`) into a permutation of `0...i-1`:
- If we want the new number to have rank `j` (be the $(j+1)$-th smallest), then all previous numbers $\ge j$ get shifted up by 1.
- So if `s[i-1] == 'I'`, we need `prev < curr`. If `curr` has rank `j`, then `prev` must have had rank `k < j`.
  - `dp[i][j] += dp[i-1][k]` for `0 <= k < j`.
- If `s[i-1] == 'D'`, we need `prev > curr`. If `curr` has rank `j`, then `prev` (which was rank `k`) becomes rank `k+1` in the new set if `k >= j`. So we need `prev` to be effectively larger.
  - `dp[i][j] += dp[i-1][k]` for `j <= k <= i-1`.

Optimization: The sums are range sums. We can compute prefix sums of the previous row to do this in $O(1)$.
*Logic chuyển trạng thái: Nếu `s[i-1] == 'I'`, ta cần số trước nhỏ hơn số hiện tại (rank `j`). Vậy số trước phải có rank `k < j`. Nếu `s[i-1] == 'D'`, ta cần số trước lớn hơn. Vậy số trước phải có rank `k >= j`. Các tổng này là tổng đoạn, có thể dùng tổng tiền tố để tính trong $O(1)$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize DP:** `dp[0][0] = 1`. `N` is length of `s`. DP size `(N+1) x (N+1)`.
    *   **Khởi tạo:** `dp[0][0] = 1`.*

2.  **Iterate:** `i` from 1 to `N`.
    - If `s[i-1] == 'I'`:
        - `dp[i][j] = sum(dp[i-1][0...j-1])`.
    - If `s[i-1] == 'D'`:
        - `dp[i][j] = sum(dp[i-1][j...i-1])`.
    *   **Duyệt:** Tính `dp[i][j]` dựa trên tổng đoạn của hàng `i-1`.*

3.  **Result:** Sum of the last row `dp[N]`.
    *   **Kết quả:** Tổng của hàng cuối cùng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numPermsDISequence(String s) {
    int MOD = 1_000_000_007;
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];
    
    // Base case: length 1 permutation (just number 0), rank 0
    dp[0][0] = 1;
    
    for (int i = 1; i <= n; i++) {
        char c = s.charAt(i - 1);
        if (c == 'I') {
            // Increasing: current must be larger than prev
            // dp[i][j] = sum(dp[i-1][k]) for k < j
            int currentSum = 0;
            for (int j = 0; j <= i; j++) {
                 // For next j, sum includes more k's?
                 // No, standard loop:
                 // dp[i][j] = sum(dp[i-1][0]...dp[i-1][j-1])
                 // We can accumulate sum as we go.
                 if (j > 0) currentSum = (currentSum + dp[i-1][j-1]) % MOD;
                 dp[i][j] = currentSum;
            }
        } else {
            // Decreasing: current must be smaller than prev
            // dp[i][j] = sum(dp[i-1][k]) for k >= j
            int currentSum = 0;
            // Iterate backwards for easier suffix sum? Or accumulate normally.
            // Suffix sum:
            for (int k = i - 1; k >= 0; k--) {
                currentSum = (currentSum + dp[i-1][k]) % MOD;
                if (k + 1 <= i) dp[i][k] = currentSum; // wait, indices are tricky
            }
            // Let's redo range logic cleanly.
            // If D: dp[i][j] sum k from j to i-1.
            // So for j=i-1: sum k=i-1. dp[i][i-1] = dp[i-1][i-1]
            // For j=i-2: sum k=i-2, i-1. = dp[i-1][i-2] + dp[i-1][i-1]
            // So dp[i][j] = dp[i][j+1] + dp[i-1][j]
            
            // Correct logic for D:
            currentSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                currentSum = (currentSum + dp[i-1][j]) % MOD;
                dp[i][j] = currentSum;
            }
        }
    }
    
    int ans = 0;
    for (int x : dp[n]) {
        ans = (ans + x) % MOD;
    }
    return ans;
}
```

Wait, indices for D:
`dp[i][j]` needs sum from `k=j` to `i-1`.
My loop for D: `j` from `i-1` down to 0. `currentSum` accumulates `dp[i-1][j]`.
First iter `j=i-1`: `sum = dp[i-1][i-1]`. Sets `dp[i][i-1]`. Correct.
Last iter `j=0`: `sum = all`. Sets `dp[i][0]`. Correct.

Note: `dp[i][j]` is valid only for `0 <= j <= i`.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Two nested loops.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ (or $O(N)$ with 1D array optimization).
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using rank-based DP standardizes the permutation problem. The range sum optimization is crucial to bring it down from $O(N^3)$ to $O(N^2)$.
*Sử dụng DP dựa trên thứ hạng giúp chuẩn hóa bài toán hoán vị. Tối ưu hóa tổng đoạn là rất quan trọng để giảm độ phức tạp từ $O(N^3)$ xuống $O(N^2)$.*
