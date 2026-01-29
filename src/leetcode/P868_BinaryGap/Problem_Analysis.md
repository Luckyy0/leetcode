# 868. Binary Gap / Khoảng cách Nhị phân

## Problem Description / Mô tả bài toán
Given a positive integer `n`, find and return the maximum distance between any two adjacent `1`'s in the binary representation of `n`.
Cho một số nguyên dương `n`, hãy tìm và trả về khoảng cách lớn nhất giữa hai số `1` liền kề trong biểu diễn nhị phân của `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation / Thao tác Bit
Algorithm:
1. Iterate through bits of `n` using `n >> 1`.
2. Keep track of the `lastIndex` where a '1' was found.
3. If current bit is '1' and `lastIndex != -1`:
   - `distance = currentIndex - lastIndex`.
   - Update `maxDistance`.
4. Update `lastIndex = currentIndex`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sequential bit check
Scan the binary digits of the number. By remembering the most recent position of a set bit, we can calculate the interval length whenever a subsequent set bit is encountered.
Quét các chữ số nhị phân của số đó. Bằng cách ghi nhớ vị trí gần nhất của một bit được thiết lập, chúng ta có thể tính toán độ dài khoảng bất cứ khi nào gặp một bit tiếp theo được thiết lập.

---
