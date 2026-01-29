# 849. Maximize Distance to Closest Person / Tối đa hóa Khoảng cách đến Người gần nhất

## Problem Description / Mô tả bài toán
You are given an array `seats` representing a row of seats where `1` represents a person and `0` represents an empty seat.
Bạn được cho một mảng `seats` đại diện cho một hàng ghế, trong đó `1` đại diện cho một người đang ngồi và `0` là ghế trống.

You want to sit in an empty seat such that the distance to the closest person is maximized. Return that maximum distance.
Bạn muốn ngồi vào một ghế trống sao cho khoảng cách đến người gần nhất là lớn nhất. Trả về khoảng cách tối đa đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Gap Analysis / Phân tích Khoảng trống
There are three types of gaps:
Có ba loại khoảng trống:
1. **Leading zeroes**: Distance is the count of zeroes.
2. **Trailing zeroes**: Distance is the count of zeroes.
3. **Zeroes between two ones**: Distance is `(count + 1) / 2`.

Algorithm:
1. Iterate through strings and count consecutive zeroes.
2. Track cases carefully for head and tail of the array.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sequential Scan
Measure the length of all contiguous blocks of empty seats. The rules for "social distancing" differ for interior gaps versus end-of-row gaps, as the latter are only constrained by a single neighbor.
Đo chiều dài của tất cả các khối ghế trống liên tiếp. Các quy tắc "giãn cách xã hội" khác nhau đối với các khoảng trống ở giữa so với các khoảng trống ở hai đầu hàng, vì loại sau chỉ bị ràng buộc bởi một hàng xóm duy nhất.

---
