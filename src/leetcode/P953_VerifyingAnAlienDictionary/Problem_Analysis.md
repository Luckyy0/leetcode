# 953. Verifying an Alien Dictionary / Xác thực Từ điển Người ngoài hành tinh

## Problem Description / Mô tả bài toán
An alien language uses English letters but in a different `order`.
Một ngôn ngữ người ngoài hành tinh sử dụng các chữ cái tiếng Anh nhưng theo một `thứ tự` khác.

Given `words` and `order`, return `true` if `words` are sorted lexicographically according to the alien dictionary.
Cho `words` và `order`, hãy trả về `true` nếu `words` được sắp xếp theo thứ tự từ điển dựa trên từ điển người ngoài hành tinh.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Custom Lexicographical Comparison / So sánh Từ điển Tùy chỉnh
Algorithm:
1. Map each character in `order` to its rank (0-25).
2. Compare each adjacent pair of words `(w1, w2)`:
   - Find the first index `j` where `w1[j] != w2[j]`.
   - If `rank(w1[j]) > rank(w2[j])`, return `false`.
   - Handle prefix case: If one is a prefix of the other, the shorter one must come first. If `length(w1) > length(w2)` and `w1` starts with `w2`, return `false`.

### Complexity / Độ phức tạp
- **Time**: O(Total chars in words).
- **Space**: O(1) (fixed size rank array).

---

## Analysis / Phân tích

### Approach: Positional Ranking validation
Redefine the alphabet based on the provided order. By performing pairwise comparisons between consecutive words, we check for ranking violations at the first differing character or prefix length discrepancies.
Định nghĩa lại bảng chữ cái dựa trên thứ tự được cung cấp. Bằng cách thực hiện so sánh từng cặp giữa các từ liên tiếp, chúng ta kiểm tra các vi phạm về thứ hạng tại ký tự khác nhau đầu tiên hoặc sự khác biệt về độ dài tiền tố.

---
