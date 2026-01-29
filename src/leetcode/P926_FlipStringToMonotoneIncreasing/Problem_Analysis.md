# 926. Flip String to Monotone Increasing / Lật Chuỗi để Tăng đơn điệu

## Problem Description / Mô tả bài toán
A binary string is monotone increasing if it consists of some number of `0`s followed by some number of `1`s.
Một chuỗi nhị phân là tăng đơn điệu nếu nó bao gồm một số lượng số `0` và theo sau là một số lượng số `1`.

Given a binary string `s`, you can flip `0` to `1` or `1` to `0`. Return the minimum number of flips to make `s` monotone increasing.
Cho một chuỗi nhị phân `s`, bạn có thể lật `0` thành `1` hoặc `1` thành `0`. Hãy trả về số lượng lật ít nhất để làm cho `s` tăng đơn điệu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / One-pass Solution / Quy hoạch động / Giải pháp một lần duyệt
Algorithm:
1. Maintain `onesCount` (number of '1's seen so far).
2. Maintain `flipCount` (minimum flips needed to make the string up to current index monotone increasing).
3. For each char `c`:
   - If `c == '1'`, `onesCount++`.
   - If `c == '0'`:
     - We have two choices:
       1. Flip current '0' to '1' (cost: `flipCount + 1`).
       2. Keep current '0', but flip all previous '1's to '0' (cost: `onesCount`).
     - `flipCount = min(flipCount + 1, onesCount)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Dilemma Minimization
For every '0' encountered, we weigh the cost of flipping it against the cost of flipping all preceding '1's. By maintaining the minimum of these two penalties, we derive the optimal conversion strategy incrementally.
Đối với mỗi số '0' bắt gặp, chúng ta cân nhắc chi phí của việc lật nó so với chi phí của việc lật tất cả các số '1' đứng trước. Bằng cách duy trì giá trị nhỏ nhất của hai hình phạt này, chúng ta suy ra chiến lược chuyển đổi tối ưu một cách tăng dần.

---
