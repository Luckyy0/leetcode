# 854. K-Similar Strings / Chuỗi K-tương tự

## Problem Description / Mô tả bài toán
Two strings `s1` and `s2` are `k`-similar if we can change `s1` into `s2` using exactly `k` swaps.
Hai chuỗi `s1` và `s2` được gọi là `k`-tương tự nếu chúng ta có thể biến đổi `s1` thành `s2` bằng đúng `k` lần hoán đổi.

Given two anagrams `s1` and `s2`, return the minimum `k`.
Cho hai từ đảo chữ `s1` and `s2`, trả về giá trị `k` tối thiểu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS on String States / BFS trên các Trạng thái Chuỗi
This is a shortest path problem in the state space of strings.
Đây là bài toán tìm đường đi ngắn nhất trong không gian trạng thái của các chuỗi.

Algorithm:
1. Use BFS starting from `s1`.
2. In each step, find the first index `i` where `s1[i] != s2[i]`.
3. Try swapping `s1[i]` with any `s1[j]` (where `j > i`) such that `s1[j] == s2[i]`.
   - Heuristic optimization: only swap if `s1[j] != s2[j]`.
4. Put New string into the queue and mark as visited.

### Complexity / Độ phức tạp
- **Time**: Exponential in worst case, but efficient with pruning for short strings.
- **Space**: Exponential.

---

## Analysis / Phân tích

### Approach: Shortest Path State Search
The transformation is treated as a distance problem. By greedily fixing the first mismatched character using all valid candidates, we explore the branching possibilities layer by layer until the target string is reached.
Quá trình biến đổi được coi là một bài toán về khoảng cách. Bằng cách sửa tham lam ký tự sai lệch đầu tiên bằng cách sử dụng tất cả các ứng viên hợp lệ, chúng ta khám phá các khả năng phân nhánh theo từng lớp cho đến khi đạt được chuỗi mục tiêu.

---
