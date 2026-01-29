# 1375. Number of Times Binary String Is Prefix-Aligned / Số Lần Chuỗi Nhị phân Được Căn chỉnh Tiền tố

## Problem Description / Mô tả bài toán
Binary string `s` initially all 0.
Array `flips`: step `i`, bit `flips[i]` becomes 1.
Prefix-aligned: First `k` bits are 1, rest 0.
Count steps where string is prefix-aligned.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Max Tracking
At step `i` (1-based), we have turned on `i` bits.
For string to be prefix-aligned (first `i` bits are 1), the indices turned on MUST be `1, 2, ..., i`.
This happens if `max(indices so far) == i`.
Simple logic:
Iterate throws flips. Track `maxIndex`.
If `maxIndex == i + 1` (since 0-indexed or 1-indexed? Problem uses 1-based indices), then aligned.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Max Index Tracking
Iterate through the `flips` array. Let `currentStep` range from 1 to `n`. Update `maxIndex` seen so far. If `maxIndex == currentStep`, it means all bits from 1 to `currentStep` have been flipped (since we have seen `currentStep` distinct flips and the max is exactly `currentStep`, no holes possible). Increment count.
Lặp qua mảng `flips`. Để `currentStep` trong khoảng từ 1 đến `n`. Cập nhật `maxIndex` đã thấy cho đến nay. Nếu `maxIndex == currentStep`, điều đó có nghĩa là tất cả các bit từ 1 đến `currentStep` đã bị lật (vì chúng ta đã thấy `currentStep` lần lật riêng biệt và tối đa chính xác là `currentStep`, không có lỗ nào có thể xảy ra). Tăng số đếm.

---
