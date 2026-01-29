# 520. Detect Capital / Phát Hiện Chữ Hoa

## Problem Description / Mô tả bài toán
We define the usage of capitals in a word to be right when one of the following cases holds:
Chúng ta xác định việc sử dụng chữ hoa trong một từ là đúng khi một trong các trường hợp sau xảy ra:

- All letters in this word are capitals, like `"USA"`.
- All letters in this word are not capitals, like `"leetcode"`.
- Only the first letter in this word is capital, like `"Google"`.

Given a string `word`, return `true` if the usage of capitals in it is right.
Cho một chuỗi `word`, hãy trả về `true` nếu việc sử dụng chữ hoa trong đó là đúng.

### Example 1:
```text
Input: word = "USA"
Output: true
```

### Example 2:
```text
Input: word = "FlaG"
Output: false
```

## Constraints / Ràng buộc
- `1 <= word.length <= 100`
- `word` consists of lowercase and uppercase English letters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Case Analysis / Phân tích trường hợp
We can count the number of uppercase letters and check against the three valid patterns.

Algorithm:
1. Count the number of uppercase letters in the word.
2. Valid cases:
   - `uppercaseCount == 0`: All lowercase.
   - `uppercaseCount == word.length()`: All uppercase.
   - `uppercaseCount == 1 && Character.isUpperCase(word.charAt(0))`: Only first letter is uppercase.
3. Return `true` if any of these conditions hold.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the word.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Simple Counting

**Algorithm**:
1.  Count uppercase letters.
2.  Check three valid patterns.
3.  Return boolean result.

---
