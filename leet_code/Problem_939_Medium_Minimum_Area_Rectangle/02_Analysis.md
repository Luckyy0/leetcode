# Analysis for Minimum Area Rectangle
# *Phân tích cho bài toán Hình chữ nhật Diện tích Tối thiểu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum area of a rectangle formed by 4 points from the input. Sides must be axis-aligned.
*Tìm diện tích nhỏ nhất của hình chữ nhật tạo bởi 4 điểm từ đầu vào. Các cạnh phải song song với trục.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A rectangle is defined by two diagonal points $(x1, y1)$ and $(x2, y2)$ where $x1 \neq x2$ and $y1 \neq y2$.
- The other two points must be $(x1, y2)$ and $(x2, y1)$.
- We can iterate through all pairs of points as diagonals.
- Check if the other two required points exist in the set of given points.
- If they exist, calculate area: $|x1 - x2| \times |y1 - y2|$.
- Update minimum area.
- Optimization: Store all points in a `Set<String>` or `Set<Long>` (encoding coordinates) or `Map<Integer, Set<Integer>>` for fast lookups.
- Given `N <= 500`, $O(N^2)$ checks is acceptable ($500^2 = 250,000$).
*Một hình chữ nhật được xác định bởi hai điểm đường chéo. Duyệt qua tất cả các cặp điểm, kiểm tra xem hai điểm còn lại có tồn tại không. Nếu có, tính diện tích và cập nhật min. Dùng Set để tra cứu nhanh.*

---

## 2. Strategy: Diagonal Search with HashSet
## *2. Chiến lược: Tìm kiếm Đường chéo với HashSet*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Store Points:** Ad all points to a `HashSet`. Encoding coordinate `x, y` as `40001 * x + y` is efficient since coordinates <= 40000.
    *   **Lưu điểm:** Thêm tất cả điểm vào HashSet. Mã hóa tọa độ để tra cứu.*

2.  **Iterate Pairs:** Loop `i` from 0 to `N-1`, `j` from `i+1` to `N-1`.
    - Let $p1 = (x1, y1)$ and $p2 = (x2, y2)$.
    - Ensure $x1 \neq x2$ and $y1 \neq y2$. If equal, they can't form a diagonal of an axis-aligned rectangle.
    *   **Duyệt cặp:** Lấy 2 điểm làm đường chéo. Đảm bảo không thẳng hàng.*

3.  **Check Existence:** Check if $(x1, y2)$ and $(x2, y1)$ exist in the set.
    *   **Kiểm tra tồn tại:** Kiểm tra 2 điểm còn lại.*

4.  **Calculate Area:** `area = abs(x1 - x2) * abs(y1 - y2)`. Update `minArea`.
    *   **Tính diện tích:** Cập nhật min.*

5.  **Return:** `minArea` (or 0 if never found).
    *   **Trả về:** `minArea`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int minAreaRect(int[][] points) {
        Set<Integer> pointSet = new HashSet<>();
        for (int[] p : points) {
            // Encode x, y into a single integer. Max coordinate is 40000.
            pointSet.add(40001 * p[0] + p[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                // Must form a diagonal (not on same x or y axis)
                if (x1 != x2 && y1 != y2) {
                    // Check if the other two corners exist: (x1, y2) and (x2, y1)
                    if (pointSet.contains(40001 * x1 + y2) && pointSet.contains(40001 * x2 + y1)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Nested loop iterating pairs. Set lookup is $O(1)$.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N)$. To store points in Set.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simply iterating diagonals and checking corners is efficient enough. Coordinate hashing avoids object creation overhead.
*Duyệt đường chéo và kiểm tra các góc là đủ hiệu quả. Mã hóa tọa độ tránh chi phí tạo đối tượng.*
