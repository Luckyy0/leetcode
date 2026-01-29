# 1053. Previous Permutation With One Swap / Hoán vị Trước đó Với Một lần Hoán đổi

## Problem Description / Mô tả bài toán
Given an array of positive integers `arr` (not necessarily distinct), return the lexicographically largest permutation that is smaller than `arr`, that can be **made with exactly one swap** (A swap exchanges the positions of two numbers `arr[i]` and `arr[j]`). If it cannot be done, then return the same array.
Cho một mảng các số nguyên dương `arr` (không nhất thiết phải phân biệt), hãy trả về hoán vị lớn nhất theo thứ tự từ điển, nhỏ hơn `arr`, mà có thể được **tạo ra bằng chính xác một lần hoán đổi** (Một lần hoán đổi trao đổi vị trí của hai số `arr[i]` và `arr[j]`). Nếu không thể thực hiện được, hãy trả về cùng một mảng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Search from Right / Tìm kiếm Tham lam từ Phải
We want the largest permutation smaller than current.
This means we want to find the "Previous Permutation".
Standard "Next Permutation" logic reversed.

Algorithm:
1. Iterate from right to left to find the first index `i` such that `arr[i] > arr[i+1]`. (This is the dip point).
   - If no such `i` (array is sorted sorted non-decreasing), return array.
2. We want to swap `arr[i]` with the largest value to its right that is *smaller* than `arr[i]`.
3. Let `j` be the index of such value. If there are duplicates, pick the *leftmost* one to keep lexicographical order largest (Wait, actually we swapping `arr[i]` with something smaller. To maximize the result, we want the prefix to be as large as possible).
   - `arr[i]` is reducing. The prefix before `i` stays same.
   - At position `i`, we put something smaller -> `arr[j]`. We want `arr[j]` to be as large as possible (closest to `arr[i]`).
   - If multiple elements have the same value `arr[j]`, which one to pick?
     - Example: `3, 1, 1, 3` -> No, example `1, 9, 4, 6, 7`. `7 > 6` ok. `6 > 4` ok. `4 < 9`. Wait.
     - Search from right: `arr`: `[3, 1, 1, 3]`. `1 < 3` ok. `1 = 1` ok. `3 > 1` break. `i=0` (val 3). We need swap 3 with largest value to right < 3. Values: `1, 1, 3`. Largest < 3 is 1. Indices of 1 are 1 and 2.
     - If we swap with index 1: `1, 3, 1, 3`.
     - If we swap with index 2: `1, 1, 3, 3`.
     - `1, 3, 1, 3` > `1, 1, 3, 3`. So we swap with index 1 (leftmost available).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Reverse Dip Detection
Find the first drop moving right-to-left (`arr[i] > arr[i+1]`). This identifies the most significant digit that can be reduced to create a smaller permutation. To keep it the "largest smaller", swap this digit with the largest number to its right that is strictly smaller than itself. If duplicates exist, choose the leftmost one to maximize the remaining suffix.
Tìm điểm giảm đầu tiên khi di chuyển từ phải sang trái (`arr[i] > arr[i+1]`). Điều này xác định chữ số quan trọng nhất có thể giảm để tạo ra hoán vị nhỏ hơn. Để giữ cho nó là "nhỏ hơn lớn nhất", hãy hoán đổi chữ số này với số lớn nhất ở bên phải nó mà nhỏ hơn chính nó. Nếu có các bản sao, hãy chọn bản sao ngoài cùng bên trái để tối đa hóa hậu tố còn lại.

---
