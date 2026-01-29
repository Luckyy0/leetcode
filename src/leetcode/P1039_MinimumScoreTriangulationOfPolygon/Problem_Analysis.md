# 1039. Minimum Score Triangulation of Polygon / Điểm Triangulation Tối thiểu của Đa giác

## Problem Description / Mô tả bài toán
You have a convex `n`-sided polygon where adjacent vertices are labeled `values[0], values[1], ..., values[n-1]` sequentially.
Bạn có một đa giác lồi `n` cạnh trong đó các đỉnh liền kề được gắn nhãn `values[0], values[1], ..., values[n-1]` theo thứ tự.

Triangulate the polygon into `n-2` triangles. The score of a triangulation is the sum of the scores of its triangles. The score of a triangle is the product of the values of its vertices.
Phân chia đa giác thành `n-2` hình tam giác. Điểm số của một phép phân chia là tổng điểm số của các hình tam giác của nó. Điểm số của một hình tam giác là tích các giá trị tại các đỉnh của nó.

Return the minimum score.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval DP / Quy hoạch Động Khoảng
We define `dp[i][j]` as the min score to triangulate the polygon formed by vertices `i, i+1, ..., j`.
Chúng ta định nghĩa `dp[i][j]` là điểm số tối thiểu để phân chia đa giác được tạo bởi các đỉnh `i, i+1, ..., j`.

Base case: Adjacent vertices (e.g., `i, i+1`) cannot form a polygon, so 0. Triangle `(i, i+1, i+2)` gives product.
Transition:
For a polygon defined by `[i, j]`, if we pick a vertex `k` in between (`i < k < j`), we form a triangle `(i, k, j)` and two sub-polygons `[i, k]` and `[k, j]`.
`dp[i][j] = min(dp[i][k] + dp[k][j] + values[i]*values[k]*values[j])` for all `k`.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Recursive Decomposition
Break the polygon down into smaller polygons by selecting a vertex to form a triangle with the base edge. By trying all possible third vertices $k$ for the edge $(i, j)$ and recursively solving for the resulting sub-polygons $(i, k)$ and $(k, j)$, we find the optimal structure.
Chia nhỏ đa giác thành các đa giác nhỏ hơn bằng cách chọn một đỉnh để tạo thành một tam giác với cạnh đáy. Bằng cách thử tất cả các đỉnh thứ ba $k$ có thể có cho cạnh $(i, j)$ và giải đệ quy cho các đa giác con kết quả $(i, k)$ và $(k, j)$, chúng ta tìm thấy cấu trúc tối ưu.

---
