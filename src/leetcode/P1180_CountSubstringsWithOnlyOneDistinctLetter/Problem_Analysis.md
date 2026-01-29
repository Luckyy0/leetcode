# 1180. Count Substrings with Only One Distinct Letter / Đếm Chuỗi con chỉ có Một Ký tự Phân biệt

## Problem Description / Mô tả bài toán
Given a string `S`, return the number of substrings that have only one distinct letter.
Cho một chuỗi `S`, hãy trả về số lượng chuỗi con chỉ có một ký tự phân biệt.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Contiguous Group Counting / Đếm Nhóm Liên tiếp
"aaaba" -> "aaa", "b", "a".
Group "aaa": length 3. Substrings: 1+2+3 = 6.
Formula: `len * (len + 1) / 2`.
Sum over all groups.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Consecutive Character Groups
Scan the string to identify maximal consecutive segments of identical characters. For a segment of length $L$, the number of valid substrings (substrings with only one distinct letter) contained within it is the sum of integers from 1 to $L$, which is $\frac{L \times (L + 1)}{2}$. Sum these values for all segments.
Quét chuỗi để xác định các đoạn liên tiếp tối đa của các ký tự giống hệt nhau. Đối với một đoạn có độ dài $L$, số lượng chuỗi con hợp lệ (chuỗi con chỉ có một ký tự phân biệt) chứa trong nó là tổng các số nguyên từ 1 đến $L$, tức là $\frac{L \times (L + 1)}{2}$. Cộng các giá trị này cho tất cả các đoạn.

---
