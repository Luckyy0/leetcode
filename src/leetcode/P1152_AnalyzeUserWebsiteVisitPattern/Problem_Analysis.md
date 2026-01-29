# 1152. Analyze User Website Visit Pattern / Phân tích Mô hình Truy cập Trang web của Người dùng

## Problem Description / Mô tả bài toán
We have records of `username`, `timestamp`, `website`.
Find the 3-sequence of websites visited by the largest number of users.
A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.
(Note: The sequence is a SUBSEQUENCE of user visits, not necessarily contiguous).
Tie breaking: lexicographically smallest 3-sequence.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force / Combination / Vét cạn / Tổ hợp
1. Group visits by user. Sort visits by time for each user.
2. For each user, generate all unique 3-sequences from their visits.
   - Using 3 nested loops (or itertools.combinations) on the user's visit list.
   - Store these sequences in a set unique to the user (to count each user once for a pattern).
3. Count frequencies of 3-sequences globally.
4. Return pattern with highest count (and lowest lex order).

### Complexity / Độ phức tạp
- **Time**: O(N^3) per user. Given array size 50, loops are small.
- **Space**: O(N^3) map size.

---

## Analysis / Phân tích

### Approach: Generate Triples Per User
Group website visits by user and sort them chronologically. For each user, generate all possible subsequences of length 3 (combinations of 3 sites in order). Use a set to ensure each pattern is counted only once per user. Accumulate global counts for these patterns and return the most frequent (lexicographically smallest on tie).
Nhóm các lượt truy cập trang web theo người dùng và sắp xếp chúng theo trình tự thời gian. Đối với mỗi người dùng, tạo tất cả các chuỗi con có thể có độ dài 3 (tổ hợp 3 trang web theo thứ tự). Sử dụng một tập hợp để đảm bảo mỗi mẫu chỉ được tính một lần cho mỗi người dùng. Tích lũy số lượng toàn cầu cho các mẫu này và trả về mẫu thường xuyên nhất (nhỏ nhất theo thứ tự từ điển khi hòa).

---
