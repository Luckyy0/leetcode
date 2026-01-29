# 1351. Count Negative Numbers in a Sorted Matrix / Đếm Số Âm trong Ma trận Đã Sắp Xếp

## Problem Description / Mô tả bài toán
`m x n` matrix. Decreasing order both row-wise and column-wise.
Count negative numbers.
Time complexity better than O(MN).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Staircase Search / Saddleback Search
Start from top-right corner (or bottom-left).
Let's analyze top-right `(0, n-1)`.
If `grid[i][j] < 0`:
- Everything in column `j` below `grid[i][j]` is also negative (decreasing column-wise).
- Count contribution `m - i`.
- Move left `j--` to check next column.
If `grid[i][j] >= 0`:
- Everything in row `i` to the left is also positive (decreasing row-wise means left is larger).
- Move down `i++`. (Actually, row is decreasing: left > right. So if `grid[i][j] >= 0`, left is larger, so positive. Right is smaller. Wait. )
- Sorting: `grid[i][j] >= grid[i][j+1]`.
- Start top-right `(0, n-1)`.
- If `grid[i][j] < 0`: This element and all below are negative?
  - Row decreasing: `[3, 2, -1, -2]`. `grid[i][j]` is negative -> `grid[i][j-1]` might be positive or negative.
  - Col decreasing: `[3, -1]`.
  - If `grid[i][j] < 0`: All elements below `(i, j)` in same column are smaller -> also negative.
  - So `j` contributes `m - i` negatives.
  - To find more negatives, check left `j--`.
- If `grid[i][j] >= 0`: This element is positive. Left is larger (positive).
  - So this column `j` and row `i` intersection is positive. Need to go down `i++` to find smaller values.
  
Correct logic: Start top-right. `(i=0, j=n-1)`.
If `grid[i][j] < 0`: Column `j` from `i` to `m-1` are negative. Add `m-i`. Move Left `j--`.
If `grid[i][j] >= 0`: This element and elements to left in row `i` are positive. Move Down `i++`.

### Complexity / Độ phức tạp
- **Time**: O(M + N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Staircase Search
Start at the top-right corner `(r=0, c=n-1)`.
Since the matrix is sorted in decreasing order:
- If `grid[r][c] < 0`: All elements in column `c` below `r` are also negative (because columns decrease). Count `m - r` negatives. Since we want to find more negatives (possibly above or left), and we exhausted this column (or at least accounted for its negatives), we move to the left `c--` to check the next column. Wait, moving left might give larger numbers.
- If `grid[r][c] >= 0`: This element is non-negative. Since rows decrease, everything to the left is larger (more positive). We need smaller numbers, so we move down `r++`.
Continue until out of bounds.
Complexity O(m+n).
Bắt đầu ở góc trên bên phải `(r=0, c=n-1)`.
Vì ma trận được sắp xếp theo thứ tự giảm dần:
- Nếu `grid[r][c] < 0`: Tất cả các phần tử trong cột `c` bên dưới `r` cũng là số âm (vì các cột giảm dần). Đếm `m - r` số âm. Vì chúng ta muốn tìm thêm số âm (có thể ở trên hoặc trái), và chúng ta đã dùng hết cột này (hoặc ít nhất đã tính số âm của nó), chúng ta di chuyển sang trái `c--` để kiểm tra cột tiếp theo. Chờ đã, di chuyển sang trái có thể cho số lớn hơn.
- Nếu `grid[r][c] >= 0`: Phần tử này không âm. Vì các hàng giảm dần, mọi thứ bên trái đều lớn hơn (dương hơn). Chúng ta cần số nhỏ hơn, vì vậy chúng ta di chuyển xuống `r++`.

---
