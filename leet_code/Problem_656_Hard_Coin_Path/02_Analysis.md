# Analysis for Coin Path
# *Phân tích cho bài toán Đường đi Xu tiền*

## 1. Problem Essence & Lexicographical Minimum Cost
## *1. Bản chất vấn đề & Chi phí tối thiểu theo Thứ tự từ điển*

### The Challenge
### *Thách thức*
We need to find a path from index 1 to index $n$ such that:
1.  The path has the minimum total cost of coins.
2.  Among paths with minimum cost, it is the one with the lexicographically smallest sequence of indices.
3.  Jumps are limited by `maxJump`, and any index with `-1` is blocked.

*Chúng ta cần tìm một đường đi từ chỉ số 1 đến $n$ sao cho: (1) Tổng chi phí xu là tối thiểu, (2) Trong các đường đi có chi phí tối thiểu, nó là đường đi nhỏ nhất theo thứ tự từ điển của các chỉ số, (3) Các bước nhảy bị giới hạn và các ô `-1` bị chặn.*

---

## 2. Strategy: Backward Dynamic Programming
## *2. Chiến lược: Quy hoạch động Ngược*

To handle the "lexicographically smallest" requirement efficiently, we can work **backwards** from the end (index $n$) to the beginning (index $1$).
*Để xử lý yêu cầu "nhỏ nhất theo thứ tự từ điển" một cách hiệu quả, chúng ta có thể làm việc **ngược** từ cuối (chỉ số $n$) về đầu (chỉ số $1$).*

### Logical Nuance
### *Sắc thái Logic*
Let $dp[i]$ be the minimum cost to reach index $n$ from index $i$.
If we go backwards:
- For each $i$, we look for a $j \in [i+1, i+maxJump]$ that minimizes $dp[j]$.
- If two indices $j_1 < j_2$ both give the same minimum cost $dp[j_1] = dp[j_2]$, choosing the smaller index $j_1$ will result in a lexicographically smaller sequence `[..., i, j1, ...]`.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** 
    - `long[] dp`: Set to a large value, except `dp[n] = coins[n]`.
    - `int[] next`: Stores the next index to jump to.
2.  **Iterate Backward (from $n-1$ down to 1):**
    * **Duyệt ngược:** *
    - If `coins[i] == -1`, skip.
    - For each `j` from `i + 1` up to `min(i + maxJump, n)`:
        - If `dp[j]` is reachable:
            - If `coins[i] + dp[j] < dp[i]`:
                - Update `dp[i] = coins[i] + dp[j]`.
                - `next[i] = j`.
            - If `coins[i] + dp[j] == dp[i]`: (Wait, in backward DP, the first match with a small `j` is already optimal).
3.  **Check Connectivity:** If `dp[1]` is still the large value, return an empty list.
4.  **Reconstruct Path:** Start at 1 and follow the `next` array pointers until reaching $n$.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Backward Direction:** This is the key "trick" for lexicographical problems. By deciding the local choice that affects the *earliest* parts of the path last (or thinking from end to start), we ensure the global lexicographical property.
    * **Hướng đi ngược:** Đây là "mẹo" then chốt cho các bài toán về thứ tự từ điển. Bằng cách làm việc từ cuối về đầu, chúng ta tự nhiên chọn được các chỉ số nhỏ nhất cho các vị trí sớm nhất trong chuỗi.*
*   **Precision:** Using `long` for DP prevents overflow when using large placeholder values.
    * **Độ chính xác:** Sử dụng kiểu `long` cho DP để ngăn chặn tràn số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \times \text{maxJump})$. Since both $N$ and `maxJump` are small ($\le 1000$ and $\le 100$), this is $O(10^5)$.
    * **Độ phức tạp thời gian:** $O(N \times \text{maxJump})$.*
*   **Space Complexity:** $O(N)$ for the DP and `next` arrays.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 2, 4, -1, 2], maxJump = 2
1. dp[5] = 2.
2. dp[4] = unreachable (-1).
3. dp[3]: j=4 (no), j=5 (yes). dp[3] = coins[3] + dp[5] = 4 + 2 = 6. next[3]=5.
4. dp[2]: j=3 (dp[3]=6), j=4 (no). dp[2] = 2 + 6 = 8. next[2]=3.
5. dp[1]: j=2 (dp[2]=8), j=3 (dp[3]=6). 
   - Option j=2: 1 + 8 = 9.
   - Option j=3: 1 + 6 = 7. (Min!)
   - dp[1] = 7. next[1]=3.
**Path Reconstruct:** 1 -> 3 -> 5.
**Result:** [1, 3, 5].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Lexicographical minimum path problems are often sensitive to the direction of construction. Backward DP is a robust technique to ensure the best choice at each step while satisfying the lexicographical requirement for indices.
*Các bài toán tìm đường đi nhỏ nhất theo thứ tự từ điển thường nhạy cảm với hướng xây dựng. DP ngược là một kỹ thuật mạnh mẽ để đảm bảo lựa chọn tốt nhất ở mỗi bước.*
---
*Hành trình tối ưu (Optimal path) không chỉ nằm ở đích đến, mà ở từng bước đi nhỏ nhất (Lexicographical order). Trong mê cung của các lựa chọn (maxJump), việc thấu hiểu hậu quả từ tương lai (Backward DP) giúp ta chọn được bước khởi đầu đúng đắn nhất. Dữ liệu dạy ta rằng bằng cách đi ngược từ kết quả (n) về nguyên nhân (1), ta có thể tìm thấy một con đường vừa tiết kiệm (Min cost) vừa tinh giản nhất.*
Optimal journey (Optimal path) lies not only in the destination, but in each smallest step (Lexicographical order). In the maze of choices (maxJump), understanding the consequences from the future (Backward DP) helps us choose the most correct starting step. Data teaches us that by going backwards from results (n) to causes (1), we can find a path that is both economical (Min cost) and most streamlined.
