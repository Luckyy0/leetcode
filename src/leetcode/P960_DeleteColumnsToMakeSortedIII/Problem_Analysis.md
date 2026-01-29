# 960. Delete Columns to Make Sorted III / Xóa Cột để làm cho được sắp xếp III

## Problem Description / Mô tả bài toán
Given an array `strs` of `n` strings, each of the same length, we want to delete the minimum number of columns such that every string becomes sorted lexicographically (non-decreasing sequence of characters).
Cho một mảng `strs` gồm `n` chuỗi, mỗi chuỗi có cùng độ dài, chúng ta muốn xóa ít nhất số lượng các cột sao cho mỗi chuỗi trở nên được sắp xếp theo thứ tự từ điển (một chuỗi ký tự không giảm).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Longest Increasing Subsequence (LIS) on Columns / Chuỗi tăng dài nhất (LIS) trên các cột
This is a variation of finding the LIS, but instead of comparing single numbers, we compare whole columns across all strings.
Đây là một biến thể của việc tìm LIS, nhưng thay vì so sánh các chữ số đơn lẻ, chúng ta so sánh toàn bộ các cột trên tất cả các chuỗi.

Algorithm:
1. `dp[i]` = the maximum number of columns we can keep ending at column `i`.
2. `dp[i] = 1 + max(dp[j])` for all `j < i` such that for all strings `s`, `s[j] <= s[i]`.
3. The result is `totalColumns - max(dp)`.

### Complexity / Độ phức tạp
- **Time**: O(Length^2 * NumberOfStrings).
- **Space**: O(Length).

---

## Analysis / Phân tích

### Approach: Multi-dimensional LIS
Find the longest subset of indices such that every string in the dataset remains sorted when restricted to those indices. By maximizing the preserved columns, we indirectly minimize the deletions.
Tìm tập hợp các chỉ số lớn nhất sao cho mọi chuỗi trong tập dữ liệu vẫn được sắp xếp khi chỉ xét các chỉ số đó. Bằng cách tối đa hóa các cột được giữ lại, chúng ta gián tiếp tối thiểu hóa việc xóa bỏ.

---
