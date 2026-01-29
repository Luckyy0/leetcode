# 969. Pancake Sorting / Sắp xếp Bánh kếp

## Problem Description / Mô tả bài toán
Given an array of integers `arr`, sort the array by performing a series of **pancake flips**.
Cho một mảng các số nguyên `arr`, hãy sắp xếp mảng bằng cách thực hiện một loạt các phép **lật bánh kếp (pancake flips)**.

In one pancake flip, we reverse a prefix of the array.
Trong một phép lật bánh kếp, chúng ta đảo ngược một tiền tố của mảng.

Return a sequence of $k$ values for the flips.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Selection (Move Largest to End) / Lựa chọn Tham lam (Chuyển phần tử lớn nhất về cuối)
Algorithm:
1. Find the index `idx` of the largest unsorted number `target`.
2. Flip `idx + 1` to bring `target` to the front.
3. Flip the entire unsorted length to bring `target` to its final position.
4. Repeat for the next largest number.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N) for result list.

---

## Analysis / Phân tích

### Approach: Two-Stage Pivoting
Sort the array by positioning the largest remaining value at its target index using at most two flips per element. The first flip brings the maximum to the front, and the second flip places it correctly at the "back" of the current unsorted segment.
Sắp xếp mảng bằng cách đặt giá trị lớn nhất còn lại vào chỉ số mục tiêu của nó bằng cách sử dụng tối đa hai lần lật cho mỗi phần tử. Lần lật đầu tiên đưa giá trị lớn nhất lên phía trước và lần lật thứ hai đặt nó chính xác vào "phía sau" của phân đoạn chưa được sắp xếp hiện tại.

---
