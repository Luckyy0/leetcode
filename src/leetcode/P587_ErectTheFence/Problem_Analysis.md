# 587. Erect the Fence / Dựng Hàng Rào

## Problem Description / Mô tả bài toán
You are given an array `trees` where `trees[i] = [xi, yi]` represents the location of a tree in the garden.
Bạn được cho một mảng `trees` trong đó `trees[i] = [xi, yi]` đại diện cho vị trí của một cái cây trong vườn.

You are asked to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if **all the trees are enclosed**.
Bạn được yêu cầu rào toàn bộ khu vườn bằng cách sử dụng chiều dài dây thừng tối thiểu vì nó rất đắt. Khu vườn chỉ được rào tốt nếu **tất cả các cây đều được bao quanh**.

Return the coordinates of trees that are exactly located on the fence perimeter.
Trả về tọa độ của những cái cây nằm chính xác trên chu vi hàng rào.

### Example 1:
```text
Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Convex Hull (Monotone Chain / Graham Scan) / Bao Lồi (Chuỗi Đơn Điệu / Quét Graham)
This problem asks for the **Convex Hull** of a set of points.
Standard algorithms:
1. **Monotone Chain Algorithm**:
   - Sort points by x-coordinate (and y-coordinate).
   - Build **lower hull**: Iterate through points, removing points that make a "right turn" (non-counter-clockwise turn) relative to the last two points in hull.
   - Build **upper hull**: Iterate reversed points, similar logic.
   - Concatenate hulls.
2. **Jarvis March**:
   - Start from leftmost point.
   - Find the next point that is "most counter-clockwise" relative to current point.
   - Repeat until back to start.
   - O(N * H) where H is hull size. Good if H is small, but worst case O(N^2).
   
Monotone Chain is O(N log N) which is robust.

Important: "Collinear points" on the hull edge should be included. Standard algorithms often skip collinear middle points unless adapted.
Logic check: `CrossProduct(O, A, B)`.
If `CrossProduct > 0`, Left turn. element is valid.
If `CrossProduct < 0`, Right turn. element invalid (remove A).
If `CrossProduct == 0`, Collinear. Keep it? For this problem, YES, all trees on fence.

### Complexity / Độ phức tạp
- **Time**: O(N log N) due to sorting.
- **Space**: O(N) for hull storage.

---

## Analysis / Phân tích

### Approach: Monotone Chain Algorithm

**Algorithm**:
1.  Sort points by x, then y.
2.  Build lower hull stack: Maintain convexity check (cross product).
3.  Build upper hull stack.
4.  Combine hulls (removing duplicates).
5.  Handle collinear points correctly (allow 0 cross product or handle specially).

---
