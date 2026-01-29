# 739. Daily Temperatures / Nhiệt độ Hàng ngày

## Problem Description / Mô tả bài toán
Given an array of integers `temperatures` represents the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `ith` day to get a warmer temperature.
Cho một mảng các số nguyên `temperatures` đại diện cho nhiệt độ hàng ngày, hãy trả về một mảng `answer` sao cho `answer[i]` là số ngày bạn phải đợi sau ngày thứ `i` để có nhiệt độ ấm hơn.

If there is no future day for which this is possible, keep `answer[i] == 0` instead.
Nếu không có ngày nào trong tương lai khả thi, hãy để `answer[i] == 0`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
We want to find the next greater element for each index.
Chúng ta muốn tìm phần tử lớn hơn tiếp theo cho mỗi chỉ số.

Algorithm:
1. Maintain a stack of indices whose temperatures have not yet found a "warmer" successor.
2. For each day `i`:
   - While `stack` is not empty and `temp[i] > temp[stack.peek()]`:
     - Pop `prevIndex`.
     - `result[prevIndex] = i - prevIndex`.
   - Push `i`.

### Complexity / Độ phức tạp
- **Time**: O(N) because each index is pushed and popped exactly once.
- **Space**: O(N) for the stack.

---

## Analysis / Phân tích

### Approach: Monotonic Increasing Stack logic
By keeping indices of decreasing temperatures in the stack, once we see a higher temperature, we can "settle" all indices in the stack that are smaller than the current one.
Bằng cách giữ các chỉ số có nhiệt độ giảm dần trong ngăn xếp, một khi chúng ta thấy nhiệt độ cao hơn, chúng ta có thể "giải quyết" tất cả các chỉ số trong ngăn xếp nhỏ hơn nhiệt độ hiện tại.

---
