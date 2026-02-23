# Analysis for K-th Symbol in Grammar
# *Phân tích cho bài toán Ký tự thứ K trong Văn phạm*

## 1. Problem Essence & Recursion
## *1. Bản chất vấn đề & Đệ quy*

### The Pattern
### *Mẫu hình*
Row 1: `0`
Row 2: `01`
Row 3: `0110`
Row 4: `01101001`
Observation: The first half of Row `N` is identical to Row `N-1`. The second half is the **complement** (inverse) of Row `N-1`.
*Quan sát: Nửa đầu của Hàng `N` giống hệt Hàng `N-1`. Nửa sau là **phần bù** (đảo ngược) của Hàng `N-1`.*

Alternatively:
- `0` spawns `01`. Parent is at index `(K+1)/2`.
- If parent is 0: left child is 0, right is 1.
- If parent is 1: left child is 1, right is 0.
*Hoặc: `0` sinh ra `01`. Cha nằm ở chỉ số `(K+1)/2`. Nếu cha là 0: con trái 0, phải 1. Nếu cha 1: con trái 1, phải 0.*

Even simpler:
- If `K` is in the first half of the row size ($2^{N-2}$), it's the same as the symbol in row `N-1` at `K`.
- If `K` is in the second half, it is `NOT` the symbol in row `N-1` at `K - half_size`.
*Đơn giản hơn: Nếu `K` nằm trong nửa đầu, nó giống ký tự ở hàng `N-1` tại `K`. Nếu `K` nằm ở nửa sau, nó là **phần bù** của ký tự ở hàng `N-1` tại `K - nửa_kích_thước`.*

---

## 2. Strategy: Recursive Bit Logic
## *2. Chiến lược: Logic Bit Đệ quy*

### Algorithm
### *Thuật toán*

1.  **Base Case:** If `n == 1` (or `k == 1`), return `0`.
    *   **Trường hợp cơ sở:** Nếu `n == 1` (hoặc `k == 1`), trả về `0`.*

2.  **Recursive Step:**
    - Length of current row is $2^{N-1}$. Mid is $2^{N-2}$.
    - If `k <= mid`: return `kthGrammar(n-1, k)`.
    - If `k > mid`: return `1 - kthGrammar(n-1, k - mid)`.
    *   **Bước Đệ quy:** Nếu `k <= mid`: trả về đệ quy nửa trái. Nếu `k > mid`: trả về 1 trừ đệ quy nửa phải.*

### Bit Count Trick
### *Mẹo Đếm Bit*
Actually, the sequence is related to the number of set bits in `K-1`.
`0`: 0 bits -> 0
`1`: 1 bit -> 1
`2`: 1 bit -> 1
`3`: 2 bits -> 0
Is it `bitCount(K-1) % 2`?
Let's check Row 4: `0 1 1 0 1 0 0 1`
Indices (0-based):
0: 0 -> 0 (Even bits)
1: 1 -> 1 (Odd bits)
2: 1 -> 1 (Odd bits)
3: 2 -> 0 (Odd bits?? Wait 3 is 11, 2 bits. Even). So 0.
4: 1 -> 1.
5: 2 -> 0.
6: 2 -> 0.
7: 3 -> 1.
It seems: Result is `Integer.bitCount(k-1) % 2`?
Wait, `3` (index) is `11` binary (2 bits). Result is 0. Parity even -> 0.
`2` (index) is `10` binary (1 bit). Result is 1. Parity odd -> 1.
Yes! The value is `bitCount(K-1) % 2`.
*Thực tế, kết quả chính là `Integer.bitCount(k-1) % 2`.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ with bit trick, or $O(N)$ with recursion.
    *   **Độ phức tạp thời gian:** $O(1)$ hoặc $O(N)$.*
*   **Space Complexity:** $O(1)$ or $O(N)$ stack.
    *   **Độ phức tạp không gian:** $O(1)$ hoặc $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**N=3, K=3**
Row 3: `0110`. K=3 is `1` (1-based index 3, 0-based 2).
Recurse:
Mid = 2 ($2^{3-2}$).
3 > 2. Second half. Invert result of `kth(N-1, 3-2=1)`.
`kth(2, 1)`: 1 <= 1. First half. Same as `kth(1, 1)`.
`kth(1, 1)`: Base case 0.
Backtrack: `kth(2, 1) = 0`.
Backtrack: `kth(3, 3) = 1 - 0 = 1`.
Result: 1.

Bit check: `K-1 = 2` -> `10`. Bits = 1. Odd. Result 1. Matches.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Use the recursion logic for clarity, or bit count for speed/elegance.
*Sử dụng logic đệ quy để rõ ràng, hoặc đếm bit để nhanh/gọn.*
