# Analysis for X of a Kind in a Deck of Cards
# *Phân tích cho bài toán X quân bài cùng loại trong bộ bài*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We have a deck of cards. We want to partition it into groups of size `X >= 2`. Each group must consist of cards with the same number.
*Chúng ta có một bộ bài. Chúng ta muốn chia nó thành các nhóm có kích thước `X >= 2`. Mỗi nhóm phải bao gồm các lá bài có cùng số.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Let the count of each card number be $C_1, C_2, \dots, C_k$.
- We need to find an integer $X \ge 2$ such that every $C_i$ is divisible by $X$.
- In other words, $X$ must be a common divisor of all counts $C_1, \dots, C_k$.
- To maximize the chance of finding such an $X$, we should look for the **Greatest Common Divisor (GCD)** of all counts.
- If $g = \text{GCD}(C_1, C_2, \dots, C_k) \ge 2$, then we can choose $X = g$ (or any divisor of $g$ that is $\ge 2$).
- If $g < 2$ (i.e., $g=1$), then no such $X$ exists.
*Giả sử số lượng của mỗi loại bài là $C_1, C_2, \dots, C_k$. Ta cần tìm số nguyên $X \ge 2$ sao cho mọi $C_i$ đều chia hết cho $X$. Tức là $X$ phải là ước chung của tất cả các $C_i$. Ta tìm Ước chung lớn nhất (GCD) của tất cả các số lượng. Nếu GCD $\ge 2$, trả về true, ngược lại false.*

---

## 2. Strategy: Count Frequencies + GCD
## *2. Chiến lược: Đếm tần suất + GCD*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Frequencies:** Use a HashMap or an array (since values are small, array is fine) to count occurrences of each card.
    *   **Đếm tần suất:** Dùng HashMap hoặc mảng để đếm số lần xuất hiện của mỗi lá bài.*

2.  **Calculate GCD:**
    - Initialize `g = -1` (or 0).
    - Iterate through all non-zero counts.
    - `g = gcd(g, count)`.
    *   **Tính GCD:** Khởi tạo `g`. Duyệt qua các số đếm khác 0 và cập nhật `g` bằng `gcd(g, count)`.*

3.  **Check Result:** Return `g >= 2`.
    *   **Kiểm tra kết quả:** Trả về `g >= 2`.*

### GCD Function
### *Hàm GCD*
Standard Euclidean algorithm: `gcd(a, b) = (b == 0) ? a : gcd(b, a % b)`.

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean hasGroupsSizeX(int[] deck) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int c : deck) {
        count.put(c, count.getOrDefault(c, 0) + 1);
    }
    
    int g = -1;
    for (int c : count.values()) {
        if (g == -1) {
            g = c;
        } else {
            g = gcd(g, c);
        }
    }
    
    return g >= 2;
}

private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log (\max C))$, where $N$ is deck size. Iterating counts is bounded by $N$. GCD is fast.
    *   **Độ phức tạp thời gian:** $O(N \log (\max C))$.*
*   **Space Complexity:** $O(N)$ for counting map.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple application of GCD properties. Counting frequencies is the first necessary step.
*Ứng dụng đơn giản của các tính chất GCD. Đếm tần suất là bước cần thiết đầu tiên.*
