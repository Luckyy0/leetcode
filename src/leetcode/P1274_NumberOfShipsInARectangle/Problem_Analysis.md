# 1274. Number of Ships in a Rectangle / Số lượng Tàu trong Hình chữ nhật

## Problem Description / Mô tả bài toán
Interactive problem. `hasShips(topRight, bottomLeft)` returns true if ships exist in rect.
Count total ships in a given large rectangle.
Limit of calls.
Ships are integer points.
Max 10 ships in total rectangle 1000x1000.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divide and Conquer (Quadtree) / Chia để trị (Cây tứ phân)
If `hasShips` returns false, return 0 (pruning).
If `hasShips` returns true:
- If rectangle is a point (topRight == bottomLeft), return 1.
- Split rectangle into 4 smaller ones (midpoint split).
- Sum results of recursive calls.

### Complexity / Độ phức tạp
- **Time**: Depends on ship distribution. With max 10 ships, pruning is effective. Path to each ship is log(Area). ~ 10 * log(1000^2) calls. 10 * 20 = 200 calls. Limit is 400. Feasible.
- **Space**: Recursion stack.

---

## Analysis / Phân tích

### Approach: Quad-tree Recruitment
Use a divide and conquer strategy.
Base case 1: The current rectangle is invalid (bottom > top or left > right) or `hasShips` returns false. Return 0.
Base case 2: It is a single point (top == bottom and left == right) and `hasShips` returned true (implied). Return 1.
Recursive step: Divide the rectangle into 4 sub-rectangles using the midpoints (`midX`, `midY`). Recursively count ships in `(topRight, mid)`, `(mid, bottomLeft)` etc. Be careful with boundaries to ensure cover and no overlap.
Partitions:
1. `(top, right)` to `(midY + 1, midX + 1)`
2. `(top, midX)` to `(midY + 1, left)`
3. `(midY, right)` to `(bottom, midX + 1)`
4. `(midY, midX)` to `(bottom, left)`
Actually common split:
Mid x, Mid y.
Quadrants:
- `[left, midX], [bottom, midY]`
- `[midX+1, right], [bottom, midY]`
- `[left, midX], [midY+1, top]`
- `[midX+1, right], [midY+1, top]`

Sử dụng chiến lược chia để trị.
Trường hợp cơ sở 1: Hình chữ nhật hiện tại không hợp lệ (bottom > top hoặc left > right) hoặc `hasShips` trả về false. Trả về 0.
Trường hợp cơ sở 2: Đó là một điểm duy nhất (top == bottom và left == right) và `hasShips` trả về true (ngụ ý). Trả về 1.
Bước đệ quy: Chia hình chữ nhật thành 4 hình chữ nhật con bằng cách sử dụng trung điểm (`midX`, `midY`). Đệ quy đếm tàu trong `(topRight, mid)`, `(mid, bottomLeft)` vân vân. Cẩn thận với các ranh giới để đảm bảo bao phủ và không trùng lặp.

---
