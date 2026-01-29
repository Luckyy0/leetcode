# 940. Distinct Subsequences II / Các Dãy con Khác nhau II

## Problem Description / Mô tả bài toán
Given a string `s`, return the number of distinct non-empty subsequences of `s`. Modulo 10^9 + 7.
Cho một chuỗi `s`, hãy trả về số lượng các dãy con không rỗng khác nhau của `s`. Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Duplicate Subtraction / Quy hoạch động / Trừ trùng lặp
Let `dp[i]` be the number of distinct subsequences using `s[0...i-1]`.
When adding `s[i]`:
- New subsequences = `dp[i-1] * 2`.
- But if `s[i]` has appeared before, we have counted some subsequences twice.
- We subtract the number of subsequences that were formed before the *previous* occurrence of `s[i]`.

Algorithm:
`dp[i] = dp[i-1] * 2 - dp[lastIndex[s[i-1]] - 1]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Cumulative Growth with Deduplication
Model the number of subsequences as a growing set. For each new character, we theoretically double the current count. By remembering the most recent contribution of each character, we can subtract precisely the overlapping patterns to maintain uniqueness.
Mô hình hóa số lượng dãy con như một tập hợp đang tăng dần. Đối với mỗi ký tự mới, theo lý thuyết, chúng ta sẽ nhân đôi số lượng hiện tại. Bằng cách ghi nhớ đóng góp gần nhất của mỗi ký tự, chúng ta có thể trừ đi chính xác các mẫu giống nhau để duy trì tính duy nhất.

---
