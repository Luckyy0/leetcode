# 1093. Statistics from a Large Sample / Thống kê từ Mẫu Lớn

## Problem Description / Mô tả bài toán
You are given a large sample of integers represented as an integer array `count` where `count[k]` is the number of times the integer `k` appears in the sample. The sample contains integers in range [0, 255].
Bạn được cho một mẫu lớn các số nguyên được biểu diễn dưới dạng mảng số nguyên `count` trong đó `count[k]` là số lần số nguyên `k` xuất hiện trong mẫu. Mẫu chứa các số nguyên trong khoảng [0, 255].
Return the minimum, maximum, mean, median, and mode of the sample.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Statistical Computation from Frequency Map / Tính toán Thống kê từ Bản đồ Tần suất
- **Min**: First index with `count > 0`.
- **Max**: Last index with `count > 0`.
- **Mean**: Sum of `i * count[i]` divided by Total Count. Sum likely needs `long`.
- **Mode**: Index with max count.
- **Median**: Value at position `total/2` (and `total/2 - 1` if even). Iterate through counts to find this position.

### Complexity / Độ phức tạp
- **Time**: O(M), where M is range size (256).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Frequency Scan
Since the data range is small (0-255), iterate through the `count` array to compute statistics directly.
- Min/Max found by first/last non-zero index.
- Mean computed by accumulating weighted sum.
- Mode found by tracking max frequency.
- Median found by counting elements up to the midpoint(s).
Vì phạm vi dữ liệu nhỏ (0-255), lặp qua mảng `count` để tính toán thống kê trực tiếp.
- Min/Max được tìm thấy bằng chỉ số khác không đầu tiên/cuối cùng.
- Trung bình được tính bằng cách tích lũy tổng có trọng số.
- Mode được tìm thấy bằng cách theo dõi tần suất tối đa.
- Trung vị được tìm thấy bằng cách đếm các phần tử cho đến điểm trung tâm.

---
