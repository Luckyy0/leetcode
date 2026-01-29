# 409. Longest Palindrome / Chuỗi Đối Xứng Dài Nhất

## Problem Description / Mô tả bài toán
Given a string `s` which consists of lowercase or uppercase letters, return the length of the **longest palindrome** that can be built with those letters.
Cho một chuỗi `s` bao gồm các chữ cái viết thường hoặc viết hoa, hãy trả về độ dài của **chuỗi đối xứng (palindrome) dài nhất** có thể được xây dựng bằng những chữ cái đó.

Letters are **case sensitive**, for example, `"Aa"` is not considered a palindrome.
Các chữ cái có **phân biệt chữ hoa và chữ thường**, ví dụ, `"Aa"` không được coi là một chuỗi đối xứng.

### Example 1:
```text
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
```

### Example 2:
```text
Input: s = "a"
Output: 1
```

## Constraints / Ràng buộc
- `1 <= s.length <= 2000`
- `s` consists of lowercase and/or uppercase English letters only.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Counting / Đếm Tham lam
A palindrome is composed of pairs of identical characters, with at most one solo character in the middle.
1. Any character appearing an even number of times `2k` can fully contribute `2k` to the palindrome length.
2. Any character appearing an odd number of times `2k + 1` can contribute `2k` to the length.
3. If there is at least one character with an odd frequency, we can place one of them in the center, adding 1 to the total length.

Algorithm:
1. Count the frequency of each character.
2. Sum up `(count / 2) * 2` for all character counts.
3. If the total length calculated is less than the input string length, add 1 (meaning there's at least one odd count available for the center).

### Complexity / Độ phức tạp
- **Time**: O(N) to iterate through the string.
- **Space**: O(1) or O(K) where K is the alphabet size (52 for A-Z, a-z).

---

## Analysis / Phân tích

### Approach: Frequency Array

**Algorithm**:
1.  Use an array of size 128 (to cover ASCII) or a `Map`.
2.  Iterate and compute the total length.

---
