# 683. K Empty Slots / K Vị trí Trống

## Problem Description / Mô tả bài toán
You have `n` bulbs in a row numbered from 1 to `n`. Initially, all the bulbs are turned off. We turn on exactly one bulb every day until all bulbs are on after `n` days.
Bạn có `n` bóng đèn liên tiếp được đánh số từ 1 đến `n`. Ban đầu, tất cả các bóng đèn đều tắt. Chúng ta bật đúng một bóng đèn mỗi ngày cho đến khi tất cả các bóng đèn đều bật sau `n` ngày.

You are given an array `bulbs` of length `n` where `bulbs[i] = x` means that on the `(i+1)th` day, we will turn on the bulb at position `x`.
Bạn được cho một mảng `bulbs` có độ dài `n` trong đó `bulbs[i] = x` có nghĩa là vào ngày thứ `(i+1)`, chúng ta sẽ bật bóng đèn tại vị trí `x`.

Given an integer `k`, return the minimum day number such that there exists two turned on bulbs that have exactly `k` bulbs between them that are **all turned off**. If no such day exists, return -1.
Cho một số nguyên `k`, hãy trả về số ngày tối thiểu sao cho tồn tại hai bóng đèn đang bật có đúng `k` bóng đèn ở giữa chúng mà **tất cả đều đang tắt**. Nếu không có ngày như vậy, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window on Days / Cửa sổ Trượt trên Ngày
Convert the `bulbs` array (day -> position) into a `days` array (position -> day).
`days[i]` is the day on which the bulb at position `i` is turned on.
Chuyển đổi mảng `bulbs` (ngày -> vị trí) thành mảng `days` (vị trí -> ngày).

We are looking for a window `[i, i + k + 1]` such that:
1. `days[i]` and `days[i + k + 1]` are smaller than all `days[j]` for `i < j < i + k + 1`.
Điều này có nghĩa là bóng đèn ở vị trí `i` và `i+k+1` được bật trước mọi bóng đèn ở giữa chúng.
Nếu điều kiện này thỏa mãn, ngày hợp lệ là `max(days[i], days[i + k + 1])`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of bulbs.
- **Space**: O(N) to store the `days` array.

---

## Analysis / Phân tích

### Approach: Window Validity Checking
Initialize a window. Slide through the positions. If you find a bulb inside the window that turns on *before* the window boundaries, skip past it. If the entire window is valid, track the minimum finish day.
Khởi tạo một cửa sổ. Trượt qua các vị trí. Nếu bạn tìm thấy một bóng đèn bên trong cửa sổ bật lên *trước* ranh giới cửa sổ, hãy bỏ qua nó. Nếu toàn bộ cửa sổ hợp lệ, hãy theo dõi ngày hoàn thành tối thiểu.

---
