# 1299. Replace Elements with Greatest Element on Right Side / Thay thế các Phần tử bằng Phần tử Lớn nhất ở Bên phải

## Problem Description / Mô tả bài toán
Array `arr`. Replace each element with the greatest element among elements to its right.
Last element replaced by -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Iteration
Start from right (index `n-1`).
Track `maxSoFar`. Initially -1.
For `i` from `n-1` down to 0:
- Temp store `arr[i]`.
- Update `arr[i] = maxSoFar`.
- Update `maxSoFar = max(maxSoFar, temp)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Right-to-Left Scan
Iterate the array backwards from the last element. Maintain a variable `maxRight` initialized to -1. For each position `i`, store the current value `arr[i]` temporarily. Update `arr[i]` with `maxRight`, then update `maxRight` to be the maximum of itself and the temporary stored value (the original `arr[i]`). This efficiently propagates the maximum element from the right.
Lặp lại mảng ngược từ phần tử cuối cùng. Duy trì một biến `maxRight` được khởi tạo thành -1. Đối với mỗi vị trí `i`, lưu trữ giá trị hiện tại `arr[i]` tạm thời. Cập nhật `arr[i]` với `maxRight`, sau đó cập nhật `maxRight` thành giá trị lớn nhất giữa chính nó và giá trị được lưu trữ tạm thời ( `arr[i]` ban đầu). Điều này lan truyền hiệu quả phần tử lớn nhất từ bên phải.

---
