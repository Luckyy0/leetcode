# 932. Beautiful Array / Mảng Đẹp

## Problem Description / Mô tả bài toán
An array `nums` of length `n` is beautiful if for every `i < k < j`, there is no `k` such that `2 * nums[k] == nums[i] + nums[j]`.
Mảng `nums` có độ dài `n` được gọi là đẹp nếu với mọi `i < k < j`, không tồn tại `k` sao cho `2 * nums[k] == nums[i] + nums[j]`.

Given `n`, return any beautiful array `nums`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divide and Conquer / Chia để trị
A key observation:
If we put all odd numbers on the left and all even numbers on the right, any `nums[i]` (odd) + `nums[j]` (even) will be odd, so its sum cannot be `2 * nums[k]` (which is always even).
Một quan sát quan trọng: Nếu ta đặt tất cả các số lẻ sang bên trái và tất cả các số chẵn sang bên phải, thì bất kỳ số lẻ nào cộng với một số chẵn sẽ ra kết quả lẻ, do đó tổng của chúng không thể bằng `2 * nums[k]` (vốn luôn chẵn).

Algorithm:
1. Start with `[1]`.
2. To build an array of size `2*N`:
   - Take the array for size `N`.
   - Map each `x` to `2*x - 1` (odd part).
   - Map each `x` to `2*x` (even part).
   - Concatenate.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N log N).

---

## Analysis / Phân tích

### Approach: Parity Separation
Decompose the problem by segregating elements based on parity. This linear transformation ($2x$ and $2x-1$) preserves the "beautiful" property of sub-problems, allowing us to build the final arrangement from a base case through recursive scaling.
Phân tích bài toán bằng cách tách biệt các phần tử dựa trên tính chẵn lẻ. Phép biến đổi tuyến tính này ($2x$ và $2x-1$) bảo toàn thuộc tính "đẹp" của các bài toán con, cho phép chúng ta xây dựng sự sắp xếp cuối cùng từ một trường hợp cơ sở thông qua việc mở rộng đệ quy.

---
