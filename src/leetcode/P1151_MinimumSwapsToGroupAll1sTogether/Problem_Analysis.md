# 1151. Minimum Swaps to Group All 1's Together / Số lần Hoán đổi Tối thiểu để Nhóm Tất cả các Số 1 Lại với nhau

## Problem Description / Mô tả bài toán
Given a binary array `data`, return the minimum number of swaps required to group all 1s present in the array together in any place in the array.
Cho một mảng nhị phân `data`, hãy trả về số lần hoán đổi tối thiểu cần thiết để nhóm tất cả các số 1 có trong mảng lại với nhau ở bất kỳ vị trí nào trong mảng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
We need a window of size `totalOnes`.
Inside this window, we want max number of 1s (so min swaps = totalOnes - currentOnes).
Algorithm:
1. Count total 1s: `ones = count(data)`.
2. Initialize window `[0, ones-1]`.
3. Count 1s in window: `currentOnes`.
4. Maximize `currentOnes`. Slide window.
5. Result `ones - maxCurrentOnes`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Fixed Window Optimization
Calculate the total number of 1s in the array (`K`). We need to gather all these 1s into a contiguous block of length `K`. Use a sliding window of size `K` to scan the array. For each window position, count the number of 1s already present. The number of swaps needed for that window is `K - (1s in window)`. Minimize this value (equivalent to maximizing 1s in the window) across all positions.
Tính tổng số lượng số 1 trong mảng (`K`). Chúng ta cần tập hợp tất cả các số 1 này thành một khối liền kề có độ dài `K`. Sử dụng cửa sổ trượt có kích thước `K` để quét mảng. Đối với mỗi vị trí cửa sổ, hãy đếm số lượng số 1 đã có. Số lần hoán đổi cần thiết cho cửa sổ đó là `K - (số 1 trong cửa sổ)`. Giảm thiểu giá trị này (tương đương với việc tối đa hóa số 1 trong cửa sổ) trên tất cả các vị trí.

---
