# Analysis for Total Hamming Distance
# *Phân tích cho bài toán Tổng Khoảng cách Hamming*

## 1. Problem Essence & Column-wise Contribution
## *1. Bản chất vấn đề & Đóng góp theo Cột*

### The Challenge
### *Thách thức*
Calculating the sum of Hamming distances for all pairs.
- Naive approach: Iterate all pairs $(i, j)$, calculate `bitCount(nums[i] ^ nums[j])`.
- Complexity: $O(N^2 \cdot \log W)$. With $N=10^4$, $N^2 = 10^8$. This might TLE or be very slow. We need something faster, ideally linear in $N$.

### Strategy: Bit-wise Vertical Counting
### *Chiến lược: Đếm dọc theo Bit*

1.  **Independent Bits:** The Hamming distance contribution of the $k$-th bit is independent of other bits.
2.  **Logic:**
    - For the $k$-th bit position, suppose there are `c` numbers with bit `1` and `N - c` numbers with bit `0`.
    - Any pair formed by a number with `1` and a number with `0` will contribute exactly **1** to the total Hamming distance for this bit position.
    - Pairs `(1, 1)` and `(0, 0)` contribute 0.
    - Total contribution of $k$-th bit: `c * (N - c)`.
3.  **Algorithm:**
    - Iterate from $k = 0$ to 31.
    - Count how many numbers set the $k$-th bit (`ones`).
    - Add `ones * (N - ones)` to the result.

---

## 2. Approach: Combinatorial Bit Counting
## *2. Hướng tiếp cận: Đếm Bit Tổ hợp*

### Logic
### *Logic*
(See above). This reduces the problem from "summing pairwise differences" to "summing column-wise contributions".

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** We iterate 32 times (constant) over N numbers. Total $32N$.
    *Hiệu quả O(N): Chúng ta lặp 32 lần (hằng số) qua N số. Tổng cộng 32N.*
*   **Space Efficient:** $O(1)$.
    *Hiệu quả không gian: O(1).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot W)$ where $W=32$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[4, 14, 2]` -> `0100`, `1110`, `0010`.
1. **Bit 0:** `0, 0, 0`. `ones=0, zeros=3`. Contrib `0*3 = 0`.
2. **Bit 1:** `0, 1, 1`. `ones=2, zeros=1`. Contrib `2*1 = 2`.
3. **Bit 2:** `1, 1, 0`. `ones=2, zeros=1`. Contrib `2*1 = 2`.
4. **Bit 3:** `0, 1, 0`. `ones=1, zeros=2`. Contrib `1*2 = 2`.
Total = $0+2+2+2 = 6$. Matches example.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Count set bits at each position and multiply `ones * zeros`.
*Đếm các bit 1 tại mỗi vị trí và nhân `số lượng 1 * số lượng 0`.*
---
*Tổng thể (total hamming distance) được tạo nên từ những sự khác biệt nhỏ nhất. Thay vì nhìn vào sự xung đột của từng cá nhân (pairwise), ta hãy nhìn vào bức tranh toàn cảnh của từng khía cạnh (column-wise). Ở mỗi vị trí, sự đa dạng (mix of 0s and 1s) chính là nguồn gốc của khoảng cách. Khi hiểu được cấu trúc dọc này, bài toán phức tạp $O(N^2)$ bỗng trở nên đơn giản và thanh lịch trong $O(N)$.*
The total (Total Hamming Distance) is made up of the smallest differences. Instead of looking at the conflict of each individual (pairwise), let look at the panoramic picture of each aspect (Column-wise). At each position, diversity (mix of 0s and 1s) is the source of distance. Understanding this vertical structure, the complex problem $O(N^2)$ suddenly becomes simple and elegant in $O(N)$.
