# 1109. Corporate Flight Bookings / Đặt chỗ Chuyến bay Doanh nghiệp

## Problem Description / Mô tả bài toán
There are `n` flights labeled from `1` to `n`.
You are given an array of flight bookings `bookings`, where `bookings[i] = [first, last, seats]`.
Return an array `answer` of length `n`, where `answer[i]` is the total number of seats reserved for flight `i`.
Có `n` chuyến bay được đánh số từ `1` đến `n`.
Bạn được cho một mảng đặt chỗ chuyến bay `bookings`, trong đó `bookings[i] = [first, last, seats]`.
Trả về một mảng `answer` có độ dài `n`, trong đó `answer[i]` là tổng số ghế được đặt cho chuyến bay `i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Difference Array / Prefix Sum / Mảng Hiệu / Tổng Tiền tố
Range update problem.
Add `seats` to range `[first, last]`.
Use difference array:
`diff[first] += seats`
`diff[last + 1] -= seats`
Finally, prefix sum of `diff` gives `answer`.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where M is number of bookings.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Difference Array Sweep
Treat seat reservations as range updates. Instead of iterating through every flight in the range for each booking (which would be slow), use a difference array. Increment the count at the start index and decrement at the index immediately following the end index. A single pass of prefix sums then reconstructs the total seats for all flights.
Coi việc đặt chỗ như là các bản cập nhật phạm vi. Thay vì lặp qua từng chuyến bay trong phạm vi cho mỗi đặt chỗ (điều này sẽ chậm), hãy sử dụng mảng hiệu số. Tăng số lượng tại chỉ số bắt đầu và giảm tại chỉ số ngay sau chỉ số kết thúc. Một lần duyệt tổng tiền tố sau đó xây dựng lại tổng số ghế cho tất cả các chuyến bay.

---
