# Analysis for Mirror Reflection
# *Phân tích cho bài toán Phản xạ Gương*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A laser bounces inside a square room $[0, p] \times [0, p]$. We start at $(0, 0)$ and go to $(p, q)$. We need to determine which receptor $(0, p), (p, p), \text{ or } (p, 0)$ it hits first. Simulating reflections is possible but mathematically complex.
*Một tia laser nảy bên trong phòng hình vuông $[0, p] \times [0, p]$. Chúng ta bắt đầu tại $(0, 0)$ và đi tới $(p, q)$. Chúng ta cần xác định xem nó chạm vào bộ thu nào: $(0, p), (p, p), \text{ hoặc } (p, 0)$ trước tiên. Mô phỏng các phản xạ là khả thi nhưng phức tạp về mặt toán học.*

---

## 2. Strategy: Unfolding the Reflections
## *2. Chiến lược: Mở rộng các phản xạ*

### Key Insight
### *Nhận thức chính*
Instead of reflecting the ray back into the original square, we can think of the ray traveling in a straight line through an infinite grid of identical $p \times p$ squares.
*Thay vì phản xạ tia laser ngược lại vào hình vuông ban đầu, chúng ta có thể coi tia laser di chuyển trên một đường thẳng xuyên qua một lưới vô hạn các hình vuông $p \times p$ giống hệt nhau.*

The ray travels $(x, y) = (k \cdot p, m \cdot q)$. It hits a receptor when both coordinates are multiples of $p$.
*Tia laser di chuyển theo $(x, y) = (k \cdot p, m \cdot q)$. Nó chạm vào một bộ thu khi cả hai tọa độ là bội số của $p$.*

This occurs at the least common multiple (LCM) of $p$ and $q$. Let $n \cdot p = m \cdot q$.
*Điều này xảy ra tại bội chung nhỏ nhất (BCNN) của $p$ và $q$. Gọi $n \cdot p = m \cdot q$.*

### Logic to identify Receptor:
- If $m$ is even: The ray hits the left wall (where receptors are 2). Since it's even, it must be the left wall.
- If $m$ is odd: The ray hits the right wall (where receptors are 0 or 1).
- If $n$ is even: The ray is at the bottom (y = 0 or 2p...).
- If $n$ is odd: The ray is at the top (y = p or 3p...).

Summarized Receptors:
- $m$ even, $n$ odd: Receptor 2 (Left wall, Top)
- $m$ odd, $n$ odd: Receptor 1 (Right wall, Top)
- $m$ odd, $n$ even: Receptor 0 (Right wall, Bottom)
Note: $m$ and $n$ cannot both be even (divide both by GCD).
*Logic xác định Bộ thu:*
*- Nếu $m$ chẵn: Tia chạm tường trái. (Bộ thu 2).*
*- Nếu $m$ lẻ: Tia chạm tường phải.*
*- Nếu $n$ chẵn: Tia ở phía dưới.*
*- Nếu $n$ lẻ: Tia ở phía trên.*
*Tóm tắt bộ thu: $m$ chẵn $n$ lẻ -> 2; $m$ lẻ $n$ lẻ -> 1; $m$ lẻ $n$ chẵn -> 0. Lưu ý: $m$ và $n$ không thể cùng chẵn (chia cả hai cho ƯCLN).*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int mirrorReflection(int p, int q) {
    while (p % 2 == 0 && q % 2 == 0) {
        p /= 2;
        q /= 2;
    }
    if (p % 2 == 0) return 2;
    if (q % 2 == 0) return 0;
    return 1;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log(\min(p, q)))$ for the GCD reduction loop.
    *   **Độ phức tạp thời gian:** $O(\log(\min(p, q)))$ cho vòng lặp giảm theo ƯCLN.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Unfolding is a powerful technique for reflection problems in geometry. Checking parity of the simplified dimensions is the fastest solution.
*Mở rộng (Unfolding) là một kỹ thuật mạnh mẽ cho các bài toán phản xạ trong hình học. Kiểm tra tính chẵn lẻ của các kích thước đã thu gọn là giải pháp nhanh nhất.*
