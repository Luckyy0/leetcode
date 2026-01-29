# 1011. Capacity To Ship Packages Within D Days / Khả năng Vận chuyển Gói hàng trong vòng D Ngày

## Problem Description / Mô tả bài toán
A conveyor belt has packages that must be shipped from one port to another within `days` days.
Một băng chuyền có các gói hàng phải được vận chuyển từ cảng này sang cảng khác trong vòng `days` ngày.

The `i-th` package has a weight of `weights[i]`. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). The ship cannot carry more weight than its maximum weight capacity.
Gói hàng thứ `i` có trọng lượng là `weights[i]`. Mỗi ngày, chúng ta chất các gói hàng trên băng chuyền lên tàu (theo thứ tự được đưa ra bởi trọng lượng). Tàu không thể chở quá trọng tải tối đa của nó.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within `days` days.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Tìm kiếm Nhị phân trên Kết quả
This is a classic "Minimize the Maximum" problem.
Đây là một bài toán "Tối thiểu hóa cái Tối đa" kinh điển.
- The capacity `C` has a range: `[max(weights), sum(weights)]`.
- Function `canShip(C)`: Checks if we can ship all packages in `<= days` with capacity `C`. This is monotonic: if `C` works, `C+1` also works.

Algorithm:
1. `low = max(weights)`, `high = sum(weights)`.
2. While `low < high`:
   - `mid = (low + high) / 2`.
   - If `canShip(mid)` -> `high = mid`.
   - Else -> `low = mid + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N * log(Sum - Max)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Parametric Search based on Capability
Guess the ship's capacity. Validate if this capacity suffices to clear the workload within the deadline by simulating the loading process greedily. Use binary search to find the minimal viable capacity.
Đoán sức chứa của con tàu. Xác thực xem liệu sức chứa này có đủ để giải quyết khối lượng công việc trong thời hạn hay không bằng cách mô phỏng quy trình tải một cách tham lam. Sử dụng tìm kiếm nhị phân để tìm sức chứa khả thi tối thiểu.

---
