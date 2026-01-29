# 941. Valid Mountain Array / Mảng Núi Hợp lệ

## Problem Description / Mô tả bài toán
Given an array of integers `arr`, return `true` if it is a valid mountain array.
Cho một mảng các số nguyên `arr`, hãy trả về `true` nếu nó là một mảng núi hợp lệ.

A mountain array has:
- `arr.length >= 3`
- There exists some `i` (slope peak) such that:
  - `arr[0] < arr[1] < ... < arr[i]`
  - `arr[i] > arr[i+1] > ... > arr[arr.length-1]`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Linear Scan with Peak Validation / Quét tuyến tính với Xác thực Đỉnh
Algorithm:
1. Start `i = 0`.
2. Climb up: while `i+1 < n` and `arr[i] < arr[i+1]`, increment `i`.
3. Check if `i` is a valid peak: `i > 0` and `i < n - 1`.
4. Climb down: while `i+1 < n` and `arr[i] > arr[i+1]`, increment `i`.
5. Return `i == n - 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Structural Ascent and Descent
Simulate the journey of climbing a mountain. We must ascend to a single peak that isn't at the very beginning or end, and then descend consistently until the termination of the array.
Mô phỏng hành trình leo núi. Chúng ta phải leo lên một đỉnh duy nhất không nằm ở ngay đầu hoặc cuối, sau đó đi xuống một cách nhất quán cho đến khi kết thúc mảng.

---
