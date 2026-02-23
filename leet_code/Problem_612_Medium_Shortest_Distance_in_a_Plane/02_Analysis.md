# Analysis for Shortest Distance in a Plane
# *Phân tích cho bài toán Khoảng cách Ngắn nhất trên Mặt phẳng*

## 1. Problem Essence & Cartesian Distance
## *1. Bản chất vấn đề & Khoảng cách Descartes*

### The Challenge
### *Thách thức*
We need to find the minimum distance between any two distinct points $(x, y)$ in a 2D plane.
*Chúng ta cần tìm khoảng cách nhỏ nhất giữa hai điểm phân biệt bất kỳ $(x, y)$ trên mặt phẳng 2D.*

The key formula is the Euclidean distance: $\sqrt{(x_2-x_1)^2 + (y_2-y_1)^2}$.
*Công thức then chốt là khoảng cách Euclidean: $\sqrt{(x_2-x_1)^2 + (y_2-y_1)^2}$.*

---

## 2. Strategy: Cross Join with Exclusion
## *2. Chiến lược: Phép nối chéo kèm Loại trừ*

To compare every point with every other point, we perform a self-join.
*Để so sánh mọi điểm với mọi điểm khác, chúng ta thực hiện phép tự nối (self-join).*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Cross Join:** Join the `Point2D` table with itself (let's call them `p1` and `p2`).
    * **Nối chéo:** Nối bảng `Point2D` với chính nó (gọi chúng là `p1` và `p2`).*

2.  **Filter Identical Points:** We must ensure we don't calculate the distance from a point to itself (which would be 0).
    * **Lọc các điểm trùng nhau:** Chúng ta phải đảm bảo không tính khoảng cách từ một điểm đến chính nó (kết quả sẽ là 0).*
    - Condition: `p1.x != p2.x OR p1.y != p2.y`.
    - *Điều kiện: `p1.x != p2.x OR p1.y != p2.y`.*

3.  **Distance Calculation:** Apply the formula `SQRT(POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2))`.
    * **Tính toán Khoảng cách:** Áp dụng công thức `SQRT(POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2))`.*

4.  **Aggregation:** Wrap the calculation in `MIN()` to find the smallest value.
    * **Tổng hợp:** Bao bọc phép tính trong `MIN()` để tìm giá trị nhỏ nhất.*

5.  **Rounding:** Use `ROUND(..., 2)`.
    * **Làm tròn:** Sử dụng `ROUND(..., 2)`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Self-Join Complexity:** A cross join on $N$ points results in $N^2$ comparisons. For large datasets, this can be slow. However, for LeetCode SQL constraints, it typically passes.
    * **Độ phức tạp của Tự nối:** Phép nối chéo trên $N$ điểm dẫn đến $N^2$ phép so sánh. Với tập dữ liệu lớn, việc này có thể chậm. Tuy nhiên, với các ràng buộc của LeetCode SQL, nó thường vượt qua được.*
*   **Unique Pairs:** Technically, distance $(A, B) = (B, A)$. A more efficient filter would be `p1.x < p2.x OR (p1.x = p2.x AND p1.y < p2.y)` to avoid calculating the same pair twice, but `!=` is simpler to write.
    * **Các cặp duy nhất:** Về mặt kỹ thuật, khoảng cách $(A, B) = (B, A)$. Một bộ lọc hiệu quả hơn sẽ là `p1.x < p2.x OR (p1.x = p2.x AND p1.y < p2.y)` để tránh tính cùng một cặp hai lần, nhưng `!=` thì viết đơn giản hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the number of points. Every point is compared with every other point.
    * **Độ phức tạp thời gian:** $O(N^2)$, trong đó $N$ là số lượng điểm. Mỗi điểm được so sánh với mọi điểm khác.*
*   **Space Complexity:** $O(N^2)$ during the join phase as the database creates intermediate rows.
    * **Độ phức tạp không gian:** $O(N^2)$ trong giai đoạn nối khi cơ sở dữ liệu tạo ra các hàng trung gian.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Points:** A(-1,-1), B(0,0), C(-1,-2)
- dist(A,B) = $\sqrt{1^2 + 1^2} = 1.41$
- dist(A,C) = $\sqrt{0^2 + 1^2} = 1.00$
- dist(B,C) = $\sqrt{1^2 + 2^2} = 2.23$
**Min:** 1.00.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For proximity problems involving all-pairs comparison, self-joins are the standard approach. Always remember to filter out self-comparisons to avoid trivial zero results.
*Đối với các bài toán về độ gần gũi liên quan đến so sánh mọi cặp, tự nối là cách tiếp cận tiêu chuẩn. Luôn nhớ lọc bỏ các phép tự so sánh để tránh các kết quả bằng 0 không mong muốn.*
---
*Mọi hành trình (Distance) đều bắt đầu từ một điểm tựa. Trong không gian hai chiều rộng lớn, chính những mối liên kết gần gũi nhất (Shortest distance) mới tạo nên sự bền chặt của cấu trúc. Dữ liệu nhắc nhở ta rằng sự gắn kết không nằm ở độ phủ rộng, mà ở khoảng cách giữa những cá thể riêng biệt.*
Every journey (Distance) starts from a point of support. In the vast two-dimensional space, it is the closest links (Shortest distance) that create the stability of the structure. Data reminds us that cohesion lies not in broad coverage, but in the distance between separate individuals.
