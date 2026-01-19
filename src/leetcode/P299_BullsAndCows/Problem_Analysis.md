# 299. Bulls and Cows / Bò và Bò Cót

## Problem Description / Mô tả bài toán
You are playing the Bulls and Cows game with your friend.
Bạn đang chơi trò chơi Bulls and Cows với bạn của mình.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
- The number of "bulls", which are digits in the guess that are in the correct position. (Số lượng "bulls", là các chữ số trong đoán đúng vị trí).
- The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls. (Số lượng "cows"...).

Given the secret number `secret` and your friend's guess `guess`, return the hint to your friend's guess. The hint should be formatted as `"xAyB"`, where `x` is the number of bulls and `y` is the number of cows. Note that both `secret` and `guess` may contain duplicate digits.
Cho số bí mật `secret` và số đoán `guess`, hãy trả về gợi ý. Định dạng `"xAyB"`.

### Example 1:
```text
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls is connected with a '|':
"1807"
  |
"7810"
Bulls = 1 (digit 8).
Cows = 3 (digits 1, 0, 7 match but wrong pos).
```

## Constraints / Ràng buộc
- `1 <= secret.length, guess.length <= 1000`
- `secret.length == guess.length`
- `secret` and `guess` consist of digits only.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Frequency Counting / Đếm Tần Suất
1.  **Bulls**: Simple pass. If `s[i] == g[i]`, `bulls++`.
2.  **Cows**:
    - Count frequencies of digits in `secret` (`sCounts`) and `guess` (`gCounts`).
    - But strictly exclude indices that were Bulls.
    - `cows += min(sCounts[d], gCounts[d])` for all digits `d`.

**Algorithm**:
1.  `bulls = 0`.
2.  `counts` buckets (size 10).
3.  Loop `i`:
    - `s = secret[i]`, `g = guess[i]`.
    - If `s == g`: `bulls++`.
    - Else:
        - `if (counts[s] < 0) cows++`. `counts[s]++`. (Secret seen, increments count).
        - `if (counts[g] > 0) cows++`. `counts[g]--`. (Guess consumes count).
    - Wait, optimize logic:
        - `counts[d]` stores net balance: + for secret, - for guess.
        - If `s != g`:
            - `if (counts[s] < 0) cows++`. (Meaning guess previously needed this val).
            - `if (counts[g] > 0) cows++`. (Meaning secret previously provided this val).
            - `counts[s]++`.
            - `counts[g]--`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (array size 10).

---

## Analysis / Phân tích

### Approach: One Pass bucket

**Algorithm**:
1.  Bulls and Cows logic as above.

---
