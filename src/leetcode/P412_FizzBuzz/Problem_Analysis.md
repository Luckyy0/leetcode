# 412. Fizz Buzz / Trò Chơi Fizz Buzz

## Problem Description / Mô tả bài toán
Given an integer `n`, return a string array `answer` (1-indexed) where:
Cho một số nguyên `n`, hãy trả về một mảng chuỗi `answer` (bắt đầu từ 1) trong đó:

- `answer[i] == "FizzBuzz"` if `i` is divisible by 3 and 5.
- `answer[i] == "Fizz"` if `i` is divisible by 3.
- `answer[i] == "Buzz"` if `i` is divisible by 5.
- `answer[i] == i` (as a string) if none of the above conditions are true.

### Example 1:
```text
Input: n = 3
Output: ["1","2","Fizz"]
```

### Example 2:
```text
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
```

### Example 3:
```text
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
```

## Constraints / Ràng buộc
- `1 <= n <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Conditional Logic / Logic có điều kiện
Loop through numbers from 1 to `n` and check divisibility using the modulo operator `%`.
Note: Check divisibility by both 3 and 5 (i.e., by 15) first, then by 3, and then by 5.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (excluding the space for the result list).

---

## Analysis / Phân tích

### Approach: Linear Iteration

**Algorithm**:
1.  Initialize a list of strings.
2.  Loop from `i = 1` to `n`.
3.  Append appropriate string based on conditions.

---
