# 989. Add to Array-Form of Integer / Cộng với dạng mảng của số nguyên

## Problem Description / Mô tả bài toán
The **array-form** of an integer is an array representing its digits in order.
Dạng mảng của một số nguyên là một mảng đại diện cho các chữ số của nó theo thứ tự.

Given `num`, the array-form of an integer, and an integer `k`, return the array-form of the integer `num + k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Elementary Math / Addition / Toán học sơ cấp / Phép cộng
Algorithm:
1. Iterate from the last digit of `num` to the first.
2. In each step, add current digit and `k`.
3. The new digit is `(nums[i] + k) % 10`.
4. The remaining carry is `(nums[i] + k) / 10`, which becomes the new `k`.
5. After the loop, if `k > 0`, keep adding digits from `k`.

### Complexity / Độ phức tạp
- **Time**: O(max(N, log K)).
- **Space**: O(max(N, log K)).

---

## Analysis / Phân tích

### Approach: Right-to-Left Accumulation
Perform manual addition by treating the integer $K$ as a multi-digit carry. Starting from the least significant digit of the array, we combine and propagate values until both the array is exhausted and $K$ is reduced to zero.
Thực hiện phép cộng thủ công bằng cách coi số nguyên $K$ như một số dư có nhiều chữ số. Bắt đầu từ chữ số ít quan trọng nhất của mảng, chúng ta kết hợp và truyền các giá trị cho đến khi mảng cạn kiệt và $K$ giảm về không.

---
