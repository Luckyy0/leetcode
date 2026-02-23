# Analysis for Nth Magical Number
# *Phân tích cho bài toán Số Kỳ ảo thứ N*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the $N$-th positive integer divisible by $a$ or $b$. Since $N \le 10^9$, we cannot iterate through numbers one by one.
*Tìm số nguyên dương thứ $N$ chia hết cho $a$ hoặc $b$. Vì $N \le 10^9$, chúng ta không thể duyệt qua từng số một.*

---

## 2. Strategy: Binary Search + Inclusion-Exclusion
## *2. Chiến lược: Tìm kiếm nhị phân + Bao hàm-Loại trừ*

### The Counting Formula
### *Công thức đếm*
The number of positive integers $\le X$ that are divisible by $a$ or $b$ is:
$$Count(X) = \lfloor \frac{X}{a} \rfloor + \lfloor \frac{X}{b} \rfloor - \lfloor \frac{X}{LCM(a, b)} \rfloor$$
where $LCM(a, b) = \frac{a \cdot b}{GCD(a, b)}$.
*Số lượng các số nguyên dương $\le X$ chia hết cho $a$ hoặc $b$ được tính theo nguyên lý Bao hàm-Loại trừ: chia hết cho $a$ + chia hết cho $b$ - chia hết cho cả hai (tức là chia hết cho BCNN).*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Calculate LCM:** Compute $L = LCM(a, b)$.
    *   **Tính BCNN:** Tính $L = BCNN(a, b)$.*

2.  **Binary Search on X:**
    - Range: `low = min(a, b)`, `high = N * min(a, b)`. (Wait, $N \cdot \min(a,b)$ could be $10^{14}$, need `long`).
    - Midpoint `mid`: Calculate `count = (mid / a) + (mid / b) - (mid / L)`.
    - If `count < n`: Need a larger number, `low = mid + 1`.
    - Else: Could be the answer, `high = mid`.
    *   **Tìm kiếm nhị phân trên X:** Phạm vi từ giá trị nhỏ nhất của $a, b$ đến $N \cdot \min(a, b)$. Tính `count` tại `mid`. Nếu `count < n`, tăng `low`. Ngược lại, thử giảm `high`.*

3.  **Result:** Return `low % (10^9 + 7)`.
    *   **Kết quả:** Trả về `low % (10^9 + 7)`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int nthMagicalNumber(int n, int a, int b) {
    long A = a, B = b;
    long l = (A * B) / gcd(A, B);
    
    long low = Math.min(A, B);
    long high = (long) n * Math.min(A, B);
    
    while (low < high) {
        long mid = low + (high - low) / 2;
        if (mid / A + mid / B - mid / l < n) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return (int) (low % 1_000_000_007);
}

private long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log(\text{target\_val}))$. The binary search runs roughly 60 iterations (for $10^{14}$). $GCD$ is logarithmic.
    *   **Độ phức tạp thời gian:** $O(\log(\text{giá\_trị\_ngưỡng}))$. Tìm kiếm nhị phân chạy khoảng 60 lượt.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Binary search is often the best choice when you can write an efficient "counting" function for a problem. Inclusion-Exclusion handles the overlaps between multiple criteria ($a$ and $b$).
*Tìm kiếm nhị phân thường là lựa chọn tốt nhất khi bạn có thể viết một hàm "đếm" hiệu quả. Nguyên lý Bao hàm-Loại trừ giúp xử lý phần chồng lấn giữa nhiều tiêu chí.*
