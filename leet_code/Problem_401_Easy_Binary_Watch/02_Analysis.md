# Analysis for Binary Watch
# *Phân tích cho bài toán Đồng hồ Nhị phân*

## 1. Problem Essence & Enumeration
## *1. Bản chất vấn đề & Liệt kê*

### The Challenge
### *Thách thức*
Finding all combinations of hours (0-11) and minutes (0-59) such that the total number of set bits in their binary representation equals a given number `turnedOn`.

### Strategy: Brute Force Iteration
### *Chiến lược: Duyệt vét cạn*
Given the extremely small search space ($12 \times 60 = 720$ total possible times), the most efficient and simplest way is to iterate through every possible hour and minute.
1.  Loop `h` from 0 to 11.
2.  Loop `m` from 0 to 59.
3.  Calculate the number of bits set to 1 in `h` and `m`. In Java, we can use `Integer.bitCount()`.
4.  If `bitCount(h) + bitCount(m) == turnedOn`, format the time as "h:mm" and add to the result list.

---

## 2. Approach: Iterative Bit Counting
## *2. Hướng tiếp cận: Đếm Bit lặp*

### Logic
### *Logic*
(See above). We use `String.format("%d:%02d", h, m)` or similar string concatenation to ensure the correct output format (no leading zero for hours, two digits for minutes).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Efficiency:** The search space is constant (720 iterations), regardless of the input `turnedOn`.
    *Hiệu quả O(1): Không gian tìm kiếm là hằng số (720 lần lặp), không phụ thuộc vào đầu vào.*
*   **Simple Implementation:** Avoids complex backtracking or bit manipulation logic since the range is small.
    *Triển khai đơn giản: Tránh được logic quay lui hay thao tác bit phức tạp vì phạm vi nhỏ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ (specifically $12 \times 60$ iterations).
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$ extra space (the result list depends on the output size, but the algorithm uses constant memory).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `turnedOn = 1`
1. `h=0 (0000), m=1 (000001)`. Total bits: 0 + 1 = 1. Add "0:01".
2. `h=0 (0000), m=2 (000010)`. Total bits: 0 + 1 = 1. Add "0:02".
...
3. `h=1 (0001), m=0 (000000)`. Total bits: 1 + 0 = 1. Add "1:00".
...
Result: `["0:01", "0:02", ..., "1:00", ...]`

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple iteration with `bitCount`.
*Duyệt lặp đơn giản với bitCount.*
---
*Thời gian (time) là một dòng chảy liên tục, nhưng trong thế giới nhị phân (binary watch), nó được cấu thành từ những xung nhịp bật-tắt (bits). Bằng cách duyệt qua mọi khả năng hiện hữu và đếm những "ngọn nến" đang thắp sáng (turnedOn), ta tìm thấy những khoảnh khắc mà sự đơn giản gặp gỡ sự chính xác.*
Time is a continuous flow, but in the binary world (binary watch), it is composed of on-off pulses (bits). By looking through every possibility and counting the "candles" being lit (turnedOn), we find moments where simplicity meets precision.
