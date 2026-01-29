# 899. Orderly Queue / Hàng đợi Thứ tự

## Problem Description / Mô tả bài toán
You are given a string `s` and an integer `k`. You can take one of the first `k` letters and move it to the end of the string.
Bạn được cho một chuỗi `s` và một số nguyên `k`. Bạn có thể lấy một trong `k` chữ cái đầu tiên và chuyển nó xuống cuối chuỗi.

Return the lexicographically smallest string you can get.
Trả về chuỗi nhỏ nhất theo thứ tự từ điển mà bạn có thể nhận được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting vs. Rotation / Sắp xếp và Xoay
Case 1: `k == 1`
You can only rotate the string (cyclic shifts).
Bạn chỉ có thể xoay chuỗi (dịch chuyển vòng).
- Try all `n` rotations. Pick the smallest.

Case 2: `k > 1`
Crucial observation: If `k > 1`, you can swap any two adjacent characters by moving others around. This means you can achieve **any** permutation of the string.
Quan sát quan trọng: Nếu `k > 1`, bạn có thể hoán đổi bất kỳ hai ký tự liền kề nào bằng cách di chuyển những ký tự khác xung quanh. Điều này có nghĩa là bạn có thể đạt được **bất kỳ** hoán vị nào của chuỗi.
- Simply sort the string and return.

### Complexity / Độ phức tạp
- **Time**: O(N^2) if `k=1`, O(N log N) if `k > 1`.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Degenerate Sorting
The value of $K$ determines the degrees of freedom in character reordering. At $K=1$, the movement is restricted to basic rotations. At $K \ge 2$, the system gains sufficient complexity to behave like a standard sorting network, allowing for the absolute lexicographical minimum to be reached.
Giá trị của $K$ xác định các bậc tự do trong việc sắp xếp lại các ký tự. Khi $K=1$, chuyển động bị giới hạn trong các phép xoay cơ bản. Khi $K \ge 2$, hệ thống đạt được độ phức tạp đủ để hoạt động như một mạng sắp xếp tiêu chuẩn, cho phép đạt được giá trị nhỏ nhất tuyệt đối theo thứ tự từ điển.

---
