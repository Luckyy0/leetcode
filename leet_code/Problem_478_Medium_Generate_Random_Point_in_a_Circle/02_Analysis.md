# Analysis for Generate Random Point in a Circle
# *Phân tích cho bài toán Tạo Điểm Ngẫu nhiên trong Hình tròn*

## 1. Problem Essence & Inverse Transform Sampling
## *1. Bản chất vấn đề & Lấy mẫu Biến đổi Ngược*

### The Challenge
### *Thách thức*
Generating points uniformly in a circle.
- Naive Polar: `r = rand() * R`, `theta = rand() * 2PI`.
  - **Issue:** This clusters points near the center. The area near center (small r) is small, but gets same probability as area near edge (large r).
- We need the **Density Function** to be uniform with respect to **Area**.
  - Area $A = \pi r^2$.
  - We want $r$ such that the probability is proportional to $r^2$.
  - If $U$ is uniform in $[0, 1]$, then $r^2 \propto U  \implies r \propto \sqrt{U}$.
  - Correct formula: `r = R * sqrt(rand())`.

### Strategy: Polar Coordinates with Sqrt(R)
### *Chiến lược: Tọa độ Cực với Căn bậc hai(R)*

1.  **Angle:** $\theta = \text{random}(0, 2\pi)$.
2.  **Radius:** $r = \text{radius} \times \sqrt{\text{random}(0, 1)}$.
3.  **Conversion:**
    - $x = x\_center + r \cos(\theta)$
    - $y = y\_center + r \sin(\theta)$

### Alternative: Rejection Sampling
### *Phương án thay thế: Lấy mẫu Từ chối*

1.  Generate random point in bounding square $[x-R, x+R] \times [y-R, y+R]$.
2.  If $(x-x_c)^2 + (y-y_c)^2 \le R^2$, return it.
3.  Else, repeat.
    - Efficiency: Area of circle / Area of square = $\pi R^2 / (2R)^2 = \pi/4 \approx 0.785$. Very efficient.

---

## 2. Approach: Rejection Sampling
## *2. Hướng tiếp cận: Lấy mẫu Từ chối*

### Logic
### *Logic*
(See above). Rejection sampling is often simpler to implement and reason about (uniform square $\to$ uniform circle subset), avoiding potential sqrt/trig precision biases (though Sqrt method is analytically correct and slightly faster/deterministic in time). Let's implement Rejection Sampling for robustness and simplicity, or the math one for $O(1)$ guarantee. LeetCode usually accepts both. Let's provide the Math one as it's truly $O(1)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Time:** The math formula is constant time. Rejection sampling is expected constant time.
    *Thời gian O(1): Công thức toán học là thời gian hằng số. Lấy mẫu từ chối là thời gian hằng số kỳ vọng.*
*   **Correct Distribution:** Specifically addresses the "clustering at center" fallacy.
    *Phân phối đúng: Giải quyết triệt để lỗi ngụy biện "tụ tập tại tâm".*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** $R=1, Center=(0,0)$
1. `rand() = 0.25`, `theta_rand() = 0.5`.
2. $r = 1 \times \sqrt{0.25} = 0.5$.
3. $\theta = 0.5 \times 2\pi = \pi$.
4. $x = 0.5 \cos(\pi) = -0.5$.
5. $y = 0.5 \sin(\pi) = 0$.
Result: `[-0.5, 0]` (Uniformly distributed).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Polar coordinates with `sqrt(random())` for radius.
*Tọa độ cực với `sqrt(random())` cho bán kính.*
---
*Để tìm thấy sự công bằng (uniform distribution) trên một mặt phẳng tròn đầy, ta không thể chỉ đơn giản đi thẳng từ tâm ra rìa (linear radius). Vì không gian mở rộng theo bình phương khoảng cách, bước chân của ta cũng phải nhanh hơn (sqrt) khi hướng về phía ánh sáng bên ngoài. Sự phân phối đều đặn đòi hỏi một sự điều chỉnh phi tuyến tính (non-linear adjustment).*
To find fairness (Uniform Distribution) on a full round plane, we cannot simply go straight from the center to the edge (Linear Radius). Since space expands according to square of distance, our steps must also be faster (SQRT) when heading towards the outside light. Regular distribution requires a nonlinear adjustment.
