# 710. Random Pick with Blacklist / Chọn Ngẫu nhiên với Danh sách Đen

## Problem Description / Mô tả bài toán
You are given an integer `n` and an array of **unique** integers `blacklist`. Design an algorithm to pick a random integer in the range `[0, n - 1]` that is **not** in `blacklist`. Any non-blacklisted integer should be equally likely to be returned.
Bạn được cho một số nguyên `n` và một mảng các số nguyên **duy nhất** `blacklist`. Hãy thiết kế một thuật toán để chọn một số nguyên ngẫu nhiên trong phạm vi `[0, n - 1]` **không** nằm trong `blacklist`. Bất kỳ số nguyên nào không nằm trong danh sách đen đều phải có khả năng được trả về như nhau.

Minimize the number of calls to the system's `Math.random()`.
Giảm thiểu số lần gọi hàm `Math.random()` của hệ thống.

Implement the `Solution` class:
- `Solution(int n, int[] blacklist)` Initializes the object with the integer `n` and `blacklist`.
- `int pick()` Returns a random integer in the range `[0, n - 1]` and not in `blacklist`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mapping / Ánh xạ
There are `n - blacklist.length` valid numbers.
Có `n - blacklist.length` số hợp lệ.

Let `M = n - blacklist.length`.
We want to pick a random number in `[0, M - 1]`.
Nếu số được chọn `x` nằm trong `blacklist` (và `x < M`), chúng ta cần ánh xạ nó tới một số hợp lệ trong phạm vi `[M, n - 1]`.

Algorithm:
1. Identify all blacklist numbers `< M`.
2. Identify all non-blacklist numbers `>= M`.
3. Create a map from those specific blacklist numbers to those specific valid numbers.

### Complexity / Độ phức tạp
- **Time**: `Constructor`: O(B) where B is blacklist size. `pick`: O(1).
- **Space**: O(B).

---

## Analysis / Phân tích

### Approach: Virtual Range with Mapping
Pick a random number in the range `[0, num_valid - 1]`. If the picked number is in the blacklist, use a hash map to return a corresponding valid number from the "upper" range.
Chọn một số ngẫu nhiên trong phạm vi `[0, num_valid - 1]`. Nếu số được chọn nằm trong danh sách đen, hãy sử dụng bản đồ băm để trả về một số hợp lệ tương ứng từ phạm vi "trên".

---
