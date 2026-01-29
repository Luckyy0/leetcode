# 948. Bag of Tokens / Túi Thẻ

## Problem Description / Mô tả bài toán
You have an initial `power`, an initial `score` of 0, and a bag of `tokens` where `tokens[i]` is the value of the `i-th` token.
Bạn có `power` ban đầu, `score` ban đầu là 0, và một túi `tokens` trong đó `tokens[i]` là giá trị của thẻ thứ `i`.

- **Face-up**: If current power $\ge$ `tokens[i]`, you can play token `i` face up to lose `tokens[i]` power and gain 1 score.
- **Face-down**: If current score $\ge$ 1, you can play token `i` face down to gain `tokens[i]` power and lose 1 score.

Return the largest possible score you can achieve.
Hãy trả về số điểm lớn nhất có thể đạt được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Two Pointers / Tham lam với Hai con trỏ
To maximize score:
- Use the smallest tokens to gain score (Face-up).
- Use the largest tokens to regain power (Face-down).

Algorithm:
1. Sort `tokens`.
2. `left = 0`, `right = n - 1`.
3. While `left <= right`:
   - If `power >= tokens[left]`:
     - Lose power, gain score, `left++`.
     - Update `maxScore`.
   - Else if `score >= 1` and `left < right`:
     - Gain power from `tokens[right]`, lose score, `right--`.
   - Else: break.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Resource Management Cycle
Sell power cheaply (using small tokens) to acquire points. When the power reserve is low, consume points to buy power dearly (using large tokens), but only if further points can be gained in future moves.
Bán rẻ năng lượng (sử dụng các thẻ nhỏ) để lấy điểm. Khi dự trữ năng lượng thấp, hãy tiêu điểm để mua lại năng lượng một cách đắt đỏ (sử dụng các thẻ lớn), nhưng chỉ khi có thể thu được thêm điểm trong các bước di chuyển tương lai.

---
