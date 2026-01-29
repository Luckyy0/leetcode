# 1220. Count Vowels Permutation / Đếm Hoán vị Nguyên âm

## Problem Description / Mô tả bài toán
Given `n`, count how many strings of length `n` can be formed using vowels ('a', 'e', 'i', 'o', 'u') respecting rules:
- 'a' -> 'e'
- 'e' -> 'a', 'i'
- 'i' -> 'a', 'e', 'o', 'u' (not 'i')
- 'o' -> 'i', 'u'
- 'u' -> 'a'

Wait, check rules carefully:
- Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
- Each vowel 'a' may only be followed by an 'e'.
- Each vowel 'e' may only be followed by an 'a' or an 'i'.
- Each vowel 'i' may not be followed by another 'i'.
- Each vowel 'o' may only be followed by an 'i' or a 'u'.
- Each vowel 'u' may only be followed by an 'a'.

Wait, rule "Each vowel 'i' may not be followed by another 'i'" means 'i' can be followed by 'a', 'e', 'o', 'u'.
Correct.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Matrix Exponentiation
`dp[len][char]` = number of valid strings of length `len` ending with `char`.
Transitions (Reverse logic: who can be followed by `char`? No, standard logic: `char` can follow whom).
Or Forward logic: `dp[i][a] = dp[i-1][e] + dp[i-1][i] + dp[i-1][u]`.
Let's use `ends with`:
- `... a` comes from `e`, `i`, `u`. (Since e->a, i->a, u->a).
- `... e` comes from `a`, `i`. (a->e, i->e).
- `... i` comes from `e`, `o`. (e->i, o->i).
- `... o` comes from `i`. (i->o).
- `... u` comes from `i`, `o`. (i->u, o->u).

Wait, let's derive from rules given:
- a -> e. So `dp[k][e] += dp[k-1][a]`.
- e -> a, i. So `dp[k][a] += dp[k-1][e]`, `dp[k][i] += dp[k-1][e]`.
- i -> a, e, o, u. So a, e, o, u get from i.
- o -> i, u.
- u -> a.

Equations for length `k`:
`countA[k] = countE[k-1] + countI[k-1] + countU[k-1]`
`countE[k] = countA[k-1] + countI[k-1]`
`countI[k] = countE[k-1] + countO[k-1]`
`countO[k] = countI[k-1]`
`countU[k] = countI[k-1] + countO[k-1]`
All strict modulo `10^9 + 7`.

### Complexity / Độ phức tạp
- **Time**: O(N). O(log N) with Matrix Exponentiation. Given `N` up to 2*10^4 (usually large), O(N) is fine.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: DP State Transition
Use Dynamic Programming to count the valid permutations. Maintain 5 variables representing the count of strings ending in 'a', 'e', 'i', 'o', and 'u'. At each step, update these counts based on the transition rules (e.g., new 'a' count comes from previous 'e', 'i', 'u' counts because those can be followed by 'a'). Use temporary variables to store the new counts to avoid using partially updated values. Perform operations modulo $10^9 + 7$.
Sử dụng Quy hoạch Động để đếm các hoán vị hợp lệ. Duy trì 5 biến đại diện cho số lượng chuỗi kết thúc bằng 'a', 'e', 'i', 'o' và 'u'. Ở mỗi bước, cập nhật các số lượng này dựa trên các quy tắc chuyển đổi (ví dụ: số lượng 'a' mới đến từ các số lượng 'e', 'i', 'u' trước đó vì những chuỗi đó có thể được theo sau bởi 'a'). Sử dụng các biến tạm thời để lưu trữ số lượng mới để tránh sử dụng các giá trị được cập nhật một phần. Thực hiện các phép tính modulo $10^9 + 7$.

---
