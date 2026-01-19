# 120. Triangle / Tam Giác

## Problem Description / Mô tả bài toán
Given a `triangle` array, return the minimum path sum from top to bottom.
Cho một mảng `triangle`, trả về tổng đường đi nhỏ nhất từ trên xuống dưới.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index `i` on the current row, you may move to either index `i` or index `i + 1` on the next row.
Đối với mỗi bước, bạn có thể di chuyển đến một số liền kề của hàng bên dưới. Cụ thể hơn, nếu bạn đang ở chỉ số `i` trên hàng hiện tại, bạn có thể di chuyển đến chỉ số `i` hoặc chỉ số `i + 1` trên hàng tiếp theo.

### Example 1:
```text
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11.
```

### Example 2:
```text
Input: triangle = [[-10]]
Output: -10
```

## Constraints / Ràng buộc
- `1 <= triangle.length <= 200`
- `triangle[0].length == 1`
- `triangle[i].length == triangle[i - 1].length + 1`
- `-10^4 <= triangle[i][j] <= 10^4`

**Follow up**: Could you do this using only O(n) extra space, where n is the total number of rows?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Problem Structure / Cấu trúc Bài toán
This is a classic **DP on DAG** (Directed Acyclic Graph) problem:
Đây là bài toán **DP trên DAG** (Đồ thị Có hướng Không chu trình) kinh điển:
- Each cell can reach two cells below it.
- Mỗi ô có thể đến hai ô bên dưới nó.
- We want minimum sum path from top to any bottom cell.
- Chúng ta muốn đường đi tổng nhỏ nhất từ đỉnh đến bất kỳ ô đáy nào.

### Top-Down vs Bottom-Up / Trên Xuống vs Dưới Lên

| Direction | Base Case | Advantage |
|-----------|-----------|-----------|
| **Top-Down** | Top cell = its value | Need to track min at bottom |
| **Bottom-Up** | Bottom row = values | Final answer at top cell! |

**Bottom-Up is preferred**: The answer accumulates naturally at `dp[0]`.
**Dưới Lên được ưu tiên**: Câu trả lời tích lũy tự nhiên tại `dp[0]`.

### Bottom-Up DP Formula / Công thức DP Dưới Lên
```
dp[i] = triangle[row][i] + min(dp[i], dp[i+1])
```
- Start from second-to-last row.
- Work upward.
- `dp[i]` = min path sum from position i to any bottom cell.

### Space Optimization / Tối ưu Không gian
- Only need the row below to compute current row.
- Can use 1D array of size n (number of rows = size of bottom row).
- Or modify triangle in-place (if allowed).

---

## Analysis / Phân tích

### Approach: Bottom-Up DP with O(n) Space / DP Dưới Lên với O(n) Không gian

**Algorithm**:
```
n = triangle.size()
dp = copy of triangle[n-1]  // Start with bottom row

for row = n-2 down to 0:
    for i = 0 to row:
        dp[i] = triangle[row][i] + min(dp[i], dp[i+1])

return dp[0]
```

### Complexity / Độ phức tạp
- **Time**: O(n²) where n = number of rows. Total elements = n(n+1)/2.
- **Space**: O(n) for dp array.

---

## Edge Cases / Các trường hợp biên
1.  **Single element**: Return that element.
2.  **Negative values**: Handled naturally.
