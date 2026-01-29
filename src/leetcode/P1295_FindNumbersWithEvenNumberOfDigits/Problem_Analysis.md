# 1295. Find Numbers with Even Number of Digits / Tìm các Số có Số lượng Chữ số Chẵn

## Problem Description / Mô tả bài toán
Array `nums`. Count numbers with even number of digits.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit Counting / String Conversion
Method 1: `String.valueOf(num).length() % 2 == 0`.
Method 2: `Math.log10(num) + 1` is count.
Method 3: Iterative division.
Constraints: `nums[i] <= 10^5`.
Ranges:
1-9 (1)
10-99 (2 - Even)
100-999 (3)
1000-9999 (4 - Even)
10000-99999 (5)
100000 (6 - Even)

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Logarithm or Ranges
Since the input values are limited ($1 \le \text{nums}[i] \le 10^5$), we can either convert to string and check length, divide repeatedly, or use log base 10. `digits = (int)Math.log10(num) + 1`. If `digits % 2 == 0`, increment count.
Checking range is potentially fastest. `(10 <= x < 100) || (1000 <= x < 10000) || (x == 100000)`.
Vì các giá trị đầu vào bị giới hạn ($1 \le \text{nums}[i] \le 10^5$), chúng ta có thể chuyển đổi thành chuỗi và kiểm tra độ dài, chia nhiều lần hoặc sử dụng logarit cơ số 10. `digits = (int)Math.log10(num) + 1`. Nếu `digits % 2 == 0`, tăng số đếm.
Kiểm tra phạm vi có khả năng nhanh nhất. `(10 <= x < 100) || (1000 <= x < 10000) || (x == 100000)`.

---
