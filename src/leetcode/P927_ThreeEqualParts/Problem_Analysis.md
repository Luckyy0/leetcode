# 927. Three Equal Parts / Ba Phần Bằng nhau

## Problem Description / Mô tả bài toán
You are given an array `arr` consisting of `0`s and `1`s. Divide the array into three non-empty parts such that all of them represent the same binary value.
Bạn được cho một mảng `arr` gồm các số `0` và `1`. Hãy chia mảng thành ba phần không rỗng sao cho tất cả chúng đại diện cho cùng một giá trị nhị phân.

Return `[i, j]` such that `[0...i]`, `[i+1...j-1]`, and `[j...n-1]` are the three parts. If impossible, return `[-1, -1]`.
Trả về `[i, j]` sao cho `[0...i]`, `[i+1...j-1]`, và `[j...n-1]` là ba phần đó. Nếu không thể, trả về `[-1, -1]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Constant One-Count and Trailing Zeroes / Số lượng số Một không đổi và các số Không ở cuối
Algorithm:
1. Total number of '1's must be divisible by 3. Let `k = totalOnes / 3`.
2. Find the starting index of the first '1' in each of the three parts (1st, `k+1`-th, `2k+1`-th).
3. The suffix after the third part determines the number of trailing zeroes each part must have.
4. Compare the three segments bit by bit. They must match exactly.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Triple Suffix Matching
The key insight is that the last part is fixed; it defines the required pattern and the number of trailing zeroes. By identifying the start of each segment and comparing them linearly against the final segment, we verify the equality of the three numeric representations.
Điểm mấu chốt là phần cuối cùng là cố định; nó xác định mẫu yêu cầu và số lượng số không ở cuối. Bằng cách xác định điểm bắt đầu của mỗi phân đoạn và so sánh chúng một cách tuyến tính với phân đoạn cuối cùng, chúng ta xác minh tính bằng nhau của ba biểu diễn số.

---
