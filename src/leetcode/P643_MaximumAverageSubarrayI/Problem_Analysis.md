# 643. Maximum Average Subarray I / Mảng Con Trung Bình Lớn Nhất I

## Problem Description / Mô tả bài toán
You are given an integer array `nums` consisting of `n` elements, and an integer `k`.
Bạn được cho một mảng số nguyên `nums` bao gồm `n` phần tử và một số nguyên `k`.

Find a contiguous subarray whose length is equal to `k` that has the maximum average value, and return this value. Any answer with a calculation error less than `10^-5` will be accepted.
Tìm một mảng con liên tiếp có độ dài bằng `k` có giá trị trung bình lớn nhất và trả về giá trị này. Bất kỳ câu trả lời nào có sai số tính toán nhỏ hơn `10^-5` sẽ được chấp nhận.

### Example 1:
```text
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa Sổ Trượt
We need max sum of subarray of length `k`.
Calculate sum of first `k` elements.
Slide window one step right: subtract outgoing element, add incoming element.
Track `maxSum`.
Result is `maxSum / k`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Fixed Size Sliding Window

**Algorithm**:
1.  Compute sum of first k elements.
2.  Iterate from k to n.
3.  Update sum and max sum.
4.  Return max sum / k.

---
