# 1310. XOR Queries of a Subarray / Truy vấn XOR của Mảng con

## Problem Description / Mô tả bài toán
Array `arr`. Queries `[L, R]`.
Return `arr[L] ^ arr[L+1] ^ ... ^ arr[R]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix XOR
Similar to Prefix Sum. `A ^ A = 0`.
`Prefix[i] = arr[0] ^ ... ^ arr[i]`.
Range XOR `[L, R]` = `Prefix[R] ^ Prefix[L-1]`.
Corner case L=0: `Prefix[R]`.

### Complexity / Độ phức tạp
- **Time**: O(N) prep + O(Q) query.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Prefix XOR Array
Construct a prefix XOR array `prefix` where `prefix[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]`.
For a query `[L, R]`:
- If `L == 0`, the answer is `prefix[R]`.
- If `L > 0`, the answer is `prefix[R] ^ prefix[L-1]`.
This leverages the property $x \oplus x = 0$, so XORing the prefix up to $R$ with the prefix up to $L-1$ cancels out the elements before $L$, leaving the XOR sum of the subarray.
Xây dựng mảng tiền tố XOR `prefix` trong đó `prefix[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]`.
Đối với truy vấn `[L, R]`:
- Nếu `L == 0`, câu trả lời là `prefix[R]`.
- Nếu `L > 0`, câu trả lời là `prefix[R] ^ prefix[L-1]`.
Điều này tận dụng thuộc tính $x \oplus x = 0$, vì vậy việc XOR tiền tố lên đến $R$ với tiền tố lên đến $L-1$ sẽ loại bỏ các phần tử trước $L$, để lại tổng XOR của mảng con.

---
