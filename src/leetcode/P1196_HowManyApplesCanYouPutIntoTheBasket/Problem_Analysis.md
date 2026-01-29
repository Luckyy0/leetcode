# 1196. How Many Apples Can You Put into the Basket / Bạn có thể Đặt bao nhiêu Quả táo vào Giỏ

## Problem Description / Mô tả bài toán
You have some apples, where `arr[i]` is the weight of the `i-th` apple.  You also have a basket that can carry up to `5000` units of weight.
Return the maximum number of apples you can put in the basket.
Bạn có một số quả táo, trong đó `arr[i]` là trọng lượng của quả táo thứ `i`. Bạn cũng có một cái giỏ có thể chứa tối đa `5000` đơn vị trọng lượng.
Trả về số lượng quả táo tối đa bạn có thể đặt vào giỏ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach / Cách tiếp cận Tham lam
Sort array. Take smallest apples first until weight > 5000.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N) sorting.

---
