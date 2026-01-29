# 1095. Find in Mountain Array / Tìm trong Mảng Núi

## Problem Description / Mô tả bài toán
(This is an interactive problem).
You may recall that an array `arr` is a mountain array if and only if:
- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
  - `arr[0] < arr[1] < ... < arr[i]`
  - `arr[i] > arr[i+1] > ... > arr[arr.length - 1]`

Given a `MountainArray` object, return the **minimum** index `i` such that `MountainArray.get(i) == target`. If such an index does not exist, return -1.
Use minimum calls to `get`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Triple Binary Search / Ba lần Tìm kiếm Nhị phân
1. **Find Peak**: Binary search to find the peak index.
   - `mid` vs `mid+1`. If `mid < mid+1`, peak is right. Else peak is left.
2. **Search Left**: Binary search in range `[0, peak]` (ascending).
3. **Search Right**: Binary search in range `[peak+1, len-1]` (descending) if not found in left.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Peak Detection & Bi-Directional Search
First, locate the peak of the mountain using binary search (comparing adjacent elements or using local slope). Once the peak is known, the array is split into two sorted segments: strictly increasing to the left and strictly decreasing to the right. Perform binary search on the increasing part first to satisfy the "minimum index" requirement. If not found, binary search the decreasing part.
Đầu tiên, xác định đỉnh núi bằng tìm kiếm nhị phân (so sánh các phần tử liền kề hoặc sử dụng độ dốc cục bộ). Khi đã biết đỉnh, mảng được chia thành hai đoạn được sắp xếp: tăng nghiêm ngặt ở bên trái và giảm nghiêm ngặt ở bên phải. Thực hiện tìm kiếm nhị phân trên phần tăng trước để thỏa mãn yêu cầu "chỉ số tối thiểu". Nếu không tìm thấy, tìm kiếm nhị phân phần giảm.

---
