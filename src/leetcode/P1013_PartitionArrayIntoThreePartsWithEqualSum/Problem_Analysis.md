# 1013. Partition Array Into Three Parts With Equal Sum / Chia Mảng thành Ba phần có Tổng Bằng nhau

## Problem Description / Mô tả bài toán
Given an array of integers `arr`, return `true` if we can partition the array into three non-empty parts with equal sums.
Cho một mảng các số nguyên `arr`, hãy trả về `true` nếu chúng ta có thể chia mảng thành ba phần không rỗng có tổng bằng nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum / Tổng Tiền tố
Algorithm:
1. Calculate `totalSum`. If `totalSum % 3 != 0`, return `false`.
2. Target part sum: `target = totalSum / 3`.
3. Iterate through array, accumulating sum.
4. Count how many times we reach `target`.
5. If we reach `target` at least 3 times, return `true`.

Important Note:
Simply finding two cuts is enough.
Once `currentSum == target`, reset (implied) or denote found part. Iterate to find second part. If second part found, remaining is third part (which must be equal to target).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Target Accumulation
Validate divisibility by 3 first. Then sweep through the array to check if the cumulative sum hits one-third and two-thirds of the total at legitimate partition points.
Xác thực khả năng chia hết cho 3 trước. Sau đó quét qua mảng để kiểm tra xem tổng tích lũy có đạt đến một phần ba và hai phần ba của tổng số tại các điểm phân vùng hợp lệ hay không.

---
