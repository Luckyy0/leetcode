# 306. Additive Number / Số Cộng

## Problem Description / Mô tả bài toán
An **additive number** is a string whose digits can form an **additive sequence**.
Một **số cộng** là một chuỗi có các chữ số có thể tạo thành một **dãy số cộng**.

A valid **additive sequence** should contain **at least** three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
Một **dãy số cộng** hợp lệ phải chứa **ít nhất** ba số. Ngoại trừ hai số đầu tiên, mỗi số tiếp theo trong dãy phải là tổng của hai số đứng trước nó.

Given a string containing only digits, return `true` if it is an **additive number** or `false` otherwise.
Cho một chuỗi chỉ chứa các chữ số, trả về `true` nếu nó là một **số cộng** hoặc `false` nếu ngược lại.

Note: Numbers in the additive sequence **cannot** have leading zeros, so sequence `1, 2, 03` or `1, 02, 3` is invalid.
Lưu ý: Các số trong dãy số cộng **không thể** có số 0 ở đầu, vì vậy dãy `1, 2, 03` hoặc `1, 02, 3` là không hợp lệ.

### Example 1:
```text
Input: "112358"
Output: true
Explanation: 
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
```

### Example 2:
```text
Input: "199100199"
Output: true
Explanation: 
The additive sequence is: 1, 99, 100, 199. 
1 + 99 = 100, 99 + 100 = 199
```

## Constraints / Ràng buộc
- `1 <= num.length <= 35`
- `num` consists only of digits.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Brute Force with Validation
We only need to determine the **first two numbers** of the sequence. Once `num1` and `num2` are fixed, the rest of the sequence is determined (`num3 = num1 + num2`, `num4 = num2 + num3`, etc.).
We iterate all possible lengths for the first number `L1` and second number `L2`.
1.  `L1` from 1 to `N*2/3`.
2.  `L2` from 1 to `N - L1 - (start of num3)`.
3.  Extract `num1 = input.substring(0, L1)`.
4.  Extract `num2 = input.substring(L1, L1 + L2)`.
5.  Check leading zeros for `num1` and `num2`.
6.  Validate the rest of the string:
    - `sum = num1 + num2`.
    - `sumStr = toString(sum)`.
    - Check if remaining string starts with `sumStr`.
    - If yes, update `num1=num2`, `num2=sum` and repeat.
    - If valid until end, return True.

### Complexity / Độ phức tạp
- **Time**: `O(N^3)`. Loop L1 (N), Loop L2 (N), Validation (N). `N=35` is very small.
- **Space**: O(N) for substrings.

---

## Analysis / Phân tích

### Approach: Iterative first two numbers

**Limits**:
- `num` length 35 -> Need `BigInteger` or `Long`. `Long` max is 19 digits. Sum could exceed Long if N=35. `BigInteger` is safer for additions.
- Or implement string addition `addStrings(s1, s2)`. Given constraints, custom string addition or BigInteger is needed. I'll use `Long` for simplicity if numbers fit? Wait, 35 digits > Long. Must use String Addition or BigInteger. Since N=35, numbers can be ~17 digits, fitting in Long. Max seq: 17, 18 digits. Sum might be 18. Long is fine for up to 18 digits. But edge case: 35 digits/2 = 17.5. Two 17-digit numbers sum to 17 or 18. `Long.MAX_VALUE` is ~19 digits. So strictly speaking, `Long` *might* be enough for split, but let's assume worst case one number is 35 digits? No, min 3 numbers. So max len is N/2 ≈ 17. Safe to use `Long` if we handle edge cases, but LeetCode constraints `num.length <= 35` means intermediate sums can be large. Let's use `BigInteger` just to be safe and clean. Or simple recursive string check.

**Edge Cases**:
- Leading zeros: "1, 0, 1" is valid. "1, 2, 03" is invalid.
- `num1` "0" -> valid. "01" -> invalid.

---
