# 1423. Maximum Points You Can Obtain from Cards / Điểm Tối đa Bạn Có thể Nhận được từ Thẻ

## Problem Description / Mô tả bài toán
Array `cardPoints`. Take `k` cards from either start or end.
Maximize total points.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window (Reverse)
Taking `k` cards from ends is equivalent to leaving `n-k` contiguous cards in the middle with Minimum Sum.
Total Sum - Min Subarray Sum of length `n-k`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Fixed Size Sliding Window
Calculate total sum of the array. Let `windowSize = n - k`.
Find the subarray of length `windowSize` with the minimum sum. Using a sliding window.
The answer is `totalSum - minWindowSum`.
Wait, if `k == n`, window size is 0, min sum is 0. Answer is `totalSum`.
Handle window init.
Tính tổng của mảng. Gọi `windowSize = n - k`.
Tìm mảng con có độ dài `windowSize` với tổng nhỏ nhất. Sử dụng cửa sổ trượt.
Câu trả lời là `totalSum - minWindowSum`.

---
