# 1313. Decompress Run-Length Encoded List / Giải nén Danh sách Được mã hóa Độ dài Chạy

## Problem Description / Mô tả bài toán
Input: `nums = [freq, val, freq, val...]`.
Output: New list with freq copies of val concatenated.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation
Iterate pair `(nums[2i], nums[2i+1])`.
Append `nums[2i+1]` to result `nums[2i]` times.

### Complexity / Độ phức tạp
- **Time**: O(N + TotalFreq).
- **Space**: O(TotalFreq).

---

## Analysis / Phân tích

### Approach: Iteration
Iterate through the array with a step of 2. For each pair `(freq, val)`, retrieve the frequency and the value. Append `val` to the result list `freq` times.
Lặp lại qua mảng với bước nhảy là 2. Đối với mỗi cặp `(freq, val)`, lấy tần suất và giá trị. Thêm `val` vào danh sách kết quả `freq` lần.

---
