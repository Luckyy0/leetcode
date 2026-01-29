# 1238. Circular Permutation in Binary Representation / Hoán vị Vòng tròn trong Biểu diễn Nhị phân

## Problem Description / Mô tả bài toán
Given `n` and `start`. Return a permutation of `0` to `2^n - 1` such that:
- `p[0] == start`.
- `p[i]` and `p[i+1]` differ by exactly one bit.
- `p[last]` and `p[0]` differ by exactly one bit.
(Gray Code starting at specific value).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Gray Code Generation / Tạo Mã Gray
Standard Gray Code for `n` bits: `G(i) = i ^ (i >> 1)`.
This sequence starts at 0. `0, 1, 3, 2, ...`.
We want it to start at `start`.
Since Gray Code is cyclic (last and first diff by 1 bit), we can just rotate the standard sequence until `start` is at index 0.
Algorithm:
1. Generate standard Gray Code list.
2. Find index of `start`.
3. Rotate list.
Or better: Iterate `i` from 0 to `2^n-1`. Calculate `g = i ^ (i >> 1)`.
XOR `g` with `start`. WHY?
Wait. `x ^ y` has same bit difference properties if we XOR everything by a constant `C`?
`diff(a^C, b^C) = diff(a, b)`. Yes.
Standard Gray Code starts at 0: `0, 1, ...`.
We want start at `S`.
Sequence: `0^S, 1^S, 3^S ...`.
First element is `0^S = S`.
Bit difference between adjacent: `diff(G[i]^S, G[i+1]^S) = diff(G[i], G[i+1]) = 1 bit`.
So simply generate `G[i] ^ start`.

### Complexity / Độ phức tạp
- **Time**: O(2^N).
- **Space**: O(2^N).

---

## Analysis / Phân tích

### Approach: Rotated Gray Code via XOR
A standard Gray code sequence $G$ starts with 0 and has the property that adjacent elements differ by 1 bit. We want a sequence starting with `start` that maintains this property. Since XORing all elements of a Gray code by a constant value `start` preserves the bitwise Hamming distance between elements, the sequence $G_i \oplus \text{start}$ will be a valid circular permutation starting at $0 \oplus \text{start} = \text{start}$.
Một chuỗi mã Gray tiêu chuẩn $G$ bắt đầu bằng 0 và có thuộc tính là các phần tử liền kề khác nhau 1 bit. Chúng ta muốn một chuỗi bắt đầu bằng `start` duy trì thuộc tính này. Vì việc XOR tất cả các phần tử của mã Gray với một giá trị không đổi `start` sẽ bảo toàn khoảng cách Hamming theo bit giữa các phần tử, chuỗi $G_i \oplus \text{start}$ sẽ là một hoán vị vòng tròn hợp lệ bắt đầu tại $0 \oplus \text{start} = \text{start}$.

---
