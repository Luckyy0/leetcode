# 522. Longest Uncommon Subsequence II / Dãy Con Không Chung Dài Nhất II

## Problem Description / Mô tả bài toán
Given an array of strings `strs`, return the length of the longest uncommon subsequence. If no such subsequence exists, return `-1`.
Cho một mảng chuỗi `strs`, trả về độ dài của dãy con không chung dài nhất. Nếu không tồn tại, trả về `-1`.

An uncommon subsequence is a subsequence that appears in one string but not in the others.
Dãy con không chung là dãy con xuất hiện trong một chuỗi nhưng không xuất hiện trong các chuỗi khác.

### Constraints / Ràng buộc
- `2 <= strs.length <= 50`
- `1 <= strs[i].length <= 10`

---

## Approach / Phương pháp
For each string, check if it's a subsequence of any other string. If not, it's uncommon.
Với mỗi chuỗi, kiểm tra xem nó có phải là dãy con của chuỗi khác không. Nếu không, nó là không chung.

Sort strings by length descending, then check each one.
Sắp xếp chuỗi theo độ dài giảm dần, sau đó kiểm tra từng cái.
