# 800. Similar RGB Color / Màu RGB Tương tự

## Problem Description / Mô tả bài toán
The distance between two colors `color1` and `color2` is the negative sum of square differences.
Khoảng cách giữa hai màu `color1` và `color2` là tổng bình phương các hiệu số.

A shorthand RGB color like `#ABC` is the same as `#AABBCC`.
Màu RGB viết tắt như `#ABC` giống với `#AABBCC`.

Given a color `#AABBCC`, find a shorthand color `#XYZ` such that the distance between `#AABBCC` and `#XXYYZZ` is minimized.
Cho màu `#AABBCC`, hãy tìm một màu viết tắt `#XYZ` sao cho khoảng cách giữa `#AABBCC` và `#XXYYZZ` là nhỏ nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Channel-wise Optimization / Tối ưu hóa theo từng Kênh
Since the distance is a sum of independent channel square differences, we can optimize each channel (R, G, B) independently.
Vì khoảng cách là tổng các bình phương hiệu số của các kênh độc lập, chúng ta có thể tối ưu hóa từng kênh (R, G, B) một cách độc lập.

For a channel value `V` (in hex), we want to find a digit `d` such that the value `(dd)_16` is closest to `V`.
The possible values for `(dd)_16` are `00, 11, 22, ..., ff`. (These are multiples of 17).

Algorithm:
1. For each 2-digit hex string `part`:
   - Convert to decimal `val`.
   - Find `round(val / 17.0)`.
   - Clamp between 0 and 15.
   - Result is `(round * 17)` in hex.

### Complexity / Độ phức tạp
- **Time**: O(1) (fixed number of channels).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Rounding to Multiples of 17
Each channel in a shorthand color `#ABC` corresponds to a hex value `XX`. these values are always multiples of 17 (e.g., `0x11 = 17`, `0x22 = 34`). We simply round the input channel to the nearest multiple of 17.
Mỗi kênh trong màu viết tắt `#ABC` tương ứng với một giá trị hex `XX`. Các giá trị này luôn là bội số của 17. Chúng ta chỉ cần làm tròn kênh đầu vào thành bội số gần nhất của 17.

---
