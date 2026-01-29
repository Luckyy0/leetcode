# 761. Special Binary String / Chuỗi Nhị phân Đặc biệt

## Problem Description / Mô tả bài toán
Special binary strings are binary strings with the following two properties:
Các chuỗi nhị phân đặc biệt là các chuỗi nhị phân có hai thuộc tính sau:

1. The number of 0's is equal to the number of 1's.
2. Every prefix of the binary string has at least as many 1's as 0's.

You can make any number of moves. In each move, you can choose two consecutive, non-empty, special binary substrings of the special binary string and swap them.
Bạn có thể thực hiện bất kỳ số lần di chuyển nào. Trong mỗi lần di chuyển, bạn có thể chọn hai chuỗi con nhị phân đặc biệt, không rỗng, liên tiếp của chuỗi nhị phân đặc biệt và hoán đổi chúng.

Return the lexicographically largest resulting string possible.
Trả về chuỗi kết quả lớn nhất có thể theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Decomposition and Sorting / Phân rã và Sắp xếp
A special binary string acts like a balanced set of parentheses (1 = '(', 0 = ')').
Một chuỗi nhị phân đặc biệt hoạt động giống như một bộ dấu ngoặc đơn cân bằng.

Algorithm:
1. Split the string into its irreducible special substrings. A substring `1...0` is irreducible if it's special.
2. For each irreducible substring, remove the leading `1` and trailing `0`, recursively process the inner part, then re-wrap.
3. Once you have the processed special substrings, sort them in descending order to maximize the final string lexicographically.
4. Join the sorted substrings.

### Complexity / Độ phức tạp
- **Time**: O(N^2) due to recursion and sorting.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive Reordering
This problem is essentially about reordering balanced parentheses groups to make the string "heavier" at the beginning. Recursive decomposition ensures every valid subgroup is optimally arranged.
Về cơ bản, bài toán này là việc sắp xếp lại các nhóm dấu ngoặc đơn cân bằng để làm cho chuỗi "nặng" hơn ở phần đầu. Phân rã đệ quy đảm bảo mọi nhóm con hợp lệ đều được sắp xếp tối ưu.

---
