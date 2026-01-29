# 801. Minimum Swaps To Make Sequences Increasing / Số lần Hoán đổi Tối thiểu để các Dãy tăng dần

## Problem Description / Mô tả bài toán
You are given two integer arrays defined on the same length `nums1` and `nums2`. In one operation, you can swap `nums1[i]` and `nums2[i]`.
Bạn được cho hai mảng số nguyên có cùng độ dài `nums1` và `nums2`. Trong một thao tác, bạn có thể hoán đổi `nums1[i]` và `nums2[i]`.

Return the minimum number of operations to make both `nums1` and `nums2` strictly increasing. The test cases are generated so that the given input always makes it possible.
Hãy trả về số lượng thao tác tối thiểu để làm cho cả `nums1` và `nums2` tăng nghiêm ngặt. Các trường hợp kiểm thử được tạo ra để đầu vào luôn có thể thực hiện được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
At each index `i`, we have two states:
Tại mỗi chỉ số `i`, chúng ta có hai trạng thái:
1. `keep[i]`: Minimum swaps to make `nums1[0...i]` and `nums2[0...i]` increasing, without swapping at index `i`.
2. `swap[i]`: Minimum swaps to make `nums1[0...i]` and `nums2[0...i]` increasing, with a swap at index `i`.

Transition depends on `i-1`:
- If `nums1[i-1] < nums1[i]` and `nums2[i-1] < nums2[i]` (Case A: Natural increasing order):
  - Staying as is at `i` matches staying as is at `i-1`.
  - Swapping at `i` matches swapping at `i-1`.
- If `nums1[i-1] < nums2[i]` and `nums2[i-1] < nums1[i]` (Case B: Cross-increasing order):
  - Staying as is at `i` matches swapping at `i-1`.
  - Swapping at `i` matches staying as is at `i-1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (can be optimized to only keep previous state).

---

## Analysis / Phân tích

### Approach: State-Based Transition
Maintain the minimum cost for both "swapped" and "not swapped" scenarios for the current index. The result is the minimum of these two values at the final index.
Duy trì chi phí tối thiểu cho cả hai kịch bản "đã hoán đổi" và "không được hoán đổi" cho chỉ số hiện tại. Kết quả là giá trị tối thiểu trong hai giá trị này tại chỉ số cuối cùng.

---
