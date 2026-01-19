# 60. Permutation Sequence / Chuỗi Hoán Vị

## Problem Description / Mô tả bài toán
The set `[1, 2, 3, ..., n]` contains a total of `n!` unique permutations.
Tập hợp `[1, 2, 3, ..., n]` chứa tổng cộng `n!` hoán vị duy nhất.

By listing and labeling all of the permutations in order, we get the following sequence for `n = 3`:
Bằng cách liệt kê và gắn nhãn tất cả các hoán vị theo thứ tự, chúng ta có chuỗi sau cho `n = 3`:
1.  "123"
2.  "132"
3.  "213"
4.  "231"
5.  "312"
6.  "321"

Given `n` and `k`, return the `k-th` permutation sequence.
Cho `n` và `k`, trả về chuỗi hoán vị thứ `k`.

### Example 1:
```text
Input: n = 3, k = 3
Output: "213"
```

### Example 2:
```text
Input: n = 4, k = 9
Output: "2314"
```

### Example 3:
```text
Input: n = 3, k = 1
Output: "123"
```

## Constraints / Ràng buộc
- `1 <= n <= 9`
- `1 <= k <= n!`

---

## Analysis / Phân tích

### Approach: Factorial Number System / Hệ Số Giai Thừa
- **Idea**: We can determine the digit at each position directly without generating all permutations.
- **Ý tưởng**: Chúng ta có thể xác định chữ số tại mỗi vị trí trực tiếp mà không cần tạo tất cả các hoán vị.
- **Logic**:
    - There are `(n-1)!` permutations starting with a specific digit.
    - The index of the first digit is `(k-1) / (n-1)!`.
    - We pick that digit from the list of available numbers.
    - Remove the digit.
    - Update `k = (k-1) % (n-1)!` and `n = n - 1`.
    - Repeat until all digits are picked.
- **Time Complexity**: O(n^2) because removing from a list takes O(n). Since n <= 9, this is very fast.
- **Space Complexity**: O(n).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: "1".
2.  **k = 1**: "123...".
3.  **k = n!**: "n...321".
