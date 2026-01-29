# 1243. Array Transformation / Biến đổi Mảng

## Problem Description / Mô tả bài toán
Given array `arr`. Each day:
For each index `i` (1 to n-2):
- If `arr[i] < arr[i-1]` and `arr[i] < arr[i+1]`, increment `arr[i]`.
- If `arr[i] > arr[i-1]` and `arr[i] > arr[i+1]`, decrement `arr[i]`.
Repeat until no changes.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Mô phỏng
Simulate the process. Create a copy of array to apply changes simultaneously.
Check if any change occurred. If not, break.

### Complexity / Độ phức tạp
- **Time**: Depends on convergence, typically small.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Day-by-day Simulation
Simulate the transformation process daily. In each iteration, create a copy of the current array to determine the next state (so updates happen simultaneously based on the *current* state). Iterate through indices from 1 to `n-2`. Apply the rules: increment if the element is smaller than both neighbors, decrement if larger than both. If no elements change during an iteration, the array has stabilized; return the result.
Mô phỏng quá trình chuyển đổi hàng ngày. Trong mỗi lần lặp, hãy tạo một bản sao của mảng hiện tại để xác định trạng thái tiếp theo (để các cập nhật diễn ra đồng thời dựa trên trạng thái *hiện tại*). Lặp qua các chỉ số từ 1 đến `n-2`. Áp dụng các quy tắc: tăng nếu phần tử nhỏ hơn cả hai phần tử lân cận, giảm nếu lớn hơn cả hai. Nếu không có phần tử nào thay đổi trong một lần lặp, mảng đã ổn định; trả về kết quả.

---
