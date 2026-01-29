# 539. Minimum Time Difference / Chênh Lệch Thời Gian Nhỏ Nhất

## Problem Description / Mô tả bài toán
Given a list of 24-hour clock time points in **"HH:MM"** format, return the minimum **minutes** difference between any two time-points in the list.
Cho một danh sách các điểm thời gian theo đồng hồ 24 giờ ở định dạng **"HH:MM"**, hãy trả về chênh lệch **phút** nhỏ nhất giữa bất kỳ hai điểm thời gian nào trong danh sách.

### Example 1:
```text
Input: timePoints = ["23:59","00:00"]
Output: 1
```

## Constraints / Ràng buộc
- `2 <= timePoints.length <= 2 * 10^4`
- `timePoints[i]` is in the format "HH:MM".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting + Circular Check / Sắp xếp + Kiểm tra vòng tròn
We can convert all times to "minutes since 00:00" (0 to 1439).

Algorithm:
1. Parse each string into integer minutes: `H * 60 + M`.
2. Sort the list of minutes.
3. Compute difference between adjacent elements: `minDiff = min(minDiff, arr[i] - arr[i-1])`.
4. IMPORTANT: Handle the circular nature (crossing midnight).
   - Check difference between the **first** and **last** element: `1440 - (last - first)`.
   - Update `minDiff` with this value.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(N) to store minutes.

---

## Analysis / Phân tích

### Approach: Linear Scan on Sorted Times

**Algorithm**:
1.  Convert times to minutes.
2.  Sort time points.
3.  Calculate adjacent differences.
4.  Account for day wrap-around (24h circle).

---
