# 861. Score After Flipping Matrix / Điểm số sau khi Lật Ma trận

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `grid`. A move consists of choosing any row or column and flipping all its values.
Bạn được cấp một ma trận nhị phân `m x n` `grid`. Một bước đi bao gồm việc chọn bất kỳ hàng hoặc cột nào và lật tất cả các giá trị của nó.

The score of the grid is the sum of the binary numbers represented by each row. Return the highest possible score.
Điểm của lưới là tổng các số nhị phân được biểu diễn bởi mỗi hàng. Trả về điểm số cao nhất có thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Bit Manipulation / Tham lam và Thao tác Bit
To maximize the sum:
1. The most significant bit (MSB) of each row should be `1`.
Bit có ý nghĩa nhất (MSB) của mỗi hàng phải là `1`.
   - If `grid[r][0] == 0`, flip row `r`.
2. For all other columns `c > 0`, we want the number of `1`s to be as large as possible.
Đối với tất cả các cột khác `c > 0`, chúng ta muốn số lượng số `1` lớn nhất có thể.
   - For each column, count current `1`s. If `count1 < count0` (i.e., `count1 < m/2`), flip the column.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Structural Priority
Prioritize the left-most bits because they hold the highest power-of-two value. Once the first column is locked to all ones, optimize each subsequent column independently to ensure it contains more ones than zeroes.
Ưu tiên các bit ngoài cùng bên trái vì chúng giữ giá trị lũy thừa của 2 cao nhất. Sau khi cột đầu tiên đã được chốt toàn bộ là số một, hãy tối ưu hóa từng cột tiếp theo một cách độc lập để đảm bảo nó chứa nhiều số một hơn số không.

---
