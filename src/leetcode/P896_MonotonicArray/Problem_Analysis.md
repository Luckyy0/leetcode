# 896. Monotonic Array / Mảng Đơn điệu

## Problem Description / Mô tả bài toán
An array is monotonic if it is either monotone increasing or monotone decreasing.
Một mảng được gọi là đơn điệu nếu nó tăng đơn điệu hoặc giảm đơn điệu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Property Validation / Xác thực Thuộc tính
Algorithm:
1. Scan the array.
2. Maintain two flags: `increasing = true`, `decreasing = true`.
3. For each adjacent pair `(a, b)`:
   - If `a > b`, set `increasing = false`.
   - If `a < b`, set `decreasing = false`.
4. Return `increasing || decreasing`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Simultaneous Observation
Test both possible directions of monotonicity in a single pass. If any violation of the condition occurs for a specific direction, mark it as invalid. The array is monotonic if at least one direction remains valid.
Kiểm tra cả hai hướng đơn điệu có thể có trong một lần duyệt duy nhất. Nếu có bất kỳ vi phạm điều kiện nào xảy ra cho một hướng cụ thể, hãy đánh dấu nó là không hợp lệ. Mảng được gọi là đơn điệu nếu ít nhất một hướng vẫn hợp lệ.

---
