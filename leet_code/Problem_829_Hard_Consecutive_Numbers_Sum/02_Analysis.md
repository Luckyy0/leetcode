# Analysis for Consecutive Numbers Sum
# *Phân tích cho bài toán Tổng của các số liên tiếp*

## 1. Problem Essence & Algebraic Approach
## *1. Bản chất vấn đề & Tiếp cận Đại số*

### THE CHALLENGE
### *Thách thức*
We need to find how many ways an integer `N` can be expressed as a sum of $k$ consecutive positive integers.
Let the consecutive integers be $a+1, a+2, \dots, a+k$ where $a \ge 0$.
The sum is:
$$(a+1) + (a+2) + \dots + (a+k) = ka + \frac{k(k+1)}{2} = N$$
*Chúng ta cần tìm xem có bao nhiêu cách biểu diễn số nguyên `N` dưới dạng tổng của $k$ số nguyên dương liên tiếp. Gọi các số đó là $a+1, a+2, \dots, a+k$. Tổng là $ka + k(k+1)/2 = N$.*

---

## 2. Strategy: Solving for $a$
## *2. Chiến lược: Giải tìm $a$*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Rearrange the Equation:**
    $$ka = N - \frac{k(k+1)}{2}$$
    For a valid $a \ge 0$, we need:
    - $(N - \frac{k(k+1)}{2})$ must be divisible by $k$ (i.e., $(N - \frac{k(k+1)}{2}) \pmod k == 0$).
    - $N - \frac{k(k+1)}{2} \ge 0$.
    *   **Biến đổi phương trình:** $ka = N - k(k+1)/2$. Để $a$ là số nguyên dương $\ge 0$ hợp lệ: Hiệu phải chia hết cho $k$ và hiệu đó phải $\ge 0$.*

2.  **Determine Range of $k$:**
    As $k$ increases, $k(k+1)/2$ increases. We stop when $k(k+1)/2 > N$. This means $k \approx \sqrt{2N}$.
    *   **Xác định phạm vi $k$:** Khi $k$ tăng, giá trị $k(k+1)/2$ cũng tăng. Ta dừng lại khi nó lớn hơn $N$. Tức là $k$ vào khoảng $\sqrt{2N}$.*

3.  **Iteration:**
    - Loop through $k = 1, 2, 3, \dots$ as long as $k(k+1)/2 \le N$.
    - Check the divisibility condition.
    - Increment answer if condition is met.
    *   **Vòng lặp:** Duyệt qua $k = 1, 2, 3, \dots$. Kiểm tra điều kiện chia hết. Nếu thỏa mãn thì tăng kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int consecutiveNumbersSum(int n) {
    int count = 0;
    // Solve: ka + k(k+1)/2 = n
    // ka = n - k(k+1)/2
    for (int k = 1; k * (k + 1) / 2 <= n; k++) {
        if ((n - k * (k + 1) / 2) % k == 0) {
            count++;
        }
    }
    return count;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sqrt{N})$. The loop terminates when $k^2 \approx 2N$. For $N=10^9$, this is about 45,000 operations.
    *   **Độ phức tạp thời gian:** $O(\sqrt{N})$. Vòng lặp dừng lại khi $k^2 \approx 2N$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `n = 15`
1. k=1: $15 - 1(2)/2 = 14$. 14 % 1 == 0. (Count=1, 15=15)
2. k=2: $15 - 2(3)/2 = 12$. 12 % 2 == 0. (Count=2, 15=7+8)
3. k=3: $15 - 3(4)/2 = 9$. 9 % 3 == 0. (Count=3, 15=4+5+6)
4. k=4: $15 - 4(5)/2 = 5$. 5 % 4 != 0. 
5. k=5: $15 - 5(6)/2 = 0$. 0 % 5 == 0. (Count=4, 15=1+2+3+4+5)
6. k=6: $6(7)/2 = 21 > 15$. Stop.
**Result:** 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Mathematics is extremely efficient for this problem. Instead of trying to find the sum using sliding windows ($O(N)$), solving the arithmetic series formula reduces the search space to $O(\sqrt{N})$.
*Toán học cực kỳ hiệu quả cho bài toán này. Thay vì dùng cửa sổ trượt ($O(N)$), việc giải công thức cấp số cộng giúp giảm không gian tìm kiếm xuống $O(\sqrt{N})$.*
