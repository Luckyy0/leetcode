# Analysis for Fair Candy Swap
# *Phân tích cho bài toán Trao đổi Kẹo Công bằng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Alice and Bob want to swap one candy bar each so that they end up with the same total amount of candy.
*Alice và Bob muốn đổi một thanh kẹo mỗi người để cuối cùng cả hai có cùng tổng lượng kẹo.*

### KEY LOGIC
### *Logic chính*
Let $S_A$ be the sum of Alice's candy sizes and $S_B$ be the sum of Bob's candy sizes.
Let $x$ be the size Alice gives, and $y$ be the size Bob gives.
After the swap:
- Alice's new sum: $S_A - x + y$
- Bob's new sum: $S_B - y + x$

We want: $S_A - x + y = S_B - y + x$
$\Rightarrow 2y - 2x = S_B - S_A$
$\Rightarrow y = x + \frac{S_B - S_A}{2}$

Let $diff = \frac{S_B - S_A}{2}$. We need to find an $x$ in Alice's array and a $y$ in Bob's array such that $y = x + diff$.
*Gọi $S_A, S_B$ lần lượt là tổng kẹo của Alice và Bob. Gọi $x, y$ là kẹo Alice và Bob trao đổi. Ta có phương trình cân bằng dẫn đến: $y = x + \frac{S_B - S_A}{2}$. Gọi $diff = \frac{S_B - S_A}{2}$, ta cần tìm cặp $(x, y)$ thỏa mãn điều kiện này.*

---

## 2. Strategy: HashSet Lookup
## *2. Chiến lược: Tra cứu bằng HashSet*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Calculate Sums:** Compute total sizes $S_A$ and $S_B$.
    *   **Tính tổng:** Tính tổng kích thước kẹo $S_A$ và $S_B$.*

2.  **Calculate Target Difference:** $diff = (S_B - S_A) / 2$.
    *   **Tính chênh lệch mục tiêu:** $diff = (S_B - S_A) / 2$.*

3.  **Store Bob's Sizes:** Put all elements of `bobSizes` into a `HashSet` for $O(1)$ lookup.
    *   **Lưu kẹo của Bob:** Đưa tất cả các phần tử của `bobSizes` vào `HashSet` để tra cứu $O(1)$.*

4.  **Find Pair:** Iterate through `x` in `aliceSizes`. Check if the set contains $y = x + diff$. If found, return `[x, y]`.
    *   **Tìm cặp:** Duyệt qua `x` trong `aliceSizes`. Kiểm tra xem tập hợp có chứa $y = x + diff$ hay không. Nếu có, trả về `[x, y]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int sumA = 0, sumB = 0;
    for (int x : aliceSizes) sumA += x;
    for (int y : bobSizes) sumB += y;
    
    int diff = (sumB - sumA) / 2;
    Set<Integer> setB = new HashSet<>();
    for (int y : bobSizes) setB.add(y);
    
    for (int x : aliceSizes) {
        if (setB.contains(x + diff)) {
            return new int[]{x, x + diff};
        }
    }
    
    return new int[0];
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ and $M$ are lengths of the arrays. Calculating sums and filling the set are linear operations.
    *   **Độ phức tạp thời gian:** $O(N + M)$, các thao tác tính tổng và điền vào tập hợp là tuyến tính.*
*   **Space Complexity:** $O(M)$ to store Bob's sizes in a set.
    *   **Độ phức tạp không gian:** $O(M)$ để lưu kẹo của Bob vào tập hợp.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Calculating the required difference first transforms the problem into a simple 2-Sum variant (find target value in set).
*Việc tính toán sự chênh lệch cần thiết trước tiên sẽ chuyển đổi bài toán thành một biến thể đơn giản của bài toán 2-Sum (tìm giá trị mục tiêu trong tập hợp).*
