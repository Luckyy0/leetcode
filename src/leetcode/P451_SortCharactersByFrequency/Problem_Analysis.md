# 451. Sort Characters By Frequency / Sắp Xếp Ký Tự Theo Tần Suất

## Problem Description / Mô tả bài toán
Given a string `s`, sort it in **decreasing order** based on the **frequency** of the characters. The frequency of a character is the number of times it appears in the string.
Cho một chuỗi `s`, hãy sắp xếp nó theo **thứ tự giảm dần** dựa trên **tần suất** xuất hiện của các ký tự. Tần suất của một ký tự là số lần nó xuất hiện trong chuỗi.

Return the sorted string. If there are multiple answers, return any of them.
Trả về chuỗi đã sắp xếp. Nếu có nhiều đáp án, hãy trả về bất kỳ đáp án nào trong số đó.

### Example 1:
```text
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
```

### Example 2:
```text
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 5 * 10^5`
- `s` consists of uppercase and lowercase English letters and digits.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Counting + Sorting / Đếm tần suất + Sắp xếp
To solve this, we need to know how many times each character appears.

Algorithm:
1. Count the frequency of each character using a `HashMap` or a fixed-size array (if the character set is restricted).
2. Create a list of characters and sort it based on the frequencies stored in the map in descending order.
3. Build the resulting string by repeating each character according to its frequency.

Optimized approach (**Bucket Sort**):
1. Count frequencies.
2. Create an array of lists (buckets) where the index represents the frequency. `bucket[f]` contains all characters that appear `f` times.
3. Traverse the buckets from largest frequency to smallest and build the string.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s` (using Bucket Sort).
- **Space**: O(N) to store frequencies and buckets.

---

## Analysis / Phân tích

### Approach: Bucket Sort

**Algorithm**:
1.  Frequency Map construction.
2.  Bucket initialization (index = frequency).
3.  String concatenation from right to left.

---
