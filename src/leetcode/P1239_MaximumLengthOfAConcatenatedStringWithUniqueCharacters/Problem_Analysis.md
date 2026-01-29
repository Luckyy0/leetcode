# 1239. Maximum Length of a Concatenated String with Unique Characters / Độ dài Tối đa của Chuỗi ghép với các Ký tự Duy nhất

## Problem Description / Mô tả bài toán
Given array of strings `arr`.
Concatenate a subsequence of `arr` such that the resulting string has all unique characters.
Return max length.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Bitmask DP
Strings have small alphabet (26).
Represent each string as a bitmask. If a string has dup chars, ignore it.
Search for max combination of masks such that `mask1 & mask2 == 0`.
Since N is small (16), 2^N is 65536. Backtracking or checking all subsets is fast.
Constraints: `arr` length up to 16. `arr[i]` length up to 26.
O(2^N) is perfectly fine.

### Complexity / Độ phức tạp
- **Time**: O(2^N).
- **Space**: O(N) recursion or 2^N DP.

---

## Analysis / Phân tích

### Approach: Backtracking
Filter out strings that have duplicate characters themselves. Recursively try adding each valid string to the current combination. Maintain a bitmask of characters currently in use. If `(currentMask & strMask) == 0`, we can include the string. Maximise the total length (or population count of the final mask).
Lọc ra các chuỗi có các ký tự trùng lặp. Đệ quy thử thêm từng chuỗi hợp lệ vào tổ hợp hiện tại. Duy trì một bitmask của các ký tự đang được sử dụng. Nếu `(currentMask & strMask) == 0`, chúng ta có thể bao gồm chuỗi. Tối đa hóa tổng độ dài (hoặc số lượng bit của mặt nạ cuối cùng).

---
