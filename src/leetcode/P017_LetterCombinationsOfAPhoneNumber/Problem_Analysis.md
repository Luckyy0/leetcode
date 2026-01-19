# 17. Letter Combinations of a Phone Number / Tổ Hợp Chữ Cái Của Số Điện Thoại

## Problem Description / Mô tả bài toán
Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.
Cho một chuỗi chứa các chữ số từ `2-9`, trả về tất cả các tổ hợp chữ cái có thể mà số đó có thể đại diện. Trả về câu trả lời theo **bất kỳ thứ tự nào**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Ánh xạ các chữ số sang chữ cái (giống như trên các nút điện thoại) được đưa ra dưới đây. Lưu ý rằng 1 không ánh xạ tới bất kỳ chữ cái nào.

| Digit | Letters |
|---|---|
| 2 | abc |
| 3 | def |
| 4 | ghi |
| 5 | jkl |
| 6 | mno |
| 7 | pqrs |
| 8 | tuv |
| 9 | wxyz |

### Example 1:
```text
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

### Example 2:
```text
Input: digits = ""
Output: []
```

### Example 3:
```text
Input: digits = "2"
Output: ["a","b","c"]
```

## Constraints / Ràng buộc
- `0 <= digits.length <= 4`
- `digits[i]` is a digit in the range `['2', '9']`.

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: Use a recursive function to build the combinations.
- **Ý tưởng**: Sử dụng hàm đệ quy để xây dựng các tổ hợp.
    - We maintain a `current` string builder and an `index` pointing to the digit we are processing.
    - For the current digit, loop through all its possible letters.
    - Append a letter, recurse for `index + 1`, then backtrack (remove the letter).
    - Base case: if `index == digits.length`, add `current` to results.
- **Time Complexity**: O(4^N * N). In the worst case (digits 7 or 9 have 4 letters), we have 4^N combinations. Building each string takes O(N).
- **Space Complexity**: O(N) for recursion stack and current string construction.

### Approach: Iterative (BFS) / Lặp (BFS)
- **Idea**: Start with an empty list `[""]`. For each digit, for each existing combination, append valid letters to create a new list of combinations.
- **Ý tưởng**: Bắt đầu với danh sách rỗng `[""]`. Với mỗi chữ số, với mỗi tổ hợp hiện có, thêm các chữ cái hợp lệ để tạo danh sách tổ hợp mới.
    - Input "23":
    - Start: `[""]`
    - Process '2': `["a", "b", "c"]`
    - Process '3': `["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]`

---

## Edge Cases / Các trường hợp biên
1.  **Empty String**: Return `[]`.
2.  **Single Digit**: Returns corresponding letters.
