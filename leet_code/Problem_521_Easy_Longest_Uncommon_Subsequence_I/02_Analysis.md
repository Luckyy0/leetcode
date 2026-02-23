# Analysis for Longest Uncommon Subsequence I
# *Phân tích cho bài toán Dãy con Không chung Dài nhất I*

## 1. Problem Essence & Trick
## *1. Bản chất vấn đề & Mẹo*

### The Challenge
### *Thách thức*
Finding the longest sequence that is a subsequence of one string but not the other.

### Strategy: Logic Deduction
### *Chiến lược: Suy luận Logic*

1.  **Case 1: `a == b`**: Every subsequence of `a` is a subsequence of `b`. No uncommon subsequence. Return -1.
2.  **Case 2: `len(a) != len(b)`**: The longer string itself cannot be a subsequence of the shorter string. So the longer string is an uncommon subsequence. Return `max(len(a), len(b))`.
3.  **Case 3: `len(a) == len(b)` but `a != b`**: String `a` is a subsequence of `a` but NOT `b` (since they are equal length but different contents). So `a` is uncommon. Return `len(a)`.

### Conclusion
### *Kết luận*
If `a == b`, return -1. Else return `max(len(a), len(b))`.

---

## 2. Approach: Brainteaser
## *2. Hướng tiếp cận: Câu đố mẹo*

### Logic
### *Logic*
(See above).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Check equality and lengths.
*Kiểm tra sự bằng nhau và độ dài.*
---
*Đôi khi câu trả lời nằm ngay trước mắt (the string itself). Nếu bạn khác biệt (a != b), chính sự tồn tại trọn vẹn của bạn là điều độc nhất vô nhị mà không ai có thể sao chép hoàn toàn.*
Sometimes the answer is right in front of your eyes (The String Itself). If you are different (a! = b), your full existence is unique that no one can copy completely.
