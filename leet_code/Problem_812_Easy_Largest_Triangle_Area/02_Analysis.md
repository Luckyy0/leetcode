# Analysis for Largest Triangle Area
# *Phân tích cho bài toán Diện tích Tam giác lớn nhất*

## 1. Problem Essence & Geometry
## *1. Bản chất vấn đề & Hình học*

### The Challenge
### *Thách thức*
We are given a set of unique points on a 2D plane. We need to find the maximum possible area for a triangle formed by selecting exactly three points. Since the number of points is small ($N \le 50$), we can afford a brute-force approach that checks every combination of three points.
*Chúng ta được cung cấp một tập hợp các điểm duy nhất trên mặt phẳng 2D. Cần tìm diện tích lớn nhất có thể của một tam giác được tạo thành bằng cách chọn đúng ba điểm. Vì số lượng điểm nhỏ ($N \le 50$), chúng ta có thể sử dụng phương pháp duyệt trâu để kiểm tra mọi tổ hợp ba điểm.*

---

## 2. Strategy: Shoelace Formula
## *2. Chiến lược: Công thức Shoelace*

### Measuring Area
### *Tính diện tích*
The most efficient way to calculate the area of a triangle given three vertex coordinates $(x_1, y_1), (x_2, y_2),$ and $(x_3, y_3)$ is using the **Shoelace Formula** (or the determinant method):
*Cách hiệu quả nhất để tính diện tích tam giác khi biết tọa độ ba đỉnh là sử dụng **Công thức Shoelace** (hoặc phương pháp định thức):*

$$Area = \frac{1}{2} |x_1(y_2 - y_3) + x_2(y_3 - y_1) + x_3(y_1 - y_2)|$$

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** Set `maxArea = 0`.
    *   **Khởi tạo:** Đặt `maxArea = 0`.*

2.  **Triple Loop:** Iterate through all possible combinations of three distinct points $(i, j, k)$:
    - For each combination, pick points `P1, P2, P3`.
    - Calculate the area using the Shoelace Formula.
    - Update `maxArea = max(maxArea, currentArea)`.
    *   **Vòng lặp ba lớp:** Duyệt qua tất cả các tổ hợp có thể có của ba điểm khác nhau $(i, j, k)$. Với mỗi tổ hợp, tính diện tích và cập nhật `maxArea`.*

3.  **Return:** Return the `maxArea`.
    *   **Trả về:** Trả về `maxArea`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public double largestTriangleArea(int[][] points) {
    int n = points.length;
    double maxArea = 0;
    
    // Triple nested loop to check all combinations
    for (int i = 0; i < n - 2; i++) {
        for (int j = i + 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                maxArea = Math.max(maxArea, calculateArea(
                    points[i], points[j], points[k]
                ));
            }
        }
    }
    return maxArea;
}

private double calculateArea(int[] p1, int[] p2, int[] p3) {
    // Shoelace formula: 0.5 * |x1(y2-y3) + x2(y3-y1) + x3(y1-y2)|
    return 0.5 * Math.abs(
        p1[0] * (p2[1] - p3[1]) + 
        p2[0] * (p3[1] - p1[1]) + 
        p3[0] * (p1[1] - p2[1])
    );
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$, where $N$ is the number of points. With $N=50$, $50^3 = 125,000$ operations, which is well within the time limit.
    *   **Độ phức tạp thời gian:** $O(N^3)$, với $N$ là số lượng điểm. Với $N=50$, thực hiện khoảng 125,000 phép tính.*
*   **Space Complexity:** $O(1)$, as we only use a few variables to store coordinates and the maximum area.
    *   **Độ phức tạp không gian:** $O(1)$, vì chúng ta chỉ sử dụng một vài biến để lưu tọa độ và diện tích lớn nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `[[0,0],[0,1],[1,0]]`
1. Combination (0,1,2):
   - Points: (0,0), (0,1), (1,0)
   - Area = $0.5 \cdot |0(1-0) + 0(0-0) + 1(0-1)| = 0.5 \cdot |0 + 0 - 1| = 0.5$
**Result:** 0.5

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Because the constraint on $N$ is small, brute forcing $O(N^3)$ is the most straightforward and reliable solution. The Shoelace formula ensures precise calculation of triangle area without dealing with complex trigonometry.
*Vì ràng buộc về $N$ nhỏ, việc duyệt trâu $O(N^3)$ là giải pháp trực tiếp và đáng tin cậy nhất. Công thức Shoelace đảm bảo tính toán chính xác diện tích tam giác mà không cần dùng đến lượng giác phức tạp.*
