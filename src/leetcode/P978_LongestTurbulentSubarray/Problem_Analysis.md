# 978. Longest Turbulent Subarray / Mảng con Hỗn loạn Dài nhất

## Problem Description / Mô tả bài toán
Given an integer array `arr`, return the length of a maximum size turbulent subarray of `arr`.
Cho một mảng số nguyên `arr`, hãy trả về độ dài của mảng con hỗn loạn có kích thước tối đa của `arr`.

A subarray is turbulent if:
- `arr[i] > arr[i+1] < arr[i+2] > arr[i+3]...`
- or `arr[i] < arr[i+1] > arr[i+2] < arr[i+3]...`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Dynamic Programming / Cửa sổ trượt / Quy hoạch động
Algorithm:
1. Maintain `inc` (length of turbulent subarray ending with increase).
2. Maintain `dec` (length of turbulent subarray ending with decrease).
3. For each element:
   - If `arr[i] > arr[i-1]`: `inc = dec + 1`, `dec = 1`.
   - If `arr[i] < arr[i-1]`: `dec = inc + 1`, `inc = 1`.
   - If `arr[i] == arr[i-1]`: `inc = 1`, `dec = 1`.
4. Max length = `max(inc, dec)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Dual-State transition
Track the growth of two alternating patterns (rising and falling). Each step either extends one pattern while resetting the other or resets both if values are equal, allowing us to find the longest sequence of alternating comparisons in one pass.
Theo dõi sự phát triển của hai mẫu xen kẽ (tăng và giảm). Mỗi bước sẽ kéo dài một mẫu đồng thời đặt lại mẫu kia, hoặc đặt lại cả hai nếu các giá trị bằng nhau, cho phép chúng ta tìm chuỗi so sánh xen kẽ dài nhất trong một lần duyệt.

---
