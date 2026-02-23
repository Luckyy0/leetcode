# Analysis for Minimum Area Rectangle II
# *Phân tích cho bài toán Diện tích Hình chữ nhật Nhỏ nhất II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find minimum area of a rectangle (rotated or not) formed by given points.
*Tìm diện tích nhỏ nhất của hình chữ nhật (có thể xoay) từ các điểm đã cho.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A rectangle is defined by 4 points A, B, C, D.
- If we iterate through all triplets (A, B, C), we can check if they form a right angle at B.
  - Dot product of vectors `BA` and `BC` must be 0.
  - If so, the 4th point D must be at `A + C - B`.
  - Check if D exists in our set of points.
  - If yes, area is `|BA| * |BC|`. Update min area.
- Constraints: $N \le 50$. $O(N^3) \approx 125,000$ operations. Very fast.
- Store points in a HashSet for $O(1)$ lookup. String encoding "x,y" or custom hash.
- Coordinate range 40000. `long` encoding `x * 40001 + y` or similar avoids collision. Or simply "x,y" string.
*Duyệt qua 3 điểm. Nếu tạo thành góc vuông, tính điểm thứ 4 và kiểm tra xem có tồn tại không. Vì N nhỏ (50), thuật toán O(N^3) hoàn toàn khả thi.*

---

## 2. Strategy: Triplet Iteration + 4th Point Lookup
## *2. Chiến lược: Duyệt Bộ Ba + Tra cứu Điểm thứ 4*

### Algorithm Steps
### *Các bước thuật toán*

1.  **HashSet:** Store all points as strings "x,y" for quick lookup.
    *   **HashSet:** Lưu các điểm để tra cứu nhanh.*

2.  **Iterate Triplets:** `i, j, k` from 0 to `N-1`.
    *   **Duyệt Bộ Ba:** `i, j, k`.*

3.  **Check Right Angle:** consider `points[i]` as the vertex with 90 degrees.
    - Vector `p1 = points[j] - points[i]`.
    - Vector `p2 = points[k] - points[i]`.
    - Dot product: `p1.x * p2.x + p1.y * p2.y == 0`.
    *   **Kiểm tra Góc vuông:** Tích vô hướng bằng 0.*

4.  **Find 4th Point:**
    - `x4 = p1.x + p2.x + points[i].x` (vector addition).
    - `y4 = p1.y + p2.y + points[i].y`.
    - Check if "x4,y4" is in Set.
    *   **Tìm Điểm thứ 4:** Tính tọa độ và kiểm tra trong Set.*

5.  **Calculate Area:** `sqrt(lenSq(p1)) * sqrt(lenSq(p2))`. Min update.
    *   **Tính Diện tích:** Cập nhật min.*

6.  **Return:** Min area or 0.
    *   **Trả về:** Min area hoặc 0.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }
        
        double minArea = Double.MAX_VALUE;
        boolean found = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = j + 1; k < n; k++) {
                    if (k == i) continue;
                    
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    
                    // Check if angle at p1 is 90 degrees
                    // Vector p1->p2: (x2-x1, y2-y1)
                    // Vector p1->p3: (x3-x1, y3-y1)
                    int x2 = p2[0] - p1[0];
                    int y2 = p2[1] - p1[1];
                    int x3 = p3[0] - p1[0];
                    int y3 = p3[1] - p1[1];
                    
                    if (x2 * x3 + y2 * y3 == 0) {
                        // 4th point should be p2 + p3 - p1
                        int x4 = p2[0] + x3;
                        int y4 = p2[1] + y3;
                        
                        if (pointSet.contains(x4 + "," + y4)) {
                            double area = Math.sqrt(x2 * x2 + y2 * y2) * Math.sqrt(x3 * x3 + y3 * y3);
                            if (area < minArea) {
                                minArea = area;
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        
        return found ? minArea : 0;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$. With $N=50$, this is roughly $1.25 \times 10^5$ iterations.
    *   **Độ phức tạp thời gian:** $O(N^3)$.*
*   **Space Complexity:** $O(N)$ for HashSet.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using the properties of vectors (dot product for orthogonality, vector addition for 4th point) combined with brute-force triplet iteration is efficient enough due to small constraints.
*Sử dụng tính chất vector (tích vô hướng để kiểm tra trực giao, cộng vector để tìm điểm thứ 4) kết hợp với duyệt bộ ba vét cạn là đủ hiệu quả do ràng buộc nhỏ.*
