# 1184. Distance Between Bus Stops / Khoảng cách Giữa các Trạm xe buýt

## Problem Description / Mô tả bài toán
A bus has `n` stops numbered from 0 to `n-1`.
Distance between `i` and `(i+1)%n` is `distance[i]`.
Return shortest distance between `start` and `destination`.
Direction can be clockwise or counter-clockwise.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Array Sum / Path Finding
Clockwise distance: Direct sum from start to dest.
Counter-clockwise distance: Total sum - Clockwise distance.
Return min.

---
