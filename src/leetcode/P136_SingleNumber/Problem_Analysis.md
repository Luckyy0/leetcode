# 136. Single Number / Số Độc Nhất

## Problem Description / Mô tả bài toán
Given a **non-empty** array of integers `nums`, every element appears twice except for one. Find that single one.
Cho một mảng số nguyên **không rỗng** `nums`, mỗi phần tử xuất hiện hai lần ngoại trừ một phần tử. Hãy tìm phần tử độc nhất đó.

You must implement a solution with a **linear** runtime complexity and use only **constant** extra space.
Bạn phải triển khai một giải pháp với độ phức tạp thời gian **tuyến tính** và chỉ sử dụng không gian bổ sung **hằng số**.

### Example 1:
```text
Input: nums = [2,2,1]
Output: 1
```

### Example 2:
```text
Input: nums = [4,1,2,1,2]
Output: 4
```

### Example 3:
```text
Input: nums = [1]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 3 * 10^4`
- `-3 * 10^4 <= nums[i] <= 3 * 10^4`
- Each element in the array appears twice except for one element which appears only once.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Manipulation (XOR) / Thao tác Bit (XOR)
The XOR operator (`^`) has several key properties that make it perfect for this problem:
Toán tử XOR (`^`) có một số tính chất quan trọng khiến nó trở nên hoàn hảo cho bài toán này:
1.  **Identity**: `a ^ 0 = a`
2.  **Self-Inverse**: `a ^ a = 0`
3.  **Commutative and Associative**: The order of XOR operations doesn't matter.

If we XOR all the numbers in the array together:
Nếu chúng ta XOR tất cả các số trong mảng với nhau:
- The numbers that appear twice will XOR together to result in `0` (`a ^ a = 0`).
- The single number will remain because `X ^ 0 = X`.

---

## Analysis / Phân tích

### Approach: Bitwise XOR / XOR Bitwise

**Algorithm**:
1.  Initialize `result = 0`.
2.  For each `num` in `nums`, `result = result ^ num`.
3.  Return `result`.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass through the array.
- **Space**: O(1) - only one variable for the result.

---

## Edge Cases / Các trường hợp biên
1.  **Array length 1**: Handled by initial XOR with 0.
2.  **Negative numbers**: XOR works the same for negative numbers (it's bitwise).
3.  **Large array**: Linear time ensures performance.
