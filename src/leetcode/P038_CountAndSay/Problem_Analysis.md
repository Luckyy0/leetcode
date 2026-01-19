# 38. Count and Say / Đếm và Nói

## Problem Description / Mô tả bài toán
The **count-and-say** sequence is a sequence of digit strings defined by the recursive formula:
Chuỗi **đếm-và-nói** là một chuỗi các chuỗi số được định nghĩa bởi công thức đệ quy:

- `countAndSay(1) = "1"`
- `countAndSay(n)` is the way you would "say" the digit string from `countAndSay(n-1)`, which is then converted into a different digit string.
- `countAndSay(n)` là cách bạn sẽ "nói" chuỗi số từ `countAndSay(n-1)`, sau đó được chuyển đổi thành một chuỗi số khác.

To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
Để xác định cách bạn "nói" một chuỗi số, hãy chia nó thành số lượng chuỗi con tối thiểu sao cho mỗi chuỗi con chứa chính xác một chữ số duy nhất. Sau đó, đối với mỗi chuỗi con, hãy nói số lượng chữ số, sau đó nói chữ số đó. Cuối cùng, nối mọi chữ số đã nói.

For example, the saying and conversion for digit string `"3322251"`:
Ví dụ, cách nói và chuyển đổi cho chuỗi số `"3322251"`:
- "33" -> two 3s -> "23"
- "222" -> three 2s -> "32"
- "5" -> one 5 -> "15"
- "1" -> one 1 -> "11"
- Result: "23321511"

### Example 1:
```text
Input: n = 1
Output: "1"
Explanation: This is the base case.
```

### Example 2:
```text
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1s = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
```

## Constraints / Ràng buộc
- `1 <= n <= 30`

---

## Analysis / Phân tích

### Approach: Iterative Generation / Tạo Lặp
- **Idea**: Since `n` is small (up to 30), we can simulate the process iteratively starting from `n=1`.
- **Ý tưởng**: Vì `n` nhỏ (tối đa 30), chúng ta có thể mô phỏng quá trình lặp đi lặp lại bắt đầu từ `n=1`.
- **Algorithm**:
    1.  Start with `s = "1"`.
    2.  Repeat `n-1` times:
        - Scan `s` to group identical consecutive characters.
        - Build `next_s`.
        - For each group of `count` identical characters `c`: append `count` then `c` to `next_s`.
        - Update `s = next_s`.
- **Time Complexity**: The length of the string grows. It's roughly O(2^n) or less (actually related to atomic decay constants, approx 1.3^n). For n=30, it is manageable.
- **Space Complexity**: O(L) where L is max length of string generated.

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: "1".
