# Analysis for Water and Jug Problem
# *Phân tích cho bài toán Nước và Bình chứa*

## 1. Problem Essence & Bézout's Identity
## *1. Bản chất vấn đề & Định lý Bézout*

### The Challenge
### *Thách thức*
Measuring $Z$ liters using jugs of $X$ and $Y$ capacities.
This is a classic state-space search problem (can be solved by BFS), but there is a much more efficient mathematical insight.

### The Math: Linear Diophantine Equation
### *Toán học: Phương trình Diophantine Tuyến tính*
The total amount of water we can have in the system is always a linear combination of $X$ and $Y$:
$aX + bY = Z$
According to **Bézout's identity**, the equation $aX + bY = Z$ has integer solutions if and only if $Z$ is a multiple of $GCD(X, Y)$.

### Necessary Conditions:
### *Điều kiện Cần và Đủ:*
1.  $Z \le X + Y$. (Total water cannot exceed total capacity).
2.  $Z \% GCD(X, Y) == 0$.

---

## 2. Approach: GCD (Greatest Common Divisor)
## *2. Hướng tiếp cận: GCD (Ước chung lớn nhất)*

### Logic
### *Logic*
(See Math section above). Instead of simulating the pour/fill steps (which can be $10^6$ states), we simply calculate the GCD of the two capacities and check if the target is divisible by it.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(log min(X, Y)) Efficiency:** Calculating GCD using the Euclidean algorithm is extremely fast.
    *Hiệu quả O(log min(X, Y)): Tính GCD bằng thuật toán Euclid cực kỳ nhanh.*
*   **Mathematical Proof:** Guaranteed correctness based on number theory.
    *Chứng minh toán học: Đảm bảo tính chính xác dựa trên lý thuyết số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log(\min(X, Y)))$.
    *Độ phức tạp thời gian: $O(\log(\min(X, Y)))$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** $X=3, Y=5, Z=4$
1. Check: $4 \le 3 + 5$ (True).
2. $GCD(3, 5) = 1$.
3. Check: $4 \% 1 == 0$ (True).
Result: True.

**Input:** $X=2, Y=6, Z=5$
1. Check: $5 \le 2 + 6$ (True).
2. $GCD(2, 6) = 2$.
3. Check: $5 \% 2 == 1$ (False).
Result: False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Use Euclidean Algorithm for GCD check.
*Sử dụng Thuật toán Euclid để kiểm tra GCD.*

---

## 7. Deep Dive: Bézout's Identity
## *7. Thảo luận chuyên sâu: Định lý Bézout*

### The Core Principle
### *Nguyên lý cốt lõi*
This problem is a physical manifestation of **Bézout's identity**, which states that for any non-zero integers $x$ and $y$, the smallest positive value of $ax + by$ is $\gcd(x, y)$. Furthermore, any value that can be represented as $ax + by$ must be a multiple of $\gcd(x, y)$.
*Bài toán này là một minh chứng vật lý của **định lý Bézout**, định lý này phát biểu rằng với bất kỳ số nguyên $x$ và $y$ khác không nào, giá trị dương nhỏ nhất của $ax + by$ là $\gcd(x, y)$. Hơn nữa, bất kỳ giá trị nào có thể được biểu diễn dưới dạng $ax + by$ đều phải là bội số của $\gcd(x, y)$.*

### Why GCD?
### *Tại sao lại là GCD?*
Every action (filling, emptying, pouring) changes the total water by $\pm x$ or $\pm y$. Thus, the total water is always $ax + by$. If the target $z$ is not a multiple of the greatest common divisor of the capacities, it is mathematically impossible to reach it using these operations.
*Mỗi hành động (đong, đổ, làm trống) đều làm thay đổi tổng lượng nước một khoảng $\pm x$ hoặc $\pm y$. Do đó, tổng lượng nước luôn là $ax + by$. Nếu mục tiêu $z$ không phải là bội số của ước chung lớn nhất của các dung tích, thì về mặt toán học, không thể đạt được mục tiêu đó bằng các thao tác này.*
---
*Cuộc sống không phải lúc nào cũng là phép cộng và phép trừ đơn thuần. Đôi khi, để đạt được mục tiêu (target), ta cần tìm ra cái "gốc" chung (GCD) của những nguồn lực mình đang có. Nếu mục tiêu không hòa hợp với cái gốc đó, mọi nỗ lực đong đếm đều sẽ trở nên vô nghĩa.*
Life is not always pure addition and subtraction. Sometimes, to achieve a goal (target), we need to find the common "root" (GCD) of our resources. If the goal is not in harmony with that root, all efforts to measure will be in vain.
